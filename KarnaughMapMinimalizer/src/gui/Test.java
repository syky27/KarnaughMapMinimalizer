package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Test extends JPanel {

   JButton but = new JButton("bullshit");
    private Icon leftPNG;





    Test(){
        URL leftPicDest = this.getClass().getResource("/pic/leftPanel.png");
        leftPNG = new ImageIcon(leftPicDest);
        JLabel leftIconLabel = new JLabel(leftPNG);

      
        
        
        this.add(leftIconLabel, BorderLayout.WEST);






    }




}
