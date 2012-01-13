/*
 * teacherpay.java
 *
 * Created on May 12, 2011, 9:56 AM
 */
package view;

import control.OccationalLogics;
import control.teacherpayControl;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class teacherpay extends javax.swing.JPanel {

    teacherpayControl control = new teacherpayControl();
    String userid = null;

    public teacherpay() {

        initComponents();
        searchscoral.setVisible(false);
        month.setEnabled(false);
      
        jyear.setValue(Calendar.getInstance().get(Calendar.YEAR));
        control.searchfirst100(tablene);
        control.setAdvancetaken(advancetable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        searchscoral = new javax.swing.JScrollPane();
        searchlist = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        teachersearch = new javax.swing.JTextField();
        paidamount = new javax.swing.JTextField();
        idseacrh = new javax.swing.JTextField();
        lastpaidmonth = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pay = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        details = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        totalpayment = new javax.swing.JLabel();
        advance = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        person = new javax.swing.JLabel();
        lpaynow1 = new javax.swing.JLabel();
        payamut2 = new javax.swing.JLabel();
        lpaynow = new javax.swing.JLabel();
        payamut = new javax.swing.JLabel();
        lpaynow2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        jyear = new com.toedter.components.JSpinField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablene = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        advancetable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 180, 209));

        jPanel4.setBackground(new java.awt.Color(191, 205, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Teacher Payment Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchlistMouseClicked(evt);
            }
        });
        searchlist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchlistKeyReleased(evt);
            }
        });
        searchscoral.setViewportView(searchlist);

        jPanel4.add(searchscoral, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 243, 10));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Paid Amount :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 100, 30));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("Paying Month");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        teachersearch.setFont(new java.awt.Font("Times New Roman", 1, 14));
        teachersearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                teachersearchKeyReleased(evt);
            }
        });
        jPanel4.add(teachersearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 243, 25));

        paidamount.setFont(new java.awt.Font("Times New Roman", 1, 14));
        paidamount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        paidamount.setText("0");
        paidamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidamountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                paidamountKeyTyped(evt);
            }
        });
        jPanel4.add(paidamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 120, 30));

        idseacrh.setFont(new java.awt.Font("Times New Roman", 1, 14));
        idseacrh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idseacrh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idseacrhKeyReleased(evt);
            }
        });
        jPanel4.add(idseacrh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 79, 25));

        lastpaidmonth.setFont(new java.awt.Font("Dialog", 1, 12));
        lastpaidmonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastpaidmonth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lastpaidmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 70, 28));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Teacher's Total Payment for this Month (LKR):");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 290, 330, 27));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel22.setText("LKR");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 30, 30));

        pay.setFont(new java.awt.Font("Dialog", 1, 12));
        pay.setText("Pay");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel4.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 375, 160, -1));

        details.setFont(new java.awt.Font("Dialog", 1, 14));
        details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClassId", "Subject", "Grade", "Day", "Time", "Total Stu", "Paid Stu", "From 1(LKR)", "Total (LKR)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        details.getTableHeader().setReorderingAllowed(false);
        details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(details);
        details.getColumnModel().getColumn(0).setMinWidth(50);
        details.getColumnModel().getColumn(0).setPreferredWidth(50);
        details.getColumnModel().getColumn(0).setMaxWidth(50);
        details.getColumnModel().getColumn(1).setMinWidth(120);
        details.getColumnModel().getColumn(1).setPreferredWidth(120);
        details.getColumnModel().getColumn(1).setMaxWidth(120);
        details.getColumnModel().getColumn(2).setMinWidth(120);
        details.getColumnModel().getColumn(2).setPreferredWidth(120);
        details.getColumnModel().getColumn(2).setMaxWidth(120);
        details.getColumnModel().getColumn(3).setMinWidth(90);
        details.getColumnModel().getColumn(3).setPreferredWidth(90);
        details.getColumnModel().getColumn(3).setMaxWidth(90);
        details.getColumnModel().getColumn(4).setMinWidth(170);
        details.getColumnModel().getColumn(4).setPreferredWidth(170);
        details.getColumnModel().getColumn(4).setMaxWidth(170);
        details.getColumnModel().getColumn(5).setMinWidth(70);
        details.getColumnModel().getColumn(5).setPreferredWidth(40);
        details.getColumnModel().getColumn(5).setMaxWidth(70);
        details.getColumnModel().getColumn(6).setMinWidth(70);
        details.getColumnModel().getColumn(6).setPreferredWidth(70);
        details.getColumnModel().getColumn(6).setMaxWidth(70);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 900, 180));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Total Advance Taken by Teacher (LKR):");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 320, 320, 25));

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Balance Payment for this Month (LKR):");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 350, 320, 25));

        totalpayment.setFont(new java.awt.Font("Dialog", 1, 14));
        totalpayment.setForeground(new java.awt.Color(255, 51, 51));
        totalpayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalpayment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));
        jPanel4.add(totalpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 114, 27));

        advance.setFont(new java.awt.Font("Dialog", 1, 14));
        advance.setForeground(new java.awt.Color(255, 51, 51));
        advance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        advance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));
        jPanel4.add(advance, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 114, 27));

        balance.setFont(new java.awt.Font("Dialog", 1, 14));
        balance.setForeground(new java.awt.Color(255, 51, 51));
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));
        jPanel4.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 114, 27));

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Balance left will be :");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Last paid month  ");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 100, 30));

        person.setFont(new java.awt.Font("Dialog", 1, 12));
        person.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        person.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(person, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 270, 28));

        lpaynow1.setFont(new java.awt.Font("Dialog", 1, 14));
        lpaynow1.setForeground(new java.awt.Color(255, 51, 51));
        lpaynow1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lpaynow1.setText("Amount to Pay  :");
        jPanel4.add(lpaynow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, -1));

        payamut2.setFont(new java.awt.Font("Dialog", 1, 14));
        payamut2.setForeground(new java.awt.Color(255, 51, 51));
        payamut2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payamut2.setText("0");
        jPanel4.add(payamut2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 118, -1));

        lpaynow.setFont(new java.awt.Font("Dialog", 1, 14));
        lpaynow.setForeground(new java.awt.Color(255, 51, 51));
        lpaynow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpaynow.setText("LKR");
        jPanel4.add(lpaynow, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 30, -1));

        payamut.setFont(new java.awt.Font("Dialog", 1, 14));
        payamut.setForeground(new java.awt.Color(255, 51, 51));
        payamut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payamut.setText("0");
        jPanel4.add(payamut, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 118, -1));

        lpaynow2.setFont(new java.awt.Font("Dialog", 1, 14));
        lpaynow2.setForeground(new java.awt.Color(255, 51, 51));
        lpaynow2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpaynow2.setText("LKR");
        jPanel4.add(lpaynow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 30, -1));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel23.setText("Teacher Name");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel4.add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, -1));
        jPanel4.add(jyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 80, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        tablene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "In.No", "Teacher No", "Name", "Payment", "Date-Time"
            }
        ));
        tablene.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablene);

        advancetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "TotalAdvance", "Advance"
            }
        ));
        jScrollPane3.setViewportView(advancetable);

        jLabel2.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void teachersearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teachersearchKeyReleased
        teacherpayControl.StudentSeach(searchscoral, teachersearch.getText(), searchlist);
        teacherpayControl.settingFocus(evt, searchlist);
    }//GEN-LAST:event_teachersearchKeyReleased

    private void idseacrhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idseacrhKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           
            userid = control.searchByUserid(idseacrh.getText(), idseacrh.getText(), person, payamut2, lastpaidmonth, month, details, payamut, totalpayment, advance, balance, jyear);
            teachersearch.setText(person.getText()+"-"+idseacrh.getText());
        }
    }//GEN-LAST:event_idseacrhKeyReleased

    private void searchlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchlistMouseClicked
        teachersearch.setText(searchlist.getSelectedValue().toString());
        idseacrh.setText(teachersearch.getText().split("-")[1]);
        userid = control.searchByUserid(teachersearch.getText().split("-")[1], idseacrh.getText(), person, payamut2, lastpaidmonth, month, details, payamut, totalpayment, advance, balance,jyear);
        teachersearch.setFocusable(true);
        searchlist.setVisible(false);
        searchscoral.setVisible(false);
}//GEN-LAST:event_searchlistMouseClicked

    private void searchlistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlistKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            teachersearch.setText(searchlist.getSelectedValue().toString());
            idseacrh.setText(teachersearch.getText().split("-")[1]);
            userid = control.searchByUserid(teachersearch.getText().split("-")[1], idseacrh.getText(), person, payamut2, lastpaidmonth, month, details, payamut, totalpayment, advance, balance,jyear);
            searchscoral.setVisible(false);
            System.out.println("what happend nw");
        } else {
            teacherpayControl.list_key_release(evt, teachersearch);
        }
}//GEN-LAST:event_searchlistKeyReleased

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
       if(!idseacrh.getText().trim().isEmpty()){
        if (OccationalLogics.showOption("Yes", "No") == 0) {

            if (control.addDetails(userid, month.getSelectedItem().toString(), payamut.getText(), paidamount.getText(), Mainwindow.UserStaffID, advance, totalpayment, jyear.getValue()+"")) {
                userid = control.searchByUserid(teachersearch.getText().split("-")[1], idseacrh.getText(), person, payamut2, lastpaidmonth, month, details, payamut, totalpayment, advance, balance,jyear);
                control.searchfirst100(tablene);
                JOptionPane.showMessageDialog(null, "successfully added data");
            }else{
                JOptionPane.showMessageDialog(null, "sorry : unexpected error occured");
            }

        }
       }else{
        JOptionPane.showMessageDialog(null, "Please Select a Teacher First", "Payment", JOptionPane.WARNING_MESSAGE);
       }
}//GEN-LAST:event_payActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
       if(userid != null){
        control.searchAlgorythem(userid, month.getSelectedItem().toString(), details, lastpaidmonth, totalpayment, advance, balance, payamut, jyear.getValue()+"");
        }
    }//GEN-LAST:event_monthActionPerformed

    private void paidamountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidamountKeyReleased
        if (!payamut.getText().equals("0") && !paidamount.getText().isEmpty()) {
            double k = -Double.parseDouble(paidamount.getText()) + Double.parseDouble(payamut.getText());
            if (k < 0) {
                paidamount.setText(payamut.getText());
                payamut2.setText("0");
                evt.consume();
            } else {
                payamut2.setText(k + "");
            }

        }
        if(paidamount.getText().isEmpty()){
            payamut2.setText("");
        }
         if (OccationalLogics.isPressEnter(evt)) {
         payActionPerformed(null);
    }
    }//GEN-LAST:event_paidamountKeyReleased

private void paidamountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidamountKeyTyped
OccationalLogics.validateTextDouble(evt);
}//GEN-LAST:event_paidamountKeyTyped

private void detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailsMouseClicked
control.getPaidReport(month,jyear,person,details);
}//GEN-LAST:event_detailsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advance;
    private javax.swing.JTable advancetable;
    private javax.swing.JLabel balance;
    private javax.swing.JTable details;
    private javax.swing.JTextField idseacrh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.components.JSpinField jyear;
    private javax.swing.JLabel lastpaidmonth;
    private javax.swing.JLabel lpaynow;
    private javax.swing.JLabel lpaynow1;
    private javax.swing.JLabel lpaynow2;
    private javax.swing.JComboBox month;
    private javax.swing.JTextField paidamount;
    private javax.swing.JButton pay;
    private javax.swing.JLabel payamut;
    private javax.swing.JLabel payamut2;
    private javax.swing.JLabel person;
    private javax.swing.JList searchlist;
    private javax.swing.JScrollPane searchscoral;
    private javax.swing.JTable tablene;
    private javax.swing.JTextField teachersearch;
    private javax.swing.JLabel totalpayment;
    // End of variables declaration//GEN-END:variables
}
