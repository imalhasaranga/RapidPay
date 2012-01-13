package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Imal
 */
public final class sqlDump {

    private File file;

    public JFileChooser getSqlFileJFileChooser() {

        final JFileChooser jFileChooser1 = new JFileChooser();
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if (JFileChooser.CANCEL_SELECTION.equals(evt.getActionCommand())) {
                        jFileChooser1.setVisible(false);
                    }
                    if (evt.getActionCommand().equals("ApproveSelection")) {
                        File file = jFileChooser1.getSelectedFile();
                        String s = file.getName();
                        int i = s.lastIndexOf('.');

                        if (i > 0 && i < s.length() - 1) {
                            String extension = s.substring(i + 1).toLowerCase();
                            if ("sql".equals(extension)) {
                                setFile(file);
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry The file you choose is not a SQL file, \n Please select the correct format");
                                setFile(null);
                            }
                        }

                    }
                } catch (Exception e) {
                    System.out.println("dffdfd");
                }
            }
        });
        return jFileChooser1;
    }

    public void Restore() throws Exception {


        JFileChooser chose = getSqlFileJFileChooser();
        chose.showOpenDialog(null);
        File sqlpat = getFile();


        if (sqlpat != null) {


            FileInputStream condata1 = new FileInputStream(System.getProperty("user.dir") + "/data1.dat");
            ObjectInputStream input = new ObjectInputStream(condata1);
            Property prop = (Property) input.readObject();
            input.close();
            String mysqlpath;
            if (isOSX()) {
                mysqlpath = System.getProperty("user.dir") + "/Mysqlutils/mysql";
            } else {
                mysqlpath = System.getProperty("user.dir") + "\\Mysqlutils\\mysql.exe";
            }

            String[] executeCmd1 = new String[]{mysqlpath, "--host=" + prop.getHost(), "--port=" + prop.getPort(), "--user=" + prop.getUsername(), "--password=" + prop.getPassword(), "-e", " source " + sqlpat + "", "TutionDB"};
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd1);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "SQl Restoring process successfully completed ", "Restoring Process Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "SQl Restoring process failled, please Try again", "Restoring Process Failled", JOptionPane.ERROR_MESSAGE);
            }


        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void backup() throws Exception {
//        FileInputStream condata1 = new FileInputStream(System.getProperty("user.dir") + "/data1.dat");
//
//        ObjectInputStream input = new ObjectInputStream(condata1);
//        Property prop = (Property) input.readObject();
//        input.close();
//
//        Date date = new Date();
//        String DATE_FORMAT = "MMM-dd-yyyy";
//
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//        String fileName = sdf.format(date);
//        String fileLocation = location + fileName + "e.sql";
//
//        String execline= null;
//        if( isOSX() ){
//                execline = System.getProperty("user.dir") + "/Mysqlutils/mysqldump";
//            }else{
//                execline = System.getProperty("user.dir") + "\\Mysqlutils\\mysqldump.exe";
//            }
//        
//        
//        try {
//            Runtime.getRuntime().exec("Cmd /c \"" + mysqlPath + "/mysqldump\" " +
//                    "-u " + prop.getUsername() + " " +
//                    "--password=" + prop.getPassword() + " " +
//                    "TutionDB -r " +
//                    "" + fileLocation + "");
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        BackupDatabase();
    }
    private int STREAM_BUFFER = 512000;

    public boolean BackupDatabase() {
        boolean success = false;



        try {
            FileInputStream condata1 = new FileInputStream(System.getProperty("user.dir") + "/data1.dat");

            ObjectInputStream input = new ObjectInputStream(condata1);
            Property prop = (Property) input.readObject();
            input.close();

            // Get SQL DUMP data
            String dump = getServerDumpData(prop.getHost(), prop.getPort(), prop.getUsername(), prop.getPassword(), "TutionDB");
            if (!dump.isEmpty()) {        // or check length like dump.length() > 256
                byte[] data = dump.getBytes();
                // Set backup folder, this is just an example

                //String rootpath = System.getProperty("user.dir") + "\\backup\\"; original code
                String rootpath = "C:\\sqlbackups\\";
                if (isOSX()) {
                    rootpath = "C:/sqlbackups/";
                }
                // See if backup folder exists
                File file1 = new File(rootpath);
                if (!file1.isDirectory()) {
                    // Create backup folder when missing. Write access is needed.
                    file1.mkdir();
                }
                // Compose full path, create a filename as you wish
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String filepath = rootpath + "backup-" + dateFormat.format(date) + ".sql";
                // Write SQL DUMP file
                File filedst = new File(filepath);
                FileOutputStream dest = new FileOutputStream(filedst);
                dest.write(data);
                dest.close();
                success = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }

    public String getServerDumpData(String host, String port, String user, String password, String db) {
        StringBuilder dumpdata = new StringBuilder();
        String execline = "";
        try {
            if (host != null && user != null && password != null && db != null) {
                // Set path. Set location of mysqldump 
                //  For example: current user folder and Mysqlutils subfolder             
                if (isOSX()) {
                    execline = System.getProperty("user.dir") + "/Mysqlutils/mysqldump";
                } else {
                    execline = System.getProperty("user.dir") + "\\Mysqlutils\\mysqldump.exe";
                }
                // Usage: mysqldump [OPTIONS] database [tables]
                // OR     mysqldump [OPTIONS] --databases [OPTIONS] DB1 [DB2 DB3...]
                // OR     mysqldump [OPTIONS] --all-databases [OPTIONS]
                String command[] = new String[]{execline,
                    "--host=" + host,
                    "--port=" + port,
                    "--user=" + user,
                    "--password=" + password,
                    //                            "--compact",
                    //                            "--complete-insert",
                    //                            "--extended-insert",
                    //                            "--skip-comments",
                    //                            "--skip-triggers",
                    db
                };

                // Run mysqldump
                ProcessBuilder pb = new ProcessBuilder(command);
                Process process = pb.start();

                InputStream in = process.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                int count;
                char[] cbuf = new char[STREAM_BUFFER];

                // Read datastream
                while ((count = br.read(cbuf, 0, STREAM_BUFFER)) != -1) {
                    dumpdata.append(cbuf, 0, count);
                }
                // Close
                br.close();
                in.close();
            }

        } catch (Exception ex) {
            // Handle exception as you wish
            ex.printStackTrace();
            return "";
        }
        return dumpdata.toString();
    }
// Add some code to it when you need to look for Android, Windows, OS X etc. versions...
    private boolean isOSX() {
        String lcOSName = System.getProperty("os.name").toLowerCase();
        return lcOSName.startsWith("mac os x");
    }
}
