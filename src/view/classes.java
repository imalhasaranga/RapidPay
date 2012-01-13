/*
 * classes.java
 *
 * Created on May 10, 2011, 1:33 PM
 */
package view;

import control.OccationalLogics;
import control.classControl;
import control.usermanageControl;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author  gihan
 */
public final class classes extends javax.swing.JPanel {

    
    classControl contrlo = new classControl();

    public classes() {
        initComponents();
      contrlo.LoadComboGrade(cmbgrade);
     contrlo.LoadComboSubject(cmbsubject);
    contrlo.LoadComboTeachers(cmbteacher);
        contrlo.loadTable(tblclass);
        tadmission.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cmbtpercent = new javax.swing.JComboBox();
        tadmission = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        tmonthly = new javax.swing.JTextField();
        bcreate = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        linspercentage = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        deleteclass = new javax.swing.JButton();
        startdate = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cmbgrade = new javax.swing.JComboBox();
        cmbsubject = new javax.swing.JComboBox();
        cmbshour = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmbteacher = new javax.swing.JComboBox();
        lteacherno = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmbday = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        cmbsminute = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        cmbehour = new javax.swing.JComboBox();
        cmbeminute = new javax.swing.JComboBox();
        lbl = new javax.swing.JLabel();
        cmbsampm = new javax.swing.JComboBox();
        cmbeampm = new javax.swing.JComboBox();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblclass = new javax.swing.JTable(new javax.swing.table.DefaultTableModel()) {

            @Override
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                repaint();
            }

            @Override
            public Component prepareRenderer(TableCellRenderer renderer,
                int rowIndex, int vColIndex) {
                Component c = super.prepareRenderer(renderer, rowIndex,	vColIndex);
                if(tblclass.getRowCount() > 0){
                    try {
                        java.text.DateFormat d = new java.text.SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date a = d.parse(tblclass.getValueAt(rowIndex, 7).toString());
                        java.util.Date b = new java.util.Date();
                        int k = (int)Math.round((b.getTime() - a.getTime())/(1000*3600*24));

                        if(k < 24){
                            c.setBackground(java.awt.Color.LIGHT_GRAY);
                            c.setForeground(Color.black);
                        }else{
                            c.setBackground(getBackground());
                            c.setForeground(Color.black);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                return c;
            }
        };
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 180, 209));

        jPanel5.setBackground(new java.awt.Color(191, 205, 219));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Fees Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel31.setText("<html>Teacher Percentage<font color=\"Red\">*</font> </html>");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel32.setText("Institute Percentage");

        cmbtpercent.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbtpercent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90" }));
        cmbtpercent.setSelectedItem("60");
        cmbtpercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtpercentActionPerformed(evt);
            }
        });
        cmbtpercent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbtpercentFocusGained(evt);
            }
        });

        tadmission.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tadmission.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tadmission.setText("575");
        tadmission.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tadmissionKeyTyped(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel34.setText("<html>\nMonthly Fees<font color=\"Red\">*</font> \n</html>");

        tmonthly.setFont(new java.awt.Font("Times New Roman", 1, 14));
        tmonthly.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tmonthly.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tmonthlyKeyTyped(evt);
            }
        });

        bcreate.setFont(new java.awt.Font("Dialog", 1, 12));
        bcreate.setText("Create");
        bcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcreateActionPerformed(evt);
            }
        });

        bedit.setFont(new java.awt.Font("Dialog", 1, 12));
        bedit.setText("Edit");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        linspercentage.setFont(new java.awt.Font("Dialog", 1, 12));
        linspercentage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linspercentage.setText("40");

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel35.setText("<html>Starting/Started Date <font color=\"Red\"></font>  </html>");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setText("DeActivate");
        jButton1.setToolTipText("<html>\n<b>DeActivate</b><br/>\nBy clicking this button after selecting a class from the table<br/>\nYou can Remove that class from the class table, so that class will not be<br/>\nuse again\n\n</html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deleteclass.setFont(new java.awt.Font("Tahoma", 1, 11));
        deleteclass.setText("Delete New Class");
        deleteclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteclassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbtpercent, 0, 126, Short.MAX_VALUE)
                                    .addComponent(tmonthly, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(linspercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tadmission, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteclass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bcreate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bcreate, bedit});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(linspercentage, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtpercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tadmission, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmonthly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteclass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bedit)
                    .addComponent(bcreate))
                .addGap(23, 23, 23))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bcreate, bedit, deleteclass, jButton1});

        jPanel4.setBackground(new java.awt.Color(191, 205, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Fees Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel21.setText("<html> Select the Grade <font color=\"Red\">*</font> </html>");

        cmbgrade.setFont(new java.awt.Font("Dialog", 1, 12));

        cmbsubject.setFont(new java.awt.Font("Dialog", 1, 12));

        cmbshour.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbshour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel22.setText("<html> Select the Subject <font color=\"Red\">*</font> </html>");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel23.setText("<html> Select the Teacher <font color=\"Red\">*</font> </html>");

        cmbteacher.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbteacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbteacherActionPerformed(evt);
            }
        });

        lteacherno.setFont(new java.awt.Font("Dialog", 1, 12));
        lteacherno.setText("Teacher No:");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel25.setText("Class held Day");

        cmbday.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel26.setText("Class Time");

        cmbsminute.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbsminute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "0 2", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("To");

        cmbehour.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbehour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmbeminute.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbeminute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        lbl.setFont(new java.awt.Font("Dialog", 1, 12));
        lbl.setForeground(new java.awt.Color(204, 51, 0));
        lbl.setText("NOTE -  * Fields can not be edited for a particular class");
        lbl.setToolTipText("");
        lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cmbsampm.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbsampm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PM", "AM" }));

        cmbeampm.setFont(new java.awt.Font("Dialog", 1, 12));
        cmbeampm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PM", "AM" }));

        lbl1.setFont(new java.awt.Font("Dialog", 1, 12));
        lbl1.setText(" ");

        lbl2.setFont(new java.awt.Font("Dialog", 1, 12));
        lbl2.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbshour, 0, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbsminute, 0, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbsampm, 0, 68, Short.MAX_VALUE))
                            .addComponent(cmbgrade, 0, 212, Short.MAX_VALUE)
                            .addComponent(cmbteacher, 0, 212, Short.MAX_VALUE)
                            .addComponent(cmbsubject, 0, 212, Short.MAX_VALUE)
                            .addComponent(cmbday, 0, 212, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbehour, 0, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbeminute, 0, 66, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbeampm, 0, 68, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lteacherno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lteacherno)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbgrade))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbsubject))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbteacher))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(cmbday))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbsampm)
                    .addComponent(cmbshour)
                    .addComponent(cmbsminute)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbeampm)
                    .addComponent(cmbeminute)
                    .addComponent(cmbehour)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblclass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C.No", "Subject", "Grade", "Teacher", "Day", "S.Time", "E.Time", "StartedDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblclass.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblclass.getTableHeader().setReorderingAllowed(false);
        tblclass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclassMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblclass);
        tblclass.getColumnModel().getColumn(0).setMinWidth(100);
        tblclass.getColumnModel().getColumn(1).setMinWidth(150);
        tblclass.getColumnModel().getColumn(2).setMinWidth(150);
        tblclass.getColumnModel().getColumn(3).setMinWidth(200);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        jLabel1.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
    }// </editor-fold>//GEN-END:initComponents

