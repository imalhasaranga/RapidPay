
package control;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Imal
 */
public final class rep_mainfinanceControl {

    public void genMainfinanceRep(String Year, int month, JTabbedPane jb, JTable table) {

       // String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthstr = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        String totalincome = null;
        String teaccherpay = null;
        double totstu = 0;
        // ((month = '" + month + "' ) OR  ( month = '" + monthName[month - 1] + "' ))
        
        String yearmont = Year+"/"+monthstr[month-1];
        try {

            ResultSet studentpayments = DB.getResultset("select sum(class_fees) as Totstupay from payment_invoice_student where   Date_Time like '"+yearmont+"____________' && pay_type ='monthlypayment' ");
            if (studentpayments.next()) {
                totalincome = studentpayments.getString("Totstupay");

            }

            ResultSet studentpayments1 = DB.getResultset("select class_fees as Totstupay from payment_invoice_student where  Date_Time like '"+yearmont+"____________' && pay_type = 'Admission' group by user_student_id ");
            while (studentpayments1.next()) {
                totstu = Double.parseDouble(studentpayments1.getString("Totstupay")) + totstu;
            }
            totalincome = totalincome == null ? "0" : totalincome;
            totalincome = (totstu + Double.parseDouble(totalincome)) + "";

            ResultSet teacherpaymnt = DB.getResultset("select sum((advance)) as paidTotacher from teacher_payment where (month = '" + month + "')  && ( balnace_payied_date like '" + Year + "______') ");
            if (teacherpaymnt.next()) {
                teaccherpay = (teacherpaymnt.getString("paidTotacher") == null) ? "0" : teacherpaymnt.getString("paidTotacher");
            }
            
            
            teaccherpay = teaccherpay == null ? "0" : teaccherpay;
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("Year", Year);
            params.put("month", month + "");
            params.put("Totinc", Double.parseDouble(totalincome));
            params.put("Totexp", Double.parseDouble(teaccherpay));

            Vector v = new Vector();
            DefaultTableModel df = ((DefaultTableModel) table.getModel());
            df.setRowCount(0);
            v.add("Total Income");
            v.add(totalincome);
            df.addRow(v);
            Vector v1 = new Vector();
            v1.add("Total Expenses");
            v1.add(teaccherpay);
            df.addRow(v1);



            JRTableModelDataSource datasource = new JRTableModelDataSource(table.getModel());
            String reportSource = System.getProperty("user.dir") + "/reports/mainfinance.jrxml";

            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);

            JRViewer jview = new JRViewer(jasperPrint);
            jb.removeAll();
            jb.add("class-by-class", jview);
            jview.setZoomRatio((float) 1.0);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
