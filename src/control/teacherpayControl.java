
package control;

import com.toedter.components.JSpinField;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DB;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gihan
 */
public final class teacherpayControl {

    private JTable advancetaken;

    public static void StudentSeach(JScrollPane js, String value, JList jl) {

        if (value.length() != 0) {
            try {
                ResultSet rs = null;
                js.setVisible(true);


                rs = DB.getResultset("select* from user_main where (User_type_id=(select user_typeid from user_type where user_type='Teacher'))&& ((Fname like '" + value + "%') || (Mname like '" + value + "%') || (Lname like '" + value + "%') ) && is_active ='1' ");


                Vector v = new Vector();
                while (rs.next()) {
                    v.add(rs.getString("Fname") + " " + rs.getString("Mname") + " " + rs.getString("LName") + "-" + rs.getString("User_id"));
                }
                jl.setListData(v);
                jl.setVisible(true);
                if (v.size() == 0) {
                    js.setSize(js.getWidth(), 0);
                } else {
                    int height = (22 + (v.size() - 1) * 17);
                    js.setSize(js.getWidth(), height);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            js.setVisible(false);
        }
    }

    public static void key_release_search(JScrollPane js, String name, String query, JList jl) {
        try {
            js.setVisible(true);

            Vector v = new Vector();
            ResultSet rs = DB.getResultset(query);

            while (rs.next()) {
                String full = rs.getString(1);
                String fullname[] = full.split(" ");
                for (int i = 0; i < fullname.length; i++) {
                    String namepart = fullname[i];
                    if (namepart.startsWith(name) && (!v.contains(full))) {
                        v.add(full);
                    }
                }
            }
            jl.setListData(v);
            jl.setVisible(true);
            js.setVisible(true);

            if (v.size() == 0) {
                js.setSize(js.getWidth(), 0);
            } else {
                int height = (37 + (v.size() - 1) * 17);
                if (height < 400) {
                    js.setSize(js.getWidth(), height);
                } else {
                    js.setSize(js.getWidth(), 400);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void settingFocus(java.awt.event.KeyEvent evt, JList list) {
        try {
            int key = evt.getKeyCode();
            if (key == KeyEvent.VK_DOWN) {
                list.grabFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select a NIC Number", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static void listclicked(JList jl, JTextField name, JTextField nic, JScrollPane js) {
        String name_nic = jl.getSelectedValue().toString();
        String namesplit[] = name_nic.split("-");
        name.setText(namesplit[0]);
        nic.setText(namesplit[1]);
        name.setFocusable(true);
        js.setVisible(false);
    }

    public static void list_key_release(java.awt.event.KeyEvent evt, JTextField tf) {
        try {
            if ((evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_UP)) {
                String s = Character.toString(evt.getKeyChar());
                tf.grabFocus();
                tf.setText(tf.getText().concat(s));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select a NIC Number", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public String searchByUserid(String userid, String text, JLabel person, JLabel payamut2, JLabel lastpaidmonth, JComboBox month, JTable details, JLabel payamut, JLabel totalpayment, JLabel advance, JLabel balance, JSpinField field) {

        try {
            ResultSet rss = DB.getResultset("select * from user_main where (user_id = '" + userid + "') && (User_type_id=(select user_typeid from user_type where user_type='Teacher'))");
            if (rss.next()) {
                person.setText(rss.getString("fname") + " " + rss.getString("mname") + " " + rss.getString("lname"));

                String month1 = null;
                ResultSet res = DB.getResultset("select year,month from Teacher_payment where (teacher_id = '" + userid + "') order by year desc limit 1");
                if (res.next()) {
                    int mon = Integer.parseInt(res.getString("month"));
                    month1 = mon + "";

                } else {
                    Calendar cal = Calendar.getInstance();
                    month1 = "" + cal.get(Calendar.MONTH);

                }
                month.setSelectedItem((Integer.parseInt(month1)) + "");


                searchAlgorythem(userid, month1, details, lastpaidmonth, totalpayment, advance, balance, payamut, field.getValue() + "");
                lastpaidmonth.setText(month1);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry No Teacher found for this id", "ERROR", JOptionPane.ERROR_MESSAGE);
                person.setText("");
                ((DefaultTableModel) details.getModel()).setRowCount(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        month.setEnabled(true);

        return userid;
    }
    double teachertotal = 0;

    public void searchAlgorythem(String userid, String month, JTable table, JLabel lastpayidmonth, JLabel thismonth, JLabel advance, JLabel balance, JLabel payamut, String year) {


        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        String yearmon = year + "-" + (month.length() == 1 ? "0" + month : month);

        try {

            ResultSet classes = DB.getResultset("select* from class where (Teacher_ID = '" + userid + "') &&(((removed_date is NULL) && ('" + yearmon + "' >= SUBSTRING(Created_date,1,7))) ||  ('" + yearmon + "' <= (SUBSTRING(removed_date,1,7)) && ('" + yearmon + "' >= SUBSTRING(Created_date,1,7)))) ");

            while (classes.next()) {
                ResultSet subject = DB.getResultset("select subject_name from subject where subject_id = '" + classes.getString("subject_id") + "' ");
                ResultSet grade = DB.getResultset("select grade_name from Grade where Grade_id ='" + classes.getString("grade_id") + "'");

                Vector vrow = new Vector();

                vrow.add(classes.getString("class_id"));

                if (subject.next()) {
                    vrow.add(subject.getString("subject_name"));
                }
                if (grade.next()) {
                    vrow.add(grade.getString("grade_name"));
                }

                vrow.add(classes.getString("day"));
                vrow.add(classes.getString("start_time") + "-" + classes.getString("ending_time"));

                ResultSet totalstudents = DB.getResultset("select count(user_student) as coun from student_class where (class_id = '" + classes.getString("class_id") + "') && ( is_active = '1' ) ");
                if (totalstudents.next()) {
                    vrow.add(totalstudents.getString("coun"));
                }
                String payidstude;
                ResultSet payiedforthismonth = DB.getResultset("select count(user_student_id) as con from  payment_invoice_student where ( month = '" + month + "' ) && ( class_id = '" + classes.getString("class_id") + "') && (pay_type = 'monthlypayment') &&  (Date_Time like  '" + year + "_______________') ");
                if (payiedforthismonth.next()) {

                    payidstude = payiedforthismonth.getString("con");
                    vrow.add(payidstude);

                } else {

                    payidstude = "0";
                    vrow.add(payidstude);
                }
                String montlyfee = classes.getString("montly_fee");
                vrow.add(montlyfee);


                double d = Math.round((Integer.parseInt(payidstude) * Double.parseDouble(montlyfee) * Double.parseDouble(classes.getString("Teacher_pay_present"))) / 100);
                teachertotal = d + teachertotal;
                vrow.add(d);

                df.addRow(vrow);

            }
            thismonth.setText(teachertotal + "");



            //

            ResultSet rere = DB.getResultset("select* from teacher_payment where (year = '" + year + "') && (teacher_id = '" + userid + "') &&(month = '" + month + "')");
            if (rere.next()) {

                advance.setText(rere.getString("advance"));
                balance.setText((teachertotal - Double.parseDouble(rere.getString("advance"))) + "");
                payamut.setText(balance.getText());
                addAdvances(rere.getString("advance_payied_date"));
            } else {
                ((DefaultTableModel) getAdvancetaken().getModel()).setRowCount(0);
                advance.setText("0");
                balance.setText(thismonth.getText());
                payamut.setText(balance.getText());
            }
            teachertotal = 0;


        } catch (Exception e) {
            e.printStackTrace();
        }


        System.gc();

    }

    public boolean addDetails(String teacherid, String month, String fullamount, String advance, String userstaf, JLabel advance1, JLabel totalpayment, String year) {
        String balnce = (Double.parseDouble(fullamount) - Double.parseDouble(advance)) + "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        Connection con = null;
        try {
            con = DB.getmyCon();
            con.setAutoCommit(false);
            String id = DB.lastinsertId("teacher_payment", "inovoice_num", con);
            int i = id == null ? 1 : Integer.parseInt(id) + 1;

            con.createStatement().executeUpdate("insert into teacher_payment(year,teacher_id,month,full_amount,advance,balance,advance_payied_date,balance_payid_by_user_staff,advance_payied_by_user_staff,inovoice_num, balnace_payied_date) " + "values('" + year + "','" + teacherid + "','" + month + "','" + fullamount + "','" + advance + "','" + balnce + "','" + (date.toString() + " " + advance) + "','" + userstaf + "','" + userstaf + "','" + i + "', '" + date + "' )");

        } catch (Exception e) {


            try {
                double totaladvance = (Double.parseDouble(advance1.getText()) + Double.parseDouble(advance));
                double totalblance = (Double.parseDouble(totalpayment.getText()) - totaladvance);

                con.createStatement().executeUpdate("update teacher_payment set " +
                        "advance ='" + totaladvance + "'," +
                        "balance ='" + totalblance + "'," +
                        "balnace_payied_date='" + date + "' ," +
                        "advance_payied_date =  CONCAT(advance_payied_date,'" + ("@" + date.toString() + " " + totaladvance) + "')," +
                        "balance_payid_by_user_staff ='" + userstaf + "' ," +
                        "advance_payied_by_user_staff ='" + userstaf + "' ," +
                        "full_amount='" + totalpayment.getText() + "'" +
                        "where (year='" + year + "') && (teacher_id= '" + teacherid + "') && (month = '" + month + "')");
            } catch (Exception ex) {
                System.out.println(ex + "gggggg");
                return false;
            }

        }
        try {

            con.commit();
            con.setAutoCommit(true);
            con = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public void searchfirst100(JTable details) {
        DefaultTableModel df = (DefaultTableModel) details.getModel();
        df.setRowCount(0);

        try {

            ResultSet results = DB.getResultset("select* from teacher_payment a, user_main b where (a.teacher_id = b.user_id) order by a.inovoice_num desc limit 100");

            while (results.next()) {

                Vector ve = new Vector();
                ve.add(results.getString("a.inovoice_num"));
                ve.add(results.getString("a.teacher_id"));
                ve.add(results.getString("b.fname") + " " + results.getString("b.mname") + " " + results.getString("b.lname"));
                ve.add(results.getString("a.full_amount"));
                ve.add(results.getString("a.advance_payied_date"));
                df.addRow(ve);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public JTable getAdvancetaken() {
        return advancetaken;
    }

    public void setAdvancetaken(JTable advancetaken) {
        this.advancetaken = advancetaken;
    }

    public void addAdvances(String adSt) {
        DefaultTableModel df = (DefaultTableModel) getAdvancetaken().getModel();
        df.setRowCount(0);
        double x,  y;
        try {
            String[] datesvals = adSt.split("@");
            for (int q = 0; q < datesvals.length; q++) {
                String dataval[] = datesvals[q].split(" ");
                Vector v = new Vector();
                v.add(dataval[0]);
                v.add(dataval[1]);

                if (q == 0) {
                    v.add(dataval[1]);
                } else {


                    v.add((Double.parseDouble(dataval[1]) - Double.parseDouble(df.getValueAt(q - 1, 2).toString())) + "");
                }
                df.addRow(v);
            }

        } catch (Exception e) {
            System.out.println(e);
            Vector v = new Vector();
            try {
                String[] extval = adSt.trim().split(" ");
                v.add(extval[0]);
                v.add(extval[1]);
                v.add(extval[1]);
                df.addRow(v);

            } catch (Exception e1) {
                System.out.println("e1" + e1);
            }

        }


    }

    public void getPaidReport(JComboBox month, JSpinField year, JLabel person, JTable classes) {

        if (classes.getRowCount() > 0) {

            int op = JOptionPane.showConfirmDialog(null, "Are you sure want to view the report of paid Students for this class ??", "Students", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                int row = classes.getSelectedRow();
                String classname = person.getText() + " / " + classes.getValueAt(row, 2) + " / " + classes.getValueAt(row, 1) + " / " + classes.getValueAt(row, 3) + " / " + classes.getValueAt(row, 4);
                String Year = year.getValue() + "";
                String Month = month.getSelectedItem().toString();
                String class_id = classes.getValueAt(row, 0).toString();

                try {
                    Map<String, Object> params = new HashMap<String, Object>();

                    params.put("classname", classname);
                    params.put("Month", Month);
                    params.put("year", Year);
                    params.put("classid", class_id);

                    String reportSource = System.getProperty("user.dir") + "/reports/rep_class_students_PaidFormonth.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DB.getmyCon());
                    JasperViewer.viewReport(jasperPrint, false);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Teacher for Student report", "REPORT ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
