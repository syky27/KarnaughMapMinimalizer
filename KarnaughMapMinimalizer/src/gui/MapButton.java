package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class MapButton {
    public JButton  button =  new JButton("0");

    public MapButton() {
    Font fontMapButton = new Font(button.getFont().getName(), button.getFont().getStyle(),30 );
    button.setFont(fontMapButton);
    button.addMouseListener(new MouseAdapter(){
            public boolean pressed;
     
            @Override
            public void mousePressed(MouseEvent e) {
                button.getModel().setArmed(true);
                button.getModel().setPressed(true);
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
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
    
    
    public String getText(){
        return button.getText();
    }
    
    
    
    
    
    
}
