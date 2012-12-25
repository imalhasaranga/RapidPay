/*
 * feesmgt.java
 *
 * Created on May 10, 2011, 12:13 PM
 */
package view;

import Utill.CUtils;
import Utill.JPOSPrinter;
import control.OccationalLogics;
import control.freemgtControl;
import control.instituteControl;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Imal
 */
public final class feesmgt extends javax.swing.JPanel {

    freemgtControl cont = new freemgtControl();
    instituteControl cont1 = new instituteControl();
    String userid = null;
    private double count;
    
    JPOSPrinter newPrinter = null;

    private void initializePrinter() {
        if (Mainwindow.EnblePrint) {        
                try {
                    newPrinter = new JPOSPrinter(cont1);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Unable To connect with the Printer program will now terminate!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
        }
    }

    public void PrintTop(String StuName, String Stuid) {
        if (Mainwindow.EnblePrint) {
            initializePrinter();
            if (onsearchPrint.isSelected()) {
                newPrinter.setStname(StuName);
                newPrinter.setStudid(Stuid);
                newPrinter.setTopPrint(false);
                newPrinter.printTopPart();

            }
        }
    }

    public feesmgt() {
        initComponents();
        searchscoral.setVisible(false);
        load();
        try {
            cont1 = cont1.getInstitute(0);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void load() {
        cont.loadlast100rec(tblinvoice);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblinvoice = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblclass = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();
        luptodatepay = new javax.swing.JLabel();
        lbalancefor = new javax.swing.JLabel();
        cmbmonth = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        searchscoral = new javax.swing.JScrollPane();
        searchlist = new javax.swing.JList();
        tsid = new javax.swing.JTextField();
        lpaynow = new javax.swing.JLabel();
        tpaid = new javax.swing.JTextField();
        lbalance = new javax.swing.JLabel();
        bpay = new javax.swing.JButton();
        balnce = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lsname = new javax.swing.JLabel();
        ssearch = new javax.swing.JTextField();
        studentnam = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lpaynow1 = new javax.swing.JLabel();
        payamut = new javax.swing.JLabel();
        delunwanted = new javax.swing.JButton();
        onsearchPrint = new javax.swing.JCheckBox();
        ll = new javax.swing.JLabel();
        lastpaidmonth = new javax.swing.JTextField();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        monthval = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(180, 214, 236));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Payment Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel23.setText("Student Name");

        jTextField11.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel17.setText("Paid Amount");

        jTextField12.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jTextField14.setFont(new java.awt.Font("Times New Roman", 1, 14));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Student Should Pay LKR");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Balance Amount: LKR");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel26.setText("LKR");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12));
        jButton2.setText("Pay");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel17))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(153, 180, 209));

        tblinvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "In.No", "class_id", "Student No", "Name", "Payment", "Date-Time"
            }
        ));
        jScrollPane1.setViewportView(tblinvoice);
        tblinvoice.getColumnModel().getColumn(0).setMaxWidth(300);
        tblinvoice.getColumnModel().getColumn(1).setMaxWidth(300);

        jPanel4.setBackground(new java.awt.Color(191, 205, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Student's Total Payment for the Month (LKR):");

        tblclass.setFont(new java.awt.Font("Dialog", 1, 12));
        tblclass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClsID", "Day", "Subject", "Teacher", "Time", "Fees", "Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblclass.setNextFocusableComponent(tpaid);
        tblclass.getTableHeader().setReorderingAllowed(false);
        tblclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclassMouseClicked(evt);
            }
        });
        tblclass.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblclassComponentAdded(evt);
            }
        });
        tblclass.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                tblclassHierarchyChanged(evt);
            }
        });
        tblclass.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblclassPropertyChange(evt);
            }
        });
        tblclass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblclassKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblclass);
        tblclass.getColumnModel().getColumn(0).setMinWidth(40);
        tblclass.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblclass.getColumnModel().getColumn(0).setMaxWidth(40);
        tblclass.getColumnModel().getColumn(1).setMinWidth(70);
        tblclass.getColumnModel().getColumn(1).setPreferredWidth(70);
        tblclass.getColumnModel().getColumn(1).setMaxWidth(80);
        tblclass.getColumnModel().getColumn(2).setMinWidth(80);
        tblclass.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblclass.getColumnModel().getColumn(2).setMaxWidth(80);
        tblclass.getColumnModel().getColumn(4).setMinWidth(130);
        tblclass.getColumnModel().getColumn(4).setPreferredWidth(130);
        tblclass.getColumnModel().getColumn(4).setMaxWidth(130);
        tblclass.getColumnModel().getColumn(5).setMinWidth(50);
        tblclass.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblclass.getColumnModel().getColumn(5).setMaxWidth(50);
        tblclass.getColumnModel().getColumn(6).setMinWidth(50);
        tblclass.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblclass.getColumnModel().getColumn(6).setMaxWidth(50);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Student's Up-To-Date Payment on the Month (LKR):");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 13));
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Balance Payment for the Month (LKR):");

        ltotal.setFont(new java.awt.Font("Dialog", 1, 14));
        ltotal.setForeground(new java.awt.Color(255, 51, 51));
        ltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));

        luptodatepay.setFont(new java.awt.Font("Dialog", 1, 14));
        luptodatepay.setForeground(new java.awt.Color(255, 51, 51));
        luptodatepay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luptodatepay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));

        lbalancefor.setFont(new java.awt.Font("Dialog", 1, 14));
        lbalancefor.setForeground(new java.awt.Color(255, 51, 51));
        lbalancefor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbalancefor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true));

        cmbmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current Status", "Next Month", "+ Month" }));
        cmbmonth.setNextFocusableComponent(tblclass);
        cmbmonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbmonthMouseClicked(evt);
            }
        });
        cmbmonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbmonthItemStateChanged(evt);
            }
        });
        cmbmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmonthActionPerformed(evt);
            }
        });
        cmbmonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbmonthKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Month Paying ");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("close_button_border_focus"));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)), "Search/pay", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchscoral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchscoralKeyReleased(evt);
            }
        });

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

        jPanel1.add(searchscoral, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 240, 10));

        tsid.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tsid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tsid.setNextFocusableComponent(cmbmonth);
        tsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsidActionPerformed(evt);
            }
        });
        tsid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tsidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tsidKeyTyped(evt);
            }
        });
        jPanel1.add(tsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 79, 26));

        lpaynow.setFont(new java.awt.Font("Dialog", 1, 14));
        lpaynow.setForeground(new java.awt.Color(255, 51, 51));
        lpaynow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lpaynow.setText("LKR");
        jPanel1.add(lpaynow, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 30, -1));

        tpaid.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tpaid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tpaid.setNextFocusableComponent(ssearch);
        tpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpaidActionPerformed(evt);
            }
        });
        tpaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpaidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tpaidKeyTyped(evt);
            }
        });
        jPanel1.add(tpaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 90, -1));

        lbalance.setFont(new java.awt.Font("Dialog", 1, 12));
        lbalance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbalance.setText("Balance Amount :");
        jPanel1.add(lbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));

        bpay.setFont(new java.awt.Font("Dialog", 1, 12));
        bpay.setText("Pay");
        bpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpayActionPerformed(evt);
            }
        });
        jPanel1.add(bpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 120, -1));

        balnce.setFont(new java.awt.Font("Dialog", 1, 12));
        balnce.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balnce.setText("0");
        jPanel1.add(balnce, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, 20));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Paid Amount :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 20));

        lsname.setFont(new java.awt.Font("Dialog", 1, 12));
        lsname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lsname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lsname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        ssearch.setFont(new java.awt.Font("Times New Roman", 1, 12));
        ssearch.setNextFocusableComponent(tsid);
        ssearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ssearchKeyReleased(evt);
            }
        });
        jPanel1.add(ssearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 26));

        studentnam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentnam.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(studentnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 330, 30));

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel29.setText("LKR");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 30, 20));

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 12));
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, 20));

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel31.setText("LKR");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 30, 20));

        lpaynow1.setFont(new java.awt.Font("Dialog", 1, 14));
        lpaynow1.setForeground(new java.awt.Color(255, 51, 51));
        lpaynow1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lpaynow1.setText("Amount to Pay :");
        jPanel1.add(lpaynow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        payamut.setFont(new java.awt.Font("Dialog", 1, 14));
        payamut.setForeground(new java.awt.Color(255, 51, 51));
        payamut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payamut.setText("0");
        jPanel1.add(payamut, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 90, -1));

        delunwanted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1315720561_delete.png"))); // NOI18N
        delunwanted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delunwantedActionPerformed(evt);
            }
        });
        jPanel1.add(delunwanted, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 30, -1));

        onsearchPrint.setSelected(true);
        onsearchPrint.setText("OnSearch Print");
        onsearchPrint.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        onsearchPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onsearchPrintActionPerformed(evt);
            }
        });
        jPanel1.add(onsearchPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        ll.setFont(new java.awt.Font("Tahoma", 1, 12));
        ll.setText("Last Paied month :");

        lastpaidmonth.setEditable(false);
        lastpaidmonth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastpaidmonth.setText("0");
        lastpaidmonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpropchange(evt);
            }
        });

        jYearChooser1.setEnabled(false);

        monthval.setFont(new java.awt.Font("Tahoma", 1, 11));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lastpaidmonth, org.jdesktop.beansbinding.ELProperty.create("${text}"), monthval, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        monthval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthvalMouseClicked(evt);
            }
        });
        monthval.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthvalPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ll, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastpaidmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthval, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cmbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbalancefor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(luptodatepay, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cmbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ll)
                                .addComponent(lastpaidmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthval, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(luptodatepay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbalancefor, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jYearChooser1, lastpaidmonth, ll, monthval});

        jLabel2.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

