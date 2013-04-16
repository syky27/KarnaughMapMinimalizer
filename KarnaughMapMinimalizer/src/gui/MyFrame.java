package gui;
import javax.swing.*;
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

public class MyFrame extends JFrame{

    JDesktopPane jdpDesktop;
    static int CounterJInternalFrame = 0;
    
    private JMenuBar menubar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu edit = new JMenu("Edit");
    private JMenu about = new JMenu("About");
    private JMenu fnc = new JMenu("Logic Functions...");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem author = new JMenuItem("Author");
    private JMenuItem license = new JMenuItem("License");
    private JMenuItem fnc3 = new JMenuItem("3 Functions");
    private JMenuItem fnc4 = new JMenuItem("4 Functions");
    private JMenuItem fnc5 = new JMenuItem("5 Functions");
    private JMenuItem fnc6 = new JMenuItem("May be continued...");
    private JMenuItem history = new JMenuItem("History");
    		
		
    
    
    public MyFrame() {
        //CleanMyFrame();

        super("Karnagh Map Minimalizer");
        // Make the main window positioned as 50 pixels from each edge of the
        // screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2,
                screenSize.height - inset * 2);
        // Add a Window Exit Listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

       
        //Create and Set up the GUI.
        jdpDesktop = new JDesktopPane();
        // A specialized layered pane to be used with JInternalFrames
        setContentPane(jdpDesktop);
        //setJMenuBar(createMenuBar());
        // Make dragging faster by setting drag mode to Outline
        jdpDesktop.setDragMode(2000000000);
        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");

        createFrame(); // Create first window
        DrawMenu();
        repaint();
        
	//setJMenuBar(createMenuBar());
        //menubar.setMnemonic(KeyEvent.VK_N);
	//menuItem.setMnemonic(KeyEvent.VK_N);
    }

    
    protected void createFrame() {
                CounterJInternalFrame++;
		MainFrame frame = new MainFrame(CounterJInternalFrame);
		frame.setVisible(true);
		jdpDesktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}
    
   
    


    public void CleanMyFrame(){
        removeAll();
    }

    public void Destructor() throws Throwable{
        this.setVisible(false);
        this.finalize();

    }

    public void DrawMenu() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setJMenuBar(menubar);
        setLocationRelativeTo( null );
        menubar.add(file);
        menubar.add(edit);
        menubar.add(about);
        file.add(fnc);
        file.add(exit);
        edit.add(history);
        fnc.add(fnc3);
        fnc.add(fnc4);
        fnc.add(fnc5);
        fnc.add(fnc6);
        about.add(author);
        about.add(license);

        exit.addActionListener(new ExitAction());
        author.addActionListener(new AuthorAction());
        fnc4.addActionListener(new Function4Action());
    }

    
    protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Frame");
		menu.setMnemonic(KeyEvent.VK_N);
		JMenuItem menuItem = new JMenuItem("New IFrame");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				createFrame();
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
	}
    
    
    
    public void assignComponemtToFrame(JComponent comp) {
        this.add(comp);
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

            //Author a = new Author();
            Test a = new Test();

            add(a);
            setVisible(true);
        }
    }



     class Function4Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            CounterJInternalFrame++;
            
            
            createFrame();

//            MainFrame mainframe = new MainFrame();
//            setVisible(true);
//            setSize(640, 480);
        }
    }
     
    
     
     
}
