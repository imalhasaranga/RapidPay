

package control;

import java.sql.ResultSet;
import javax.swing.JLabel;
import model.DB;

/**
 *
 * @author gihan
 */
public final class rep_ins_summaryControl {

    public void loadsummery(JLabel totalregstudents, JLabel totalactiveStudents, JLabel totalinactive, JLabel totalteachers, JLabel totalactiveteachrs, JLabel totalinactiveteach, JLabel totalactiveclasses) {
      
        try {
            
       
       ResultSet totalreg =  DB.getResultset("select count(a.User_id) as total1 from user_main a, user_student b where (a.User_id = b.User_student_id) ");
        if(totalreg.next())
            totalregstudents.setText(totalreg.getString("total1"));
       ResultSet totalregina =  DB.getResultset("select count(a.User_id) as total1 from user_main a, user_student b where (a.User_id = b.User_student_id) && a.is_active = '1'");
        if(totalregina.next())
            totalactiveStudents.setText(totalregina.getString("total1"));
     
       totalinactive.setText((Integer.parseInt(totalregstudents.getText()) - Integer.parseInt(totalactiveStudents.getText()))+"");
     //////////////////
       
        ResultSet totalreg11 =  DB.getResultset("select count(a.User_id) as total1 from user_main a, user_teacher b where (a.User_id = b.User_teacher_id) ");
        if(totalreg11.next())
            totalteachers.setText(totalreg11.getString("total1"));
       ResultSet totalregina12 =  DB.getResultset("select count(a.User_id) as total1 from user_main a, user_teacher b where (a.User_id = b.User_teacher_id) && a.is_active = '1'");
        if(totalregina12.next())
            totalactiveteachrs.setText(totalregina12.getString("total1"));
       
       totalinactiveteach.setText((Integer.parseInt(totalregstudents.getText()) - Integer.parseInt(totalactiveStudents.getText()))+"");
      /// 
       
       
        ResultSet totalclasses =  DB.getResultset("select count(class_id) as total1 from class where is_active='1'");
        if(totalclasses.next())
           totalactiveclasses.setText(totalclasses.getString("total1"));
       } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    
    
    
    

}
