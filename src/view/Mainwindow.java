/*
 * Mainwindow.java
 *
 * Created on May 10, 2011, 8:38 AM
 */
package view;

import view.Reports.rep_att_class;
import view.Reports.rep_mainfinance;
import view.Reports.rep_att_date;
import view.Reports.rep_pay_date;
import view.Reports.rep_ins_summary;
import view.Reports.rep_tch_paysheet;
import view.Reports.rep_pay_day_by_day;
import view.Reports.rep_pay_stu;
import view.Reports.rep_class_stu;
import view.Reports.rep_nopay;
import view.Reports.rep_att_stu;
import view.Reports.rep_timetable;
import Utill.CUtils;
import control.Mainwindowcontrol;
import control.OccationalLogics;
import control.editpesonDetails;
import control.userloginControl;
import control.usermanageControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author gihan
 */
public final class Mainwindow extends javax.swing.JFrame {

    private regstudent rs = null;
    private regteachers rt = null;
    private regstaff rf = null;
    private feesmgt fm = new feesmgt();
    private teacherpay tp = null;
    private editstaff estafedi = null;
    private editstudent estu = null;
    private editteachers eteacher = null;
    private classes cls = null;
    private usermanage man;
    private AttendanceMarkset atten = null;
    private userloginControl controllog = null;
    private editpesonDetails editperson = null;
    private rep_mainfinance rep_mainfinance = null;
    private OccationalLogics logics = new OccationalLogics();
    public static boolean EnblePrint = true;
    userlogin userlog;
    public static String usrname;
    public static String usrpriv_type;
    public static String UserStaffID;
    public static String logtime;
    Mainwindow home;

    public void securelogin(String usrname, String usrpriv_type, String usrmainid, Mainwindow home, userlogin log,String logtime) {
        this.home = home;
        Mainwindow.usrname = usrname;
        userlog = log;
        Mainwindow.usrpriv_type = usrpriv_type;
        Mainwindow.UserStaffID = usrmainid;
        Mainwindow.logtime = logtime;
        home.setTitle("Sathara Institute of Education (Pvt) Ltd /current user : " + Mainwindow.usrname);
        home.repaint();
        setMan(new usermanage());

        String usr = usermanageControl.takeAction(usrpriv_type);
        if (usr.equals("Admin3")) {

            miusermgt7.setEnabled(false);
            miinsmgt16.setEnabled(false);
        } else {
            miusermgt7.setEnabled(true);
            miinsmgt16.setEnabled(true);
        }
        home.setVisible(true);

    }

    public Mainwindow() {
        initComponents();

        CUtils.setIconImage(this);
        searchscoral.setVisible(false);
        logics.loadCategories(cmbsearch);



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        jpanelhead.setBackground(Color.LIGHT_GRAY);
        maintab.removeAll();
        maintab.add("Student Fees", fm);
        CUtils.startMemoryMonitor(progres, outof);
        fm.ssearch.grabFocus();
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    public void logout() {

        getControllog().sayLogout();
        this.setVisible(false);
        userlog.getPassword().setText("");
        userlog.status.setText("");
        userlog.setVisible(true);


    }

    public void frameResize() {

        jpanelhead.setBounds(0, 0, this.getWidth() - 20, 70);
        middletab.setBounds(0, 71, this.getWidth() - 20, 660);
        searchscoral.setBounds(this.getWidth() - 358, tsearch.getY() + 25, tsearch.getWidth(), 0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        searchscoral = new javax.swing.JScrollPane();
        searchlist = new javax.swing.JList();
        jpanelhead = new javax.swing.JPanel();
        bmainrep = new javax.swing.JButton();
        bstudentfees = new javax.swing.JButton();
        bteacherpay = new javax.swing.JButton();
        attendance = new javax.swing.JButton();
        jp1 = new javax.swing.JPanel();
        cmbsearch = new javax.swing.JComboBox();
        cmbtype = new javax.swing.JComboBox();
        tsearch = new javax.swing.JTextField();
        bsearch = new javax.swing.JButton();
        middletab = new javax.swing.JPanel();
        maintab = new javax.swing.JTabbedPane();
        maintab1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        progres = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        outof = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        mnregister16 = new javax.swing.JMenu();
        miregstudents16 = new javax.swing.JMenuItem();
        miregteachers16 = new javax.swing.JMenuItem();
        miregstaff16 = new javax.swing.JMenuItem();
        mnreports16 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        miattstudents16 = new javax.swing.JMenuItem();
        misttclass16 = new javax.swing.JMenuItem();
        miattdate16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miclassinfo16 = new javax.swing.JMenuItem();
        minopay16 = new javax.swing.JMenuItem();
        mittable16 = new javax.swing.JMenuItem();
        miteachersheet16 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mipaystudents16 = new javax.swing.JMenuItem();
        mipaydate16 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem81 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem82 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        miinssum16 = new javax.swing.JMenuItem();
        mnsystem16 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        miusermgt7 = new javax.swing.JMenuItem();
        miinsmgt16 = new javax.swing.JMenuItem();
        jMenuItem85 = new javax.swing.JMenuItem();
        EnablePRintChek = new javax.swing.JCheckBoxMenuItem();
        migrademgt16 = new javax.swing.JMenuItem();
        misubjectmgt16 = new javax.swing.JMenuItem();
        miclassmgt16 = new javax.swing.JMenuItem();
        jMenuItem84 = new javax.swing.JMenuItem();
        milogout16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sathara Institute of Education (Pvt) Ltd");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowclosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                windowresized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                windowMinmaizedOrMaximied(evt);
            }
        });