private void tpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpaidActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tpaidActionPerformed

private void ssearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ssearchKeyReleased
    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE || ssearch.getText().length() == 0) {
        freemgtControl.StudentSeach(searchscoral, ssearch.getText(), searchlist);
        freemgtControl.settingFocus(evt, searchlist);
    }
}//GEN-LAST:event_ssearchKeyReleased

private void searchlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchlistMouseClicked
    count = 0;
    ssearch.setText(searchlist.getSelectedValue().toString());
    tsid.setText(ssearch.getText().split("-")[1]);
    userid = cont.searchByUserid(ssearch.getText().split("-")[1], studentnam, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);
    ssearch.setFocusable(true);
    searchlist.setVisible(false);
    searchscoral.setVisible(false);
    PrintTop(studentnam.getText(), userid);
}//GEN-LAST:event_searchlistMouseClicked

private void searchlistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlistKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        count = 0;
        ssearch.setText(searchlist.getSelectedValue().toString());
        tsid.setText(ssearch.getText().split("-")[1]);
        userid = cont.searchByUserid(ssearch.getText().split("-")[1], studentnam, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);
        searchscoral.setVisible(false);
        PrintTop(studentnam.getText(), userid);
    } else {
        freemgtControl.list_key_release(evt, ssearch);
    }
}//GEN-LAST:event_searchlistKeyReleased

