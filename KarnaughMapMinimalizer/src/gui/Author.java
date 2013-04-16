/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import email.SendEmail;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author syky
 */
public class Author extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;
    JButton emailButton = new JButton("Email me");
    JButton twitterButton = new JButton("Follow me");
    JPanel bottomPanel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.BLACK);

    JLabel infoLabel = new JLabel(  "<html><font size=+2>"
                                    + "<b>Tomáš Sýkora, jr.</b><br>"
                                    + "This program was created with goal to help Harware "
                                    + "students on ČVUT FIT, I hope you guys will enjoy it"
                                    + "</html>");
    

    

    
    public Author(int CounterJInternalFrame) {
        super("IFrame #" + CounterJInternalFrame ,  
                            false, // resizable
                            true, // closable
                            false, // maximizable
                            true);// iconifiable
                            setSize(640, 480);
			// Set the window's location.
	setLocation(xPosition * CounterJInternalFrame , yPosition * CounterJInternalFrame );
        initAuthor();

    }

    protected void initAuthor() {
        twitterButton.addActionListener(new TwitterAction());
        emailButton.addActionListener(new EmailAction());
        bottomPanel.add(emailButton);
        bottomPanel.add(twitterButton);
        //infoLabel.setBorder(border);
        infoLabel.setPreferredSize(new Dimension(500,400));
        infoLabel.setHorizontalTextPosition(JLabel.CENTER);
        infoLabel.setVerticalTextPosition(JLabel.CENTER);
        
        
        add(infoLabel);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

       
    }

    
        static class EmailAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           SendEmail x = new SendEmail();

        }
    }

    
    
    static class TwitterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                URL myURL = new URL("http://www.twitter.com/syky27");

                openWebpage(myURL);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
