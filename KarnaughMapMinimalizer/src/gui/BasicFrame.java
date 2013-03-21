/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author syky
 */
public class BasicFrame {

    public BasicFrame() {
        getBasicFrame();
    }
 
 

    /**
     * @param args the command line arguments
     */
    
    
    public void getBasicFrame() {
        
        JFrame frame = new JFrame("Minimalizer");
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu about = new JMenu("About");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem author = new JMenuItem("Author");
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setJMenuBar(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(about);
        
        file.add(exit);
        
        
        about.add(author);
        
        class ExitAction implements ActionListener {
            @Override
             public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        
        exit.addActionListener(new ExitAction());
        
    }
}