private void bcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcreateActionPerformed
    if (!tmonthly.getText().isEmpty() && !tadmission.getText().isEmpty() && startdate.getDate() != null) {
        if (OccationalLogics.showOption("Yes", "No") == 0) {
            contrlo.setStartTime(cmbshour.getSelectedItem().toString() + " : " + cmbsminute.getSelectedItem().toString() + " " + cmbsampm.getSelectedItem().toString());
            contrlo.setEndTime(cmbehour.getSelectedItem().toString() + " : " + cmbeminute.getSelectedItem().toString() + " " + cmbeampm.getSelectedItem().toString());
            if (!contrlo.checkForExistig(tblclass, cmbgrade, cmbsubject, cmbteacher, cmbday, contrlo.getStartTime(), contrlo.getEndTime())) {
                contrlo.setGrade("" + contrlo.getGradeId(cmbgrade.getSelectedIndex()));
                contrlo.setSubject("" + contrlo.getSubjectsId(cmbsubject.getSelectedIndex()));
                contrlo.setTeacher("" + contrlo.getTeachersid(cmbteacher.getSelectedIndex()));
                contrlo.setHeldingDay(cmbday.getSelectedItem().toString());
                contrlo.setStartTime(cmbshour.getSelectedItem().toString() + " : " + cmbsminute.getSelectedItem().toString() + " " + cmbsampm.getSelectedItem().toString());
                contrlo.setEndTime(cmbehour.getSelectedItem().toString() + " : " + cmbeminute.getSelectedItem().toString() + " " + cmbeampm.getSelectedItem().toString());
                contrlo.setTeacherPrecen(cmbtpercent.getSelectedItem().toString());
                contrlo.setInstitutepre(linspercentage.getText());
                contrlo.setAdmitionFee(tadmission.getText());
                contrlo.setMontlyfee(tmonthly.getText());
                contrlo.setStatdate(startdate.getDate());
                if (contrlo.addClass(contrlo)) {
                    contrlo.loadTable(tblclass);
                    JOptionPane.showMessageDialog(null, "Successfully added new Class!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry unexpected error occured");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Check the table this Class is alrady added!!");
            }

        }


}//GEN-LAST:event_bcreateActionPerformed
 else {
            JOptionPane.showMessageDialog(null, "Addmission fee or monthly fee fields can't be empty and start date cant be empty", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
private void cmbtpercentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtpercentFocusGained
//    try {
//       lduration.setText(contrlo.calculateDuration(cmbshour.getSelectedItem().toString()+":"+cmbsminute.getSelectedItem().toString(), cmbehour.getSelectedItem().toString()+":"+cmbeminute.getSelectedItem().toString()));
//    } catch (Exception e) {
//        System.out.println(e);
//    }
}//GEN-LAST:event_cmbtpercentFocusGained

private void cmbtpercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtpercentActionPerformed
    linspercentage.setText("" + (100 - Integer.parseInt(cmbtpercent.getSelectedItem().toString())));
}//GEN-LAST:event_cmbtpercentActionPerformed

private void tblclassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclassMouseClicked
    String values[] = contrlo.tableclicked(tblclass);
    cmbgrade.setSelectedItem(values[2]);
    cmbsubject.setSelectedItem(values[1]);
    cmbteacher.setSelectedItem(values[3]);
    cmbday.setSelectedItem(values[4]);
    cmbshour.setSelectedItem(values[5].trim());
    cmbsminute.setSelectedItem(values[6].trim());
    cmbsampm.setSelectedItem(values[7].trim());
    cmbehour.setSelectedItem(values[8].trim());
    cmbeminute.setSelectedItem(values[9].trim());
    cmbeampm.setSelectedItem(values[10].trim());
    cmbtpercent.setSelectedItem(values[11]);
    linspercentage.setText(values[12]);
    tadmission.setText(values[13]);
    tmonthly.setText(values[14]);
    
    try {
        startdate.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse(values[15]));
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
}//GEN-LAST:event_tblclassMouseClicked

