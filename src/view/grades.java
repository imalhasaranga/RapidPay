/*
 * grades.java
 *
 * Created on May 10, 2011, 1:41 PM
 */
package view;

import Utill.CUtils;
import control.gradesControl;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class grades extends javax.swing.JFrame {

    gradesControl gradecontrol = new gradesControl();

    /** Creates new form grades */
    public grades() {
        initComponents();
        gradecontrol.loadGrades(tblgrades);
 CUtils.setIconImage(this);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        bDelete = new javax.swing.JButton();
        tgrade = new javax.swing.JTextField();
        badd1 = new javax.swing.JButton();
        badd2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblgrades = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grade Details");
        setBackground(new java.awt.Color(164, 199, 222));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jPanel4.setBackground(new java.awt.Color(181, 201, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Enter Grades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("Grade");

        bDelete.setFont(new java.awt.Font("Dialog", 1, 12));
        bDelete.setText("Delete");
        bDelete.setEnabled(false);
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        tgrade.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgradeActionPerformed(evt);
            }
        });

        badd1.setFont(new java.awt.Font("Dialog", 1, 12));
        badd1.setText("Add");
        badd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badd1ActionPerformed(evt);
            }
        });

        badd2.setFont(new java.awt.Font("Dialog", 1, 12));
        badd2.setText("InAc");
        badd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badd1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(badd2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(tgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badd1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(badd2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        tblgrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Grades", "active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblgrades.getTableHeader().setReorderingAllowed(false);
        tblgrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblgradesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblgrades);
        tblgrades.getColumnModel().getColumn(0).setMinWidth(70);
        tblgrades.getColumnModel().getColumn(0).setPreferredWidth(70);
        tblgrades.getColumnModel().getColumn(0).setMaxWidth(70);
        tblgrades.getColumnModel().getColumn(2).setMinWidth(45);
        tblgrades.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblgrades.getColumnModel().getColumn(2).setMaxWidth(50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("NOTE* Before inactivating grades, makesure that they will not use again for any student ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
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
        setBounds((screenSize.width-447)/2, (screenSize.height-467)/2, 447, 467);
    }// </editor-fold>//GEN-END:initComponents

private void badd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badd1ActionPerformed

    if(!tgrade.getText().isEmpty()){
    gradecontrol.addGrade(tgrade.getText());
    gradecontrol.loadGrades(tblgrades);
    }else{
    JOptionPane.showMessageDialog(null, "Grade Field cant'be empty", "Grade field null", JOptionPane.INFORMATION_MESSAGE);
    }
}//GEN-LAST:event_badd1ActionPerformed

private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
    gradecontrol.deleteSelecteRec(tblgrades);
    gradecontrol.loadGrades(tblgrades);
}//GEN-LAST:event_bDeleteActionPerformed

private void tgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgradeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tgradeActionPerformed

private void tblgradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgradesMouseClicked

}//GEN-LAST:event_tblgradesMouseClicked

private void badd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badd2ActionPerformed
    if(gradecontrol.InactiveGrade(tblgrades)){ JOptionPane.showMessageDialog(null, "Job Done!!"); }
    gradecontrol.loadGrades(tblgrades);
}//GEN-LAST:event_badd2ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton badd1;
    private javax.swing.JButton badd2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblgrades;
    private javax.swing.JTextField tgrade;
    // End of variables declaration//GEN-END:variables
}
