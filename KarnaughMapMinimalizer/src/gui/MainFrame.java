package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import test.NewJFrame;

public class MainFrame extends BasicFrame {
    JPanel topPanel =  new JPanel();
    JPanel leftPanel =  new JPanel();
    JPanel bottomPanel =  new JPanel();
    JButton generateButton = new JButton("Generate");
    
    JPanel mapPanel = new JPanel();
    MapButton but_0 = new MapButton();
    MapButton but_1 = new MapButton();
    MapButton but_2 = new MapButton();
    MapButton but_3 = new MapButton();
    MapButton but_4 = new MapButton();
    MapButton but_5 = new MapButton();
    MapButton but_6 = new MapButton();
    MapButton but_7 = new MapButton();
    MapButton but_8 = new MapButton();
    MapButton but_9 = new MapButton();
    MapButton but_10 = new MapButton();
    MapButton but_11 = new MapButton();
    MapButton but_12 = new MapButton();
    MapButton but_13 = new MapButton();
    MapButton but_14 = new MapButton();
    MapButton but_15 = new MapButton();

    
    private Icon topPNG;
    private Icon leftPNG;
    
    public MainFrame() {
        initGui();
    }

    private void initGui() {
        //mapPanel.setBorder(BorderFactory.createEmptyBorder(1,1));
         int x = 200;
         int y = 200;
        mapPanel.setLayout(new GridLayout(4, 4, 4, 4));
        mapPanel.setSize(new Dimension(200, 200));
        mapPanel.add(but_0.button);
        mapPanel.add(but_4.button);
        mapPanel.add(but_12.button);
        mapPanel.add(but_8.button);
        mapPanel.add(but_1.button);
        mapPanel.add(but_5.button);
        mapPanel.add(but_13.button);
        mapPanel.add(but_9.button);
        mapPanel.add(but_3.button);
        mapPanel.add(but_7.button);
        mapPanel.add(but_15.button);
        mapPanel.add(but_11.button);
        mapPanel.add(but_2.button);
        mapPanel.add(but_6.button);
        mapPanel.add(but_14.button);
        mapPanel.add(but_10.button);


        
        URL topPicDest = this.getClass().getResource("/pic/vrchniPanel.png");
        topPNG = new ImageIcon(topPicDest);
        JLabel iconLabel = new JLabel(topPNG);

        URL leftPicDest = this.getClass().getResource("/pic/leftPanel.png");
        leftPNG = new ImageIcon(leftPicDest);
        JLabel leftIconLabel = new JLabel(leftPNG);
        
        
                
        topPanel.add(iconLabel);
        leftPanel.add(leftIconLabel);
        
        
        bottomPanel.add(generateButton);
        
        
        super.frame.add(leftPanel, BorderLayout.WEST);
        super.frame.add(topPanel,BorderLayout.NORTH);
        super.frame.add(bottomPanel, BorderLayout.SOUTH);
        
        super.frame.add(mapPanel);
        super.frame.setVisible(true);
        super.frame.setLocationRelativeTo( null );



        
    }
}
