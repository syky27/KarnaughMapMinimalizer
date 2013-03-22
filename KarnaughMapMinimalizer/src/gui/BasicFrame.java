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
    
        protected JFrame frame = new JFrame("Minimalizer");
        protected JMenuBar menubar = new JMenuBar();
        protected JMenu file = new JMenu("File");
        protected JMenu edit = new JMenu("Edit");
        protected JMenu about = new JMenu("About");
        protected JMenu fnc = new JMenu("Logic Functions...");
        protected JMenuItem exit = new JMenuItem("Exit");
        protected JMenuItem author = new JMenuItem("Author");
        protected JMenuItem fnc3 = new JMenuItem("3 Functions");
        protected JMenuItem fnc4 = new JMenuItem("4 Functions");
        protected JMenuItem fnc5 = new JMenuItem("5 Functions");
        protected JMenuItem fnc6 = new JMenuItem("May be continued...");
        
        protected MapButton x = new MapButton();
        
        protected final JButton button = new JButton("1");

    public BasicFrame() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setJMenuBar(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(about);
        
        file.add(exit);
        file.add(fnc);
        fnc.add(fnc3);
        fnc.add(fnc4);
        fnc.add(fnc5);
        fnc.add(fnc6);
        
        about.add(author); 
        frame.add(x.button);

        
    exit.addActionListener(new ExitAction());
    author.addActionListener(new AuthorAction());
    
    }
    
    public void assignButton(JButton button){
        this.frame.add(button);
    }
    
    
    static class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    static class AuthorAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(1);
        }
    }

        
    

    public void  getTestingButton() {
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

        
        
  
        
        
        
        
        
    }
}


