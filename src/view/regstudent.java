/*
 * regstudent.java
 *
 * Created on May 10, 2011, 12:40 PM
 */
package view;

import Utill.PrintRegBill;
import control.OccationalLogics;
import control.instituteControl;
import control.regStudentControl;

import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author  gihan
 */
public final class regstudent extends javax.swing.JPanel {

    /** Creates new form regstudent */
    OccationalLogics logics = new OccationalLogics();
    regStudentControl newstudent = new regStudentControl();
    String gardian = "Father";
    JTextComponent comp[] = new JTextComponent[13];
    Map<String, Object> params = new HashMap<String, Object>();
    instituteControl cont = new instituteControl();
    String uid;

    public regstudent() {
        initComponents();
        ltotalfee12.setVisible(false);
        dob.setDate(new Date());
        logics.LoadComboGrade(cmbgrade);
        logics.loadCobobos(cmbteacher, cmbclassgrade, cmbsubject);
        comp[12] = tfname;
        comp[11] = tmname;
        comp[0] = tlname;
        comp[1] = taddno;
        comp[2] = tstreet;
        comp[3] = tcity;
        comp[4] = tcontact;
        comp[5] = tschool;
        comp[6] = tguardname;
        comp[7] = tguardaddress;
        comp[8] = tworkaddress;
        comp[9] = tworkcontact;
        comp[10] = tpaid;
        try {
            cont = cont.getInstitute(0);
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
    
    
   PrintRegBill newPrinter =null;
   public void initializePrinter(){
     
        if(newPrinter == null){
             
            try{
             newPrinter = new PrintRegBill(cont);
            }catch(Exception e){
            
                JOptionPane.showMessageDialog(null, "Unable To connect with the Printer program will now terminate!!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tschool = new javax.swing.JTextField();
        cmbgrade = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tguardname = new javax.swing.JTextField();
        tguardaddress = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tguardcontact = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tworkcontact = new javax.swing.JTextField();
        tworkaddress = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        radiofather = new javax.swing.JRadioButton();
        radiomother = new javax.swing.JRadioButton();
        radioguard = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblclass1 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        bregister = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblclass2 = new javax.swing.JTable();
        tpaid = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lbalance = new javax.swing.JLabel();
        ltotalfee12 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        ltotalfee = new javax.swing.JLabel();
        jcheck = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cmbclassgrade = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        cmbsubject = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cmbteacher = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setBackground(new java.awt.Color(153, 180, 209));
        setMaximumSize(new java.awt.Dimension(1300, 600));

        jPanel1.setBackground(new java.awt.Color(191, 205, 219));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Main Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel2.setText("First Name *");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel3.setText("Middle Name");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel4.setText("Last Name");

        tfname.setFont(new java.awt.Font("Times New Roman", 1, 14));

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
        tcontact.setNextFocusableComponent(tschool);

        dob.setFont(new java.awt.Font("Tahoma", 0, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfname, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tlname, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(tmname, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addGap(31, 31, 31))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                        .addGap(45, 45, 45)))
                                .addGap(23, 23, 23))
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(tcity, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(taddno, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addGap(91, 91, 91))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tstreet, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addGap(8, 8, 8))
                            .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfname, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tmname, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tlname, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(taddno, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tstreet, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                    .addComponent(tcity, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tcontact)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(191, 205, 219));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "School Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel13.setText("School");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel14.setText("Study Grade");

        tschool.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tschool.setNextFocusableComponent(cmbgrade);

        cmbgrade.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbgrade.setNextFocusableComponent(radiofather);
        cmbgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbgradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tschool, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tschool, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(cmbgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbgrade, jLabel13, jLabel14, tschool});

        jPanel3.setBackground(new java.awt.Color(191, 205, 219));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Parents/Guardian Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel15.setText("Name");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel16.setText("Address");

        tguardname.setFont(new java.awt.Font("Times New Roman", 1, 14));

        tguardaddress.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel17.setText("Contact No");

        tguardcontact.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Work Place Details");

        tworkcontact.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tworkcontact.setNextFocusableComponent(cmbclassgrade);

        tworkaddress.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel19.setText("Address");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel20.setText("Contact No");

        buttonGroup1.add(radiofather);
        radiofather.setFont(new java.awt.Font("Dialog", 1, 12));
        radiofather.setSelected(true);
        radiofather.setText("Father");
        radiofather.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiofatherActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiomother);
        radiomother.setFont(new java.awt.Font("Dialog", 1, 12));
        radiomother.setText("Mother");
        radiomother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiomotherActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioguard);
        radioguard.setFont(new java.awt.Font("Dialog", 1, 12));
        radioguard.setText("Guardian");
        radioguard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioguardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(radiofather, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radiomother, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioguard, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                    .addComponent(tguardname, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                                .addGap(13, 13, 13)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tguardaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tguardcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addGap(163, 163, 163))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(151, 151, 151))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tworkaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tworkcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(162, 162, 162))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiomother, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radiofather, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioguard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(tguardname, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(tguardaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(tguardcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tworkaddress)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(tworkcontact, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        jPanel4.setBackground(new java.awt.Color(191, 205, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Subjects/classes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tblclass1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "class-id", "Day", "Start-Time", "End-Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        tblclass1.getTableHeader().setReorderingAllowed(false);
        tblclass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclass1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblclass1);
        tblclass1.getColumnModel().getColumn(0).setMinWidth(60);
        tblclass1.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblclass1.getColumnModel().getColumn(0).setMaxWidth(40);
        tblclass1.getColumnModel().getColumn(2).setMinWidth(80);
        tblclass1.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblclass1.getColumnModel().getColumn(2).setMaxWidth(80);
        tblclass1.getColumnModel().getColumn(3).setMinWidth(80);
        tblclass1.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblclass1.getColumnModel().getColumn(3).setMaxWidth(80);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel22.setText("Fee");

        bregister.setFont(new java.awt.Font("Dialog", 1, 12));
        bregister.setText("Register");
        bregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bregisterMouseEntered(evt);
            }
        });
        bregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregisterActionPerformed(evt);
            }
        });

        tblclass2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "class-id", "Subject", "Day", "Ad.Fees", "Mnt.Fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblclass2.getTableHeader().setReorderingAllowed(false);
        tblclass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclass2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblclass2);
        tblclass2.getColumnModel().getColumn(0).setMinWidth(60);
        tblclass2.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblclass2.getColumnModel().getColumn(0).setMaxWidth(40);
        tblclass2.getColumnModel().getColumn(1).setMinWidth(90);
        tblclass2.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblclass2.getColumnModel().getColumn(1).setMaxWidth(90);
        tblclass2.getColumnModel().getColumn(3).setMinWidth(80);
        tblclass2.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblclass2.getColumnModel().getColumn(3).setMaxWidth(80);

        tpaid.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tpaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tpaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tpaidKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel23.setText("Paid (LKR)");

        lbalance.setFont(new java.awt.Font("Dialog", 1, 12));
        lbalance.setText("Balance: LKR");

        ltotalfee12.setFont(new java.awt.Font("Dialog", 1, 12));
        ltotalfee12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltotalfee12.setText("0.0");

        balance.setFont(new java.awt.Font("Dialog", 1, 12));
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ltotalfee.setFont(new java.awt.Font("Dialog", 1, 12));
        ltotalfee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltotalfee.setText("0.0");
        ltotalfee.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcheck.setFont(new java.awt.Font("Tahoma", 1, 12));
        jcheck.setSelected(true);
        jcheck.setText("New Student");
        jcheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jcheck.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckActionPerformed(evt);
            }
        });

        jLabel1.setText("                                 ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                            .addGap(11, 11, 11))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(ltotalfee12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addComponent(lbalance, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(balance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(ltotalfee, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(tpaid, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                    .addGap(125, 125, 125))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jcheck, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                    .addGap(1, 1, 1)))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(bregister, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ltotalfee12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ltotalfee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpaid, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bregister, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel5.setBackground(new java.awt.Color(191, 205, 219));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Class Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        cmbclassgrade.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbclassgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbclassgradeActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel24.setText("Grade");

        cmbsubject.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsubjectActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel25.setText("Subject");

        cmbteacher.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbteacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbteacherActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel26.setText("Teacher");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbclassgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbsubject, 0, 222, Short.MAX_VALUE)
                    .addComponent(cmbteacher, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbclassgrade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(cmbsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(cmbteacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbclassgrade, cmbsubject, cmbteacher});

        jLabel9.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void radiomotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiomotherActionPerformed
    gardian = "Mother";
}//GEN-LAST:event_radiomotherActionPerformed