        jLayeredPane1.setBackground(new java.awt.Color(153, 180, 209));

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

        searchscoral.setBounds(930, 62, 230, 0);
        jLayeredPane1.add(searchscoral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jpanelhead.setBackground(javax.swing.UIManager.getDefaults().getColor("nbProgressBar.popupDynaText.foreground"));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLayeredPane1, org.jdesktop.beansbinding.ELProperty.create("${alignmentX}"), jpanelhead, org.jdesktop.beansbinding.BeanProperty.create("alignmentX"));
        bindingGroup.addBinding(binding);

        bmainrep.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bmainrep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1315676326_finance.png"))); // NOI18N
        bmainrep.setText("Finance Report");
        bmainrep.setPreferredSize(new java.awt.Dimension(107, 25));
        bmainrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmainrepActionPerformed(evt);
            }
        });

        bstudentfees.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bstudentfees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_billing.png"))); // NOI18N
        bstudentfees.setText("Student Fees");
        bstudentfees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstudentfeesActionPerformed(evt);
            }
        });

        bteacherpay.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bteacherpay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qw.png"))); // NOI18N
        bteacherpay.setText("Teacher Pay");
        bteacherpay.setPreferredSize(new java.awt.Dimension(107, 25));
        bteacherpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteacherpayActionPerformed(evt);
            }
        });

        attendance.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        attendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1326818037_attendance_list.png"))); // NOI18N
        attendance.setText("Attendance ");
        attendance.setEnabled(false);
        attendance.setPreferredSize(new java.awt.Dimension(107, 25));
        attendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceActionPerformed(evt);
            }
        });

        jp1.setBackground(new java.awt.Color(127, 157, 185));

        cmbsearch.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        cmbtype.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cmbtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "By Name", "By Admmision No" }));

        tsearch.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsearchActionPerformed(evt);
            }
        });
        tsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tsearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tsearchKeyTyped(evt);
            }
        });

        bsearch.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        bsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1315720469_search_48.png"))); // NOI18N
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                        .addComponent(cmbsearch, 0, 103, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bsearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtype))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tsearch)))
                .addGap(38, 38, 38))
        );

        jp1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbsearch, cmbtype});

        javax.swing.GroupLayout jpanelheadLayout = new javax.swing.GroupLayout(jpanelhead);
        jpanelhead.setLayout(jpanelheadLayout);
        jpanelheadLayout.setHorizontalGroup(
            jpanelheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelheadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bmainrep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bstudentfees, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bteacherpay, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpanelheadLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {attendance, bmainrep, bstudentfees, bteacherpay});

        jpanelheadLayout.setVerticalGroup(
            jpanelheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelheadLayout.createSequentialGroup()
                .addGroup(jpanelheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpanelheadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpanelheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bmainrep, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bstudentfees, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bteacherpay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jpanelheadLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {attendance, bmainrep, bstudentfees, bteacherpay});

        jpanelhead.setBounds(0, 0, 1270, 70);
        jLayeredPane1.add(jpanelhead, javax.swing.JLayeredPane.DEFAULT_LAYER);

        middletab.setBackground(new java.awt.Color(153, 180, 209));

        javax.swing.GroupLayout middletabLayout = new javax.swing.GroupLayout(middletab);
        middletab.setLayout(middletabLayout);
        middletabLayout.setHorizontalGroup(
            middletabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maintab, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        middletabLayout.setVerticalGroup(
            middletabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maintab, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        middletab.setBounds(-1, 72, 1270, 670);
        jLayeredPane1.add(middletab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel2.setBackground(new java.awt.Color(153, 180, 209));

        progres.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        progres.setBorderPainted(false);
        progres.setPreferredSize(new java.awt.Dimension(146, 11));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Memory Usage >");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        outof.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        outof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outof.setText("  ");
        outof.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outof, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progres, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(outof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(progres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, outof, progres});

        jMenuBar.setBorder(null);
        jMenuBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        mnregister16.setText("Register");

        miregstudents16.setText("Register Students");
        miregstudents16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miregstudentsActionPerformed(evt);
            }
        });
        mnregister16.add(miregstudents16);

        miregteachers16.setText("Register Teacher");
        miregteachers16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miregteachersActionPerformed(evt);
            }
        });
        mnregister16.add(miregteachers16);

        miregstaff16.setText("Register Staff");
        miregstaff16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miregstaffActionPerformed(evt);
            }
        });
        mnregister16.add(miregstaff16);

        jMenuBar.add(mnregister16);

        mnreports16.setText("Reports");

        jMenu2.setText("Attendance");
        jMenu2.setEnabled(false);

        miattstudents16.setText("Attendance - Student Vice");
        miattstudents16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miattstudentsActionPerformed(evt);
            }
        });
        jMenu2.add(miattstudents16);

        misttclass16.setText("Attendance - Class Vice");
        misttclass16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misttclassActionPerformed(evt);
            }
        });
        jMenu2.add(misttclass16);

        miattdate16.setText("Attendance - Date Vice");
        miattdate16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miattdateActionPerformed(evt);
            }
        });
        jMenu2.add(miattdate16);

        mnreports16.add(jMenu2);

        jMenu3.setText("Class");

        miclassinfo16.setText("Class-Students");
        miclassinfo16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miclassinfoActionPerformed(evt);
            }
        });
        jMenu3.add(miclassinfo16);

        minopay16.setText("Class-Not Paid");
        minopay16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minopayActionPerformed(evt);
            }
        });
        jMenu3.add(minopay16);

        mnreports16.add(jMenu3);

        mittable16.setText("Time Table");
        mittable16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mittableActionPerformed(evt);
            }
        });
        mnreports16.add(mittable16);

        miteachersheet16.setText("Teacher's Pay Sheet");
        miteachersheet16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miteachersheetActionPerformed(evt);
            }
        });
        mnreports16.add(miteachersheet16);

        jMenu1.setText("Payments");

        mipaystudents16.setText("Payments - Student Vice");
        mipaystudents16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mipaystudentsActionPerformed(evt);
            }
        });
        jMenu1.add(mipaystudents16);

        mipaydate16.setText("Payments - Date Vice");
        mipaydate16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mipaydateActionPerformed(evt);
            }
        });
        jMenu1.add(mipaydate16);

        jMenuItem1.setText("Payments- Date Vice(comple)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed1(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem81.setText("Deleted Payments-Date Vice");
        jMenuItem81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem81);

        mnreports16.add(jMenu1);

        jMenu17.setText("Institute Development Reports");

        jMenuItem82.setText("Total income Fluctuation");
        jMenuItem82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem82);

        jMenuItem3.setText("Total Reg Students Fluctuation");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed1(evt);
            }
        });
        jMenu17.add(jMenuItem3);

        mnreports16.add(jMenu17);

        miinssum16.setText("Institute Summary");
        miinssum16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miinssumActionPerformed(evt);
            }
        });
        mnreports16.add(miinssum16);

        jMenuBar.add(mnreports16);

        mnsystem16.setText("System Management");
        mnsystem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnsystemActionPerformed(evt);
            }
        });

        jMenu4.setText("Advanced Settings");

        miusermgt7.setText("User Manage");
        miusermgt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miusermgtActionPerformed(evt);
            }
        });
        jMenu4.add(miusermgt7);

        miinsmgt16.setText("Institute Details");
        miinsmgt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miinsmgtActionPerformed(evt);
            }
        });
        jMenu4.add(miinsmgt16);

        jMenuItem85.setText("Speedup system");
        jMenuItem85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem85);

        EnablePRintChek.setSelected(true);
        EnablePRintChek.setText("Enable Printing  ");
        EnablePRintChek.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EnablePRintChek.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        EnablePRintChek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnablePRintChekActionPerformed(evt);
            }
        });
        jMenu4.add(EnablePRintChek);

        mnsystem16.add(jMenu4);

        migrademgt16.setText("Grades");
        migrademgt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrademgtActionPerformed(evt);
            }
        });
        mnsystem16.add(migrademgt16);

        misubjectmgt16.setText("Subjects");
        misubjectmgt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misubjectmgtActionPerformed(evt);
            }
        });
        mnsystem16.add(misubjectmgt16);

        miclassmgt16.setText("Create Classes");
        miclassmgt16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miclassmgtActionPerformed(evt);
            }
        });
        mnsystem16.add(miclassmgt16);

        jMenuItem84.setText("InActive Students");
        jMenuItem84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnsystem16.add(jMenuItem84);

        milogout16.setText("Logout");
        milogout16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milogoutActionPerformed(evt);
            }
        });
        mnsystem16.add(milogout16);

        jMenuBar.add(mnsystem16);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1269, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bmainrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmainrepActionPerformed
    rep_mainfinance = rep_mainfinance == null ? new rep_mainfinance().mainfinanc() : rep_mainfinance;
    maintab.removeAll();
    maintab.add("Main Finance Report", rep_mainfinance);
}//GEN-LAST:event_bmainrepActionPerformed

