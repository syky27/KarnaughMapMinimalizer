package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.beans.PropertyVetoException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameEvent;
import test.NewJFrame;

public class MainFrame extends JInternalFrame {
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

        static final int xPosition = 30, yPosition = 30;

    private Icon topPNG;
    private Icon leftPNG;
    
    public MainFrame() {
        super("IFrame #" ,  false, // resizable
                            true, // closable
                            false, // maximizable
                            true);// iconifiable
                         setSize(640, 480);
			// Set the window's location.
			setLocation(xPosition + 30 , yPosition + 30 );
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
        
        
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        
       

        topPanel.add(iconLabel);
        leftPanel.add(leftIconLabel);
        
        
        bottomPanel.add(generateButton);
        
        
        add(leftPanel, BorderLayout.WEST);
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        
        add(mapPanel);
        setVisible(true);
        //setLocationRelativeTo( null );
        
        
       

        
    }
   void internalFrameClosed(InternalFrameEvent e){
       this.setVisible(false); 
       this.dispose();
     
        
        
         }


}


