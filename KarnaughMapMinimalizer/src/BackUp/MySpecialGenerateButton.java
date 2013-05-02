/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author syky
 */
public class MySpecialGenerateButton extends JButton{

    public MySpecialGenerateButton() {
        super("Generate");
         addMouseListener(new MouseAdapter(){
            boolean pressed;
     
            @Override
            public void mousePressed(MouseEvent e) {
                getModel().setArmed(true);
                getModel().setPressed(true);
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                getModel().setArmed(false);
                getModel().setPressed(false);

                if (pressed) {
                   
                    
                    //TODO: Calculate
                    
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
