/*
 * rep_ins_summary.java
 *
 * Created on May 11, 2011, 11:23 PM
 */

package view;

import control.AttendanceMarksetControl;



/**
 *
 * @author  gihan
 */
public final class AttendanceMarkset extends javax.swing.JPanel {

    AttendanceMarksetControl controlatten = new AttendanceMarksetControl();
    
    
    public AttendanceMarkset() {
        initComponents();
        controlatten.setTable(selecclass);
        controlatten.setDay(cmbday);
        controlatten.setBlocked(blockedlist);
        controlatten.setMonth(month);
        controlatten.setYear(year);
        cmbdayActionPerformed(null);
        
        
        
        for (int i = 0; i < selecclass.getRowCount(); i++) {
            
            selecclass.setValueAt(false, i, 6);
            
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        selecclass = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbday = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        blockedlist = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        classes = new javax.swing.JLabel();
        year = new com.toedter.calendar.JYearChooser();
        month = new com.toedter.calendar.JMonthChooser();
        loadBolckedLit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 180, 209));

        selecclass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CId", "Subject", "Grade", "Teacher", "startTime", "endTime", "Class Selection"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selecclass.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(selecclass);
        selecclass.getColumnModel().getColumn(0).setMinWidth(70);
        selecclass.getColumnModel().getColumn(0).setPreferredWidth(70);
        selecclass.getColumnModel().getColumn(0).setMaxWidth(70);
        selecclass.getColumnModel().getColumn(1).setMinWidth(180);
        selecclass.getColumnModel().getColumn(1).setPreferredWidth(180);
        selecclass.getColumnModel().getColumn(1).setMaxWidth(180);
        selecclass.getColumnModel().getColumn(2).setMinWidth(180);
        selecclass.getColumnModel().getColumn(2).setPreferredWidth(180);
        selecclass.getColumnModel().getColumn(2).setMaxWidth(190);
        selecclass.getColumnModel().getColumn(3).setPreferredWidth(300);
        selecclass.getColumnModel().getColumn(4).setPreferredWidth(100);
        selecclass.getColumnModel().getColumn(5).setPreferredWidth(100);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Select The Day :");

        cmbday.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        cmbday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdayActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(blockedlist);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Classes");

        classes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        classes.setText(" ");

        month.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        loadBolckedLit.setText("Load Bloacked List >>");
        loadBolckedLit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBolckedLitActionPerformed(evt);
            }
        });

        jLabel2.setText(" ");

        jLabel3.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbday, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(loadBolckedLit, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loadBolckedLit)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(jLabel3)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {classes, cmbday, jLabel1, jLabel5, month, year});

    }// </editor-fold>//GEN-END:initComponents

private void cmbdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdayActionPerformed

    controlatten.loadClassoftheday();
    classes.setText(controlatten.classes+"");
}//GEN-LAST:event_cmbdayActionPerformed

private void loadBolckedLitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBolckedLitActionPerformed
    controlatten.loadData();
}//GEN-LAST:event_loadBolckedLitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList blockedlist;
    private javax.swing.JLabel classes;
    private javax.swing.JComboBox cmbday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton loadBolckedLit;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JTable selecclass;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables

}
