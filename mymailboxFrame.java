/*
 * Edit By Alexander Eric
 * Library: SUN
 */



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.mail.DefaultMetalTheme;
import javax.swing.plaf.mail.MetalTheme;
import javax.swing.plaf.mail.OceanTheme;

@SuppressWarnings("serial")
public final class mymailFrame extends JFrame {

    JMenuBar menuBar;
    JDesktopPane desktop;
    JInternalFrame toolPalette;
    JCheckBoxMenuItem showToolPaletteMenuItem;
    static final Integer DOCLAYER = 5;
    static final Integer TOOLLAYER = 6;
    static final Integer HELPLAYER = 7;
    static final String ABOUTMSG = "mymail \n \nSoftware known as MailBox Server. "
            + "This is a sample tools. \n \nWrittern by Alexander Eric, Trainee of glowfreelancer "
            + "MailBox System Software \n  By Alexander Eric,Trainee of GlowFreelancer\n  Hosted by Malaysia Goverment\n  "
            + "Mail Box System\n  v 1.0.0";

    public mymailFrame() {
        super("mymail");
        final int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset
                * 2);
        buildContent();
        buildMenus();
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
        UIManager.addPropertyChangeListener(new UISwitchListener(
                (JComponent) getRootPane()));
    }

    protected void buildMenus() {
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        JMenu file = buildFileMenu();
        JMenu edit = buildEditMenu();
        JMenu views = buildViewsMenu();
        JMenu speed = buildSpeedMenu();
        JMenu help = buildHelpMenu();

        MetalTheme myTheme = null;
        try {
            InputStream istream = getClass().getResourceAsStream(
                    "/resources/MyTheme.theme");
            myTheme = new PropertiesMetalTheme(istream);
        } catch (NullPointerException e) {
            System.out.println(e);
        }


        MetalTheme[] themes = { new OceanTheme(),
            new DefaultMetalTheme(),
            new GreenMetalTheme(),
            new AquaMetalTheme(),
            new KhakiMetalTheme(),
            new DemoMetalTheme(),
            new ContrastMetalTheme(),
            new BigContrastMetalTheme(),
            myTheme };

        JMenu themeMenu = new MetalThemeMenu("Theme", themes);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(views);
        menuBar.add(themeMenu);
        menuBar.add(speed);
        menuBar.add(help);
        setJMenuBar(menuBar);
    }

    protected JMenu buildFileMenu() {
        JMenu file = new JMenu("File");
        JMenuItem newWin = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");

        newWin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                newDocument();
            }
        });

        open.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openDocument();
            }
        });

        quit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });

        file.add(newWin);
        file.add(open);
        file.addSeparator();
        file.add(quit);
        return file;
    }

    protected JMenu buildEditMenu() {
        JMenu edit = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem prefs = new JMenuItem("Preferences...");

        undo.setEnabled(false);
        copy.setEnabled(false);
        cut.setEnabled(false);
        paste.setEnabled(false);

        prefs.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openPrefsWindow();
            }
        });

        edit.add(undo);
        edit.addSeparator();
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(prefs);
        return edit;
    }

    protected JMenu buildViewsMenu() {
        JMenu views = new JMenu("Views");

        JMenuItem inBox = new JMenuItem("Open In-Box");
        JMenuItem outBox = new JMenuItem("Open Out-Box");
        outBox.setEnabled(false);

        inBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openInBox();
            }
        });

        views.add(inBox);
        views.add(outBox);
        return views;
    }

    protected JMenu buildSpeedMenu() {
        JMenu speed = new JMenu("Drag");

        JRadioButtonMenuItem live = new JRadioButtonMenuItem("Live");
        JRadioButtonMenuItem outline = new JRadioButtonMenuItem("Outline");

        JRadioButtonMenuItem slow = new JRadioButtonMenuItem("Old and Slow");

        ButtonGroup group = new ButtonGroup();

        group.add(live);
        group.add(outline);
        group.add(slow);

        live.setSelected(true);

        slow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                desktop.setDragMode(-1);
            }
        });

        live.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
            }
        });

        outline.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
            }
        });


        speed.add(live);
        speed.add(outline);
        speed.add(slow);
        return speed;
    }

    protected JMenu buildHelpMenu() {
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About mymail...");
        JMenuItem openHelp = new JMenuItem("Open Help Window");

        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                showAboutBox();
            }
        });

        openHelp.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                openHelpWindow();
            }
        });

        help.add(about);
        help.add(openHelp);

        return help;
    }

    protected void buildContent() {
        desktop = new JDesktopPane();
        getContentPane().add(desktop);
    }

    public void quit() {
        System.exit(0);
    }

    public void newDocument() {
        JInternalFrame doc = new mymailDocumentFrame();
        desktop.add(doc, DOCLAYER);
        try {
            doc.setVisible(true);
            doc.setSelected(true);
        } catch (java.beans.PropertyVetoException e2) {
        }
    }

    public void openDocument() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(this);
    }

    public void openHelpWindow() {
        JInternalFrame help = new mymailHelp();
        desktop.add(help, HELPLAYER);
        try {
            help.setVisible(true);
            help.setSelected(true);
        } catch (java.beans.PropertyVetoException e2) {
        }
    }

    public void showAboutBox() {
        JOptionPane.showMessageDialog(this, ABOUTMSG);
    }

    public void openPrefsWindow() {
        mymailPrefs dialog = new mymailPrefs(this);
        dialog.setVisible(true);

    }

    public void openInBox() {
        JInternalFrame doc = new mymailInBox();
        desktop.add(doc, DOCLAYER);
        try {
            doc.setVisible(true);
            doc.setSelected(true);
        } catch (java.beans.PropertyVetoException e2) {
        }
    }
}
