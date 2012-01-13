/*
 * usermanage.java
 *
 * Created on May 10, 2011, 1:37 PM
 */
package view;

import Utill.CUtils;
import control.OccationalLogics;
import control.usermanageControl;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class usermanage extends javax.swing.JFrame {

    usermanageControl usermanage = null;
    String userac;

    public usermanage() {
        initComponents();
         CUtils.setIconImage(this);
    }

    usermanage(String usrpriv_type) {
        userac = usrpriv_type;
        initComponents();
        usermanage = new usermanageControl();
        usermanage.calculate(cmbuser, cmbacctype, tblusers, usrpriv_type);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        bdone = new javax.swing.JButton();
        cmbuser = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        cmbacctype = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblusers = new javax.swing.JTable();
        bdelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Management");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jPanel4.setBackground(new java.awt.Color(181, 201, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "User Management", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("Select User");

        bdone.setFont(new java.awt.Font("Dialog", 1, 12));
        bdone.setText("Done");
        bdone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdoneActionPerformed(evt);
            }
        });

        cmbuser.setFont(new java.awt.Font("Dialog", 1, 12));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel22.setText("Select Access Type");

        cmbacctype.setFont(new java.awt.Font("Dialog", 1, 12));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(64, 64, 64)
                        .addComponent(cmbuser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(cmbacctype, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdone, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cmbacctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bdone))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Grades"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tblusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserId", "User Name", "Type"
            }
        ));
        jScrollPane2.setViewportView(tblusers);

        bdelete.setFont(new java.awt.Font("Dialog", 1, 12));
        bdelete.setText("Remove Login");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
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
                        .addComponent(bdelete, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addGap(333, 333, 333))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bdelete)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-498)/2, (screenSize.height-425)/2, 498, 425);
    }// </editor-fold>//GEN-END:initComponents

private void bdoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdoneActionPerformed

    if (OccationalLogics.showOption("Yes", "No") == 0) {
        if (usermanage.chagePriviledge("" + usermanage.getUsersid(cmbuser.getSelectedIndex()), "" + usermanage.getAccesstype(cmbacctype.getSelectedIndex()))) {

            JOptionPane.showMessageDialog(null, "Operation Success");
            usermanage.calculate(cmbuser, cmbacctype, tblusers, userac);
        }

    }

}//GEN-LAST:event_bdoneActionPerformed

private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
    if (tblusers.getSelectedRow() != -1) {
        if(OccationalLogics.showOption("Yes", "No") == 0){
        if (usermanage.removeThisUser(tblusers.getValueAt(tblusers.getSelectedRow(), 0).toString())) {

            JOptionPane.showMessageDialog(null, "User removed successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry unexpected error occured");
        }
        }
    } else {
        JOptionPane.showMessageDialog(null, "First Select User you want to delete");
    }
}//GEN-LAST:event_bdeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bdone;
    private javax.swing.JComboBox cmbacctype;
    private javax.swing.JComboBox cmbuser;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblusers;
    // End of variables declaration//GEN-END:variables
}