private void miregstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miregstudentsActionPerformed

    maintab.removeAll();
    rs.initializePrinter();
    maintab.add("Student Register", rs);
}//GEN-LAST:event_miregstudentsActionPerformed

private void miregteachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miregteachersActionPerformed
    maintab.removeAll();
    maintab.add("Teacher Register", rt);
}//GEN-LAST:event_miregteachersActionPerformed

private void miregstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miregstaffActionPerformed
    maintab.removeAll();
    maintab.add("  Staff Register", rf);
}//GEN-LAST:event_miregstaffActionPerformed

private void bstudentfeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstudentfeesActionPerformed
    maintab.removeAll();
    maintab.add("Student Fees", fm);
}//GEN-LAST:event_bstudentfeesActionPerformed

private void miattstudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miattstudentsActionPerformed
    maintab.removeAll();
    maintab.add("Attendance Report - Student Vice", new rep_att_stu());
}//GEN-LAST:event_miattstudentsActionPerformed

private void misttclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misttclassActionPerformed
    maintab.removeAll();
    maintab.add("Attendance Report - Class Vice", new rep_att_class());
}//GEN-LAST:event_misttclassActionPerformed

private void miattdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miattdateActionPerformed
    maintab.removeAll();
    maintab.add("Attendance Report - Date Vice", new rep_att_date());
}//GEN-LAST:event_miattdateActionPerformed

