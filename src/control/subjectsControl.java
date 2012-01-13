

package control;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author Imal
 */
public final class subjectsControl {

     public void loadSubjects(JTable table) {

        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        try {
            ResultSet grades = DB.getResultset("select* from subject ");

            while (grades.next()) {

                Vector grade = new Vector();
                grade.add(grades.getString("subject_id"));
                grade.add(grades.getString("subject_name"));

                df.addRow(grade);


            }
        } catch (Exception e) {
            System.out.println(e);
        }






    }

    public void addSubjects(String subjectname) {

        try {

            DB.stexecuteUpdate("insert into subject(subject_name) values('" +subjectname+ "')");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean deleteSelecteRec(JTable table) {
        if (table.getSelectedRow() != -1) {
            String id = (String) table.getValueAt(table.getSelectedRow(), 0);
            try {
                DB.stexecuteUpdate("delete from subject where subject_id = '" + id + "'");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can't Delete this Subject, this is activly using in the system");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Please select the subject you want to delete");

        }
        return true;
    }
}
