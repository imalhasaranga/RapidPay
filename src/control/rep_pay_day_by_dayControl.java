
package control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import model.DB;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JRViewer;
import view.Reports.rep_pay_date;

/**
 *
 * @author Imal
 */
public final class rep_pay_day_by_dayControl {

    rep_pay_date rep_pay_date = new rep_pay_date();

    public void viewReport(Date d,JTable tb,JTabbedPane jtab){
     if (d.equals(null)) {
            JOptionPane.showMessageDialog(rep_pay_date, "Select the Date");
     }else{
     SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
     SimpleDateFormat format2 = new SimpleDateFormat("EEEEE");
     String date = format1.format(d);
         DefaultTableModel df = (DefaultTableModel) tb.getModel();
         df.setRowCount(0);
         try {
             
        
         ResultSet rs = DB.getResultset("SELECT "
                 +"  Invoice_id, "
                 +"  User_student_id, "
                 +"  a.class_id as classe, "
                 +"  s.Subject_name, "
                 +"  a.class_fees, "
                 +"  ((a.class_fees*Institute_presentage)/100) as inst, "
                 +"  ((a.class_fees*Teacher_pay_present)/100) as tech, "
                 +"  a.pay_type, "
                 +"  user_stafff "
                 +"FROM (payment_invoice_student a "
                 +"   JOIN class b "
                 +"     ON a.class_id = b.Class_id "
                 +"   JOIN grade g "
                 +"     ON b.Grade_id = g.Grade_id "
                 +"   JOIN SUBJECT s "
                 +"     ON b.Subject_id = s.subject_id) "
                 +"WHERE (a.Date_Time like '"+date+"_________') && (a.pay_type = 'Admission') "
                 +"GROUP BY a.user_student_id UNION SELECT "
                 +"                                   Invoice_id, "
                 +"                                   User_student_id, "
                 +"                                   a.class_id as classe, "
                 +"                                   s.Subject_name, "
                 +"                                   a.class_fees, "
                 +"  ((a.class_fees*Institute_presentage)/100) as inst, "
                 +"  ((a.class_fees*Teacher_pay_present)/100) as tech, "
                 +"                                   a.pay_type, "
                 +"                                   user_stafff "
                 +"                                 FROM (payment_invoice_student a "
                 +"                                    JOIN class b "
                 +"                                      ON a.class_id = b.Class_id "
                 +"                                    JOIN grade g "
                 +"                                      ON b.Grade_id = g.Grade_id "
                 +"                                    JOIN SUBJECT s "
                 +"                                      ON b.Subject_id = s.subject_id) "
                 +"                                 WHERE (a.Date_Time Like '"+date+"_________') && (pay_type = 'monthlypayment') "
                 +"ORDER BY Invoice_id "
                 +"");
             
            
         while(rs.next()){
         
             Vector v = new Vector();
             
             v.add(rs.getString("Invoice_id"));
             v.add(rs.getString("User_student_id"));
             
             
             if(rs.getString("pay_type").equals("monthlypayment")){
             
             v.add(rs.getString("classe"));
             v.add(rs.getString("Subject_name"));
             v.add(rs.getString("class_fees"));
             v.add(rs.getString("inst"));
             v.add(rs.getString("tech"));
             
             }else{
              v.add(" - ");
              v.add(" - ");
              v.add(rs.getString("class_fees"));
              v.add(rs.getString("class_fees"));
              v.add(" - ");
             }
             
             v.add(rs.getString("pay_type"));
              v.add(rs.getString("user_stafff"));
              df.addRow(v);
     
         }

          } catch (Exception e) {
              System.out.println(e);
         }
         
         
         
         
         double IncomFINFM=0;
         double IncomFINFA=0;
         double IncomFTEFM=0;
         
         for (int i = 0; i < tb.getRowCount(); i++) {
             
             String type = tb.getValueAt(i, 7).toString();
             if(type.trim().equals("Admission")){
             IncomFINFA += Double.parseDouble(tb.getValueAt(i, 5).toString());
             }else{
             IncomFTEFM += Double.parseDouble(tb.getValueAt(i, 6).toString());
             IncomFINFM += Double.parseDouble(tb.getValueAt(i, 4).toString());
             }
         }
        
                 String rep_path = System.getProperty("user.dir") + "/reports/dailyrep2.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();

           
           
          
            params.put("Date_Time", date+"");
            params.put("day", format2.format(d));
            params.put("TotalIncomInstFm", IncomFINFM+"");
            params.put("TotalIncomeTechFM", IncomFTEFM+"");
            params.put("TotalIncomInstAD",IncomFINFA+"" );
            params.put("TotFinalins",(IncomFINFM+IncomFINFA-IncomFTEFM)+"" );
             params.put("alltot",(IncomFINFM+IncomFINFA)+"" );

            try {

                   JRTableModelDataSource datasource = new JRTableModelDataSource(tb.getModel());
                JasperReport jreport = JasperCompileManager.compileReport(rep_path);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, params, datasource);
                
                JRViewer jview = new JRViewer(jprint);
                jtab.add("Report", jview);
                jview.setZoomRatio((float) 0.9);

            } catch (Exception ex) {
                System.out.println("ERROR:" + ex);
            }
     }
    }
    
    
  

    public String getDateTime() {
        Calendar currdate = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String datenow = format1.format(currdate.getTime());

        return datenow;
    }

    public String getDateAd(Date thisdate) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String datead = df.format(thisdate);

        return datead;
    }

   

    public String getDay(Date thisdate) {
        String day = "";

        if (thisdate.getDay() == 0) {
            day = "Sunday";
        } else if (thisdate.getDay() == 1) {
            day = "Monday";
        } else if (thisdate.getDay() == 2) {
            day = "Tuesday";
        } else if (thisdate.getDay() == 3) {
            day = "Wednesday";
        } else if (thisdate.getDay() == 4) {
            day = "Thursday";
        } else if (thisdate.getDay() == 5) {
            day = "Friday";
        } else if (thisdate.getDay() == 6) {
            day = "Saturday";
        }

        return day;

    }

    public int getTotPayments(Date thisdate) {
        int tot1 = 0;
        

        try {
            ResultSet rs = DB.getResultset("select COUNT(pay_type) as tot from payment_invoice_student where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________') && (pay_type = 'monthlypayment') ORDER BY Payment_id ");
            rs.next();
            tot1 = rs.getInt("tot");
            ResultSet rs1 = DB.getResultset("select COUNT(DISTINCT user_student_id) as tot from payment_invoice_student where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________') &&  (pay_type = 'Admission')  ");
            rs1.next();
            tot1 = rs1.getInt("tot")+tot1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return tot1;
    }

    public double getTotIncome(Date thisdate) {
      
        double totsum = 0;

        try {
            ResultSet rs = DB.getResultset("select class_fees as totincome from payment_invoice_student where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________')&& (pay_type = 'Admission') group by user_student_id ");
            while(rs.next()){           
            totsum = Double.parseDouble(rs.getString("totincome"))+totsum;
            } 
            ResultSet rs1 = DB.getResultset("select SUM(class_fees) as totincome from payment_invoice_student where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________')&& (pay_type = 'monthlypayment') ORDER BY Payment_id ");
            rs1.next(); 
            totsum = Double.parseDouble(rs1.getString("totincome"))+totsum;
        } catch (Exception e) {
            System.out.println(e);
        }
        return totsum;
    }
}
