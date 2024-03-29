/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Databaseconfig.java
 *
 * Created on Jun 8, 2011, 7:16:19 PM
 */
package model;

import Utill.CUtils;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public final class Databaseconfig extends javax.swing.JFrame {

    String password1;
    public static final int DB_CONNECTION_UNAVILABLE = 10;
    public static final int DB_CONNECTION_AVILABLE = 11;
    Connection con = null;

    public void load1() {
        try {
            if ((new File(System.getProperty("user.dir") + "/data1.dat").exists())) {
                FileInputStream condata1 = new FileInputStream(System.getProperty("user.dir") + "/data1.dat");

                ObjectInputStream input = new ObjectInputStream(condata1);

                Property prop = (Property) input.readObject();
                Host1.setText(prop.getHost());
                Port1.setText(prop.getPort());
                usrname.setText(prop.getUsername());
                password1 = prop.getPassword();
                password.setText(password1);

                input.close();

            } else {
                FileOutputStream condata2 = new FileOutputStream(System.getProperty("user.dir") + "/data1.dat");
                ObjectOutputStream outstream = new ObjectOutputStream(condata2);
                Property prop = new Property();
                prop.setHost("localhost");
                prop.setPort("3306");
                prop.setUsername("root");
                prop.setPassword("123");
                outstream.writeObject(prop);
                outstream.close();

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void TogleButton() {
        if (QueryCache.isSelected()) {
            QueryCache.setText("Disable");
        } else {
            QueryCache.setText("Enable");
        }

    }

    /**
     * Creates new form Databaseconfig
     */
    public Databaseconfig(int State) {
        initComponents();
        if (State == 11) {


            try {
                con = DB.getmyCon();
                ResultSet querycache = con.createStatement().executeQuery("SHOW VARIABLES LIKE 'query_cache_size'");
                if (querycache.next()) {
                    long b = (long) Math.round(Double.parseDouble(querycache.getString("value")) / (1024 * 1024));
                    querych.setText(b + "");
                    QueryCache.setSelected(true);
                } else {
                    querych.setText("0");
                    QueryCache.setSelected(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        TogleButton();
        CUtils.setIconImage(this);
        load1();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Host = new javax.swing.JLabel();
        Post = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        usrname = new javax.swing.JTextField();
        Port1 = new javax.swing.JTextField();
        Host1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        QueryCache = new javax.swing.JToggleButton();
        querych = new javax.swing.JTextField();

        jLabel3.setText("jLabel1");

        jTextField3.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jLabel6.setBackground(new java.awt.Color(181, 201, 243));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DB Configure");

        save.setText("save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton1.setText("Backup DB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Host.setText("Host");

        Post.setText("Port");

        jLabel4.setText("DB User name");

        jLabel5.setText("DB Password");

        usrname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrnameActionPerformed(evt);
            }
        });

        jButton2.setText("Restore DB");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("SQl Cache (MB)");

        QueryCache.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        QueryCache.setText("Enable");
        QueryCache.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryCacheActionPerformed(evt);
            }
        });

        querych.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                querychKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                querychKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Post, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Host, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(querych)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QueryCache, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(password)
                            .addComponent(usrname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Port1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Host1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Host, Post, jLabel4, jLabel5, jLabel7});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Host, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Host1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Post, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Port1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usrname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QueryCache, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(querych, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, password});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, usrname});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Port1, Post});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Host, Host1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-257)/2, (screenSize.height-299)/2, 257, 299);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        Object[] options = {"Yes", "No"};
        int res = JOptionPane.showOptionDialog(null, "Changing configuration might cause This software not working, are you sure you want to change", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (res == 0) {
            try {
                FileOutputStream condata2 = new FileOutputStream(System.getProperty("user.dir") + "/data1.dat");
                ObjectOutputStream outstream = new ObjectOutputStream(condata2);
                Property prop = new Property();
                prop.setHost(Host1.getText());
                prop.setPort(Port1.getText());
                prop.setUsername(usrname.getText());

                password1 = password.getText().isEmpty() ? password1 : password.getText();
                prop.setPassword(password1);

                outstream.writeObject(prop);
                outstream.close();

                Class.forName(prop.getDriver()).newInstance();
                DriverManager.getConnection("jdbc:mysql://" + prop.getHost() + ":" + prop.getPort() + "/tutionDb?autoReconnect=true", prop.getUsername(), prop.getPassword());

                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection Failure, Check configuration again", "mysql Connection Status", JOptionPane.WARNING_MESSAGE);
            }
            load1();
        }
    }//GEN-LAST:event_saveActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {

        new sqlDump().backup();
        JOptionPane.showMessageDialog(null, "Mysql Backup file sucess created", "SQL Backup", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        System.out.println(e);
    }

}//GEN-LAST:event_jButton1ActionPerformed

private void usrnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrnameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_usrnameActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        new sqlDump().Restore();
    } catch (Exception e) {
        System.out.println(e);
    }
}//GEN-LAST:event_jButton2ActionPerformed

    private void QueryCacheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryCacheActionPerformed

        try {
            long cacheSize = Integer.parseInt(querych.getText()) * 1024 * 1024;
            if (!QueryCache.isSelected()) {
                cacheSize = 0;
            } 
            System.out.println("SET GLOBAL query_cache_size = " + cacheSize);
            DB.getmyCon().createStatement().executeQuery("SET GLOBAL query_cache_size = " + cacheSize);
            querych.setText(cacheSize+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TogleButton();

    }//GEN-LAST:event_QueryCacheActionPerformed

    private void querychKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_querychKeyTyped
    }//GEN-LAST:event_querychKeyTyped

    private void querychKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_querychKeyReleased
        if (QueryCache.isSelected()) {
            QueryCache.setSelected(false);
            TogleButton();
        }
    }//GEN-LAST:event_querychKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Databaseconfig(Databaseconfig.DB_CONNECTION_AVILABLE).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Host;
    private javax.swing.JTextField Host1;
    private javax.swing.JTextField Port1;
    private javax.swing.JLabel Post;
    private javax.swing.JToggleButton QueryCache;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField querych;
    private javax.swing.JButton save;
    private javax.swing.JTextField usrname;
    // End of variables declaration//GEN-END:variables
}
