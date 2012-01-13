

package control;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DB;
import view.Mainwindow;
import view.userlogin;

/**
 *
 * @author gihan
 */
public final class userloginControl {
  
    
    
  Mainwindow window; 
    
  
DateFormat df = new SimpleDateFormat("yyyy:MM:dd HH.mm.ss");
    
    public boolean checkLogin(String username, String pasword, userlogin log,Mainwindow window){
        this.window = window;
        try {
                ResultSet usr = DB.getResultset("select* from user_login  where (User_name='"+username+"' && User_password = '"+pasword+"' && is_active = '1') ");
                if(usr.next()){
            
                  window.securelogin(usr.getString("User_name"), usr.getString("user_priviledge_type"),usr.getString("user_mainuser_id"), window,log);
                  saylogged(usr.getString("user_mainuser_id"));
                  return false;
                }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    return true;
    }

    public void saylogged(String usrMainid){

        try {
            DB.stexecuteUpdate("insert into login_logout(User_mainUser_id)" +
                    " values('"+usrMainid+"')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sayLogout(String userMainid){

       
        try {
            DB.stexecuteUpdate("update login_logout set Logout_time= '"+ df.format(new Date())+"' where User_mainUser_id = '"+userMainid+"' order by Login_time desc limit 1");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    
    
}
