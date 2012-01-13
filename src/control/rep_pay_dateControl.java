
package control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import model.DB;
import net.sf.jasperreports.view.JRViewer;
import view.Reports.rep_pay_date;

/**
 *
 * @author gihan
 */
public final class rep_pay_dateControl {

    rep_pay_date rep_pay_date = new rep_pay_date();

    public void viewReport(Date selectdate, JTabbedPane jtab, JLabel totalstudents, JLabel totaliincome) {
        if (selectdate.equals(null)) {
            JOptionPane.showMessageDialog(rep_pay_date, "Select the Date");
        } else {

            String rep_path = System.getProperty("user.dir") + "/reports/payment_date.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();

            int total = this.getTotPayments(selectdate);
            double totaincome = this.getTotIncome(selectdate);
           
            totalstudents.setText(total+"");
           totaliincome.setText(totaincome+"");
            params.put("datetime", this.getDateTime());
            params.put("date_ad", this.getDateAd(selectdate));
            params.put("date_mth", this.getDateAd(selectdate));
            params.put("day", this.getDay(selectdate));
            params.put("totpayments",total );
            params.put("totincome",totaincome );

            try {

                JasperReport jreport = JasperCompileManager.compileReport(rep_path);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, params, DB.getmyCon());
                jtab.removeAll();
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
