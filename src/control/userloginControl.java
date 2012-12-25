package control;

import java.sql.ResultSet;
import java.sql.Timestamp;
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
    DateFormat df2 = new SimpleDateFormat("yyyy:MM:dd");
    public boolean checkLogin(String username, String pasword, userlogin log, Mainwindow window) {
        this.window = window;
        try {
            ResultSet usr = DB.getResultset("select* from user_login  where (User_name='" + username + "' && User_password = '" + pasword + "' && is_active = '1') ");
            if (usr.next()) {
                String logtime = saylogged(usr.getString("user_mainuser_id"));
                window.securelogin(usr.getString("User_name"), usr.getString("user_priviledge_type"), usr.getString("user_mainuser_id"), window, log,logtime);
                String today = df2.format(new Date());
                
                //adding current id to invoiceid table
                ResultSet rs1 = DB.getResultset("SELECT Today FROM invoiceid where Today ='"+today+"' ");
                if(rs1.next()){
                // no need to do     
                }else{
                    ResultSet rsx = DB.getResultset("select max(invoice_id ) as id1 from payment_invoice_student ");
                    rsx.first();
                    String id = rsx.getString("id1");
                    DB.stexecuteUpdate("update invoiceid set Today = '"+today+"',currentID='"+id+"' ");
                }
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    public String saylogged(String usrMainid) {
        String t = null;
        try {
            java.util.Date date = new java.util.Date();
            t = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Timestamp(date.getTime()));
            DB.stexecuteUpdate("insert into login_logout(User_mainUser_id,Login_time)"
                    + " values('" + usrMainid + "','" + t
                    + "')");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return t;
    }

    public void sayLogout() {


        try {
            DB.stexecuteUpdate("update login_logout set Logout_time= '" + df.format(new Date()) + "' where User_mainUser_id = '" + Mainwindow.UserStaffID + "' && Login_time = '"+Mainwindow.logtime+"' order by Login_time desc limit 1");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
