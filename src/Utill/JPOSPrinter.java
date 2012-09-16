package Utill;

import control.instituteControl;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;
import java.text.NumberFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import jpos.*;
import model.DB;

public class JPOSPrinter {

    static POSPrinterControl18 ptr = null;
    instituteControl controlins = null;
    DateFormat da;
    DateFormat time;
    private boolean TopPrint = false;
    private String invoiceid;
    private String month;
    //required for topPart printing
    private String studid;
    private String stname;
    private String stfnam;
    private String Regfe;
    private String paid;
    private String lectureFee;
    private String balnce;
    private String blance1;
    private String cash;
    //settign values 
    //automatically setsbelow values
    private String Grade;
    ArrayList<String> subj = null;
    ArrayList<String> Teacher = null;
    ArrayList<String> Amounts = null;

    public JPOSPrinter() {}

    public JPOSPrinter(instituteControl controlins) throws Exception{

        this.controlins = controlins;
        da = new SimpleDateFormat("yyyy/MM/dd");
        time = new SimpleDateFormat("HH:mm");
        String PrintersLogicName = "TM-U220D";

        if (ptr == null) {
            try {


                ptr = (POSPrinterControl18) new POSPrinter();
                ptr.open(PrintersLogicName);
                ptr.claim(1000);


            } catch (JposException ex) {
                JOptionPane.showMessageDialog(null, "The port name is illegal. or couldn't be connected to the device", "", JOptionPane.WARNING_MESSAGE);
               // ex.printStackTrace();
                throw ex;
                
            }
            try {
                //Enable the device.           
                ptr.setDeviceEnabled(true);
            } catch (JposException ex) {
                //System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Can not Enable The Printer Connected, internal Error Occured, Please Call for Maintanace", "", JOptionPane.WARNING_MESSAGE);
                throw ex;
               
            }
            try {
                //Even if using any printers, 0.01mm unit makes it possible to print neatly.
                ptr.setMapMode(POSPrinterConst.PTR_MM_METRIC);
            //Output by the high quality mode
            // ptr.setRecLetterQuality(true); ---------------------------------- hight quality output--------------

            } catch (JposException ex) {
                System.out.println(ex);
            }

        }
    }

    public synchronized void StartPrinting() {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                subj = new ArrayList<String>();
                Teacher = new ArrayList<String>();
                Amounts = new ArrayList<String>();
                try {


                    ResultSet rs = DB.getResultset("SELECT* FROM payment_invoice_student a JOIN class b ON a.class_id = b.class_id" +
                            " JOIN SUBJECT d ON b.subject_id = d.subject_id " +
                            " JOIN user_main c ON b.Teacher_id = c.user_id" +
                            " JOIN grade gr ON  b.Grade_id = gr.Grade_id" +
                            " WHERE " +
                            " a.invoice_id =" + getInvoiceid());

                    while (rs.next()) {
                        subj.add(rs.getString("class_id") + " " + rs.getString("Subject_name"));
                        Teacher.add(rs.getString("Fname") + " " + rs.getString("LName"));
                        Amounts.add(rs.getString("class_fees"));
                        setGrade(rs.getString("Grade_name"));
                    }


                    printTopPartnoThr();

                    printMiddleAnDBottom();

                } catch (Exception e) {
                    System.out.println(e + "the erros is in the middle query");
                }
            }
        });
        t1.start();

    }

    public synchronized void printTopPart() {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                printTopPartnoThr();
            }
        });
        t.start();

    }

    public void printTopPartnoThr() {


        if (!isTopPrint()) {
            try {
                String Text = null;
                Date today = new Date();

                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA\u001b|bC" + controlins.getInstituteName() + "\n");

                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + controlins.getAddressno() + "" + controlins.getStreet() + " " + controlins.getCity() + "\n");
                Text = makePrintString(ptr.getRecLineChars(), "TL:" + controlins.getContact1() + "," + controlins.getContact2(), "");
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, Text + "\n");
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|NDate:" + da.format(today) + " " + time.format(today) + "\n");
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|NID:" + getStudid() + " " + getStname() + "\n");

                setTopPrint(true);
            } catch (JposException ex) {
                System.out.println(ex);
            }
        }




    }

    public void printMiddleAnDBottom() {
        try {
            String Text;
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|NGrd:" + getGrade() + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Inv:" + getInvoiceid(), "By:" + getStfnam() + "");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + Text + "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + getLine(ptr.getRecLineChars()) + "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cAPayment month  " + getMonth() + "\n");
//----------------------------------------------------------------------------------------- 
            for (int i = 0; i < subj.size(); ++i) {
                Text = makePrintString(ptr.getRecLineChars(), subj.get(i), formatForDouble(Double.parseDouble(Amounts.get(i))));
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, Text + "\n");
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + Teacher.get(i) + "\n");
            }
//-------------------------------------------------------------------------------------------
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + getLine(ptr.getRecLineChars()) + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Institute fee", formatForDouble(Double.parseDouble(getPaid())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Lecturers fee ", formatForDouble(Double.parseDouble(getLectureFee())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");
//-------------------------------------------------------------------------------------------           
            Text = makePrintString(ptr.getRecLineChars() - 20, "Total ", formatForDouble((Double.parseDouble(getLectureFee()) + Double.parseDouble(getPaid()))));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA\u001b|bC\u001b|2C" + Text + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Cash ", formatForDouble(Double.parseDouble(getCash())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Balance ", formatForDouble(Double.parseDouble(getBlance1())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cAPlease keep the receipt\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cADeen Technologies-2848182\n");
//--------------------------------------------------------------------------------------------
            //cut the recipt if that function available and finish printing
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|fP");
            setTopPrint(false);
        } catch (JposException e) {
            System.out.println(e);
        }
    }

    public String makePrintString(int lineChars, String text1, String text2) {
        int spaces = 0;
        String tab = "";
        try {
            spaces = lineChars - (text1.length() + text2.length());
            for (int j = 0; j < spaces; j++) {
                tab += " ";
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return text1 + tab + text2;
    }

    public String getLine(int linechars) {
        String line = "";
        for (int i = 0; i < linechars; i++) {
            line += "-";
        }
        return line;
    }

    static String formatForDouble(double contents) {
        String newFormNo = "";
        try {
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            newFormNo = nf.format(contents);
        } catch (Exception ex) {
        }
        return newFormNo;
    }

    public boolean isTopPrint() {
        return TopPrint;
    }

    public void setTopPrint(boolean TopPrint) {
        this.TopPrint = TopPrint;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStudid() {
        return studid;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getStfnam() {
        return stfnam;
    }

    public void setStfnam(String stfnam) {
        this.stfnam = stfnam;
    }

    public String getRegfe() {
        return Regfe;
    }

    public void setRegfe(String Regfe) {
        this.Regfe = Regfe;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getLectureFee() {
        return lectureFee;
    }

    public void setLectureFee(String lectureFee) {
        this.lectureFee = lectureFee;
    }

    public String getBalnce() {
        return balnce;
    }

    public void setBalnce(String balnce) {
        this.balnce = balnce;
    }

    public String getBlance1() {
        return blance1;
    }

    public void setBlance1(String blance1) {
        this.blance1 = blance1;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
}
