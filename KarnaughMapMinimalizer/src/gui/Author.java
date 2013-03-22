/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author syky
 */
public class Author extends BasicFrame{
 
    JButton emailButton = new JButton("Email me");
    JButton twitterButton = new JButton("Follow me");
    JPanel bottomPanel = new JPanel();
    

    

    public Author() {
        setFrame();
        
    }

    
    protected void setFrame(){
        bottomPanel.add(emailButton);
        bottomPanel.add(twitterButton);
        super.frame.add(bottomPanel, BorderLayout.SOUTH);
        
    }
    
    
   
}
