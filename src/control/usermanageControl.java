
package control;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DB;

/**
 *
 * @author gihan
 */
public final class usermanageControl {
    private Vector usersid = null;
    private Vector accesstype = null;

    public static String takeAction(String usrpriv_type) {
        System.out.println(usrpriv_type);

        try {
            ResultSet usertype = DB.getResultset("select User_prvi_type from user_priviledge where User_prviID = '" + usrpriv_type + "'");
            if (usertype.next()) {

                return usertype.getString("User_prvi_type");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public void calculate(JComboBox selectuser, JComboBox accesstype, JTable table, String usrtype) {

        String priviledegtype = usermanageControl.takeAction(usrtype);


        if (priviledegtype.equals("Admin1")) {
            try {

              
                Vector v1 = new Vector();
                usersid = new Vector();
               
                

                ResultSet rs13 = DB.getResultset("select* from user_priviledge");
                Vector v2 = new Vector();
                this.accesstype = new Vector();
                while (rs13.next()) {

                    v2.add(rs13.getString("User_prvi_type"));
                    this.accesstype.add(rs13.getString("User_prviID"));
                    accesstype.setModel(new DefaultComboBoxModel(v2));

                }

                ResultSet rs14 = DB.getResultset("select* from user_login a, user_priviledge b where (a.User_priviledge_type = b.User_prviID) && a.is_active = '1' ");
                DefaultTableModel df = (DefaultTableModel) table.getModel();
                df.setRowCount(0);
                while (rs14.next()) {

                    Vector v = new Vector();
                    String username = rs14.getString("a.User_name");
                    String id = rs14.getString("a.User_mainUser_id");

                    v1.add(username);
                    usersid.add(id);
                    v.add(id);
                    v.add(username);
                    v.add(rs14.getString("b.User_prvi_type"));
                    df.addRow(v);
                    selectuser.setModel(new DefaultComboBoxModel(v1));
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (priviledegtype.equals("Admin2")) {

            try {

                ResultSet rs12 = DB.getResultset("select* from user_login a, user_priviledge b where(a.User_priviledge_type = b.User_prviID) &&  (b.User_prvi_type != 'Admin1') ");
                Vector v1 = new Vector();
                usersid = new Vector();
                while (rs12.next()) {
                    v1.add(rs12.getString("a.User_name"));
                    usersid.add(rs12.getString("a.User_mainUser_id"));
                    selectuser.setModel(new DefaultComboBoxModel(v1));
                }

                ResultSet rs13 = DB.getResultset("select* from user_priviledge where User_prvi_type != 'Admin1' ");
                Vector v2 = new Vector();
                this.accesstype = new Vector();
                while (rs13.next()) {

                    v2.add(rs13.getString("User_prvi_type"));
                    this.accesstype.add(rs13.getString("User_prviID"));
                    accesstype.setModel(new DefaultComboBoxModel(v2));

                }

                ResultSet rs14 = DB.getResultset("select* from user_login a, user_priviledge b where (a.User_priviledge_type = b.User_prviID) &&  (b.User_prvi_type != 'Admin1') ");
                DefaultTableModel df = (DefaultTableModel) table.getModel();
                df.setRowCount(0);
                while (rs14.next()) {

                    Vector v = new Vector();
                    v.add(rs14.getString("a.User_mainUser_id"));
                    v.add(rs14.getString("a.User_name"));
                    v.add(rs14.getString("b.User_prvi_type"));
                    df.addRow(v);

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
    
    public boolean chagePriviledge(String user,String accesstype){
        try {
            
            DB.stexecuteUpdate("update user_login set User_priviledge_type= '"+accesstype.trim()+"' where User_mainUser_id = '"+user.trim()+"'");
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    
    return true;
    }
    
    public boolean removeThisUser(String userid){
        
        try {
            DB.stexecuteUpdate("update user_main set is_active = '0' where user_id = '"+userid+"' ");
            DB.stexecuteUpdate("update user_login set is_active = '0' where User_mainuser_id = '"+userid+"'");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    
        return true;
    }
    

    public int getUsersid(int id) {
        return Integer.parseInt(usersid.get(id).toString())  ;
    }

    public int getAccesstype(int id) {
        
        return Integer.parseInt(accesstype.get(id).toString())  ;
    }
}