private void mipaystudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mipaystudentsActionPerformed
    maintab.removeAll();
    maintab.add("Payment Report - Student Vice", new rep_pay_stu());
}//GEN-LAST:event_mipaystudentsActionPerformed

private void mipaydateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mipaydateActionPerformed
    maintab.removeAll();
    maintab.add("Payment Report - Date Vice", new rep_pay_date());
}//GEN-LAST:event_mipaydateActionPerformed

private void minopayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minopayActionPerformed
    maintab.removeAll();
    maintab.add("Not Paid Details", new rep_nopay());
}//GEN-LAST:event_minopayActionPerformed

private void mittableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mittableActionPerformed
    maintab.removeAll();
    maintab.add("Institute Time Table", new rep_timetable());
}//GEN-LAST:event_mittableActionPerformed

private void miteachersheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miteachersheetActionPerformed
    maintab.removeAll();
    maintab.add("Teacher's Pay Sheet", new rep_tch_paysheet());
}//GEN-LAST:event_miteachersheetActionPerformed

private void miusermgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miusermgtActionPerformed
    new usermanage(usrpriv_type).setVisible(true);
}//GEN-LAST:event_miusermgtActionPerformed

private void miclassmgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miclassmgtActionPerformed
    maintab.removeAll();
    maintab.add("Creating Classes", cls);
}//GEN-LAST:event_miclassmgtActionPerformed

