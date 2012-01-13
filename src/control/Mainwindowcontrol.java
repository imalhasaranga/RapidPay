
package control;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.DB;

/**
 *
 * @author gihan
 */
public final class Mainwindowcontrol {
    //  static Vector vsearch = new Vector();
    //   static ResultSet rso = null;

    public static void key_release_search(JScrollPane js, String name, String query, JList jl) {
        try {
            js.setVisible(true);
            Vector v = new Vector();
            ResultSet rs = DB.getResultset(query);
            while (rs.next()) {
                String full = rs.getString(1);
                String fullname[] = full.split(" ");
                for (int i = 0; i < fullname.length; i++) {
                    String namepart = fullname[i];
                    if (namepart.startsWith(name) && (!v.contains(full))) {
                        v.add(full);
                    }
                }
            }
            jl.setListData(v);
            jl.setVisible(true);
            js.setVisible(true);

            if (v.size() == 0) {
                js.setSize(js.getWidth(), 0);
            } else {
                int height = (37 + (v.size() - 1) * 17);
                if (height < 400) {
                    js.setSize(js.getWidth(), height);
                } else {
                    js.setSize(js.getWidth(), 400);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void settingFocus(java.awt.event.KeyEvent evt, JList list) {
        try {
            int key = evt.getKeyCode();
            if (key == KeyEvent.VK_DOWN) {
                list.grabFocus();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void listclicked(JList jl, JTextField name, JTextField nic, JScrollPane js) {
        String name_nic = jl.getSelectedValue().toString();
        String namesplit[] = name_nic.split("-");
        name.setText(namesplit[0]);
        nic.setText(namesplit[1]);
        name.setFocusable(true);
        js.setVisible(false);
    }

    public static void list_key_release(java.awt.event.KeyEvent evt, JTextField tf) {
        try {
            if ((evt.getKeyCode() != KeyEvent.VK_DOWN) && (evt.getKeyCode() != KeyEvent.VK_UP)) {
                String s = Character.toString(evt.getKeyChar());
                tf.grabFocus();
                tf.setText(tf.getText().concat(s));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void personSeach(JScrollPane js, String value, JList jl, int id, int selectd) {

        Vector vsearch = new Vector();
        ResultSet rso = null;
        if (value.length() != 0) {
            try {
                js.setVisible(true);
                if (selectd == 0) {
                    rso = DB.getResultset("select* from user_main where (User_type_id='" + id + "')&& concat(Fname,' ', Mname,' ',Lname) like '" + value + "%' && ( is_active = '1' )");
                } else if (selectd == 1) {
                    rso = DB.getResultset("select* from user_main where (User_type_id='" + id + "') && ( User_id = '" + value + "') && ( is_active = '1' ) ");
                }
                while (rso.next()) {
                    vsearch.add(rso.getString("Fname") + " " + rso.getString("Mname") + " " + rso.getString("LName") + "-" + rso.getString("User_id"));
                }
                jl.setListData(vsearch);
                jl.setVisible(true);
                if (vsearch.size() == 0) {
                    js.setSize(js.getWidth(), 0);
                } else {
                    js.setSize(js.getWidth(), (22 + (vsearch.size() - 1) * 17));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            js.setVisible(false);
        }
        vsearch = null;
        rso = null;
        js = null;
        value = null;
        jl = null;
    }
}