private void radioguardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioguardActionPerformed
    gardian = "Guardian";
}//GEN-LAST:event_radioguardActionPerformed

private void cmbclassgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbclassgradeActionPerformed
   logics.LoadComboSubject(cmbsubject, cmbclassgrade);
    cmbteacherActionPerformed(null);
}//GEN-LAST:event_cmbclassgradeActionPerformed

private void cmbteacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbteacherActionPerformed
    newstudent.getThisTeachersClasses(logics.getGradeId(cmbclassgrade.getSelectedIndex()), logics.getSubjectsId(cmbsubject.getSelectedIndex()), logics.getTeachersid(cmbteacher.getSelectedIndex()), tblclass1);
}//GEN-LAST:event_cmbteacherActionPerformed

private void tblclass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclass1MouseClicked
    newstudent.addClass(Integer.parseInt(tblclass1.getValueAt(tblclass1.getSelectedRow(), 0).toString()), tblclass2, ltotalfee);
}//GEN-LAST:event_tblclass1MouseClicked

private void tblclass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclass2MouseClicked
    newstudent.removeRow(tblclass2, ltotalfee);
}//GEN-LAST:event_tblclass2MouseClicked

private void bregisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bregisterMouseEntered
}//GEN-LAST:event_bregisterMouseEntered

