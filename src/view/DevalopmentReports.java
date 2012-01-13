/*
 * DevalopmentReports.java
 *
 * Created on July 19, 2011, 5:03 PM
 */
package view;

import Utill.CUtils;
import control.OccationalLogics;
import control.instituteControl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author  Imal
 */
public final class DevalopmentReports extends javax.swing.JFrame {

    instituteControl control = new instituteControl();
    Map<String, Object> params = new HashMap<String, Object>();
    private String reportname;

    public DevalopmentReports() {
        initComponents();
         CUtils.setIconImage(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jyear = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();
        repdetails = new javax.swing.JLabel();
        reportarea = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Year");

        jButton1.setText("Genarate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        repdetails.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        repdetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repdetails.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jyear, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226)
                .addComponent(repdetails, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(repdetails))
                    .addComponent(jyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportarea, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportarea, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-984)/2, (screenSize.height-600)/2, 984, 600);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    new Thread(new Runnable() {

        public void run() {
            params.put("year", jyear.getYear() + "");
            OccationalLogics.JReport(reportarea, repdetails.getText(), 0.9, params, reportname, 1, control);
        }
    }).start();


}//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JYearChooser jyear;
    private javax.swing.JLabel repdetails;
    private javax.swing.JTabbedPane reportarea;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getRepdetails() {
        return repdetails;
    }

    public void setReportname(
            String reportname) {
        this.reportname = reportname;
    }
}
