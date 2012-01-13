package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;
import view.Mainwindow;

public final class regStudentControl {

    private String FName;
    private String Mname;
    private String Lname;
    private String addressNo;
    private String street;
    private String city;
    private Date dob;
    private String ContactNum;
    private String school;
    private String StudyGrade;
    private String Gardien;
    private String GName;
    private String GAddress;
    private String Gcontact;
    private String GWAddress;
    private String GWcontact;
    private String StudentId;
    private String Staffreg;
    DateFormat da = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String invoiceid;
    private String studID;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudyGrade() {
        return StudyGrade;
    }

    public void setStudyGrade(String StudyGrade) {
        this.StudyGrade = StudyGrade;
    }

    public String getGardien() {
        return Gardien;
    }

    public void setGardien(String Gardien) {
        this.Gardien = Gardien;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getGAddress() {
        return GAddress;
    }

    public void setGAddress(String GAddress) {
        this.GAddress = GAddress;
    }

    public void getThisTeachersClasses(int gradeid, int subjectid, int teacherid, JTable table) {

        try {
            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);

            ResultSet rse = DB.getResultset("select Class_id,Day,Start_time,Ending_time from class " + "where (Grade_id='" + gradeid + "' && Subject_id='" + subjectid + "' && Teacher_ID ='" + teacherid + "' && is_active='1')");
            while (rse.next()) {

                Vector v = new Vector();
                v.add(rse.getString("Class_id"));
                v.add(rse.getString("Day"));
                v.add(rse.getString("Start_time"));
                v.add(rse.getString("Ending_time"));
                df.addRow(v);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    int k = 0;
    double count = 0;

    public void addClass(int id, JTable table, JLabel jtext) {
        DefaultTableModel df = (DefaultTableModel) table.getModel();
        k = 0;
        int i = 0;
        for (i = 0; i < table.getRowCount(); i++) {
            if (Integer.parseInt(table.getValueAt(i, 0).toString()) == id) {
                JOptionPane.showMessageDialog(null, "you have alrady added this class", "Information", JOptionPane.INFORMATION_MESSAGE);
                k = 1;
                break;
            } else {
                k = 0;

            }


        }

        try {
            if (k < 1) {
                ResultSet rs = DB.getResultset("select* from class a, subject b where (a.class_id = '" + id + "') && (a.Subject_id = b.Subject_id)");
                if (rs.next()) {
                    Vector va = new Vector();
                    va.add(rs.getString("a.Class_id"));
                    va.add(rs.getString("b.Subject_name"));
                    va.add(rs.getString("a.day"));
                    va.add(rs.getString("a.admition_fee"));
                    va.add(rs.getString("a.montly_fee"));
                    df.addRow(va);
                    // if the institute using differant admisions then use this code
                    // count += Double.parseDouble(table.getValueAt(i, 3).toString());
                    count = Double.parseDouble(table.getValueAt(i, 3).toString());
                    jtext.setText("" + count);
                }
            }

        } catch (Exception e) {

            System.out.println(e);

        }


    }

    public void removeRow(JTable tblclass2, JLabel lb) {

        try {
            DefaultTableModel df = (DefaultTableModel) tblclass2.getModel();
            System.out.println(tblclass2.getValueAt(tblclass2.getSelectedRow(), 3));
            count = count - Double.parseDouble(tblclass2.getValueAt(tblclass2.getSelectedRow(), 3).toString());
            df.removeRow(tblclass2.getSelectedRow());

            lb.setText(count + "");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * @return the Gcontact
     */
    public String getGcontact() {
        return Gcontact;
    }

    /**
     * @param Gcontact the Gcontact to set
     */
    public void setGcontact(String Gcontact) {
        this.Gcontact = Gcontact;
    }

    /**
     * @return the GWAddress
     */
    public String getGWAddress() {
        return GWAddress;
    }

    /**
     * @param GWAddress the GWAddress to set
     */
    public void setGWAddress(String GWAddress) {
        this.GWAddress = GWAddress;
    }

    /**
     * @return the GWcontact
     */
    public String getGWcontact() {
        return GWcontact;
    }

    /**
     * @param GWcontact the GWcontact to set
     */
    public void setGWcontact(String GWcontact) {
        this.GWcontact = GWcontact;
    }

    /**
     * @return the StudentId
     */
    public String getStudentId() {
        return StudentId;
    }

    /**
     * @param StudentId the StudentId to set
     */
    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    /**
     * @return the Staffreg
     */
    public String getStaffreg() {
        return Staffreg;
    }

    /**
     * @param Staffreg the Staffreg to set
     */
    public void setStaffreg(String Staffreg) {
        this.Staffreg = Staffreg;
    }

    public Boolean regStudent(regStudentControl stud, JTable studentclasses, JCheckBox box) {

        boolean bool = box.isSelected();
        boolean wthp = false;
        String usertypei = null;
        DefaultTableModel df = (DefaultTableModel) studentclasses.getModel();
        Date today = new Date();

        if (!stud.getFName().trim().isEmpty() && df.getRowCount() != 0) {

            try {
                Connection con = DB.getmyCon();
                con.setAutoCommit(false);
                ResultSet usertype = con.createStatement().executeQuery("select user_typeid from user_type where user_type ='Student'");
                if (usertype.next()) {
                    usertypei = usertype.getString("user_typeid");
                }

                String Dob = da.format(stud.getDob());
                Statement st = con.createStatement();
                st.executeUpdate("insert into user_main(Fname,Mname,Lname,adress_num,Street,City,Dob,contact_number,is_active,User_type_id,Registration_date)" +
                        "values('" + stud.getFName() + "','" + stud.getMname() + "','" + stud.getLname() + "','" + stud.addressNo + "','" + stud.getStreet() + "'" +
                        ",'" + stud.getCity() + "','" + Dob + "','" + stud.ContactNum + "','1','" + usertypei + "','" + da.format(today) + "')", Statement.RETURN_GENERATED_KEYS);

                String lastid = null;
                ResultSet key = st.getGeneratedKeys();
                while (key.next()) {
                    lastid = key.getString(1);
                    setStudID(lastid);
                }
                con.createStatement().executeUpdate("insert into user_Student(School,Grade,Gardn,User_student_id,Gard_name,Gard_Address,Gard_contact,Gard_workplace_address,Gard_wordplace_contact,student_staff)" +
                        "values('" + stud.getSchool() + "','" + stud.getStudyGrade() + "','" + stud.getGardien() + "','" + lastid + "','" + stud.getGName() + "','" + stud.getGAddress() + "','" + stud.getGcontact() +
                        "','" + stud.getGWAddress() + "','" + stud.getGWcontact() + "','" + stud.getStaffreg() + "')");


                String lastinvoiceid = DB.lastinsertId("payment_invoice_student", "Invoice_id", con);
                lastinvoiceid = (lastinvoiceid == null) ? "1" : "" + (Integer.parseInt(lastinvoiceid) + 1);
                setInvoiceid(lastinvoiceid + "");
                for (int i = 0; i < df.getRowCount(); i++) {

                    con.createStatement().executeUpdate("insert into student_class(user_student,class_id,class_fees,is_active) values('" + lastid + "','" + df.getValueAt(i, 0).toString() + "','" + df.getValueAt(i, 4).toString() + "','1')");
                    if (bool) {
                        con.createStatement().executeUpdate("insert into payment_invoice_student(Invoice_id,user_student_id,class_id,class_fees,month,user_stafff,pay_type,Date_Time) values('" + lastinvoiceid + "','" + lastid + "','" + df.getValueAt(i, 0).toString() + "','" + df.getValueAt(i, 3).toString() + "','" + new SimpleDateFormat("MMM").format(today) + "','" + Mainwindow.UserStaffID + "','Admission','" + da.format(today) + "')");
                    }
                }
                con.commit();
                con.setAutoCommit(true);
                con = null;
                wthp = true;
            } catch (Exception e) {
                System.out.println(e);
                wthp = false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Registration Failled Due To One Of Bellow Problems \n > Student First Name Left Blank \n >No Classes Selected to Register \n Please Fix above problems to Register successfully", "REGISTRATION ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return wthp;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }
}