private void bregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregisterActionPerformed
    if (OccationalLogics.CheckValue(tpaid.getText(), ltotalfee.getText())) {
        if (OccationalLogics.showOption("Yes", "No") == 0) {
            
            
            
            newstudent.setFName(tfname.getText());
            newstudent.setMname(tmname.getText());
            newstudent.setLname(tlname.getText());
            newstudent.setAddressNo(taddno.getText());
            newstudent.setStreet(tstreet.getText());
            newstudent.setCity(tcity.getText());
            newstudent.setDob(dob.getDate());
            newstudent.setContactNum(tcontact.getText());
            newstudent.setSchool(tschool.getText());
            newstudent.setStudyGrade("" + logics.getGradeId(cmbgrade.getSelectedIndex()));
            newstudent.setGardien(gardian);
            newstudent.setGName(tguardname.getText());
            newstudent.setGAddress(tguardaddress.getText());
            newstudent.setGcontact(tguardcontact.getText());
            newstudent.setGWAddress(tworkaddress.getText());
            newstudent.setGWcontact(tworkcontact.getText());
            newstudent.setStaffreg(Mainwindow.UserStaffID);
            if (newstudent.regStudent(newstudent, tblclass2, jcheck)) {
                try {
                    uid = newstudent.getStudID();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Registration Success", "Student Registration", JOptionPane.INFORMATION_MESSAGE);
                if (jcheck.isSelected()) {

//                    params.put("invoiceid", newstudent.getInvoiceid());
//                    params.put("studid", uid);
//                    params.put("stname", tfname.getText() + " " + tmname.getText() + " " + tlname.getText());
//                    params.put("stfnam", Mainwindow.usrname);
//                    params.put("Regfe", ltotalfee.getText());
//                    params.put("paid", Double.parseDouble(tpaid.getText()) + "");
//                    params.put("balnce", (Double.parseDouble(tpaid.getText()) - Double.parseDouble(ltotalfee.getText())) + "");
//                    params.put("Grade1", cmbgrade.getSelectedItem().toString());
//                    OccationalLogics.JReport(null, null, 0, params, "studentinvoice2.jrxml", 2, cont);
                    
                    newPrinter.setInvoiceid(newstudent.getInvoiceid());
                    newPrinter.setStudid(uid);
                    newPrinter.setStname(tfname.getText() + " " + tmname.getText() + " " + tlname.getText());
                    newPrinter.setStfnam(Mainwindow.usrname);
                    
                    newPrinter.setRegfe(ltotalfee.getText());
                    newPrinter.setPaid(Double.parseDouble(tpaid.getText()) + "");
                    newPrinter.setBalnce((Double.parseDouble(tpaid.getText()) - Double.parseDouble(ltotalfee.getText())) + "");
                    newPrinter.setGrade(cmbgrade.getSelectedItem().toString());
                    newPrinter.StartPrinting();
                    
                    

                }
                OccationalLogics.clearTextFields(comp);
                ((DefaultTableModel) tblclass2.getModel()).setRowCount(0);
                ((DefaultTableModel) tblclass1.getModel()).setRowCount(0);

            } else {
                JOptionPane.showMessageDialog(null, "Sorry, unexpected Error occured", "Student Registration", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}//GEN-LAST:event_bregisterActionPerformed

private void radiofatherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiofatherActionPerformed
    gardian = "Father";
}//GEN-LAST:event_radiofatherActionPerformed

private void tpaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaidKeyTyped
OccationalLogics.validateTextDouble(evt);//GEN-LAST:event_tpaidKeyTyped
    }

private void tpaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaidKeyReleased
    if (!tpaid.getText().isEmpty()) {
        System.out.println(Double.parseDouble(tpaid.getText()));
        System.out.println(Double.parseDouble(ltotalfee.getText()));
        balance.setText("" + (Double.parseDouble(tpaid.getText()) - Double.parseDouble(ltotalfee.getText())));

    }
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        bregisterActionPerformed(null);
    }
}//GEN-LAST:event_tpaidKeyReleased

