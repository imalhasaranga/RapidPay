

package control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author Imal
 */
public final class classControl {

    private String Grade;
    private String Subject;
    private String Teacher;
    private String heldingDay;
    private String StartTime;
    private String EndTime;
    private String TeacherPrecen;
    private String AdmitionFee;
    private String montlyfee;
    private String institutepre;
    private Date statdate;

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
    }

    public String getHeldingDay() {
        return heldingDay;
    }

    public void setHeldingDay(String heldingDay) {
        this.heldingDay = heldingDay;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getTeacherPrecen() {
        return TeacherPrecen;
    }

    public void setTeacherPrecen(String TeacherPrecen) {
        this.TeacherPrecen = TeacherPrecen;
    }

    public String getAdmitionFee() {
        return AdmitionFee;
    }

    public void setAdmitionFee(String AdmitionFee) {
        this.AdmitionFee = AdmitionFee;
    }

    public String getMontlyfee() {
        return montlyfee;
    }

    public void setMontlyfee(String montlyfee) {
        this.montlyfee = montlyfee;
    }

    public String getInstitutepre() {
        return institutepre;
    }

    public void setInstitutepre(String institutepre) {
        this.institutepre = institutepre;
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public String calculateDuration(String time1, String time2) throws Exception {
        long duration = 0;
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        Date time11 = sdf.parse(time1);
        Date time22 = sdf.parse(time2);

        if (time11.getTime() > time22.getTime()) {

            duration = time11.getTime() - time22.getTime();

        } else {
            System.out.println(duration);
            duration = -time11.getTime() + time22.getTime();

        }

        double d = ((double) duration) / (1000 * 3600);

        int hour = (int) d;
        int minutes1 = ((((int) Math.round((d * 100))) % 100) * 60) / 100;


        return String.valueOf(hour + ": " + minutes1);

    }

    public boolean addClass(classControl val) {

        try {
            DB.stexecuteUpdate("insert into class(Day,Teacher_id,subject_id,Grade_id,teacher_pay_present,institute_presentage,admition_fee,montly_fee,start_time,Ending_time,created_date)" +
                    "values('" + val.getHeldingDay() + "','" + val.getTeacher() + "','" + val.getSubject() + "','" + val.getGrade() + "','" + val.getTeacherPrecen() + "','" + val.institutepre + "'," +
                    "'" + val.getAdmitionFee() + "','" + val.getMontlyfee() + "','" + val.getStartTime() + "','" + val.getEndTime() + "','" + new SimpleDateFormat("yyyy-MM-dd").format(val.getStatdate()) + "')");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public void loadTable(JTable table) {

        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        try {

            ResultSet restl = DB.getResultset("select* from (class join subject on class.subject_id = subject.subject_id) where is_active='1' order by subject.subject_name");
            while (restl.next()) {

                Vector v = new Vector();
                v.add(restl.getString("class_id"));
                v.add(restl.getString("subject.subject_name"));

                ResultSet rest3 = DB.getResultset("select* from Grade where Grade_id = '" + restl.getString("Grade_id") + "'");
                if (rest3.next()) {
                    v.add(rest3.getString("Grade_name"));
                }

                ResultSet rest4 = DB.getResultset("select* from user_main a, user_teacher b where (user_id = user_teacher_id) && User_id = '" + restl.getString("Teacher_id") + "'");
                if (rest4.next()) {
                    v.add(rest4.getString("a.Fname") + " " + rest4.getString("a.Lname"));
                }
                v.add(restl.getString("Day"));
                v.add(restl.getString("start_time"));
                v.add(restl.getString("ending_time"));
                v.add(restl.getString("created_date"));
                df.addRow(v);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String[] tableclicked(JTable table) {

        String a[] = new String[16];
        a[0] = table.getValueAt(table.getSelectedRow(), 0).toString();
        a[1] = table.getValueAt(table.getSelectedRow(), 1).toString();
        a[2] = table.getValueAt(table.getSelectedRow(), 2).toString();
        a[3] = table.getValueAt(table.getSelectedRow(), 3).toString();
        a[4] = table.getValueAt(table.getSelectedRow(), 4).toString();

        String stime = table.getValueAt(table.getSelectedRow(), 5).toString();

        String stm[] = stime.split(":");
        a[5] = stm[0];
        a[6] = (stm[1]).trim().split(" ")[0];
        a[7] = (stm[1]).trim().split(" ")[1];


        String endtime = table.getValueAt(table.getSelectedRow(), 6).toString();

        String stm1[] = endtime.split(":");
        a[8] = stm1[0];
        a[9] = (stm1[1]).trim().split(" ")[0];
        a[10] = (stm1[1]).trim().split(" ")[1];

        try {

            ResultSet rs = DB.getResultset("select* from class where  class_id = '" + a[0] + "'");
            if (rs.next()) {

                a[11] = rs.getString("teacher_pay_present");
                a[12] = rs.getString("institute_presentage");
                a[13] = rs.getString("admition_fee");
                a[14] = rs.getString("montly_fee");
                a[15] = rs.getString("created_date");
            }

        } catch (Exception e) {
            System.out.println(e);
        }



        return a;
    }

    public boolean updateClass(classControl val, String id) {

        try {
//            DB.stexecuteUpdate("update  class set Day = '" + val.getHeldingDay() + "',Teacher_id = '" + val.getTeacher() + "',subject_id='" + val.getSubject() + "',Grade_id='" + val.getGrade() +
//                    "',teacher_pay_present='" + val.getTeacherPrecen() + "',institute_presentage='" + val.institutepre +
//                    "',admition_fee='" + val.getAdmitionFee() + "',montly_fee='" + val.getMontlyfee() + "',start_time= '" + val.getStartTime() + "',Ending_time='" + val.getEndTime() + "' where class_id = '" + id + "' ");

            DB.stexecuteUpdate("update  class set Day = '" + val.getHeldingDay() + "' " +
                    ",start_time= '" + val.getStartTime() + "',Ending_time='" + val.getEndTime() + "',created_date='" + new SimpleDateFormat("yyyy-MM-dd").format(val.getStatdate()) + "' where class_id = '" + id + "' ");


        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean checkForExistig(JTable jtb, JComboBox cmbgrade, JComboBox cmbsubject, JComboBox cmbteacher, JComboBox cmbday, String StartTime, String Endtime) {

        for (int i = 0; i < jtb.getRowCount(); i++) {
            if ((jtb.getValueAt(i, 1).equals(cmbsubject.getSelectedItem())) && (jtb.getValueAt(i, 2).equals(cmbgrade.getSelectedItem())) && (jtb.getValueAt(i, 3).equals(cmbteacher.getSelectedItem())) && (jtb.getValueAt(i, 4).equals(cmbday.getSelectedItem())) && (jtb.getValueAt(i, 5).toString().equals(StartTime)) && (jtb.getValueAt(i, 6).toString().equals(Endtime))) {
                return true;
            }

        }

        return false;
    }

    public boolean clearClasses(JTable classes) {

        try {
            if (classes.getSelectedRow() != -1) {
                Object[] options = {"Im aware of the risk, change", "Dont change"};
                int res = JOptionPane.showOptionDialog(null, "Are you sure you want to proceed : By proceeding you will remove all the existing students in this class", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (res == 0) {
                    DB.stexecuteUpdate("update student_class set is_active = '0'  where class_id ='" + classes.getValueAt(classes.getSelectedRow(), 0).toString() + "' ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select class", "Class Selection", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    public void DeactivateClass(JTable classes) {


        try {
            if (classes.getSelectedRow() != -1) {
                Object[] options = {"Im aware of the risk, change", "Dont change"};
                int res = JOptionPane.showOptionDialog(null, "Are you sure you want to proceed : By proceeding you will DeActivate this class permanently", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (res == 0) {
                    DB.stexecuteUpdate("update class set is_active = '0',removed_date = '" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "'  where class_id ='" + classes.getValueAt(classes.getSelectedRow(), 0).toString() + "' ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select class", "Class Selection", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void DeleteNewClass(JTable classes) {


        try {
            if (classes.getSelectedRow() != -1) {
                Object[] options = {" Delete ", " Dont Delete "};
                int res = JOptionPane.showOptionDialog(null, "Are you sure you want to proceed : Class will Delete, only if it hasn't used yet ", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);


                if (res == 0) {

                    //DB.stexecuteUpdate("Delete from  class  where class_id ='" + classes.getValueAt(classes.getSelectedRow(), 0).toString() + "' ");
                    DB.stexecuteUpdate("Delete from  class  where (class_id ='" + classes.getValueAt(classes.getSelectedRow(), 0).toString() + "') && class_id not in (SELECT class_id FROM student_class) ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select class", "Class Selection", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    
    
    
    
    
    ResultSet subjectsres = null;
    ResultSet Grades = null;
    ResultSet Teachers = null;
    Vector Categories = new Vector();
    private Vector getCategory = new Vector();
    
    Vector grades1 = new Vector();
    private Vector gradeId = new Vector();
    
    Vector subjects = new Vector();
    private Vector subjectsId = new Vector();
    
    Vector teachers = new Vector();
    private Vector teachersid = new Vector();
   

    public void LoadComboGrade(JComboBox Gradecmbo) {

        try {
            if (Grades == null) {
                Grades = DB.getResultset("select* from grade");

                while (Grades.next()) {
                    grades1.add(Grades.getString("Grade_name"));
                    gradeId.add(Grades.getString("Grade_id"));
                }
            }
            Gradecmbo.setModel(new DefaultComboBoxModel(grades1));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void LoadComboSubject(JComboBox comboname) {

        try {
            if (subjectsres == null) {
                subjectsres = DB.getResultset("select* from subject");
                while (subjectsres.next()) {
                    subjects.add(subjectsres.getString("subject_name"));
                    subjectsId.add(subjectsres.getString("subject_id"));
                }
            }
            comboname.setModel(new DefaultComboBoxModel(subjects));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void LoadComboTeachers(JComboBox Teachers) {

        try {
            if (this.Teachers == null) {
                this.Teachers = DB.getResultset("select* from user_main a, user_teacher b where (user_id = user_teacher_id) && ( a.is_active = '1' ) ");
                while (this.Teachers.next()) {
                    teachers.add(this.Teachers.getString("a.Fname") + " " + this.Teachers.getString("a.Lname"));
                    teachersid.add(this.Teachers.getString("b.user_teacher_id"));
                }
            }
            Teachers.setModel(new DefaultComboBoxModel(teachers));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

  

    public int getGradeId(int id) {
        return Integer.parseInt(gradeId.get(id).toString());
    }

    public int getSubjectsId(int id) {
        return Integer.parseInt(subjectsId.get(id).toString());
    }

    public int getTeachersid(int id) {
        return Integer.parseInt(teachersid.get(id).toString());
    }

    public int getGetCategory(int id) {
        return Integer.parseInt(getCategory.get(id).toString());
    }

    
    
    
    
    
}