private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed

    if (tblclass.getSelectedRow() != -1) {

        if (OccationalLogics.showOption("Yes", "No") == 0) {
            //  contrlo.setGrade("" + oca.getGradeId(cmbgrade.getSelectedIndex()));
            //   contrlo.setSubject("" + oca.getSubjectsId(cmbsubject.getSelectedIndex()));
            //   contrlo.setTeacher("" + oca.getTeachersid(cmbteacher.getSelectedIndex()));
            contrlo.setHeldingDay(cmbday.getSelectedItem().toString());
            contrlo.setStartTime(cmbshour.getSelectedItem().toString() + " : " + cmbsminute.getSelectedItem().toString() + " " + cmbsampm.getSelectedItem().toString());
            contrlo.setEndTime(cmbehour.getSelectedItem().toString() + " : " + cmbeminute.getSelectedItem().toString() + " " + cmbeampm.getSelectedItem().toString());
            // contrlo.setTeacherPrecen(cmbtpercent.getSelectedItem().toString());
            // contrlo.setInstitutepre(linspercentage.getText());
            // contrlo.setAdmitionFee(tadmission.getText());
            // contrlo.setMontlyfee(tmonthly.getText());
            contrlo.setStatdate(startdate.getDate());
            if (contrlo.updateClass(contrlo, tblclass.getValueAt(tblclass.getSelectedRow(), 0).toString())) {
                contrlo.loadTable(tblclass);
                JOptionPane.showMessageDialog(null, "Successfully updated Class!!");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry unexpected error occured");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select Row you want to edit");
    }
}//GEN-LAST:event_beditActionPerformed

