/*
 * rep_nopay.java
 *
 * Created on May 10, 2011, 1:19 PM
 */
package view.Reports;

import control.rep_nopayControl;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class rep_nopay extends javax.swing.JPanel {

    rep_nopayControl repnopayc = null;
    String classname = null;

    /** Creates new form rep_nopay */
    public rep_nopay() {
        initComponents();
        cmbdayActionPerformed(null);
    }
    
    void bclick(){
        repnopayc = repnopayc != null ? repnopayc : new rep_nopayControl();  
        repnopayc.loadClass((String) cmbday.getSelectedItem(), cmbclass, lclid);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        cmbday = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        cmbclass = new javax.swing.JComboBox();
        lclid = new javax.swing.JLabel();
        cmbyear = new com.toedter.calendar.JYearChooser();
        cmbmonth = new com.toedter.calendar.JMonthChooser();
        bview = new javax.swing.JButton();
        bpdf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblstudents1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblstudents2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 180, 209));

        jPanel4.setBackground(new java.awt.Color(181, 201, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Select the Class", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        cmbday.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        cmbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdayActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel26.setText("Class");

        cmbclass.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbclass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbclassItemStateChanged(evt);
            }
        });

        lclid.setFont(new java.awt.Font("Dialog", 1, 12));
        lclid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lclid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cmbmonth.setFont(new java.awt.Font("Dialog", 1, 12));

        bview.setFont(new java.awt.Font("Dialog", 1, 12));
        bview.setText("View");
        bview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewActionPerformed(evt);
            }
        });

        bpdf.setFont(new java.awt.Font("Dialog", 1, 12));
        bpdf.setText("Gen-Report");
        bpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpdfActionPerformed(evt);
            }
        });

        jLabel1.setText(" ");

        jLabel2.setText(" ");

        jLabel3.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(bview, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cmbday, 0, 178, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbclass, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lclid, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(cmbyear, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbmonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cmbclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lclid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(cmbyear, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bview, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bpdf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbclass, cmbday, cmbmonth, cmbyear, jLabel1, jLabel2, jLabel26, lclid});

        tblstudents1.setBackground(new java.awt.Color(250, 177, 177));
        tblstudents1.setFont(new java.awt.Font("Tahoma", 1, 12));
        tblstudents1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.ID", "Student Name", "Contact number", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblstudents1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblstudents1);
        tblstudents1.getColumnModel().getColumn(0).setMinWidth(90);
        tblstudents1.getColumnModel().getColumn(0).setPreferredWidth(90);
        tblstudents1.getColumnModel().getColumn(1).setMinWidth(300);
        tblstudents1.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblstudents1.getColumnModel().getColumn(1).setMaxWidth(300);
        tblstudents1.getColumnModel().getColumn(2).setMinWidth(150);
        tblstudents1.getColumnModel().getColumn(2).setPreferredWidth(90);
        tblstudents1.getColumnModel().getColumn(3).setMinWidth(150);
        tblstudents1.getColumnModel().getColumn(3).setPreferredWidth(150);

        tblstudents2.setBackground(new java.awt.Color(250, 177, 177));
        tblstudents2.setFont(new java.awt.Font("Tahoma", 1, 12));
        tblstudents2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.ID", "Student Name", "Contact number", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblstudents2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblstudents2);
        tblstudents2.getColumnModel().getColumn(0).setMinWidth(90);
        tblstudents2.getColumnModel().getColumn(0).setPreferredWidth(90);
        tblstudents2.getColumnModel().getColumn(1).setMinWidth(300);
        tblstudents2.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblstudents2.getColumnModel().getColumn(1).setMaxWidth(300);
        tblstudents2.getColumnModel().getColumn(2).setMinWidth(150);
        tblstudents2.getColumnModel().getColumn(2).setPreferredWidth(90);
        tblstudents2.getColumnModel().getColumn(3).setMinWidth(150);
        tblstudents2.getColumnModel().getColumn(3).setPreferredWidth(150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void bviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewActionPerformed
    if (cmbclass.getItemCount() == 0 || lclid.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Select the Day & Class");
    } else {
        repnopayc = repnopayc != null ? repnopayc : new rep_nopayControl();
        repnopayc.getNotPaid(tblstudents1, lclid, cmbyear.getYear(), (cmbmonth.getMonth() + 1) + "");
        classname = cmbclass.getSelectedItem().toString();

    }

}//GEN-LAST:event_bviewActionPerformed

private void cmbclassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbclassItemStateChanged
    if (cmbclass.getItemCount() == 0) {
        JOptionPane.showMessageDialog(null, "Select the Day & Class");
    } else {
        String classval = (String) cmbclass.getSelectedItem();
        repnopayc = repnopayc != null ? repnopayc : new rep_nopayControl();
        repnopayc.setClassId(classval, lclid);
    }

}//GEN-LAST:event_cmbclassItemStateChanged

private void bpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpdfActionPerformed
    bviewActionPerformed(null);
    if (tblstudents1.getRowCount() <= 0) {
        JOptionPane.showMessageDialog(null, "No Data on Table");
    } else {
         repnopayc = repnopayc != null ? repnopayc : new rep_nopayControl();
         repnopayc.reportPdf(tblstudents1, classname, tblstudents1.getRowCount());
    }
}//GEN-LAST:event_bpdfActionPerformed

private void cmbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdayActionPerformed
bclick();
}//GEN-LAST:event_cmbdayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bpdf;
    private javax.swing.JButton bview;
    private javax.swing.JComboBox cmbclass;
    private javax.swing.JComboBox cmbday;
    private com.toedter.calendar.JMonthChooser cmbmonth;
    private com.toedter.calendar.JYearChooser cmbyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lclid;
    private javax.swing.JTable tblstudents1;
    private javax.swing.JTable tblstudents2;
    // End of variables declaration//GEN-END:variables
}
