package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.DB;
import view.Mainwindow;

/**
 *
 * @author Imal
 */
public final class freemgtControl {

    DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public double Institutefee1;
    public double LectureFee1;
    private String invoiceid;

    public void calculateInsandLecFee(String studid) {
        Institutefee1 = 0;
        LectureFee1 = 0;
        Date today = new Date();
        try {
            ResultSet rs = DB.getResultset("select* from payment_invoice_student a join class b on a.class_id = b.class_id  join subject d on b.subject_id = d.subject_id join user_main c on b.Teacher_id = c.user_id "
                    + "where user_student_id = '" + studid + "' && "
                    + "pay_type = 'monthlypayment' && "
                    + "Date_time like concat('" + OccationalLogics.da.format(today) + "','_','" + OccationalLogics.time.format(today) + "','%')");

            while (rs.next()) {

                Institutefee1 = Institutefee1 + (Double.parseDouble(rs.getString("class_fees")) * Double.parseDouble(rs.getString("Institute_presentage")) / 100);
                LectureFee1 = LectureFee1 + (Double.parseDouble(rs.getString("class_fees")) * Double.parseDouble(rs.getString("Teacher_pay_present")) / 100);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void StudentSeach(JScrollPane js, String value, JList jl) {

        if (value.length() != 0) {
            try {
                ResultSet rs = null;
                js.setVisible(true);


                rs = DB.getResultset("select* from user_main where (User_type_id=(select user_typeid from user_type where user_type='Student'))&& concat(Fname,' ', Mname,' ',Lname) like '" + value + "%' && ( is_active = '1' )");

                ArrayList vsearvh = new ArrayList();
                while (rs.next()) {
                    vsearvh.add(rs.getString("Fname") + " " + rs.getString("Mname") + " " + rs.getString("LName") + "-" + rs.getString("User_id"));
                }
                jl.setListData(vsearvh.toArray());
                jl.setVisible(true);
                if (vsearvh.isEmpty()) {
                    js.setSize(js.getWidth(), 0);
                } else {

                    js.setSize(js.getWidth(), (22 + (vsearvh.size() - 1) * 18));

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

            ArrayList v = new ArrayList();
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
            jl.setListData(v.toArray());
            jl.setVisible(true);
            js.setVisible(true);

            if (v.isEmpty()) {
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

            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                list.grabFocus();

            }
        } catch (Exception e) {
            System.out.println(e);
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
            System.out.println(e);
        }

    }

    public String searchByUserid(String userid, JLabel studentnam, JLabel payamut, JComboBox cmbmonth, JTable tblclass, JLabel ltotal, JLabel luptodatepay, JLabel lbalancefor, JTextField lastpaidmonth) {
        payamut.setText("0");
        cmbmonth.setSelectedIndex(0);
        cmbmonth.grabFocus();
        lastpaidmonth.setEditable(false);
        lastpaidmonth.setBackground(Color.white);

        try {
            ResultSet rss = DB.getResultset("select CONCAT(fname,' ',mname,' ',lname) as Fulname from user_main where (user_id = '" + userid + "') && (is_active= '1') && (User_type_id=(select user_typeid from user_type where user_type='Student'))");
            if (rss.next()) {
                studentnam.setText(rss.getString("Fulname"));

                combosearch(userid, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);
                if (lastpaidmonth.getText().equals("0")) {

                    lastpaidmonth.setBackground(Color.red);
                    lastpaidmonth.setText(String.valueOf((new Date().getMonth()) + 1));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry No Student found for this id", "ERROR", JOptionPane.ERROR_MESSAGE);
                studentnam.setText("");
                ((DefaultTableModel) tblclass.getModel()).setRowCount(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userid;
    }

    public void combosearch(String userid, JLabel payamut, JComboBox cmbmonth, JTable tblclass, JLabel ltotal, JLabel luptodatepay, JLabel lbalancefor, JTextField lastpaidmonth) {


        DefaultTableModel df = (DefaultTableModel) tblclass.getModel();
        df.setRowCount(0);
        try {
            int a = cmbmonth.getSelectedIndex();

            if (a == 0) {
                lastpaidmonth.setText("0");

                ResultSet rest = DB.getResultset("SELECT* FROM FeesMangeInfo WHERE StuID ='" + userid + "'");

                int year = Calendar.getInstance().get(Calendar.YEAR);
                ResultSet reo = DB.getResultset("select MAX(CAST(MONTH AS SIGNED)) as k from Current_month where  (user_student = '" + userid + "') && (Date_Time like '" + year + "_______________')");
                if (reo.next()) {
                    lastpaidmonth.setText(reo.getString("k") == null ? "0" : reo.getString("k"));
                }
                while (rest.next()) {
                    //
                    String classid = rest.getString("StuClass");
                    ArrayList v = new ArrayList();
                    v.add(classid);
                    v.add(rest.getString("PayDay"));
                    v.add(rest.getString("subjectnm"));
                    v.add(rest.getString("TeacherName"));
                    v.add(rest.getString("StartTime") + " - " + rest.getString("EndTime"));
                    v.add(rest.getString("classFees"));
                    //
                    ResultSet re = DB.getResultset("select* from Current_month where  (user_student = '" + userid + "') && (user_class ='" + classid + "') && (Date_Time like '" + year + "_______________')  order by (CAST(MONTH AS SIGNED)) desc");
                    if (re.next()) {
                        if (Integer.parseInt(lastpaidmonth.getText()) <= Integer.parseInt(re.getString("month"))) {
                            lastpaidmonth.setText(re.getString("month"));
                            v.add("paydB");
                        } else {
                            v.add("No");
                        }
                    } else {
                        v.add("No");
                    }
                    df.addRow(v.toArray());
                }

            } else if (a == 1) {

                ResultSet rest = DB.getResultset("select* from FeesMangeInfo where StuID ='" + userid + "' ");
                while (rest.next()) {
                    //
                    String classid = rest.getString("StuClass");
                    ArrayList v = new ArrayList();
                    v.add(classid);
                    v.add(rest.getString("PayDay"));
                    v.add(rest.getString("subjectnm"));
                    v.add(rest.getString("TeacherName"));
                    v.add(rest.getString("StartTime") + " - " + rest.getString("EndTime"));
                    v.add(rest.getString("classFees"));
                    //
                    v.add("No");
                    df.addRow(v.toArray());
                }
                int i = Integer.parseInt(lastpaidmonth.getText());
                i = (i == 12) ? 1 : i + 1;
                lastpaidmonth.setText("" + i);
            }



            double totalpay = 0;
            double payid = 0;
            double balnce = 0;
            for (int i = 0; i < df.getRowCount(); i++) {

                totalpay = Double.parseDouble(df.getValueAt(i, 5).toString()) + totalpay;
                if (df.getValueAt(i, 6).toString().equals("paydB")) {
                    payid = Double.parseDouble(df.getValueAt(i, 5).toString()) + payid;
                }
            }

            balnce = totalpay - payid;
            ltotal.setText(totalpay + "");
            luptodatepay.setText(payid + "");
            lbalancefor.setText(balnce + "");


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.gc();

    }

    public static void LoadPaymentDetails(JTable tbclass, String userid, int year, int month) {
        try {
            System.out.println(year + " " + month);
            DefaultTableModel df = (DefaultTableModel) tbclass.getModel();
            df.setRowCount(0);


            ResultSet rest = DB.getResultset("SELECT* FROM FeesMangeInfo WHERE StuID ='" + userid + "'");



            while (rest.next()) {

                //
                String classid = rest.getString("StuClass");
                ArrayList v = new ArrayList();

                v.add(rest.getString("PayDay"));
                v.add(rest.getString("subjectnm"));
                v.add(rest.getString("TeacherName"));
                v.add(rest.getString("StartTime") + " - " + rest.getString("EndTime"));

                //
                ResultSet re = DB.getResultset("select* from Current_month where  (user_student = '" + userid + "') && (user_class ='" + classid + "') && (Date_Time like '" + year + "_______________')  order by (CAST(MONTH AS SIGNED)) desc");
                if (re.next()) {
                    if (month <= Integer.parseInt(re.getString("month"))) {

                        v.add("PAYIED");
                    } else {
                        v.add("NOT PAYIED");
                    }
                } else {
                    v.add("NOT PAYIED");
                }

                df.addRow(v.toArray());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public boolean addDetailsToDB(String studentid, JTable student, JComboBox cmbmonth, JTextField lastpaidmonth) {
        Connection con = null;
        try {
            Date dat = new Date();
            int LastPaidMonth = Integer.parseInt(lastpaidmonth.getText());        //new Date().getMonth() + 1;

            con = DB.getmyCon();
            con.setAutoCommit(false);
            Savepoint save1 = con.setSavepoint();

            DB.getmyCon().createStatement().execute("CALL getInvoiceID(@Y)");
            ResultSet rsx = DB.getResultset("SELECT @Y AS id");
            rsx.first();
            String id = rsx.getString("id");
            int lastinvoceid = Integer.parseInt(id);

//            Statement lastid = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet lasidresult = lastid.executeQuery("select max(invoice_id ) as id1 from payment_invoice_student ");
//            lasidresult.first();
//            String id = lasidresult.getString("id1");
//            int lastinvoceid = Integer.parseInt(id == null ? "0" : id) + 1;
            setInvoiceid(lastinvoceid + "");

            for (int j = 0; j < student.getRowCount(); j++) {

                if (student.getValueAt(j, 6).toString().equals("paydN")) {

                    Statement st = con.createStatement();
                    st.executeUpdate("insert into payment_invoice_student(invoice_id,user_student_id,class_id,class_fees,month,user_stafff,pay_type,Date_time)" + " values('" + lastinvoceid + "','" + studentid + "','" + student.getValueAt(j, 0).toString() + "','" + student.getValueAt(j, 5).toString() + "','" + LastPaidMonth + "','" + Mainwindow.UserStaffID + "','monthlypayment','" + format.format(dat) + "')", Statement.RETURN_GENERATED_KEYS);
                    ResultSet genkey = st.getGeneratedKeys();
                    genkey.first();
                    String genKey = genkey.getString(1);
                    ResultSet rs = con.createStatement().executeQuery("select* from current_month where (user_student = '" + studentid + "') && (user_class ='" + student.getValueAt(j, 0).toString() + "') ");
                    if (rs.next()) {
                        con.createStatement().executeUpdate("update current_month set payment_id='" + genKey + "', month='" + LastPaidMonth + "',Date_Time = '" + format.format(dat) + "'" + " where (user_class = '" + student.getValueAt(j, 0).toString() + "') && ( user_student='" + studentid + "') ");
                    } else {
                        con.createStatement().executeUpdate("insert into current_month(payment_id,month,user_student,Date_Time,user_class) values('" + genKey + "','" + LastPaidMonth + "','" + studentid + "','" + format.format(dat) + "','" + student.getValueAt(j, 0).toString() + "')   ");
                    }
                    con.commit();
                }

            }
            con.setAutoCommit(true);
            con = null;

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(freemgtControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return true;
    }

    public void loadlast100rec(JTable table1) {
        DefaultTableModel df = (DefaultTableModel) table1.getModel();
        df.setRowCount(0);
        try {
            ResultSet rs = DB.getResultset("select* from payment_invoice_student a, user_main b  where (a.user_student_id = b.user_id) && ( a.pay_type ='monthlypayment') order by a.payment_id desc limit 200");
            while (rs.next()) {

                ArrayList v = new ArrayList();
                v.add(rs.getString("a.invoice_id"));
                v.add(rs.getString("a.class_id"));
                v.add(rs.getString("b.user_id"));
                v.add(rs.getString("b.Fname") + " " + rs.getString("b.Lname"));
                v.add(rs.getString("class_fees"));
                v.add(rs.getString("Date_Time"));
                df.addRow(v.toArray());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean deleteDetails(String invoiceid, String clasid, String UserStaff) {

        try {

            ResultSet rs = DB.getResultset("select* from payment_invoice_student where Invoice_id='" + invoiceid + "' && class_id ='" + clasid + "' ");
            if (rs.next()) {
                DB.stexecuteUpdate("delete from payment_invoice_student where Invoice_id='" + invoiceid + "' && class_id ='" + clasid + "' ");
                ResultSet rout = DB.getResultset("select*  from payment_invoice_student where (class_id='" + clasid + "') && (user_student_id='" + rs.getString("user_student_id") + "') && (pay_type != 'Admission') ORDER BY Date_Time DESC LIMIT 1");
                if (rout.next()) {
                    DB.stexecuteUpdate("insert into current_month(payment_id,month,user_student,user_class,Date_time) values("
                            + "'" + rout.getString("Payment_id") + "',"
                            + "'" + rout.getString("month") + "',"
                            + "'" + rout.getString("user_student_id") + "',"
                            + "'" + rout.getString("class_id") + "',"
                            + "'" + rout.getString("Date_Time") + "') ");

                }

                DB.stexecuteUpdate("INSERT into deleted_bills"
                        + "(payemnt_id,Invoice_id,user_student,Class_id,fee,month,User_staff_id,pay_type,Date_Time) "
                        + "VALUES('" + rs.getString("Payment_id") + "','" + rs.getString("Invoice_id") + "','" + rs.getString("User_student_id") + "',"
                        + "'" + rs.getString("class_id") + "','" + rs.getString("class_fees") + "','" + rs.getString("month") + "','" + UserStaff + "','" + rs.getString("pay_type") + "','" + getDateTime() + "')");


                JOptionPane.showMessageDialog(null, "Bill Removed", "Bill info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "sorry wrong details, can't find the bill", "Bill info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getDateTime() {
        Calendar currdate = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String datenow = format1.format(currdate.getTime());

        return datenow;
    }
}