private void cmbteacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbteacherActionPerformed
    lteacherno.setText("Teacher No: " + contrlo.getTeachersid(cmbteacher.getSelectedIndex()));
}//GEN-LAST:event_cmbteacherActionPerformed
    
private void tmonthlyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmonthlyKeyTyped
    OccationalLogics.validateTextDouble(evt);
}//GEN-LAST:event_tmonthlyKeyTyped

private void tadmissionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tadmissionKeyTyped
    OccationalLogics.validateTextDouble(evt);
}//GEN-LAST:event_tadmissionKeyTyped

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


    if (!usermanageControl.takeAction(Mainwindow.usrpriv_type).equals("Admin3")) {
        contrlo.DeactivateClass(tblclass);
        contrlo.loadTable(tblclass);
    } else {
        JOptionPane.showMessageDialog(null, " This operation can only be done by someone who has higer privilege than you!!!", "Operation Not Allowed", JOptionPane.WARNING_MESSAGE);
    }

}//GEN-LAST:event_jButton1ActionPerformed

private void deleteclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteclassActionPerformed
 if (!usermanageControl.takeAction(Mainwindow.usrpriv_type).equals("Admin3")) {
        contrlo.DeleteNewClass(tblclass);
        contrlo.loadTable(tblclass);
    } else {
        JOptionPane.showMessageDialog(null, " This operation can only be done by someone who has higer privilege than you!!!", "Operation Not Allowed", JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_deleteclassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcreate;
    private javax.swing.JButton bedit;
    private javax.swing.JComboBox cmbday;
    private javax.swing.JComboBox cmbeampm;
    private javax.swing.JComboBox cmbehour;
    private javax.swing.JComboBox cmbeminute;
    private javax.swing.JComboBox cmbgrade;
    private javax.swing.JComboBox cmbsampm;
    private javax.swing.JComboBox cmbshour;
    private javax.swing.JComboBox cmbsminute;
    private javax.swing.JComboBox cmbsubject;
    private javax.swing.JComboBox cmbteacher;
    private javax.swing.JComboBox cmbtpercent;
    private javax.swing.JButton deleteclass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel linspercentage;
    private javax.swing.JLabel lteacherno;
    private org.jdesktop.swingx.JXDatePicker startdate;
    private javax.swing.JTextField tadmission;
    private javax.swing.JTable tblclass;
    private javax.swing.JTextField tmonthly;
    // End of variables declaration//GEN-END:variables
}
