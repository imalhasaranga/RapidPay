
package control;

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
public final class regteacherControl {

    private String TeacherID;
    private String FName;
    private String Mname;
    private String Lname;
    private String addressNo;
    private String street;
    private String city;
    private Date dob;
    private String ContactNum;
    private String workAddress;
    private String workcontact;
    private String workExperience;
    private String NIC;
    private String teacherid;

    public String getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
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

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getWorkcontact() {
        return workcontact;
    }

    public void setWorkcontact(String workcontact) {
        this.workcontact = workcontact;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public boolean addTeacher(regteacherControl teacher) {
        boolean wthp;
        String usertypei = null;
        if(!teacher.getFName().isEmpty()){
        try {

            ResultSet usertype = DB.getResultset("select user_typeid from user_type where user_type ='teacher'");
            if (usertype.next()) {
                usertypei = usertype.getString("user_typeid");
            }

            DateFormat da = new SimpleDateFormat("yyyy/MM/dd");
            String Dob = da.format(teacher.getDob());

            Statement st = DB.getmyCon().createStatement();
            st.executeUpdate("insert into user_main(Fname,Mname,Lname,adress_num,Street,City,Dob,contact_number,is_active,User_type_id,Registration_date)" +
                    "values('" + teacher.getFName() + "','" + teacher.getMname() + "','" + teacher.getLname() + "','" + teacher.addressNo + "','" + teacher.getStreet() + "'" +
                    ",'" + teacher.getCity() + "','" + Dob + "','" + teacher.ContactNum + "','1','" + usertypei + "','" + da.format(new Date()) + "')", Statement.RETURN_GENERATED_KEYS);

            String lastid = null;
            ResultSet key = st.getGeneratedKeys();
            while (key.next()) {
                lastid = key.getString(1);
                setTeacherID(lastid);
            }
            DB.stexecuteUpdate("insert into user_teacher(Nic,work_address,work_contact_number,Experience,user_teacher_id)" +
                    "values('" + teacher.getNIC() + "','" + teacher.getWorkAddress() + "','" + teacher.getWorkcontact() + "','" + teacher.getWorkExperience() + "','" + lastid + "')");
            wthp = true;
        } catch (Exception e) {
            System.out.println(e);
            wthp = false;
        }


        return wthp;
        }else{
            JOptionPane.showMessageDialog(null, " * Mark Fields should filled surly", "Registration Failed", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }

    public static void loadTeacherDetails(JTable teacherde) {


        try {

            DefaultTableModel df = (DefaultTableModel) teacherde.getModel();
            df.setRowCount(0);
            ResultSet teacher = DB.getResultset("select* from user_main a, user_teacher b where (user_id = user_teacher_id) && ( a.is_active = '1' ) ");


            while (teacher.next()) {
                Vector v = new Vector();

                v.add(teacher.getString("a.user_id"));
                v.add(teacher.getString("a.Fname") + " " + teacher.getString("a.Lname"));
                v.add((teacher.getString("a.Adress_num") + " " + teacher.getString("a.Street") + " " + teacher.getString("a.City")));
                v.add(teacher.getString("a.contact_number"));
                v.add(teacher.getString("b.Nic"));
                df.addRow(v);

            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
