/*
 * regteachers.java
 *
 * Created on May 10, 2011, 12:41 PM
 */
package view;

import control.OccationalLogics;
import control.regteacherControl;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  gihan
 */
public final class regteachers extends javax.swing.JPanel {

   
    public regteachers() {
        initComponents();
        dob.setDate(new Date());
        regteacherControl.loadTeacherDetails(tblteachers);


    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblteachers = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        tmname = new javax.swing.JTextField();
        tlname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        taddno = new javax.swing.JTextField();
        tstreet = new javax.swing.JTextField();
        tcity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tcontact = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        tworkaddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tworkcontact = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtexperience = new javax.swing.JTextArea();
        bsave1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tnic = new javax.swing.JTextField();
        bsave2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 180, 209));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblteachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg.No", "Name", "Address", "Contact No", "NIC No"
            }
        ));
        tblteachers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblteachers.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblteachers);
        tblteachers.getColumnModel().getColumn(0).setMinWidth(80);
        tblteachers.getColumnModel().getColumn(1).setMinWidth(200);
        tblteachers.getColumnModel().getColumn(2).setMinWidth(300);
        tblteachers.getColumnModel().getColumn(3).setMinWidth(120);
        tblteachers.getColumnModel().getColumn(4).setMinWidth(100);

        jPanel1.setBackground(new java.awt.Color(191, 205, 219));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Main Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel2.setText("First Name *");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel3.setText("Middle Name");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel4.setText("Last Name");

        tfname.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnameActionPerformed(evt);
            }
        });

        tmname.setFont(new java.awt.Font("Times New Roman", 1, 14));

        tlname.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel5.setText("Address No");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel6.setText("Street");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel7.setText("City");

        taddno.setFont(new java.awt.Font("Times New Roman", 1, 14));

        tstreet.setFont(new java.awt.Font("Times New Roman", 1, 14));

        tcity.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel8.setText("Date of Birth");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel12.setText("Contact No");

        tcontact.setFont(new java.awt.Font("Times New Roman", 1, 14));

        dob.setDateFormatString("MM, dd, yyyy");
        dob.setFont(new java.awt.Font("Tahoma", 0, 10));
        dob.setMinSelectableDate(new java.util.Date(-62135785697000L));
        dob.setMinimumSize(new java.awt.Dimension(10, 10));
        dob.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tmname, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(tlname, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(tcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taddno, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tcity, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tstreet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tmname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taddno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tstreet, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(191, 205, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Work Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("Work Address");

        tworkaddress.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel14.setText("Contact No");

        tworkcontact.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel15.setText("Work Experience");

        txtexperience.setColumns(20);
        txtexperience.setFont(new java.awt.Font("Times New Roman", 1, 14));
        txtexperience.setRows(5);
        jScrollPane1.setViewportView(txtexperience);

        bsave1.setFont(new java.awt.Font("Dialog", 1, 12));
        bsave1.setText("Save");
        bsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsave1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel17.setText("NIC No");

        tnic.setFont(new java.awt.Font("Times New Roman", 1, 14));

        bsave2.setFont(new java.awt.Font("Dialog", 1, 12));
        bsave2.setText("Clear Fields");
        bsave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsave2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bsave1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel21)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(tnic, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bsave2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tworkcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addComponent(tworkaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel17, jLabel21});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tworkaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tworkcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsave2)
                            .addComponent(tnic, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bsave1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel14, jLabel17, jLabel21, tworkaddress, tworkcontact});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
    }// </editor-fold>//GEN-END:initComponents

private void bsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsave1ActionPerformed

    if (OccationalLogics.showOption("Yes", "No") == 0) {
        regteacherControl teacher = new regteacherControl();
        teacher.setFName(tfname.getText());
        teacher.setMname(tmname.getText());
        teacher.setLname(tlname.getText());
        teacher.setAddressNo(taddno.getText());
        teacher.setStreet(tstreet.getText());
        teacher.setCity(tcity.getText());
        teacher.setDob(dob.getDate());
        teacher.setContactNum(tcontact.getText());
        teacher.setWorkAddress(tworkaddress.getText());
        teacher.setWorkcontact(tworkcontact.getText());
        teacher.setWorkExperience(txtexperience.getText());
        teacher.setNIC(tnic.getText());

        if (teacher.addTeacher(teacher)) {
            JOptionPane.showMessageDialog(null, "Thank you for joining with us");
            regteacherControl.loadTeacherDetails(tblteachers);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry unexpected error occured try again");
        }

    }
}//GEN-LAST:event_bsave1ActionPerformed

private void bsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsave2ActionPerformed

    JTextComponent[] comp = {tfname, tmname, tlname, taddno, tstreet, tcity, tcontact, tworkaddress, tworkcontact, txtexperience, tnic};
    OccationalLogics.clearTextFields(comp);

}//GEN-LAST:event_bsave2ActionPerformed

private void tfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfnameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsave1;
    private javax.swing.JButton bsave2;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField taddno;
    private javax.swing.JTable tblteachers;
    private javax.swing.JTextField tcity;
    private javax.swing.JTextField tcontact;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tlname;
    private javax.swing.JTextField tmname;
    private javax.swing.JTextField tnic;
    private javax.swing.JTextField tstreet;
    private javax.swing.JTextField tworkaddress;
    private javax.swing.JTextField tworkcontact;
    private javax.swing.JTextArea txtexperience;
    // End of variables declaration//GEN-END:variables
}
