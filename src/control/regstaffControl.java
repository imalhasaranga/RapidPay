
package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author Imal
 */
public final class regstaffControl {

    private String StaffId;
    private String FName;
    private String Mname;
    private String Lname;
    private String addressNo;
    private String street;
    private String city;
    private Date dob;
    private String ContactNum;
    private String EpfNo;
    private String designation;
    private String nic;
    private String basicsallary;
    private String username;
    private String password;
    private String M_status;
    private String staffID;

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String StaffId) {
        this.StaffId = StaffId;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactNum() {
        return ContactNum;
    }

    public void setContactNum(String ContactNum) {
        this.ContactNum = ContactNum;
    }

    public String getEpfNo() {
        return EpfNo;
    }

    public void setEpfNo(String EpfNo) {
        this.EpfNo = EpfNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBasicsallary() {
        return basicsallary;
    }

    public void setBasicsallary(String basicsallary) {
        this.basicsallary = basicsallary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean addStaff(regstaffControl staff) {
        boolean wthp;
        String usertypei = null;

        if (!staff.getFName().isEmpty()) {
            try {
                Connection con = DB.getmyCon();
                con.setAutoCommit(false);
                ResultSet usertype = con.createStatement().executeQuery("select user_typeid from user_type where user_type ='Staff'");
                if (usertype.next()) {
                    usertypei = usertype.getString("user_typeid");
                }

                DateFormat da = new SimpleDateFormat("yyyy/MM/dd");
                String Dob = da.format(staff.getDob());
                Statement st = con.createStatement();
                st.executeUpdate("insert into user_main(Fname,Mname,Lname,adress_num,Street,City,Dob,contact_number,is_active,User_type_id,Registration_date)" +
                        "values('" + staff.getFName() + "','" + staff.getMname() + "','" + staff.getLname() + "','" + staff.addressNo + "','" + staff.getStreet() + "'" +
                        ",'" + staff.getCity() + "','" + Dob + "','" + staff.ContactNum + "','1','" + usertypei + "','" + da.format(new Date()) + "')", Statement.RETURN_GENERATED_KEYS);


                String lastid = null;
                ResultSet key = st.getGeneratedKeys();
                while (key.next()) {
                    lastid = key.getString(1);
                    setTeacherId(lastid);
                }
                con.createStatement().executeUpdate("insert into user_staff(Epf_nuber,Designation,M_status,user_staff_id,basic_sallary)" +
                        "values('" + staff.getEpfNo() + "','" + staff.getDesignation() + "','" + staff.getM_status() + "','" + lastid + "','" + staff.getBasicsallary() + "')");

                ResultSet prviledgtype = con.createStatement().executeQuery("select user_prviID from user_priviledge where user_prvi_type = 'Admin3' ");
                if (prviledgtype.next()) {

                    usertypei = prviledgtype.getString("user_prviID");

                }

                con.createStatement().executeUpdate("insert into user_login(User_priviledge_type,User_password,User_name,User_mainUser_id,is_active) " +
                        "values('" + usertypei + "','" + staff.getPassword() + "','" + staff.getUsername() + "','" + lastid + "','1')");

                con.commit();
                con.setAutoCommit(true);
                con = null;
                wthp = true;
            } catch (Exception e) {
                System.out.println(e);
                wthp = false;
            }


            return wthp;
        } else {
            JOptionPane.showMessageDialog(null, " * Mark Fields should filled surly", "Registration Failed", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }

    public static void loadStaff(JTable staffde) {


        try {

            DefaultTableModel df = (DefaultTableModel) staffde.getModel();
            df.setRowCount(0);
            ResultSet teacher = DB.getResultset("select* from user_main a, user_staff b where (a.user_id = b.user_staff_id) && ( a.is_active = '1' )  ");


            while (teacher.next()) {
                Vector v = new Vector();
                v.add(teacher.getString("a.user_id"));
                v.add(teacher.getString("a.Fname") + " " + teacher.getString("a.Lname"));
                v.add((teacher.getString("a.Adress_num") + " " + teacher.getString("a.Street") + " " + teacher.getString("a.City")));
                v.add(teacher.getString("a.contact_number"));
                v.add(teacher.getString("b.Designation"));
                df.addRow(v);

            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public boolean istUserAvailable(String usrname) {

        try {
            ResultSet user1 = DB.getResultset("select* from user_login where user_name='" + usrname + "'");
            if (user1.next()) {

                return false;
            }
        } catch (Exception e) {
            System.out.println(e + "a");
        }

        return true;
    }

    public String getM_status() {
        return M_status;
    }

    public void setM_status(String M_status) {
        this.M_status = M_status;
    }

    public String getTeacherId() {
        return staffID;
    }

    public void setTeacherId(String TeacherId) {
        this.staffID = TeacherId;
    }
}
