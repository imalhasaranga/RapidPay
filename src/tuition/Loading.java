/*
 * Loading.java
 *
 * Created on August 25, 2011, 12:28 AM
 */
package tuition;

import Utill.CUtils;
import control.OccationalLogics;
import control.editpesonDetails;
import control.userloginControl;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.DB;
import model.Databaseconfig;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import view.Mainwindow;
import view.userlogin;

/**
 *
 * @author  Imal
 */
public  final class Loading extends javax.swing.JFrame {

    Mainwindow win;
    

    public Loading() {
        initComponents();
        CUtils.setIconImage(this);

    }

    public void LoadValues(){
    
     try {
            DB.getmyCon();
             win = new Mainwindow();
            datacon();
        } catch (Exception e) {
                       
            JOptionPane.showMessageDialog(null, "Due to internal Db connection error, application will need to reconfigure, \n please start again after changes", "Connection Config", WIDTH);
            new Databaseconfig(Databaseconfig.DB_CONNECTION_UNAVILABLE).setVisible(true);
            dispose();
        }
    }
    
    public void  datacon(){
   
        jprog.setMinimum(0);
        jprog.setMaximum(100);


        jprog.setMinimum(0);
        jprog.setMaximum(100);
        OccationalLogics.Compare();

        new Thread(new Runnable() {

            public void run() {



                for (int i = jprog.getMinimum(); i <= jprog.getMaximum(); ++i) {

                    try {
                        Thread.sleep(10);

                        switch (i) {
                            case 11:

                                break;
                            case 17:
                                status.setText("Staff Registration...");
                                win.setRf(new view.regstaff());

                                break;
                            case 23:
                                status.setText("Teacher Regist...");
                                win.setRt(new view.regteachers());

                                break;
                            case 30:
                                status.setText("Student Registration...");
                                win.setRs(new view.regstudent());
                                break;
                            case 35:
                                status.setText("Teacher payment...");
                                win.setTp(new view.teacherpay());

                                break;
                            case 43:
                                win.setEstafedi(new view.editstaff());
                                status.setText("Staff Edit...");
                                break;
                            case 49:
                                status.setText("Student Edit..");
                                win.setEstu(new view.editstudent());

                                break;
                            case 52:
                                status.setText("Teacher edit..");
                                win.setEteacher(new view.editteachers());

                                break;
                            case 60:
                                status.setText("Classes...");
                                win.setCls(new view.classes());

                                break;
                            case 70:
                                win.setControllog(new userloginControl());
                                status.setText("User control..");
                                break;
                            case 75:
                                status.setText("Edit personcontrol...");
                                win.setEditperson(new editpesonDetails());
                                break;

                            case 80:
                                status.setText("Initializing Jasper engine......");
                                Map<String, Object> params = new HashMap<String, Object>();
                                params.put("Load1", "load");
                                params.put("Load2", "load2");
                                JasperReport jreport = JasperCompileManager.compileReport(System.getProperty("user.dir") + "/reports/JasperInitializer.jrxml");
                                JasperPrint jprint = JasperFillManager.fillReport(jreport, params, new JREmptyDataSource());
                                jreport = null;
                                jprint = null;
                                break;
                            case 98:
                                status.setText("Loading Main window...");
                                break;
                        }
                        presen.setText(i + "");
                        jprog.setValue(i);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                
                    userlogin user = new userlogin(win);
                    user.setVisible(true);
                    win = null;
                    dispose();
                

            }
        }).start();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jprog = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        presen = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jprog, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 530, -1));

        status.setForeground(new java.awt.Color(153, 153, 153));
        status.setText(" ");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, -1));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("%");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 20, -1));

        presen.setForeground(new java.awt.Color(204, 204, 204));
        presen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        presen.setText("0");
        getContentPane().add(presen, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edukca1.png"))); // NOI18N
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-550)/2, (screenSize.height-315)/2, 550, 315);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jprog;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel presen;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
