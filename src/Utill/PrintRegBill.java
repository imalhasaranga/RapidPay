
package Utill;

import control.instituteControl;
import java.sql.ResultSet;
import java.util.ArrayList;
import jpos.JposException;
import jpos.POSPrinterConst;
import model.DB;


/**
 *
 * @author Imal
 */
public final class PrintRegBill extends JPOSPrinter {

    public PrintRegBill(instituteControl controlins) throws Exception {
       
        super(controlins);
       
    }
    
    
    @Override
    public synchronized void StartPrinting(){       
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                subj = new ArrayList<String>();
                Teacher = new ArrayList<String>();
                
                try {
                    ResultSet rs = DB.getResultset("select* from invoicedetails where  invoice_id = '"+getInvoiceid()+"'");
                    while (rs.next()) {
                        subj.add(rs.getString("class_id") + " " + rs.getString("Subject_name"));
                        Teacher.add(rs.getString("Fname") + " " + rs.getString("LName"));                       
                    }
                    printTopPartnoThr();
                    printMiddleAnDBottom();                   
                } catch (Exception e) {
                    System.out.println(e + "the erros is in the middle query");
                }
            }
        });
        t.start(); 
    }
    
    @Override
    public void printMiddleAnDBottom(){
        
      try {
            String Text;
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|NGrd:" + getGrade() + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Inv:" + getInvoiceid(), "By:" + getStfnam() + "");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + Text + "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + getLine(ptr.getRecLineChars()) + "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cARegistration\n");
//----------------------------------------------------------------------------------------- 
            for (int i = 0; i < subj.size(); ++i) {
                Text = makePrintString(ptr.getRecLineChars(), subj.get(i), Teacher.get(i));
                ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, Text + "\n");               
            }
//-------------------------------------------------------------------------------------------
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|N" + getLine(ptr.getRecLineChars()) + "\n");          
//-------------------------------------------------------------------------------------------           
            Text = makePrintString(ptr.getRecLineChars() - 20, "Total ", formatForDouble(Double.parseDouble(getRegfe())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA\u001b|bC\u001b|2C" + Text + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Cash ", formatForDouble(Double.parseDouble(getPaid())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");
            Text = makePrintString(ptr.getRecLineChars(), "Balance ", formatForDouble(Double.parseDouble(getBalnce())));
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cA" + Text + "\n");         
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|NDear  "+getStname()+"\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cAWelcome to the Sathara Institute, We expect\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cAthat you will obey all the rules and\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\u001b|cAregulations of our institute\n");            
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

}