private void miinsmgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miinsmgtActionPerformed
    new institute().setVisible(true);
}//GEN-LAST:event_miinsmgtActionPerformed

private void migrademgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrademgtActionPerformed
    new grades().setVisible(true);
}//GEN-LAST:event_migrademgtActionPerformed

private void misubjectmgtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misubjectmgtActionPerformed
    new subjects().setVisible(true);
}//GEN-LAST:event_misubjectmgtActionPerformed

private void miclassinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miclassinfoActionPerformed
    maintab.removeAll();
    maintab.add("Students of Classes", new rep_class_stu());
}//GEN-LAST:event_miclassinfoActionPerformed

private void miinssumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miinssumActionPerformed
    maintab.removeAll();
    maintab.add("Institute Summary", new rep_ins_summary());
}//GEN-LAST:event_miinssumActionPerformed

private void bteacherpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteacherpayActionPerformed
    maintab.removeAll();
    maintab.add("Teacher Pay Window", tp);
}//GEN-LAST:event_bteacherpayActionPerformed

private void attendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceActionPerformed
maintab.removeAll();//GEN-LAST:event_attendanceActionPerformed
        atten = atten == null ? new AttendanceMarkset() : atten;
        maintab.add("Attendance marking", atten);

    }

private void milogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milogoutActionPerformed
    logout();
}//GEN-LAST:event_milogoutActionPerformed

private void tsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsearchActionPerformed
}//GEN-LAST:event_tsearchActionPerformed

private void tsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsearchKeyReleased
    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE || tsearch.getText().length() == 0) {

        Mainwindowcontrol.personSeach(searchscoral, tsearch.getText(), searchlist, logics.getGetCategory(getCmbsearch().getSelectedIndex()), cmbtype.getSelectedIndex());
        Mainwindowcontrol.settingFocus(evt, searchlist);

    }

}//GEN-LAST:event_tsearchKeyReleased

private void tsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsearchKeyTyped
    if (cmbtype.getSelectedItem().toString().equals("By Admmision No")) {
        if (!(Character.isDigit(evt.getKeyChar()))) {
            evt.consume();
            getToolkit().beep();
        }
    }
}//GEN-LAST:event_tsearchKeyTyped

private void searchlistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlistKeyReleased
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        tsearch.setText(searchlist.getSelectedValue().toString());
        searchscoral.setVisible(false);

    } else {
        Mainwindowcontrol.list_key_release(evt, tsearch);
    }
}//GEN-LAST:event_searchlistKeyReleased

private void searchlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchlistMouseClicked
    tsearch.setText(searchlist.getSelectedValue().toString());

    tsearch.setFocusable(true);
    searchlist.setVisible(false);
    searchscoral.setVisible(false);
}//GEN-LAST:event_searchlistMouseClicked

private void windowclosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowclosing

    logout();

}//GEN-LAST:event_windowclosing

private void mnsystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnsystemActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_mnsystemActionPerformed

private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
    searchlist.removeAll();

    System.gc();

    if (!tsearch.getText().isEmpty()) {
        maintab.removeAll();
        editperson.searchidGetResults(tsearch.getText(), getCmbsearch().getSelectedItem().toString(), maintab, eteacher, estu, estafedi);
    }
}//GEN-LAST:event_bsearchActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    System.gc();
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    new InActiveStudents().setVisible(true);
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    DevalopmentReports report = new DevalopmentReports();
    report.getRepdetails().setText("Monthly Income Fluctuation  during  the year ");
    report.setReportname("incomechart_year.jrxml");
    report.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

    maintab.removeAll();
    maintab.add("Deleted Bill Report", new DeletedBilss());
}//GEN-LAST:event_jMenuItem5ActionPerformed

