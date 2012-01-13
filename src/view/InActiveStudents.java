/*
 * InActiveStudents.java
 *
 * Created on July 17, 2011, 9:59 PM
 */
package view;

import Utill.CUtils;
import control.InActiveStudentControl;

/**
 *
 * @author  Imal
 */
public final class InActiveStudents extends javax.swing.JFrame {

    InActiveStudentControl controlInactiv = new InActiveStudentControl();

    public InActiveStudents() {
        initComponents();
        
        controlInactiv.setJt(inactiveStudents);
        controlInactiv.setT(seachfield);
        controlInactiv.setBox(method);
        controlInactiv.setButton(radio);
        loadval();
        CUtils.setIconImage(this);
    }

    protected void loadval() {

        controlInactiv.setDatedif(jtimeval.getSelectedItem().toString());
        controlInactiv.loadToTable();
        count.setText(inactiveStudents.getRowCount() + "");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inactiveStudents = new javax.swing.JTable();
        seachfield = new javax.swing.JTextField();
        method = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Inactiveallstudents = new javax.swing.JButton();
        Savechanges = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jtimeval = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        count = new javax.swing.JLabel();
        radio = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        inactiveStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "StudentName", "Last Paid Date", "InActive Days", "Make Active/InActive"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inactiveStudents.getTableHeader().setReorderingAllowed(false);
        inactiveStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inactiveStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inactiveStudents);
        inactiveStudents.getColumnModel().getColumn(0).setPreferredWidth(150);
        inactiveStudents.getColumnModel().getColumn(1).setPreferredWidth(300);
        inactiveStudents.getColumnModel().getColumn(3).setPreferredWidth(90);

        seachfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seachfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                seachfieldKeyTyped(evt);
            }
        });

        method.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "By Name", "By ID" }));
        method.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                methodActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search Student ");

        Inactiveallstudents.setText("InActiveAll");
        Inactiveallstudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactiveallstudentsActionPerformed(evt);
            }
        });

        Savechanges.setText("Save Changes");
        Savechanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavechangesActionPerformed(evt);
            }
        });

        jButton1.setText("Load Original Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtimeval.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30", "60", "90", "120", "180", "360" }));
        jtimeval.setSelectedIndex(2);
        jtimeval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtimevalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("InActive Since");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Days");

        radio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radio.setSelected(true);
        radio.setText("Show only Active Students");
        radio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        radio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seachfield, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(method, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtimeval, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Inactiveallstudents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Savechanges, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(method, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seachfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtimeval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(radio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Savechanges)
                    .addComponent(Inactiveallstudents)
                    .addComponent(jButton1)
                    .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setBounds((screenSize.width-1002)/2, (screenSize.height-668)/2, 1002, 668);
    }// </editor-fold>//GEN-END:initComponents

private void InactiveallstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactiveallstudentsActionPerformed
    controlInactiv.inActiveAll();
}//GEN-LAST:event_InactiveallstudentsActionPerformed

private void inactiveStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inactiveStudentsMouseClicked
    controlInactiv.onTableClick();
}//GEN-LAST:event_inactiveStudentsMouseClicked

private void SavechangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavechangesActionPerformed
    controlInactiv.makethemInactive();
}//GEN-LAST:event_SavechangesActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    controlInactiv.loadToTable();
}//GEN-LAST:event_jButton1ActionPerformed

private void seachfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachfieldKeyReleased
    controlInactiv.searchJTable();
     count.setText(inactiveStudents.getRowCount() + "");
     if(seachfield.getText().isEmpty()){ loadval(); }
}//GEN-LAST:event_seachfieldKeyReleased

private void jtimevalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtimevalActionPerformed
    loadval();
}//GEN-LAST:event_jtimevalActionPerformed

private void seachfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachfieldKeyTyped
}//GEN-LAST:event_seachfieldKeyTyped

private void methodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_methodActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_methodActionPerformed

private void radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioActionPerformed
loadval();
}//GEN-LAST:event_radioActionPerformed

  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inactiveallstudents;
    private javax.swing.JButton Savechanges;
    private javax.swing.JLabel count;
    private javax.swing.JTable inactiveStudents;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jtimeval;
    private javax.swing.JComboBox method;
    private javax.swing.JCheckBox radio;
    private javax.swing.JTextField seachfield;
    // End of variables declaration//GEN-END:variables
}