private void tsidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsidKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        count = 0;
        userid = cont.searchByUserid(tsid.getText(), studentnam, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);
        ssearch.setText(studentnam.getText() + "-" + tsid.getText());
        PrintTop(studentnam.getText(), userid);
    }
}//GEN-LAST:event_tsidKeyReleased

private void tblclassComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblclassComponentAdded
}//GEN-LAST:event_tblclassComponentAdded

private void tblclassPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblclassPropertyChange
}//GEN-LAST:event_tblclassPropertyChange

private void tblclassHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_tblclassHierarchyChanged
}//GEN-LAST:event_tblclassHierarchyChanged

private void tpaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaidKeyReleased
    if (!payamut.getText().equals("0") && !tpaid.getText().isEmpty()) {
        double k = Double.parseDouble(tpaid.getText()) - Double.parseDouble(payamut.getText());
        balnce.setText(k + "");
    } else if (tpaid.getText().isEmpty()) {
        balnce.setText("");
    }
    if (OccationalLogics.isPressEnter(evt)) {
        bpayActionPerformed(null);
    }
}//GEN-LAST:event_tpaidKeyReleased

private void bpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpayActionPerformed
    if (!studentnam.getText().trim().isEmpty()) {
        if (OccationalLogics.CheckValue(tpaid.getText(), payamut.getText())) {
            if (OccationalLogics.showOption("yes", "no") == 0) {

                if (cont.addDetailsToDB(userid, tblclass, cmbmonth, lastpaidmonth)) {
                    userid = cont.searchByUserid(userid, studentnam, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);
                    cont.calculateInsandLecFee(userid);

                    if (Mainwindow.EnblePrint) {
                        initializePrinter();
                        newPrinter.setStname(studentnam.getText());
                        newPrinter.setStudid(userid);
                        newPrinter.setInvoiceid(cont.getInvoiceid());
                        newPrinter.setMonth(lastpaidmonth.getText());
                        newPrinter.setStfnam(Mainwindow.usrname);
                        newPrinter.setRegfe(ltotal.getText());
                        newPrinter.setPaid(cont.Institutefee1 + "");
                        newPrinter.setLectureFee(cont.LectureFee1 + "");
                        newPrinter.setBalnce(lbalancefor.getText());
                        newPrinter.setBlance1(balnce.getText());
                        newPrinter.setCash(Double.parseDouble(tpaid.getText()) + "");
                        newPrinter.StartPrinting();
                    }

                    JOptionPane.showMessageDialog(null, "Payment successfully added", "Payment", JOptionPane.INFORMATION_MESSAGE);

                    count = 0;
                    lastpaidmonth.setEditable(false);
                    lastpaidmonth.setBackground(Color.white);
                    payamut.setText(count + "");
                    cont.loadlast100rec(tblinvoice);
                    ssearch.setText("");
                    tsid.setText("");
                    tpaid.setText("");
                    balnce.setText("");
                    ssearch.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Unexpected error occured", "Payment", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please Select a Student First", "Payment", JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_bpayActionPerformed

private void tblclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclassMouseClicked


    if (tblclass.getValueAt(tblclass.getSelectedRow(), 6).toString().equals("No")) {
        tblclass.setValueAt("paydN", tblclass.getSelectedRow(), 6);
        count = count + Double.parseDouble(tblclass.getValueAt(tblclass.getSelectedRow(), 5).toString());
    } else if (tblclass.getValueAt(tblclass.getSelectedRow(), 6).toString().equals("paydN")) {
        count = count - Double.parseDouble(tblclass.getValueAt(tblclass.getSelectedRow(), 5).toString());
        tblclass.setValueAt("No", tblclass.getSelectedRow(), 6);
    }
    payamut.setText(count + "");
}//GEN-LAST:event_tblclassMouseClicked

private void cmbmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmonthActionPerformed

    if ((!studentnam.getText().isEmpty()) && userid != null) {


        cont.combosearch(userid, payamut, cmbmonth, tblclass, ltotal, luptodatepay, lbalancefor, lastpaidmonth);

    }

    if (cmbmonth.getSelectedIndex() == 0) {
        ll.setText("Last Paied month :");
    } else {
        ll.setText("Paying month :");
    }
    if (cmbmonth.getSelectedIndex() == 2) {
        cmbmonth.setSelectedIndex(1);
        cmbmonthActionPerformed(null);
    }


}//GEN-LAST:event_cmbmonthActionPerformed

private void searchscoralKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchscoralKeyReleased
    // TODO add your handling code here:
}//GEN-LAST:event_searchscoralKeyReleased

private void tpaidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaidKeyTyped
OccationalLogics.validateTextDouble(evt);//GEN-LAST:event_tpaidKeyTyped
    }

