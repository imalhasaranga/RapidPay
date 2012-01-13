
package control;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import model.DB;
import view.Reports.rep_timetable;

/**
 *
 * @author Imal
 */
public final class rep_timetableControl {

    rep_timetable rep_time;
    DB con = new DB();
    int tot = 0;

    public void viewReport(String selectday, JTabbedPane reportarea) {
        if (selectday.equals("")) {
            JOptionPane.showMessageDialog(rep_time, "Select the Day");
        } else {
            JOptionPane.showMessageDialog(rep_time, "Day: " + selectday);
            JOptionPane.showMessageDialog(rep_time, "Total: " + this.getTotClasses(selectday));

            String rep_path = System.getProperty("user.dir") + "/reports/timetable.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();

            params.put("datetime", this.getDateTime());
            params.put("day", selectday);
            params.put("tot", this.getTotClasses(selectday));

            try {

                JasperReport jreport = JasperCompileManager.compileReport(rep_path);
                JasperPrint jprint = JasperFillManager.fillReport(jreport, params, DB.getmyCon());
                JRViewer jview = new JRViewer(jprint);
                reportarea.removeAll();
                reportarea.add("Timetable", jview);
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

    public int getTotClasses(String selectday) {
        try {
            ResultSet rs = DB.getResultset("select COUNT(class_id) as tot from class where day = '" + selectday + "' AND is_active='1'");
            rs.next();
            tot = rs.getInt("tot");
        } catch (Exception e) {
        }
        return tot;
    }
}
