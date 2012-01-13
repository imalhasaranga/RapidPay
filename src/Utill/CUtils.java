
package Utill;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.text.JTextComponent;
import net.java.balloontip.BalloonTip;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author Imal
 */
public final class CUtils {

    private BalloonTip bt = null;

    public static void setIconImage(Container window) {
        JFrame frame = ((JFrame) window);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/images/titleimage.png")));

    }

    public static synchronized void startMemoryMonitor(final JProgressBar progress, final JLabel jlb) {

        progress.setMinimum(0);
        progress.setMaximum(100);
        progress.setStringPainted(true);


        Thread t = new Thread(new Runnable() {

            int leftmem = 0;

            public void run() {
                try {

                    while (true) {
                        long heapSize = Runtime.getRuntime().totalMemory() / (1024 * 1024);
                        long heapFreeSize = Runtime.getRuntime().freeMemory() / (1024 * 1024);
                        long heapMaxSize = Runtime.getRuntime().maxMemory() / (1024 * 1024);
                        leftmem = (int) ((heapSize - heapFreeSize) * 100 / heapSize);

                        progress.setValue(leftmem);
                        jlb.setText("(" + heapSize + "," + heapMaxSize + ")");
                        if (heapMaxSize - heapSize < 11) {

                            JOptionPane.showMessageDialog(null, "Sorry Application Should be restarted", "Memeory dump", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }

                        Thread.sleep(100);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.setName("RapidPayMemeoryusage");
        t.start();
    }

    public static boolean isInteger(String string) {
        try {
            Integer.valueOf(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void clearTextFields(JTextComponent[] comp) {

        for (int i = 0; i < comp.length; i++) {
            comp[i].setText("");

        }
    }

    private void printExport(JasperPrint print) {

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

    public void showBallonTool(JTextComponent comp, JFrame jb, boolean rootPaneCheckingEnabled, String text) {

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
}