private void cmbmonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbmonthMouseClicked
}//GEN-LAST:event_cmbmonthMouseClicked

private void cmbmonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbmonthItemStateChanged
}//GEN-LAST:event_cmbmonthItemStateChanged

private void tsidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsidKeyTyped
    OccationalLogics.validateTextDouble(evt);
}//GEN-LAST:event_tsidKeyTyped

private void delunwantedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delunwantedActionPerformed
    delpay pay = new delpay();
    pay.setMgt(this);
    pay.setVisible(true);
}//GEN-LAST:event_delunwantedActionPerformed

private void monthvalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthvalMouseClicked
}//GEN-LAST:event_monthvalMouseClicked

private void jpropchange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpropchange
    /// System.out.println(lastpaidmonth.getText());
    //  
}//GEN-LAST:event_jpropchange

private void monthvalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthvalPropertyChange
    
    monthval.setText(OccationalLogics.getMonth(Integer.parseInt(lastpaidmonth.getText())));
}//GEN-LAST:event_monthvalPropertyChange

private void cmbmonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbmonthKeyPressed

    if (evt.getKeyCode() == 39) {
        cmbmonth.setSelectedIndex(2);
        //cmbmonthActionPerformed(null);
    } else if (evt.getKeyCode() == 37) {
        System.out.println(evt.getKeyCode());
        cmbmonth.setSelectedIndex(0);

    }
}//GEN-LAST:event_cmbmonthKeyPressed

