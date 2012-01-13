package tuition;

import javax.swing.UIManager;
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            Loading l = new Loading();
            l.setVisible(true);
            l.LoadValues();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
