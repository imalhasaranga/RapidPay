
package control;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import view.Reports.rep_nopay;

/**
 *
 * @author gihan
 */
public final class rep_nopayControl {

    rep_nopay repnopay;
    DB con = new DB();
    private int classid = 0;
    String class_students[];
    String paid_students[];
    String nopay_students[];
    String clas_fees;

    public void loadClass(String day, JComboBox cmbclass, JLabel lbl) {
        cmbclass.removeAllItems();

        try {
            ResultSet rs1 = DB.getResultset("select cl.class_id as class, cl.Teacher_ID as tid, cl.Subject_id as sid, cl.Grade_id as gid, cl.Start_time as st, cl.Ending_time as et, um.fname as fname, um.lname as lname, gr.grade_name as grname, sb.subject_name as sbname from Class cl, user_main um, grade gr, subject sb where cl.Day = '" + day + "' AND cl.Teacher_ID = um.user_id AND cl.Subject_id = sb.subject_id AND cl.Grade_id = gr.grade_id And cl.is_active = '1'");
            while (rs1.next()) {
                classid = rs1.getInt("class");
                String classdetail = rs1.getString("fname") + " " + rs1.getString("lname") + " / " + rs1.getString("grname") + " / " + rs1.getString("sbname") + " / " + rs1.getString("st") + " to " + rs1.getString("et") + "-" + rs1.getString("class");

                lbl.setText("" + classid);
                cmbclass.addItem(classdetail);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(repnopay, "Exception: " + e);
        }


    }

    public void setClassId(String classval, JLabel lbl) {
        String thisclassval = classval;
        String clid[] = thisclassval.split("-");
        classid = Integer.parseInt(clid[1]);
        lbl.setText("" + classid);

    }

    public int getClassId(JLabel lbl) {
        classid = Integer.parseInt(lbl.getText());
        return classid;

    }

    public void getNotPaid(JTable tbl, JLabel lbl, int year, String month) {
        this.clearTable(tbl);
        DefaultTableModel dt = (DefaultTableModel) tbl.getModel();

        try {
            ResultSet rs2 = DB.getResultset("select user_student as uid1,class_fees from student_class where class_id = '" + lbl.getText() + "' AND is_active = 1");

            while (rs2.next()) {
                String stid = rs2.getString("uid1");
                clas_fees = rs2.getString("class_fees");
                ResultSet rs3 = DB.getResultset("select user_student_id as uid2 from payment_invoice_student where user_student_id = '" + stid + "' AND pay_type = 'monthlypayment' AND date_time like '" + year + "_______________' AND class_id = '" + lbl.getText() + "' AND month ='" + month + "' ");
                if (rs3.next()) {
                } else {
                    ResultSet rs4 = DB.getResultset("select fname, mname,Contact_number,Adress_num,lname,Street,City from user_main where user_id = '" + stid + "'");
                    rs4.next();

                    Vector vec = new Vector();
                    vec.add(stid);
                    vec.add(rs4.getString("fname") + " " + rs4.getString("mname") + " " + rs4.getString("lname"));
                    vec.add(rs4.getString("Contact_number"));
                    vec.add(rs4.getString("Adress_num") + " " + rs4.getString("Street") + " " + rs4.getString("City"));
                    dt.addRow(vec);

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(repnopay, "ERROR from getNotPaid:" + e);
            e.printStackTrace();
        }
    }

    public void reportPdf(JTable table, String classname, int tablelength) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("classname", classname);
        params.put("tablelenth", tablelength* Double.parseDouble(clas_fees));

        JRTableModelDataSource datasource = new JRTableModelDataSource(table.getModel());
        String reportSource = System.getProperty("user.dir") + "/reports/notpaid.jrxml";
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    void clearTable(JTable tbl) {
        DefaultTableModel dt = (DefaultTableModel) tbl.getModel();
        int count = tbl.getRowCount();
        for (int x = 0; x < count; x++) {
            dt.removeRow(0);
        }
    }
}
