package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * This class represents the main frame in program, it also runs it in new thread
 * 
 * @author syky
 */
public class MyFrame extends JFrame implements Runnable {

    public static int CounterJInternalFrame = 0;
    static JDesktopPane jdpDesktop;
    private JMenuBar menubar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu edit = new JMenu("Edit");
    private JMenu about = new JMenu("About");
    private JMenu fnc = new JMenu("Logic Functions...");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem author = new JMenuItem("Author");
    private JMenuItem license = new JMenuItem("License");
    private JMenuItem fnc4 = new JMenuItem("4 Functions");
    private JMenuItem fnc6 = new JMenuItem("May be continued...");
    private JMenuItem history = new JMenuItem("History");

    /**
     * Constructor for MyFrame, building new object and runs new threads
     * 
     */
    public MyFrame() {
        super("Karnagh Map Minimalizer Designed by Tomas Sykora, jr.");


        // Make the main window positioned as 50 pixels from each edge of the
        // screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        

        Thread MyFrameThread = new Thread(this);
        MyFrameThread.start();

        drawFourFunction(); // Create first window

    }

    /**
     *
     * DrawMenu is designed for drawing the top menu
     * 
     */
    public void DrawMenu() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setJMenuBar(menubar);
        setLocationRelativeTo(null);
        menubar.add(file);
        menubar.add(about);


        file.add(fnc);
        file.add(exit);
        edit.add(history);

        fnc.add(fnc4);
        fnc.add(fnc6);
        about.add(author);
        about.add(license);

        exit.addActionListener(new ExitAction());
        author.addActionListener(new AuthorAction());
        fnc4.addActionListener(new Function4Action());
        license.addActionListener(new LicenseAction());
    }

  

    /**
     * 
     * drawFourFunction gives you JInternalFrame with gui to manage your boolean expression 
     * 
     */
    protected void drawFourFunction() {
        CounterJInternalFrame++;
        FourLogicFrame ff = new FourLogicFrame(CounterJInternalFrame);
        ff.setVisible(true);
        jdpDesktop.add(ff);


        try {
            ff.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    /**
     *
     * drawAuthor draws JInternalFrame containing info about Author
     * 
     */
    protected void drawAuthor() {
        CounterJInternalFrame++;
        Author a = new Author(CounterJInternalFrame);
        a.setVisible(true);
        jdpDesktop.add(a);
        try {
            a.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    /**
     * Overriding method run inherited from class Runnable to run new thread
     * 
     */
    @Override
    public void run() {


        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);
        jdpDesktop.setDragMode(2000000000); //Makes dragging faster
        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");

        
        DrawMenu();
        repaint();


    }
    /**
     * 
     * Makes the application to close and kill all the threads
     * 
     */
    static class ExitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    /**
     * 
     * Handling menu item Author
     * 
     */
    class AuthorAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawAuthor();
        }
    }
    
     /**
     * 
     * Handling menu item License
     * 
     */
    class LicenseAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawLicense();
        }

    }
    
    
     /**
     * Draws license JInternalFrame
     */
    protected void drawLicense() {
        CounterJInternalFrame++;
        License a = new License(CounterJInternalFrame);
        a.setVisible(true);
        jdpDesktop.add(a);
        try {
            a.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }
    
     /**
     * 
     * drawFourFunction gives you JInternalFrame with gui to manage your boolean expression, when menu item is pressed
     * 
     */
    class Function4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawFourFunction();

        }
    }
}
