/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackUp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 *
 * @author syky
 */



public class BasicFrame {

    protected JFrame frame = new JFrame("Minimalizer");
    protected JMenuBar menubar = new JMenuBar();
    protected JMenu file = new JMenu("File");
    protected JMenu edit = new JMenu("Edit");
    protected JMenu about = new JMenu("About");
    protected JMenu fnc = new JMenu("Logic Functions...");
    
    protected JMenuItem exit = new JMenuItem("Exit");
    protected JMenuItem author = new JMenuItem("Author");
    protected JMenuItem license = new JMenuItem("License");
    protected JMenuItem fnc3 = new JMenuItem("3 Functions");
    protected JMenuItem fnc4 = new JMenuItem("4 Functions");
    protected JMenuItem fnc5 = new JMenuItem("5 Functions");
    protected JMenuItem fnc6 = new JMenuItem("May be continued...");
    protected JMenuItem history = new JMenuItem("History");
    protected MapButton x = new MapButton();
    protected final JButton button = new JButton("1");

    
    public void Destructor() throws Throwable{
        this.frame.setVisible(false);
        this.finalize();
    }
    
    public BasicFrame() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
     
        frame.setSize(640, 480);
        frame.setResizable(true);
        frame.setJMenuBar(menubar);
        frame.setLocationRelativeTo( null );
        
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
        //frame.add(x.button);
       

        //listerners for menu button actions
        exit.addActionListener(new ExitAction());
        
        author.addActionListener(new AuthorAction());
        
        fnc4.addActionListener(new Function4Action());

    }

    protected void assignComponemtToFrame(JButton button) {
        frame.add(button);
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
 //           Author author = new Author();
            frame.add(author);
            
        }
    }
    

    
    class Function4Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
           
           
    //       MainFrame mainframe = new MainFrame();
           
           
       //    frame.add(mainframe);
            frame.setVisible(true);
            frame.setSize(640, 500);
            
        }
    }
}

