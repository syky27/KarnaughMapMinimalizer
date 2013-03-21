/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
        final JButton button = new JButton("1");
        
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
    
        
        // ---------------------TEST!!!!-------------------//
        
        button.addMouseListener(new MouseAdapter(){
            boolean pressed;

            @Override
            public void mousePressed(MouseEvent e) {
                button.getModel().setArmed(true);
                button.getModel().setPressed(true);
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //if(isRightButtonPressed) {underlyingButton.getModel().setPressed(true));
                button.getModel().setArmed(false);
                button.getModel().setPressed(false);

                if (pressed) {
                    if (SwingUtilities.isLeftMouseButton(e) && !("1".equals(button.getText()))) {
                        button.setText("1");
                    }else if(SwingUtilities.isLeftMouseButton(e) && ("1".equals(button.getText()))){
                        button.setText("0");
                    } 
                    else {
                        button.setText("X");
                    }
                }
                pressed = false;

            }

            @Override
            public void mouseExited(MouseEvent e) {
                pressed = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pressed = true;
            }                    
        });
        frame.add(button);

        
        
        
        
        
        
        
        
    }
}


