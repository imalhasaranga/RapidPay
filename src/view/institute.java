/*
 * institute.java
 *
 * Created on May 10, 2011, 1:40 PM
 */
package view;

import Utill.CUtils;
import control.instituteControl;
import javax.swing.JOptionPane;

/**
 *
 * @author  gihan
 */
public final class institute extends javax.swing.JFrame {

    instituteControl cinstitute = new instituteControl();

    void loadinstitute(int i) {
        try {
            cinstitute = cinstitute.getInstitute(i);
            institutename.setText(cinstitute.getInstituteName());
            adno.setText(cinstitute.getAddressno());
            street.setText(cinstitute.getStreet());
            city.setText(cinstitute.getCity());
            con1.setText(cinstitute.getContact1());
            con2.setText(cinstitute.getContact2());
            con3.setText(cinstitute.getContact3());
            email.setText(cinstitute.getWebsite());
            web.setText(cinstitute.getEmail());
            fax.setText(cinstitute.getFax());


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public institute() {
        initComponents();


        loadinstitute(0);

 CUtils.setIconImage(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        adno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        web = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fax = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        con1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        con2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        con3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        street = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        institutename = new javax.swing.JTextField();
        edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Institute Details");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

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

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Fax");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Email");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Web Site");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("City");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Street");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Address No");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Contact Numbers");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Institute Name");

        adno.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel1.setText(" ");

        city.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel3.setText(" ");

        email.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel8.setText(" ");

        web.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel7.setText(" ");

        fax.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel9.setText(" ");

        con1.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel4.setText(" ");

        con2.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel5.setText(" ");

        con3.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel6.setText(" ");

        street.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jLabel2.setText(" ");

        institutename.setFont(new java.awt.Font("Times New Roman", 0, 12));

        edit.setFont(new java.awt.Font("Dialog", 0, 12));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(institutename, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(adno, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(city, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(web, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(con1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(con2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(con3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(street, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(fax, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(institutename, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(adno, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(street, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(city, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(con1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(con2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(con3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(web, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fax, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit)
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
        setBounds((screenSize.width-386)/2, (screenSize.height-441)/2, 386, 441);
    }// </editor-fold>//GEN-END:initComponents

private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
    cinstitute.setInstituteName(institutename.getText());
    cinstitute.setAddressno(adno.getText());
    cinstitute.setStreet(street.getText());
    cinstitute.setCity(city.getText());
    cinstitute.setContact1(con1.getText());
    cinstitute.setContact2(con2.getText());
    cinstitute.setContact3(con3.getText());
    cinstitute.setWebsite(web.getText());
    cinstitute.setEmail(email.getText());
    cinstitute.setFax(fax.getText());
    if (cinstitute.addInstitute(cinstitute)) {
        JOptionPane.showMessageDialog(null, "Institute successfully added");
        loadinstitute(1);

    } else {
        JOptionPane.showMessageDialog(null, "Sorry unexpected Error occured");
    }

}//GEN-LAST:event_editActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adno;
    private javax.swing.JTextField city;
    private javax.swing.JTextField con1;
    private javax.swing.JTextField con2;
    private javax.swing.JTextField con3;
    private javax.swing.JButton edit;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fax;
    private javax.swing.JTextField institutename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField street;
    private javax.swing.JTextField web;
    // End of variables declaration//GEN-END:variables
}