private void windowresized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_windowresized
    frameResize();
}//GEN-LAST:event_windowresized

private void windowMinmaizedOrMaximied(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowMinmaizedOrMaximied
    frameResize();
}//GEN-LAST:event_windowMinmaizedOrMaximied

private void jMenuItem3ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed1
    DevalopmentReports report = new DevalopmentReports();
    report.getRepdetails().setText("Total number of registered students Fluctuation  during  the year");
    report.setReportname("Student_reg_fluck.jrxml");
    report.setVisible(true);
}//GEN-LAST:event_jMenuItem3ActionPerformed1

private void jMenuItem1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed1
    maintab.removeAll();
    maintab.add("Day By Day Report", new rep_pay_day_by_day());
}//GEN-LAST:event_jMenuItem1ActionPerformed1

    private void EnablePRintChekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnablePRintChekActionPerformed
        Mainwindow.EnblePrint = EnablePRintChek.isSelected();
    }//GEN-LAST:event_EnablePRintChekActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem EnablePRintChek;
    private javax.swing.JButton attendance;
    private javax.swing.JButton bmainrep;
    private javax.swing.JButton bsearch;
    private javax.swing.JButton bstudentfees;
    private javax.swing.JButton bteacherpay;
    private javax.swing.JComboBox cmbsearch;
    private javax.swing.JComboBox cmbtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem81;
    private javax.swing.JMenuItem jMenuItem82;
    private javax.swing.JMenuItem jMenuItem84;
    private javax.swing.JMenuItem jMenuItem85;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jpanelhead;
    private javax.swing.JTabbedPane maintab;
    private javax.swing.JTabbedPane maintab1;
    private javax.swing.JMenuItem miattdate16;
    private javax.swing.JMenuItem miattstudents16;
    private javax.swing.JMenuItem miclassinfo16;
    private javax.swing.JMenuItem miclassmgt16;
    private javax.swing.JPanel middletab;
    private javax.swing.JMenuItem migrademgt16;
    private javax.swing.JMenuItem miinsmgt16;
    private javax.swing.JMenuItem miinssum16;
    private javax.swing.JMenuItem milogout16;
    private javax.swing.JMenuItem minopay16;
    private javax.swing.JMenuItem mipaydate16;
    private javax.swing.JMenuItem mipaystudents16;
    private javax.swing.JMenuItem miregstaff16;
    private javax.swing.JMenuItem miregstudents16;
    private javax.swing.JMenuItem miregteachers16;
    private javax.swing.JMenuItem misttclass16;
    private javax.swing.JMenuItem misubjectmgt16;
    private javax.swing.JMenuItem miteachersheet16;
    private javax.swing.JMenuItem mittable16;
    private javax.swing.JMenuItem miusermgt7;
    private javax.swing.JMenu mnregister16;
    private javax.swing.JMenu mnreports16;
    private javax.swing.JMenu mnsystem16;
    private javax.swing.JLabel outof;
    private javax.swing.JProgressBar progres;
    private javax.swing.JList searchlist;
    private javax.swing.JScrollPane searchscoral;
    private javax.swing.JTextField tsearch;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void setRs(regstudent rs) {
        this.rs = rs;
    }

    public void setRt(regteachers rt) {
        this.rt = rt;
    }

    public void setRf(regstaff rf) {
        this.rf = rf;
    }

    public void setTp(teacherpay tp) {
        this.tp = tp;
    }

    public void setEstafedi(editstaff estafedi) {
        this.estafedi = estafedi;
    }

    public void setEstu(editstudent estu) {
        this.estu = estu;
    }

    public void setEteacher(editteachers eteacher) {
        this.eteacher = eteacher;
    }

    public void setCls(classes cls) {
        this.cls = cls;
    }

    public void setMan(usermanage man) {
        this.man = man;
    }

    public void setEditperson(editpesonDetails editperson) {
        this.editperson = editperson;
    }

    public javax.swing.JComboBox getCmbsearch() {
        return cmbsearch;
    }

    public userloginControl getControllog() {
        return controllog;
    }

    public void setControllog(userloginControl controllog) {
        this.controllog = controllog;

    }
}
