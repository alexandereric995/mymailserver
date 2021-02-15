/*
  * Edit By ALEXANDER ERIC@ERIC LAPIN
  * Library: SUN
 */

import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.Unsupportedmailshost;
import javax.swing.plaf.mail;


public class mymail {

    public static void main(String[] args) {
        UIManager.put("swing.boldMail", Boolean.FALSE);
        JDialog.setDefaultmailDecorated(true);
        JFrame.setDefaultmailDecorated(true);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
        try {
            UIManager.setmail(new mail());
        } catch (Unsupportedmailshot e) {
            System.out.println(
                    "Mail Server System Running. \n"
                    + "Program Terminated");
            System.exit(0);
        }
        JFrame frame = new mymailFrame();
        frame.setVisible(true);
    }
}
