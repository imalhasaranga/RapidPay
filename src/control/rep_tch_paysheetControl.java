
package control;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
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
public final class rep_tch_paysheetControl {

    public void searchAlgorythem(String month, JTable table, String year, JTabbedPane jb) {


        Object[] options = {" Class by class ", " Teacher By Teacher "};
        int res = JOptionPane.showOptionDialog(null, "Please Select Report Type you want", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);


        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("year", year + "");
        params.put("month", month + "");

        String yearmon = year+"-"+(month.length() == 1 ? "0"+month : month);
        
        try {

            ResultSet rs11 = DB.getResultset("select* from user_teacher a, user_main b where (b.user_id = a.user_teacher_id) && ( b.is_active = '1') ");
            while (rs11.next()) {

                String userid = rs11.getString("b.user_id");
                String usrname = rs11.getString("b.fname") + " " + rs11.getString("b.mname") + " " + rs11.getString("b.lname");
               
                ResultSet classes = DB.getResultset("select* from class where (Teacher_ID = '" + userid + "')&&(((removed_date is NULL) && ('"+yearmon+"' >= SUBSTRING(Created_date,1,7))) ||  ('"+yearmon+"' <= (SUBSTRING(removed_date,1,7)) && ('"+yearmon+"' >= SUBSTRING(Created_date,1,7)))) ");
                while (classes.next()) {
                    ResultSet subject = DB.getResultset("select subject_name from subject where subject_id = '" + classes.getString("subject_id") + "' ");
                    ResultSet grade = DB.getResultset("select grade_name from Grade where Grade_id ='" + classes.getString("grade_id") + "'");

                    Vector vrow = new Vector();
                    vrow.add(classes.getString("class_id") + "");

                    if (subject.next()) {
                        vrow.add(subject.getString("subject_name"));
                    }
                    if (grade.next()) {
                        vrow.add(grade.getString("grade_name"));
                    }



                    ResultSet totalstudents = DB.getResultset("select count(user_student) as coun from student_class where (class_id = '" + classes.getString("class_id") + "') && ( is_active = '1' ) ");
                    if (totalstudents.next()) {
                        vrow.add(totalstudents.getString("coun") + "");
                    }

                    String payidstude;
                    ResultSet payiedforthismonth = DB.getResultset("select count(user_student_id) as con from  payment_invoice_student where ( month = '" + month + "' ) && ( class_id = '" + classes.getString("class_id") + "') && (pay_type = 'monthlypayment') &&  (Date_Time like  '" + year + "_______________') ");
                    if (payiedforthismonth.next()) {

                        payidstude = payiedforthismonth.getString("con") + "";
                        vrow.add(payidstude);

                    } else {

                        payidstude = "0";
                        vrow.add(payidstude);
                    }
                    String montlyfee = classes.getString("montly_fee");
                    vrow.add(userid);

                    double d = Math.round((Integer.parseInt(payidstude) * Double.parseDouble(montlyfee) * Double.parseDouble(classes.getString("Teacher_pay_present"))) / 100);

                    vrow.add(d + "0");
                    vrow.add(usrname);
                    df.addRow(vrow);
                }
            }
            String path1 = "teacherpaysheet1.jrxml";
            params.put("rep", "Class by Class");
            if (res == 1) {
                path1 = "teacherpaysheet3.jrxml";
                params.put("rep", "Teacher By Teacher");
                for (int i = 0; i < df.getRowCount(); i++) {
                    
                    String id = df.getValueAt(i, 5).toString();
                    double income = Double.parseDouble(df.getValueAt(i, 6).toString());

                    for (int j = i + 1; j < df.getRowCount(); j++) {
                        if (df.getValueAt(j, 5).toString().equals(id)) {
                            income = income + Double.parseDouble(df.getValueAt(j, 6).toString());
                            df.removeRow(j);
                            j = j - 1;                   
                        }
                    }
                    df.setValueAt(income + "0", i, 6);
                }
            }


            JRTableModelDataSource datasource = new JRTableModelDataSource(table.getModel());
            String reportSource = System.getProperty("user.dir") + "/reports/" + path1;

            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);

            JRViewer jview = new JRViewer(jasperPrint);
            jb.removeAll();
            jb.add("class-by-class", jview);
            jview.setZoomRatio((float) 1.0);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void totalpament(String year, String month, JTabbedPane jb) {

        try {


            Map<String, Object> params = new HashMap<String, Object>();
            params.put("year", year + "");
            params.put("month", month + "");
            String reportSource = System.getProperty("user.dir") + "/reports/teacherpaysheet2.jrxml";
            JasperReport jreport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, params, DB.getmyCon());

            JRViewer jview = new JRViewer(jprint);
            jb.removeAll();

            jb.add("class-by-class", jview);
            jview.setZoomRatio((float) 1.0);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




// ResultSet rere = DB.getResultset("select* from teacher_payment where (year = '" + year + "') && (teacher_id = '" + userid + "') &&(month = '" + month + "')");
//            if (rere.next()) {
//
//                advance.setText(rere.getString("advance"));
//                balance.setText((teachertotal - Double.parseDouble(rere.getString("advance"))) + "");
//                payamut.setText(balance.getText());
//                addAdvances(rere.getString("advance_payied_date"));
//            } else {
//                ((DefaultTableModel) getAdvancetaken().getModel()).setRowCount(0);
//                advance.setText("0");
//                balance.setText(thismonth.getText());
//                payamut.setText(balance.getText());
//            }
//            teachertotal = 0;
