package control;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author Imal
 */
public final class AttendanceMarksetControl {

    private JTable table;
    private JComboBox day;
    private JMonthChooser month;
    private JYearChooser year;
    private JList blocked;
    private JList allowed;
    public int classes;

    public void loadClassoftheday() {
        String Day = getDay().getSelectedItem().toString();
        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        try {
            int count = 0;

            for (int i = 0; i < 2; i++) {
                String Ampm = (i == 0) ? "A" : "P";
                String ch1 = i == 0 ? "UNION SELECT class.class_id,subject.Subject_name,Grade.Grade_name,user_main.Fname,user_main.Lname,class.Start_time,class.Ending_time FROM class JOIN SUBJECT ON SUBJECT.Subject_id = class.Subject_id JOIN Grade ON Grade.Grade_id = class.Grade_id JOIN user_main ON user_main.User_id = class.Teacher_ID WHERE DAY ='" + Day + "' && class.is_active = '1' && Start_time LIKE '12%' " : "&& Start_time NOT LIKE '12%'";
                ResultSet restl = DB.getResultset("SELECT class.class_id,subject.Subject_name,Grade.Grade_name,user_main.Fname,user_main.Lname,class.Start_time,class.Ending_time FROM class JOIN SUBJECT ON SUBJECT.Subject_id = class.Subject_id JOIN Grade ON Grade.Grade_id = class.Grade_id JOIN user_main ON user_main.User_id = class.Teacher_ID WHERE (Day ='" + Day + "' && class.is_active = '1' && (SUBSTRING(Start_time,8,1) = '" + Ampm + "'  || SUBSTRING(Start_time,9,1) = '" + Ampm + "')) " + ch1 + " "
                        + "ORDER BY SUBSTRING(Start_time,1,2) * 1 ASC");
                while (restl.next()) {
                    ++count;
                    ArrayList v = new ArrayList();
                    v.add(restl.getString("class_id"));
                    v.add(restl.getString("Subject_name"));
                    v.add(restl.getString("Grade_name"));
                    v.add(restl.getString("Fname") + " " + restl.getString("Lname"));
                    v.add(restl.getString("Start_time"));
                    v.add(restl.getString("Ending_time"));
                    v.add(false);
                    df.addRow(v.toArray());
                }
            }
            classes = count;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean loadData() {
        getPaied();
        getNotPaid();
        return true;
    }

    public String getQuerypart() {
        StringBuilder clsId = new StringBuilder();
        for (int i = 0; i < getTable().getRowCount(); i++) {
            boolean b = Boolean.parseBoolean(getTable().getValueAt(i, 6).toString());
            if (b) {
                clsId.append(getTable().getValueAt(i, 0).toString()).append(" ,");
            }
        }
        return clsId.substring(0, clsId.length() - 1);
    }

    public boolean getNotPaid() {
        JList li = getBlocked();

        li.removeAll();
        int Month = getMonth().getMonth() + 1;
        int Year = getYearchoes().getYear();
        Collection<String> BlockedList = new TreeSet<String>();

        StringBuilder bf = new StringBuilder();
        String prefix = "";

        try {
            ResultSet rs2 = DB.getResultset("select user_student as uid1,class_fees, Class_id  from student_class where Class_id IN  ( " + getQuerypart() + " ) && is_active = '1' ");
            DB.stexecuteUpdate("Delete from bstudent");
            while (rs2.next()) {
                String stid = rs2.getString("uid1");
                ResultSet rs3 = DB.getResultset("select user_student_id as uid2 from payment_invoice_student where user_student_id = '" + stid + "' AND pay_type = 'monthlypayment' AND date_time like '" + Year + "_______________' AND class_id = '" + rs2.getString("Class_id") + "' AND month ='" + Month + "' ");
                if (rs3.next()) {
                } else {
                    BlockedList.add(stid);
                    bf.append(prefix);
                    prefix = " UNION ";
                    bf.append(" SELECT '").append(stid).append("'");

                }


            }
            li.setListData(BlockedList.toArray());
            if (prefix.trim().equals("UNION")) {
                DB.stexecuteUpdate("INSERT INTO bstudent(student_Id) " + bf);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sorry Unexpected Error Occured System need to shutdown ERROR from getNotPaid:" + e);
            e.printStackTrace();
            return false;
        }
        JOptionPane.showMessageDialog(null, "Total of " + BlockedList.size() + " has been blocked \n Blocking process success!!!", "Block student Status", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public boolean getPaied() {
        JList allowedlist = getAllowed();
        allowedlist.removeAll();

        int Month = getMonth().getMonth() + 1;
        int Year = getYearchoes().getYear();
        Collection<Integer> AllowedList = new TreeSet<Integer>();
        try {
            ///All the Paid students
            ResultSet rs = DB.getResultset("SELECT User_student_id FROM payment_invoice_student WHERE (MONTH = '" + Month + "' && SUBSTRING(Date_time,1,4) = '" + Year + "' && pay_type = 'monthlypayment')  && (Class_id IN  ( " + getQuerypart() + " ) )");
            DB.stexecuteUpdate("Delete from astudent");
            StringBuilder bf = new StringBuilder();
            String prefix = "";
            while (rs.next()) {
                int stuid = rs.getInt("User_student_id");
                AllowedList.add(stuid);
                bf.append(prefix);
                prefix = " UNION ";
                bf.append(" SELECT '").append(stuid).append("'");

            }

            allowedlist.setListData(AllowedList.toArray());
            if (prefix.trim().equals("UNION")) {
                DB.stexecuteUpdate("INSERT INTO astudent(student_Id) " + bf);
            }
            return true;
        } catch (StringIndexOutOfBoundsException e1) {
            JOptionPane.showMessageDialog(null, "Please select the classes First", "Class selection failed", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {


        this.table = table;
    }

    public JComboBox getDay() {
        return day;
    }

    public void setDay(JComboBox day) {
        this.day = day;
    }

    public JMonthChooser getMonth() {
        return month;
    }

    public void setMonth(JMonthChooser month) {
        this.month = month;
    }

    public JYearChooser getYearchoes() {
        return year;
    }

    public void setYear(JYearChooser year) {
        this.year = year;
    }

    public JList getBlocked() {
        return blocked;
    }

    public void setBlocked(JList blocked) {
        this.blocked = blocked;
    }

    /**
     * @return the allowed
     */
    public JList getAllowed() {
        return allowed;
    }

    /**
     * @param allowed the allowed to set
     */
    public void setAllowed(JList allowed) {
        this.allowed = allowed;
    }
}
