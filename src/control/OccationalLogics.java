
package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.text.JTextComponent;
import model.DB;
import net.java.balloontip.BalloonTip;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public final class OccationalLogics {

    Vector students;
    Vector Categories = new Vector();
    private Vector getCategory = new Vector();
    Vector grades1;
    Vector gradeId;
    Vector subjects;
    Vector subjectsId;
    Vector teachers;
    Vector teachersid;
    
    
    static DateFormat da = new SimpleDateFormat("yyyy/MM/dd");
    static DateFormat time = new SimpleDateFormat("HH:mm");

   public void loadCobobos(JComboBox Teachers1,JComboBox grade,JComboBox Subjects){
    LoadComboGrade(grade); 
    LoadComboSubject(Subjects,grade);
    LoadComboTeachers(Teachers1,grade,Subjects);
   }
    
    
    public void LoadComboGrade(JComboBox Gradecmbo) {
        grades1 = new Vector();
        gradeId = new Vector();
       // Gradecmbo.removeAllItems();
        try {
           
            ResultSet Grades = DB.getResultset("SELECT "
                        +"  cls.Class_id, "
                        +"  cls.Teacher_ID, "
                        +"  CONCAT(tech.Fname,' ',tech.Mname,' ',tech.Lname) AS teacher, "
                        +"  cls.Subject_id, "
                        +"  subject.Subject_name, "
                        +"  cls.Grade_id, "
                        +"  gr.Grade_name, "
                        +"  cls.is_active "
                        +"FROM class cls "
                        +"  JOIN grade gr "
                        +"    ON cls.Grade_id = gr.Grade_id "
                        +"  JOIN user_main tech "
                        +"    ON cls.Teacher_ID = tech.user_id "
                        +"  JOIN SUBJECT "
                        +"    ON cls.Subject_id = subject.Subject_id "
                        +"WHERE cls.is_active = '1' "
                        +" "
                        +"GROUP BY cls.Grade_id "
                        +"");

            while (Grades.next()) {
                grades1.add(Grades.getString("gr.Grade_name"));
                gradeId.add(Grades.getString("cls.Grade_id"));
               
            }

           Gradecmbo.setModel(new DefaultComboBoxModel(grades1));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    

    public void LoadComboSubject(JComboBox Subjects,JComboBox grade) {
        subjects = new Vector();
        subjectsId = new Vector();
       //  Subjects.removeAllItems();
        try {
           String value =null;
           if(grade.getSelectedIndex() == -1){
           value = "-1";
           }else{
           value = getGradeId(grade.getSelectedIndex())+"";
           }
            ResultSet subjectsres = DB.getResultset("SELECT "
                        +"  cls.Class_id, "
                        +"  cls.Teacher_ID, "
                        +"  CONCAT(tech.Fname,' ',tech.Mname,' ',tech.Lname) AS teacher, "
                        +"  cls.Subject_id, "
                        +"  subject.Subject_name, "
                        +"  cls.Grade_id, "
                        +"  gr.Grade_name, "
                        +"  cls.is_active "
                        +"FROM class cls "
                        +"  JOIN grade gr "
                        +"    ON cls.Grade_id = gr.Grade_id "
                        +"  JOIN user_main tech "
                        +"    ON cls.Teacher_ID = tech.user_id "
                        +"  JOIN SUBJECT "
                        +"    ON cls.Subject_id = subject.Subject_id "
                        +"WHERE cls.is_active = '1' && cls.Grade_id = '"+value+"' "
                        +"Group by subject_id");
            
            while (subjectsres.next()) {
                subjects.add(subjectsres.getString("subject.Subject_name"));
                subjectsId.add(subjectsres.getString("cls.Subject_id"));
            }

            Subjects.setModel(new DefaultComboBoxModel(subjects));
            
            if(Subjects.getItemCount() == 0){
                    subjects.add("Select");
                    subjectsId.add("-1");
                    Subjects.setModel(new DefaultComboBoxModel(subjects));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void LoadComboTeachers(JComboBox Teachers1,JComboBox grade,JComboBox Subjects) {
        teachers = new Vector();
        teachersid = new Vector();
     //  Teachers1.removeAllItems();
        try {
            
            
             String value =null;
           if(grade.getSelectedIndex() == -1){
           value = "-1";
           }else{
           value = getGradeId(grade.getSelectedIndex())+"";
           }
             String subvalu = null;
             if(Subjects.getSelectedIndex() == -1){
             subvalu = "-1";
             }else{
             subvalu = getSubjectsId(Subjects.getSelectedIndex())+""; 
             }

            ResultSet Teachers = DB.getResultset("SELECT "
                        +"  cls.Class_id, "
                        +"  cls.Teacher_ID, "
                        +"  CONCAT(tech.Fname,' ',tech.Mname,' ',tech.Lname) AS teacher, "
                        +"  cls.Subject_id, "
                        +"  subject.Subject_name, "
                        +"  cls.Grade_id, "
                        +"  gr.Grade_name, "
                        +"  cls.is_active "
                        +"FROM class cls "
                        +"  JOIN grade gr "
                        +"    ON cls.Grade_id = gr.Grade_id "
                        +"  JOIN user_main tech "
                        +"    ON cls.Teacher_ID = tech.user_id "
                        +"  JOIN SUBJECT "
                        +"    ON cls.Subject_id = subject.Subject_id "
                        +"WHERE cls.is_active = '1' && cls.Grade_id = '"+value+"' &&  cls.Subject_id ='"+subvalu+"' "
                        +"group by teacher");
            while (Teachers.next()) {
                teachers.add(Teachers.getString("teacher"));
                teachersid.add(Teachers.getString("cls.Teacher_ID"));
            }
            Teachers1.setModel(new DefaultComboBoxModel(teachers));
             if(Teachers1.getItemCount() == 0){
                    teachers.add("Select");
                    teachersid.add("-1");
                    Subjects.setModel(new DefaultComboBoxModel(subjects));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

 
    public void loadCategories(JComboBox Categories) {
        ResultSet rss = null;

        try {
            rss = DB.getResultset("select* from user_type");
            while (rss.next()) {
                this.Categories.add(rss.getString("user_type"));
                getCategory.add(rss.getString("user_typeId"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Categories.setModel(new DefaultComboBoxModel(this.Categories));

    }

    public static int showOption(String op1, String op2) {

        Object[] options = {op1, op2};
        int res = JOptionPane.showOptionDialog(null, "Are you sure you want to proceed", "warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        return res;
    }

    public static void clearTextFields(JTextComponent[] comp) {

        for (int i = 0; i < comp.length; i++) {
            comp[i].setText("");

        }
    }

    public int getGradeId(int id) {
        return Integer.parseInt(gradeId.get(id).toString());
    }

    public int getSubjectsId(int id) {
        return Integer.parseInt(subjectsId.get(id).toString());
    }

    public int getTeachersid(int id) {
        return Integer.parseInt(teachersid.get(id).toString());
    }

    public int getGetCategory(int id) {
        return Integer.parseInt(getCategory.get(id).toString());
    }

    public int getGetCategory(String utype) {
        ResultSet rss = null;

        try {
            rss = DB.getResultset("select user_typeid from user_type where user_type = '" + utype + "'");
            if (rss.next()) {
                return rss.getInt("user_typeid");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 1000;
    }

    public static boolean isPressEnter(KeyEvent evt) {

        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }

    public static void JReport(JTabbedPane pnl, String reportname, double zoom, Map<String, Object> params, String jrxmlpath, int option, instituteControl controlins) {



        Date today = new Date();
        String rep_path = System.getProperty("user.dir") + "/reports/" + jrxmlpath;

        //params.put("inName", (controlins.getInstituteName()).split(" ")[0]);
        params.put("inSecName", controlins.getInstituteName());
        params.put("insAddr", controlins.getAddressno() + " " + controlins.getStreet() + " " + controlins.getCity());
        params.put("telephone", controlins.getContact1() + "," + controlins.getContact2());
        params.put("website", controlins.getWebsite());
        params.put("datepaid", da.format(today));
        params.put("Timepaid", time.format(today));


        try {



            JasperReport jreport = JasperCompileManager.compileReport(rep_path);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, params, DB.getmyCon());
            JRViewer jview = new JRViewer(jprint);

            if (option == 0) {
                JasperViewer.viewReport(jprint, false);
            } else if (option == 1) {

                pnl.removeAll();
                pnl.add(reportname, jview);
                jview.setZoomRatio((float) zoom);

            } else if (option == 2) {
                printExport(jprint);

            } else if (option == 3) {

                pnl.removeAll();
                jview.setPreferredSize(pnl.getSize());
                pnl.add(reportname, jview);
                jview.setZoomRatio((float) zoom);
                printExport(jprint);
            }else if(option == 4){
             pnl.removeAll();
                jview.setPreferredSize(pnl.getSize());
                pnl.add(reportname, jview);
                jview.setZoomRatio((float) zoom);
               
            }


        } catch (Exception ex) {
            System.out.println("ERROR:" + ex);
        }


    }

    private static void printExport(JasperPrint print) {
        JRExporter exporter = new JRPrintServiceExporter();

        //--- Get printjob and service (default printer)
        PrinterJob pj = PrinterJob.getPrinterJob();
        PrintService ps = pj.getPrintService();

        //--- Set print properties
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(MediaSizeName.NA_5X7);


        //--- Set print parameters
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, ps.getAttributes());
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

        //--- Print the document
        try {
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void validateTextDouble(java.awt.event.KeyEvent evt) {


        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }

    }
    static BalloonTip bt = null;

    public static void ballonTool(JTextComponent comp, JFrame jb, boolean rootPaneCheckingEnabled, String text) {

        if (bt == null) {
            bt = BalloonTip.createRoundedBalloonTip(comp, BalloonTip.Alignment.LEFT_ALIGNED_ABOVE, new Color(102, 113, 9), new Color(223, 236, 110), 2, 20, 20, 12, 12, rootPaneCheckingEnabled);
            Icon i = new ImageIcon(jb.getClass().getResource("/images/block_32.png"));
            bt.setIcon(i);
            bt.setIconTextGap(2);
            bt.setText(text);
        }


        if (java.awt.Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK)) {

            bt.setVisible(true);
        } else {

            bt.setVisible(false);


        }

    }

    public static boolean CheckValue(String maxvalue, String mainvalue) {

        try {


            double maxval = Double.parseDouble(maxvalue);
            double minval = Double.parseDouble(mainvalue);

            if (maxval - minval < 0) {

                JOptionPane.showMessageDialog(null, "Paying Amount is Less Than Calculated Amount", "PAYMENT ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Paying Amount is Null, Or Other Unexpected Error Occard", "PAYMENT ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public static void Compare() {

        try {

            ResultSet rs = DB.getResultset("SELECT DATEDIFF(CURDATE(), MAX(logout_time)) AS intval FROM login_logout");
            if (rs.next()) {

                int value = rs.getInt("intval");
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "The System Date has been changed, \n Please Correct the Date and Time of the Computer and Run again", "SYSTEM DATE CHANGE", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }




    }
}
