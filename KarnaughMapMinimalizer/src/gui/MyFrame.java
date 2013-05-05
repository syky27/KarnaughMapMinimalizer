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
    }

    public static void addJIn(JInternalFrame f) {
        jdpDesktop.add(f);
    }

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

    @Override
    public void run() {


        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);
        jdpDesktop.setDragMode(2000000000); //Makes dragging faster
        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");

        
        DrawMenu();
        repaint();


    }

    static class ExitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class AuthorAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawAuthor();
        }
    }

    class Function4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drawFourFunction();

        }
    }
}
