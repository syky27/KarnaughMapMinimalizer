package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logic.FourFunction;

public class FourFunctionFrame extends JInternalFrame {
    
    
    
    JPanel topPanel =  new JPanel();
    JPanel leftPanel =  new JPanel();
    JPanel bottomPanel =  new JPanel();
    JButton generateButtonBOOL = new JButton("Generate Boolean Algebra");
    JButton generateButtonVHDL = new JButton("Generate VHDL");
    
    //MySpecialGenerateButton generateButton = new MySpecialGenerateButton();
    
    
    
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
    
    public FourFunctionFrame(int CounterJInternalFrame) {
        super("IFrame #" + CounterJInternalFrame ,  
                            false, // resizable
                            true, // closable
                            false, // maximizable
                            true);// iconifiable
                            setSize(640, 480);
			// Set the window's location.
	setLocation(xPosition * CounterJInternalFrame , yPosition * CounterJInternalFrame );
        initMap();
    }

   
    
    private void initMap() {
         int x = 200;
         int y = 200;
        mapPanel.setLayout(new GridLayout(4, 4, 4, 4));
        mapPanel.setSize(new Dimension(200, 200));
        
        mapPanel.add(but_0.button);
        mapPanel.add(but_1.button);
        mapPanel.add(but_3.button);
        mapPanel.add(but_2.button);

        
        
        mapPanel.add(but_4.button);
        mapPanel.add(but_5.button);
        mapPanel.add(but_7.button);
        mapPanel.add(but_6.button);
        
        
        mapPanel.add(but_12.button);
        mapPanel.add(but_13.button);
        mapPanel.add(but_15.button);
        mapPanel.add(but_14.button);
        
        mapPanel.add(but_8.button);
        mapPanel.add(but_9.button);
        mapPanel.add(but_11.button);
        mapPanel.add(but_10.button);
        
        

        
        
        
        
        
        

        //top picture
        URL topPicDest = this.getClass().getResource("/pic/vrchniPanel.png");
        topPNG = new ImageIcon(topPicDest);
        JLabel iconLabel = new JLabel(topPNG);
        topPanel.add(iconLabel);
        add(topPanel,BorderLayout.NORTH);

        //left picture
        URL leftPicDest = this.getClass().getResource("/pic/leftPanel.png");
        leftPNG = new ImageIcon(leftPicDest);
        JLabel leftIconLabel = new JLabel(leftPNG);
        leftPanel.add(leftIconLabel);
        add(leftPanel, BorderLayout.WEST);
        
        
        generateButtonVHDL.addActionListener(new GenerateVHDL());
        
        bottomPanel.add(generateButtonBOOL);
        bottomPanel.add(generateButtonVHDL);
        add(bottomPanel, BorderLayout.SOUTH);
        
        add(mapPanel);
        setVisible(true);
           
            
};
    
    
   class GenerateVHDL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        FourFunction ev = new FourFunction( Integer.parseInt(but_0.button.getText()),
                                            Integer.parseInt(but_1.button.getText()),
                                            Integer.parseInt(but_2.button.getText()),
                                            Integer.parseInt(but_3.button.getText()),
                                            Integer.parseInt(but_4.button.getText()),
                                            Integer.parseInt(but_5.button.getText()),
                                            Integer.parseInt(but_6.button.getText()),
                                            Integer.parseInt(but_7.button.getText()),
                                            Integer.parseInt(but_8.button.getText()),
                                            Integer.parseInt(but_9.button.getText()),
                                            Integer.parseInt(but_10.button.getText()),
                                            Integer.parseInt(but_11.button.getText()),
                                            Integer.parseInt(but_12.button.getText()),
                                            Integer.parseInt(but_13.button.getText()),
                                            Integer.parseInt(but_14.button.getText()),
                                            Integer.parseInt(but_15.button.getText()));
            
        
        JFrame s = ev.getResult();
        
        
        
        
       
        }
    } 
    
    
        
}
    