private void cmbsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsubjectActionPerformed
    logics.LoadComboTeachers(cmbteacher, cmbclassgrade, cmbsubject);
    cmbteacherActionPerformed(null);
}//GEN-LAST:event_cmbsubjectActionPerformed

private void jcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckActionPerformed
//jcheck.setText(jcheck.isSelected() ?  "New Student " : "Old Student");
}//GEN-LAST:event_jcheckActionPerformed

private void cmbgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbgradeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cmbgradeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balance;
    private javax.swing.JButton bregister;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbclassgrade;
    private javax.swing.JComboBox cmbgrade;
    private javax.swing.JComboBox cmbsubject;
    private javax.swing.JComboBox cmbteacher;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JCheckBox jcheck;
    private javax.swing.JLabel lbalance;
    private javax.swing.JLabel ltotalfee;
    private javax.swing.JLabel ltotalfee12;
    private javax.swing.JRadioButton radiofather;
    private javax.swing.JRadioButton radioguard;
    private javax.swing.JRadioButton radiomother;
    private javax.swing.JTextField taddno;
    private javax.swing.JTable tblclass1;
    private javax.swing.JTable tblclass2;
    private javax.swing.JTextField tcity;
    private javax.swing.JTextField tcontact;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tguardaddress;
    private javax.swing.JTextField tguardcontact;
    private javax.swing.JTextField tguardname;
    private javax.swing.JTextField tlname;
    private javax.swing.JTextField tmname;
    private javax.swing.JTextField tpaid;
    private javax.swing.JTextField tschool;
    private javax.swing.JTextField tstreet;
    private javax.swing.JTextField tworkaddress;
    private javax.swing.JTextField tworkcontact;
    // End of variables declaration//GEN-END:variables
}
