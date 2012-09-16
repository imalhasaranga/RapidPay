package control;


import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author Imal
 */
public final class InActiveStudentControl {

    private JTable jt;
    private String datedif;
    private JTextField t;
    private JComboBox box;
    private JCheckBox button;

    public void loadToTable() {
        String value = button.isSelected() == true ? "where c.is_active ='1'" : "";
        DefaultTableModel df = (DefaultTableModel) jt.getModel();
        df.setRowCount(0);
        try {
            ResultSet rest = DB.getResultset(
                    " "
                    + "SELECT "
                    + "  MAX(b.Date_Time), "
                    + "  a.user_student_id, "
                    + "  DATEDIFF(CURRENT_DATE, b.Date_Time) AS datedif, "
                    + "  c.fname, "
                    + "  c.mname, "
                    + "  c.lname, "
                    + "  b.Date_Time, "
                    + "  c.is_active "
                    + "FROM ((user_student a "
                    + "    LEFT JOIN lastpayments b "
                    + "      ON a.User_student_id = b.user_student_id) "
                    + "   JOIN user_main c "
                    + "     ON a.User_student_id = c.User_id) "
                    + " " + value + " GROUP BY a.user_student_id "
                    + "");

            while (rest.next()) {
                String Datedifferance = rest.getString("datedif");
                if (Datedifferance != null) {
                    if (Integer.parseInt(Datedifferance) >= Integer.parseInt(getDatedif())) {
                        ArrayList v = new ArrayList();
                        v.add(rest.getString("a.user_student_id"));
                        v.add(rest.getString("fname") + " " + rest.getString("mname") + " " + rest.getString("lname"));
                        v.add(rest.getString("Date_Time"));
                        v.add(Datedifferance);
                        v.add(rest.getString("is_active").equals("0") ? "InActive" : "StillActive");
                        df.addRow(v.toArray());
                    }
                } else {
                    ArrayList v = new ArrayList();
                    v.add(rest.getString("a.user_student_id"));
                    v.add(rest.getString("fname") + " " + rest.getString("mname") + " " + rest.getString("lname"));
                    v.add("Havent Paid");
                    v.add("from start");
                    v.add(rest.getString("is_active").equals("0") ? "InActive" : "StillActive");
                    df.addRow(v.toArray());

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void onTableClick() {
        if (jt.getSelectedRow() != -1) {
            String status = jt.getValueAt(jt.getSelectedRow(), 4).toString();
            jt.setValueAt(status.equals("InActive") ? "StillActive" : "InActive", jt.getSelectedRow(), 4);
        }
    }

    public void inActiveAll() {

        for (int i = 0; i < jt.getRowCount(); i++) {
            jt.setValueAt("InActive", i, 4);
        }

    }

    public void makethemInactive() {
        if (OccationalLogics.showOption("Yes", "No") == 0) {
            try {
                for (int i = 0; i < jt.getRowCount(); i++) {
                    String student_id = jt.getValueAt(i, 0).toString();
                    String activein = jt.getValueAt(i, 4).toString();

                    DB.stexecuteUpdate("update user_main set is_active = '" + (activein.equals("InActive") ? "0" : "1") + "' where User_id = '" + student_id + "'");
                    

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void searchJTable() {
        String val = null;

        if (getBox().getSelectedItem().toString().equals("By Name")) {
            val = "concat(Fname,' ', Mname,' ',Lname) like '%" + getT().getText() + "%' " + (getButton().isSelected() == true ? "&& c.is_active ='1'" : "");
        } else {
            val = "user_id like '%" + getT().getText() + "%' " + (getButton().isSelected() == true ? "&& c.is_active ='1'" : "");
        }

        DefaultTableModel df = (DefaultTableModel) jt.getModel();
        df.setRowCount(0);
        try {

            ResultSet rest = DB.getResultset(
                    " "
                    + "SELECT "
                    + "  MAX(b.Date_Time), "
                    + "  a.user_student_id, "
                    + "  DATEDIFF(CURRENT_DATE, b.Date_Time) AS datedif, "
                    + "  c.fname, "
                    + "  c.mname, "
                    + "  c.lname, "
                    + "  b.Date_Time, "
                    + "  c.is_active "
                    + "FROM ((user_student a "
                    + "    LEFT JOIN lastpayments b "
                    + "      ON a.User_student_id = b.user_student_id) "
                    + "   JOIN user_main c "
                    + "     ON a.User_student_id = c.User_id) "
                    + " where " + val + " GROUP BY a.user_student_id "
                    + "");




            while (rest.next()) {
                String Datedifferance = rest.getString("datedif");
                if (Datedifferance != null) {
                    if (Integer.parseInt(Datedifferance) >= Integer.parseInt(getDatedif())) {
                        ArrayList v = new ArrayList();
                        v.add(rest.getString("a.user_student_id"));
                        v.add(rest.getString("fname") + " " + rest.getString("mname") + " " + rest.getString("lname"));
                        v.add(rest.getString("Date_Time"));
                        v.add(rest.getString("datedif"));
                        v.add(rest.getString("is_active").equals("0") ? "InActive" : "StillActive");
                        df.addRow(v.toArray());
                    }
                } else {
                    ArrayList v = new ArrayList();
                    v.add(rest.getString("a.user_student_id"));
                    v.add(rest.getString("fname") + " " + rest.getString("mname") + " " + rest.getString("lname"));
                    v.add("Havent Paid");
                    v.add("from start");
                    v.add(rest.getString("is_active").equals("0") ? "InActive" : "StillActive");
                    df.addRow(v.toArray());
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public JTable getJt() {
        return jt;
    }

    public void setJt(JTable jt) {
        this.jt = jt;
    }

    public JTextField getT() {
        return t;
    }

    public void setT(JTextField t) {
        this.t = t;
    }

    public JComboBox getBox() {
        return box;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    public JCheckBox getButton() {
        return button;
    }

    public void setButton(JCheckBox button) {
        this.button = button;
    }

    public String getDatedif() {
        return datedif;
    }

    public void setDatedif(String datedif) {
        this.datedif = datedif;
    }
}
