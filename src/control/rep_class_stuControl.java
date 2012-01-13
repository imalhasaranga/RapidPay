
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
import view.Reports.rep_class_stu;

/**
 *
 * @author gihan
 */
public final class rep_class_stuControl {

    rep_class_stu repstu;
    private int classid = 0;
    private int totstudents = 0;
    String class_students[];

    public void loadClass(String day, JComboBox cmbclass, JLabel lbl, JTable tbl) {
        cmbclass.removeAllItems();
        this.clearTable(tbl);

        try {
            ResultSet rs1 = DB.getResultset("select cl.class_id as class, cl.Teacher_ID as tid, cl.Subject_id as sid, cl.Grade_id as gid, cl.Start_time as st, cl.Ending_time as et, um.fname as fname, um.lname as lname, gr.grade_name as grname, sb.subject_name as sbname from Class cl, user_main um, grade gr, subject sb where cl.Day = '" + day + "' AND cl.Teacher_ID = um.user_id AND cl.Subject_id = sb.subject_id AND cl.Grade_id = gr.grade_id AND cl.is_active='1'");
            while (rs1.next()) {
                classid = rs1.getInt("class");
                String classdetail = rs1.getString("fname") + " " + rs1.getString("lname") + " / " + rs1.getString("grname") + " / " + rs1.getString("sbname") + " / " + rs1.getString("st") + " to " + rs1.getString("et") + "-" + rs1.getString("class");

                lbl.setText("" + classid);
                cmbclass.addItem(classdetail);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(repstu, "Exception: " + e);
        }



    }

    public int getClassId(JLabel lbl) {
        classid = Integer.parseInt(lbl.getText());
        return classid;

    }

    public void setClassId(String classval, JLabel lbl) {
        String thisclassval = classval;
        String clid[] = thisclassval.split("-");
        classid = Integer.parseInt(clid[1]);
        lbl.setText("" + classid);

    }

    public void getStudents(JLabel lbl, JTable tbl, JLabel lbltot) {
        this.clearTable(tbl);
        DefaultTableModel dt = (DefaultTableModel) tbl.getModel();
        System.out.println("class id is"+this.getClassId(lbl));
        try {
            ResultSet rs2 = DB.getResultset("select user_student as uid1, fname, mname, lname, Adress_num as adno, Street, city, " +
                    "Gardn as guard, Gard_name as gname, Gard_contact as gcontact, Gard_workplace_address gwaddress, Gard_wordplace_contact gwcontact " +
                    "from student_class cl, user_main um, user_student us where cl.class_id = '" + this.getClassId(lbl) + "' AND cl.is_active = '1' AND um.is_active = '1' " +
                    "AND um.user_id = cl.user_student AND um.user_id = us.User_student_id ORDER BY um.user_id");
            while (rs2.next()) {
                Vector vec = new Vector();
                String sname = rs2.getString("fname") + " " + rs2.getString("mname") + " " + rs2.getString("lname");
                String saddress = rs2.getString("adno") + " " + rs2.getString("street") + " " + rs2.getString("city");
                vec.add(rs2.getString("uid1"));
                vec.add(sname);
                vec.add(saddress);
                vec.add(rs2.getString("guard"));
                vec.add(rs2.getString("gname"));
                vec.add(rs2.getString("gcontact"));
                vec.add(rs2.getString("gwaddress"));
                vec.add(rs2.getString("gwcontact"));

                dt.addRow(vec);
            }

            this.getTotStu(lbl, lbltot);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(repstu, "ERROR from getNotPaid:" + e);
            e.printStackTrace();
        }

    }

    public int getTotStu(JLabel lbl, JLabel lbltot) {
        try {
            ResultSet rs3 = DB.getResultset("select COUNT(user_student) as totstudents from student_class cl, user_main um where cl.class_id = '" + this.getClassId(lbl) + "' AND cl.is_active = 1 AND um.is_active = 1 AND um.user_id = cl.user_student");
            rs3.next();
            totstudents = rs3.getInt("totstudents");
            lbltot.setText("" + totstudents);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(repstu, "ERROR - getTotStu: " + e);
        }


        return totstudents;
    }

    void clearTable(JTable tbl) {
        DefaultTableModel dt = (DefaultTableModel) tbl.getModel();
        int count = tbl.getRowCount();
        for (int x = 0; x < count; x++) {
            dt.removeRow(0);
        }
    }

    public void CrateReport(JTable table, String classname) {



        Map<String, Object> params = new HashMap<String, Object>();
        params.put("classname", classname);
        

        JRTableModelDataSource datasource = new JRTableModelDataSource(table.getModel());
        String reportSource = System.getProperty("user.dir") + "/reports/rep_class_students.jrxml";
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println(e);
        }



    }
}
