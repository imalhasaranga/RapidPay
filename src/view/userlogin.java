/*
 * userlogin.java
 *
 * Created on May 17, 2011, 7:53 PM
 */
package view;

import Utill.CUtils;
import control.OccationalLogics;
import control.userloginControl;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import model.Databaseconfig;

/**
 *
 * @author gihan
 */
public final class userlogin extends javax.swing.JFrame {

    Databaseconfig config = new Databaseconfig(Databaseconfig.DB_CONNECTION_AVILABLE);
    userloginControl usrlog = new userloginControl();
    Mainwindow mainwin;

    public userlogin(Mainwindow mainwin) {
        initComponents();
        CUtils.setIconImage(this);
        this.mainwin = mainwin;
        username.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGING");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameKeyReleased(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 106, 266, 26));

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 145, 266, 24));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logingbuton.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 170, 70, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gear_16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 30, 20));

        status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(184, 17, 17));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText(" ");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 300, 20));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1342454217_preferences-system-time.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 290, 30, 20));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gt-202-login.jpg"))); // NOI18N
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 330));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-358)/2, 416, 358);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (usrlog.checkLogin(username.getText().replace("'", ""), new String(password.getPassword()).replace("'", ""), this, mainwin)) {
        status.setText("Unable to login, Check your login details");
    } else {

        this.dispose();
    }

}//GEN-LAST:event_jButton1ActionPerformed

private void usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jButton1ActionPerformed(null);
    }

    OccationalLogics.ballonTool(username, this, rootPaneCheckingEnabled, "Caps look On");
}//GEN-LAST:event_usernameKeyReleased

private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

        jButton1ActionPerformed(null);
    }

    OccationalLogics.ballonTool(password, this, rootPaneCheckingEnabled, "Caps look On");
}//GEN-LAST:event_passwordKeyReleased

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    config.setVisible(true);
}//GEN-LAST:event_jButton2ActionPerformed

private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_usernameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new BarcodeAttendance().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public JPasswordField getPassword() {

        return password;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel panel;
    private javax.swing.JPasswordField password;
    public javax.swing.JLabel status;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
