
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
 * Author JInternalFrame gives information about author
 * 
 * @author syky
 */
public class Author extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;
    JButton emailButton = new JButton("Email me");
    JButton twitterButton = new JButton("Follow me");
    JButton aboutButton = new JButton("about.me");
    JPanel bottomPanel = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.BLACK);

    JLabel infoLabel = new JLabel(  "<html><div style=\\\"text-align: center;\\\"><font size=+2>"
                                    + "<b>Tomáš Sýkora, jr.</b><br>"
                                    + "This program was created with goal to eliminate stupid paperwork "
                                    
                                    + "</html>");
    

    

    
    /**
     *
     * Makes Author object
     * 
     * @param CounterJInternalFrame, takes control of placing the new frame shifted so you can see bit of the earlier frame
     */
    public Author(int CounterJInternalFrame) {
        super("Frame #" + CounterJInternalFrame + " About Author",  
                            false, // resizable
                            true, // closable
                            false, // maximizable
                            true);// iconifiable
                            setSize(400, 350);
			// Set the window's location.
	setLocation(xPosition * CounterJInternalFrame , yPosition * CounterJInternalFrame );
        initAuthor();

    }

    /**
     * This is just helping method called in constructor
     */
    protected void initAuthor() {
        twitterButton.addActionListener(new TwitterAction());
        emailButton.addActionListener(new EmailAction());
        aboutButton.addActionListener(new AboutAction());
        bottomPanel.add(emailButton);
        bottomPanel.add(twitterButton);
        bottomPanel.add(aboutButton);
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
    
        static class AboutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                URL myURL = new URL("http://about.me/Tomas.Sykora");

                openWebpage(myURL);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Helps open webpage
     * 
     * @param uri, takes URI, makes it work in browser
     */
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

    /**
     * Opening URL
     * 
     * @param url, opening this URL in default browse
     */
    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
