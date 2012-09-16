package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.DB;
import view.editstaff;
import view.editstudent;
import view.editteachers;

/**
 *
 * @author Imal
 */
public final class editpesonDetails {

    public void searchidGetResults(String name, String UserType, JTabbedPane maintab, editteachers eteacher, editstudent estudent, editstaff estaff) {

        String id = null;
        try {
            id = name.split("-")[1];
        } catch (Exception e) {
            id = name;
        }


        if (UserType.equals("Student")) {

            String UserDetails[] = new String[16];

            try {

                ResultSet userdetils = DB.getResultset("select* from User_main a, User_Student b where (a.user_id = b.user_student_id) && (a.user_id = '" + id + "')&&  a.is_active = '1' ");
                if (userdetils.next()) {

                    UserDetails[1] = userdetils.getString("a.User_id");
                    UserDetails[0] = userdetils.getString("a.Fname");
                    UserDetails[2] = userdetils.getString("a.Mname");
                    UserDetails[3] = userdetils.getString("a.LName");
                    UserDetails[4] = userdetils.getString("a.Adress_num");
                    UserDetails[5] = userdetils.getString("a.Street");
                    UserDetails[6] = userdetils.getString("a.City");
                    UserDetails[7] = userdetils.getString("a.Contact_number");
                    UserDetails[8] = userdetils.getString("b.School");
                    ResultSet res = DB.getResultset("select Grade_name from grade where Grade_id = '" + userdetils.getString("b.Grade") + "' ");

                    if (res.next()) {
                        UserDetails[9] = res.getString("Grade_name");
                    }
                    UserDetails[10] = userdetils.getString("b.Gardn");
                    UserDetails[11] = userdetils.getString("b.Gard_name");
                    UserDetails[12] = userdetils.getString("b.Gard_Address");
                    UserDetails[13] = userdetils.getString("b.Gard_contact");
                    UserDetails[14] = userdetils.getString("b.Gard_workplace_address");
                    UserDetails[15] = userdetils.getString("b.Gard_wordplace_contact");

                    for (int i = 0; i < UserDetails.length; i++) {
                        String string = UserDetails[i];
                        if (string == null) {
                            UserDetails[i] = " ";
                        }

                    }

                    estudent.setData(UserDetails, this);
                    maintab.add("Edit Student", estudent);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }







        } else if (UserType.equals("Teacher")) {


            String UserDetails[] = new String[16];

            try {

                ResultSet userdetils = DB.getResultset("select* from User_main a, user_teacher b where (a.user_id = b.User_teacher_id) && (a.user_id = '" + id + "')&& a.is_active = '1' ");
                if (userdetils.next()) {

                    UserDetails[1] = userdetils.getString("a.User_id");
                    UserDetails[0] = userdetils.getString("a.Fname");
                    UserDetails[2] = userdetils.getString("a.Mname");
                    UserDetails[3] = userdetils.getString("a.LName");
                    UserDetails[4] = userdetils.getString("a.Adress_num");
                    UserDetails[5] = userdetils.getString("a.Street");
                    UserDetails[6] = userdetils.getString("a.City");
                    UserDetails[7] = userdetils.getString("a.Contact_number");
                    UserDetails[8] = userdetils.getString("b.Nic");
                    UserDetails[9] = userdetils.getString("b.work_address");
                    UserDetails[10] = userdetils.getString("b.work_contact_number");
                    UserDetails[11] = userdetils.getString("b.Experience");


                    for (int i = 0; i < UserDetails.length; i++) {
                        String string = UserDetails[i];
                        if (string == null) {
                            UserDetails[i] = " ";
                        }

                    }

                    eteacher.setData(UserDetails, this);
                    maintab.add("Edit Teacher", eteacher);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }




        } else if (UserType.equals("Staff")) {

            String UserDetails[] = new String[16];

            try {

                ResultSet userdetils = DB.getResultset("select* from User_main a, user_staff b, user_login c where (a.user_id = b.User_staff_id) && (a.user_id = '" + id + "') && (a.user_id = c.User_mainUser_id)&& a.is_active = '1'");
                if (userdetils.next()) {

                    UserDetails[1] = userdetils.getString("a.User_id");
                    UserDetails[0] = userdetils.getString("a.Fname");
                    UserDetails[2] = userdetils.getString("a.Mname");
                    UserDetails[3] = userdetils.getString("a.LName");
                    UserDetails[4] = userdetils.getString("a.Adress_num");
                    UserDetails[5] = userdetils.getString("a.Street");
                    UserDetails[6] = userdetils.getString("a.City");
                    UserDetails[7] = userdetils.getString("a.Contact_number");
                    UserDetails[8] = userdetils.getString("b.Epf_nuber");
                    UserDetails[9] = userdetils.getString("b.Designation");
                    UserDetails[10] = userdetils.getString("b.M_status");
                    UserDetails[11] = userdetils.getString("b.Basic_sallary");
                    UserDetails[12] = userdetils.getString("c.User_name");
                    UserDetails[13] = userdetils.getString("c.User_password");

                    for (int i = 0; i < UserDetails.length; i++) {
                        String string = UserDetails[i];
                        if (string == null) {
                            UserDetails[i] = " ";
                        }

                    }

                    estaff.setData(UserDetails, this);
                    maintab.add("Edit Staff", estaff);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    public void searchStudent(String userid, JTable table) {
        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            ResultSet rest = DB.getResultset("select* from Student_class where (user_student ='" + userid + "') order by is_active = '1' desc ");
            while (rest.next()) {

                String classid = rest.getString("class_id");

                ResultSet classde = DB.getResultset("select* from class where class_id='" + classid + "' && is_active = '1'");
                if (classde.next()) {
                    Vector v = new Vector();
                    v.add(classid);

                    ResultSet subject = DB.getResultset("select Subject_name from Subject where subject_id ='" + classde.getString("Subject_id") + "'");

                    if (subject.next()) {
                        v.add(subject.getString("subject_name"));
                    }
                    v.add(classde.getString("day"));
                    ResultSet teachername = DB.getResultset("select Fname,Mname,Lname from User_main where User_id='" + classde.getString("Teacher_ID") + "'");
                    if (teachername.next()) {
                        v.add(teachername.getString("Fname") + " " + teachername.getString("Mname") + " " + teachername.getString("Lname"));
                    }

                    v.add(classde.getString("Start_time") + " - " + classde.getString("Ending_time"));

                    if (rest.getString("is_active").equals("1")) {
                        v.add("enrolled");
                    } else {
                        v.add("dropped");
                    }
                    df.addRow(v);
                }



            }





        } catch (Exception e) {
        }

    }

    public boolean removeClasss(JTable table, String userid) {

        if (table.getSelectedRow() != -1) {
            String clasid = table.getValueAt(table.getSelectedRow(), 0).toString();
            try {

                DB.stexecuteUpdate("update Student_class set is_active = '0' where (user_student = '" + userid + "') && ( class_id = '" + clasid + "') ");
            } catch (Exception e) {
            }


        } else {
            JOptionPane.showMessageDialog(null, "Please Select the Class you want to Delete");
            return false;
        }

        return true;
    }

    public boolean addnewclassforstudent(JTable tablae, String studentid) {

        try {

            DefaultTableModel df = (DefaultTableModel) tablae.getModel();
            Connection con = DB.getmyCon();

            String lastinvoiceid = DB.lastinsertId("payment_invoice_student", "Invoice_id"); //// PROBLEM OCCURING CODE LINE /////////
            lastinvoiceid = (lastinvoiceid == null) ? "1" : "" + (Integer.parseInt(lastinvoiceid) + 1);
            con.setAutoCommit(false);
            for (int i = 0; i < df.getRowCount(); i++) {
                con.createStatement().executeUpdate("insert into student_class(user_student,class_id,class_fees,is_active) values('" + studentid + "','" + df.getValueAt(i, 0).toString() + "','" + df.getValueAt(i, 4).toString() + "','1')");
                con.commit();
            }

            con.setAutoCommit(true);
            con = null;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean editpersonalData(JComponent comp[], String gardin) {

        try {


            DB.stexecuteUpdate("update user_main set Fname ='" + ((JTextField) comp[0]).getText() + "',Mname = '" + ((JTextField) comp[2]).getText() + "',Lname = '" + ((JTextField) comp[3]).getText() + "',adress_num = '" + ((JTextField) comp[4]).getText() + "',Street = '" + ((JTextField) comp[5]).getText() + "',City = '" + ((JTextField) comp[6]).getText() + "',contact_number = '" + ((JTextField) comp[7]).getText() + "' where user_id = '" + ((JLabel) comp[1]).getText() + "'");
            DB.stexecuteUpdate("update  user_Student set School = '" + ((JTextField) comp[8]).getText() + "',Grade = '" + ((JComboBox) comp[9]).getSelectedItem().toString() + "',Gardn = '" + gardin + "',Gard_name ='" + ((JTextField) comp[10]).getText() + "',Gard_Address = '" + ((JTextField) comp[11]).getText() + "', Gard_contact = '" + ((JTextField) comp[12]).getText() + "',Gard_workplace_address = '" + ((JTextField) comp[13]).getText() + "',Gard_wordplace_contact = '" + ((JTextField) comp[14]).getText() + "' where user_student_id = '" + ((JLabel) comp[1]).getText() + "'");


        } catch (Exception e) {
            System.out.println(e);
            return false;
        }



        return true;
    }

    public boolean editTeachdr(JComponent comp[]) {

        try {


            DB.stexecuteUpdate("update user_main set Fname ='" + ((JTextField) comp[0]).getText() + "',Mname = '" + ((JTextField) comp[2]).getText() + "',Lname = '" + ((JTextField) comp[3]).getText() + "',adress_num = '" + ((JTextField) comp[4]).getText() + "',Street = '" + ((JTextField) comp[5]).getText() + "',City = '" + ((JTextField) comp[6]).getText() + "',contact_number = '" + ((JTextField) comp[7]).getText() + "' where user_id = '" + ((JLabel) comp[1]).getText() + "'");
            DB.stexecuteUpdate("update  user_teacher set Nic = '" + ((JTextField) comp[8]).getText() + "',work_address = '" + ((JTextField) comp[9]).getText() + "',work_contact_number = '" + ((JTextField) comp[10]).getText() + "',Experience ='" + ((JTextArea) comp[11]).getText() + "'  where User_teacher_id = '" + ((JLabel) comp[1]).getText() + "'");


        } catch (Exception e) {
            System.out.println(e);
            return false;
        }



        return true;
    }

    public boolean editStaff(JComponent comp[], String pass) {

        try {

            String mstat = ((JRadioButton) comp[9]).isSelected() ? "Married" : "Single";

            DB.stexecuteUpdate("update user_main set Fname ='" + ((JTextField) comp[0]).getText() + "',Mname = '" + ((JTextField) comp[2]).getText() + "',Lname = '" + ((JTextField) comp[3]).getText() + "',adress_num = '" + ((JTextField) comp[4]).getText() + "',Street = '" + ((JTextField) comp[5]).getText() + "',City = '" + ((JTextField) comp[6]).getText() + "',contact_number = '" + ((JTextField) comp[7]).getText() + "' where user_id = '" + ((JLabel) comp[1]).getText() + "'");
            DB.stexecuteUpdate("update  user_staff set Epf_nuber = '" + ((JTextField) comp[8]).getText() + "',Designation = '" + ((JTextField) comp[10]).getText() + "',M_status = '" + mstat + "',Basic_sallary ='" + ((JTextField) comp[11]).getText() + "'  where User_staff_id = '" + ((JLabel) comp[1]).getText() + "'");
            DB.stexecuteUpdate("update user_login set User_password='" + pass + "' where User_mainUser_id = '" + ((JLabel) comp[1]).getText() + "'");

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }



        return true;
    }

    public boolean upadateTable(JTable stclass, String stid) {

        if (stclass.getSelectedRow() != -1) {
            String state = stclass.getValueAt(stclass.getSelectedRow(), 5).toString();
            if (state.equals("enrolled")) {
                state = "1";
            } else {
                state = "0";
            }

            try {
                DB.stexecuteUpdate("update student_class set is_active = '" + state + "' where (user_student ='" + stid + "') && (class_id = '" + stclass.getValueAt(stclass.getSelectedRow(), 0) + "') ");
            } catch (Exception e) {

                e.printStackTrace();
                return false;
            }

            return true;
        }
        return false;
    }
}
