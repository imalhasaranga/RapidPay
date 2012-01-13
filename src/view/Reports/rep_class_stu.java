/*
 * rep_class_stu.java
 *
 * Created on May 11, 2011, 11:16 PM
 */

package view.Reports;

import control.rep_class_stuControl;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class rep_class_stu extends javax.swing.JPanel {
    
    rep_class_stuControl rep_classstu = new rep_class_stuControl();
    String clasname = null;
    
    
    /** Creates new form rep_class_stu */
    public rep_class_stu() {
        initComponents();
        rep_classstu = new rep_class_stuControl();
        cmbdayActionPerformed(null);
    }

   private void bclick(){
    rep_classstu.loadClass( (String) cmbday.getSelectedItem(), cmbclass, lclid, tblstudents);
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblstudents = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        bview = new javax.swing.JButton();
        cmbday = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        cmbclass = new javax.swing.JComboBox();
        lclid = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ltotstu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 180, 209));

        tblstudents.setFont(new java.awt.Font("Dialog", 1, 12));
        tblstudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "In.No", "Name", "Address", "Guard / Parent", "G / P Name", "G / P Contact", "G / P Work Address", "G / P Work Contact"
            }
        ));
        jScrollPane1.setViewportView(tblstudents);
        tblstudents.getColumnModel().getColumn(0).setMinWidth(50);
        tblstudents.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblstudents.getColumnModel().getColumn(0).setMaxWidth(50);
        tblstudents.getColumnModel().getColumn(3).setMinWidth(100);
        tblstudents.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblstudents.getColumnModel().getColumn(3).setMaxWidth(100);
        tblstudents.getColumnModel().getColumn(5).setMinWidth(100);
        tblstudents.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblstudents.getColumnModel().getColumn(5).setMaxWidth(100);
        tblstudents.getColumnModel().getColumn(7).setMinWidth(120);
        tblstudents.getColumnModel().getColumn(7).setPreferredWidth(120);
        tblstudents.getColumnModel().getColumn(7).setMaxWidth(120);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel23.setText("Total Students in Class:");

        jPanel4.setBackground(new java.awt.Color(181, 201, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Select the Class", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("Day");

        bview.setFont(new java.awt.Font("Dialog", 1, 12));
        bview.setText("View");
        bview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewActionPerformed(evt);
            }
        });

        cmbday.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        cmbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdayActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Class");

        cmbclass.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbclass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbclassItemStateChanged(evt);
            }
        });

        lclid.setFont(new java.awt.Font("Dialog", 1, 12));
        lclid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lclid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
        jButton2.setText("Report - PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbday, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbclass, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lclid, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bview, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbclass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbday, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jButton2)
                            .addComponent(bview))
                        .addComponent(lclid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bview, cmbclass, cmbday, jButton2, jLabel1, jLabel21, jLabel24, lclid});

        ltotstu.setFont(new java.awt.Font("Dialog", 1, 12));
        ltotstu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltotstu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ltotstu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(ltotstu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void cmbclassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbclassItemStateChanged
    if(cmbclass.getItemCount()== 0){
        JOptionPane.showMessageDialog(null, "Select the Day & Class");
    }else{
        String classval = (String) cmbclass.getSelectedItem();
        rep_classstu = new rep_class_stuControl();
        rep_classstu.setClassId(classval, lclid); 
    }
    
    
    
}//GEN-LAST:event_cmbclassItemStateChanged

private void bviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewActionPerformed
    if(cmbclass.getItemCount()== 0 || lclid.getText().equals("")){ 
        JOptionPane.showMessageDialog(null, "Select the Day & Class");
    }else{
        
        rep_classstu.getStudents(lclid, tblstudents, ltotstu); 
        clasname = cmbclass.getSelectedItem().toString();
    }
}//GEN-LAST:event_bviewActionPerformed

private void cmbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdayActionPerformed
bclick();
}//GEN-LAST:event_cmbdayActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
bviewActionPerformed(null);
    if(tblstudents.getRowCount() > 0){
        rep_classstu.CrateReport(tblstudents,clasname);
    
    }
}//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bview;
    private javax.swing.JComboBox cmbclass;
    private javax.swing.JComboBox cmbday;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lclid;
    private javax.swing.JLabel ltotstu;
    private javax.swing.JTable tblstudents;
    // End of variables declaration//GEN-END:variables

}
