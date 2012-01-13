

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
public final class gradesControl {

    public void loadGrades(JTable table) {

        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.setRowCount(0);
        try {
            ResultSet grades = DB.getResultset("select* from grade where is_active='1' union select* from grade where is_active='0'");

            while (grades.next()) {

                Vector grade = new Vector();
                grade.add(grades.getString("Grade_id"));
                grade.add(grades.getString("Grade_name"));
                grade.add(grades.getString("is_active"));

                df.addRow(grade);


            }
        } catch (Exception e) {
            System.out.println(e);
        }






    }

    public void addGrade(String gardename) {

        try {

            DB.stexecuteUpdate("insert into grade(Grade_name) values('" + gardename + "')");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean deleteSelecteRec(JTable table) {
        if (table.getSelectedRow() != -1) {
            String id = (String) table.getValueAt(table.getSelectedRow(), 0);
            try {
                DB.stexecuteUpdate("delete from grade where grade_id = '" + id + "'");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can not Delete this Grade, system is using this grade activley");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Please select the Grade you want to delete");
            return false;
        }
        return true;
    }
    
    
    public boolean InactiveGrade(JTable table){
        if (table.getSelectedRow() != -1) {
            
            if(OccationalLogics.showOption("yes", "no") == 0){
            
            String id = (String) table.getValueAt(table.getSelectedRow(), 0);
            try {
                DB.stexecuteUpdate("update grade set is_active='0' where grade_id = '" + id + "'");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can not inactivate this Grade,");
            }
            }
        } else {

            JOptionPane.showMessageDialog(null, "Please select the Grade you want to inactivate");
            return false;
        }
    
        return true;
    }
}
