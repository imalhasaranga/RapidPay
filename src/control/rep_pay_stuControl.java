

package control;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import model.DB;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import view.Reports.rep_pay_stu;

/**
 *
 * @author Imal
 */
public final class rep_pay_stuControl {
    public int sid;
    rep_pay_stu repstu = new rep_pay_stu();
   
   
    
    public void viewReport(String text, JTabbedPane pnl,int year){
      
        sid =Integer.parseInt(text); 
        if(text.equals("")){ 
            JOptionPane.showMessageDialog(repstu, "Type the Student Id");
        }else{
            
            
                String rep_path = System.getProperty("user.dir")+"/reports/payment_stu.jrxml";
                Map<String, Object> params = new HashMap<String, Object>();

                params.put("sid", sid);
                params.put("year", ""+year);
                params.put("name", this.getName());
                params.put("datetime", this.getDateTime());
                
                try {
                    
                    JasperReport jreport = JasperCompileManager.compileReport(rep_path);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, params, DB.getmyCon());
                   
                    JRViewer jview = new JRViewer(jprint);
                    pnl.removeAll();
                    pnl.add("Report", jview);
                   
                    
                    jview.setZoomRatio((float) 0.9);
                } catch (Exception ex) {
                    System.out.println("ERROR:" + ex);
                }
                
                
                
                
           
            
        }
        
    }
    
    public String getDateTime(){
        String dt = "";
        Date date = new Date();
        dt = 1900 + date.getYear() + "-" + 1 + date.getMonth() + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        
        return dt;
    }
    
    public String getName(){
        String name = "";
        
        try {
            ResultSet rs = DB.getResultset("select fname, mname, lname from user_main where user_id = '"+sid+"'");
            rs.next();
            name = rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname");
        } catch (Exception e) {
            System.out.println("ERROR from rep_pay_stuControl-gatName: " + e); 
        }
        
        
        return name;
    } 
    
}
