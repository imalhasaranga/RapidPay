
package control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import model.DB;
import net.sf.jasperreports.view.JRViewer;
import view.Reports.rep_pay_date;

public final class Rep_pay_deletedBilss {

    rep_pay_date rep_pay_date = new rep_pay_date();

    public void viewReport(Date selectdate, JTabbedPane jtab) {
        if (selectdate.equals(null)) {
            JOptionPane.showMessageDialog(rep_pay_date, "Select the Date");
        } else {

            String rep_path = System.getProperty("user.dir") + "/reports/payment_date_deleted.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();

            int total = this.getTotPayments(selectdate);
            double totaincome = this.getTotIncome(selectdate);
           
           
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
            ResultSet rs = DB.getResultset("select COUNT(pay_type) as tot from deleted_bills where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________') && (pay_type = 'monthlypayment') ORDER BY Payemnt_id ");
            if(rs.next()){
            tot1 = rs.getInt("tot");
            }else{
            tot1 = 0;
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return tot1;
    }

    public double getTotIncome(Date thisdate) {
      
        double totsum = 0;

        try {
            
            ResultSet rs1 = DB.getResultset("select SUM(fee) as totincome from deleted_bills where (Date_Time LIKE '" + this.getDateAd(thisdate) + "_________')&& (pay_type = 'monthlypayment') ORDER BY Payemnt_id ");
            if(rs1.next()){
                if(rs1.getString("totincome") != null){
            totsum = Double.parseDouble(rs1.getString("totincome"));
                }
            }else {            
            totsum  = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return totsum;
    }
}