private void tblclassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblclassKeyPressed
    String i = evt.getKeyChar() + "";
    if (evt.getKeyCode() == 96 && tblclass.getRowCount() > 0) {
        tblclassMouseClicked(null);
    } else if (evt.getKeyCode() == 9) {
        tpaid.grabFocus();
    } else if (CUtils.isInteger(i) && !i.equals("0")) {
        int y = Integer.parseInt(i);
        if (tblclass.getRowCount() >= y) {
            tblclass.setRowSelectionInterval(y - 1, y - 1);
            tblclassMouseClicked(null);
        }
    }
}//GEN-LAST:event_tblclassKeyPressed

private void tsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsidActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tsidActionPerformed

private void onsearchPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onsearchPrintActionPerformed
    initializePrinter();
    if (Mainwindow.EnblePrint) {
    newPrinter.setTopPrint(onsearchPrint.isSelected());
    }
}//GEN-LAST:event_onsearchPrintActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balnce;
    private javax.swing.JButton bpay;
    private javax.swing.JComboBox cmbmonth;
    private javax.swing.JButton delunwanted;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JTextField lastpaidmonth;
    private javax.swing.JLabel lbalance;
    private javax.swing.JLabel lbalancefor;
    private javax.swing.JLabel ll;
    private javax.swing.JLabel lpaynow;
    private javax.swing.JLabel lpaynow1;
    private javax.swing.JLabel lsname;
    private javax.swing.JLabel ltotal;
    private javax.swing.JLabel luptodatepay;
    private javax.swing.JLabel monthval;
    private javax.swing.JCheckBox onsearchPrint;
    private javax.swing.JLabel payamut;
    private javax.swing.JList searchlist;
    private javax.swing.JScrollPane searchscoral;
    public javax.swing.JTextField ssearch;
    private javax.swing.JLabel studentnam;
    private javax.swing.JTable tblclass;
    private javax.swing.JTable tblinvoice;
    private javax.swing.JTextField tpaid;
    private javax.swing.JTextField tsid;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
