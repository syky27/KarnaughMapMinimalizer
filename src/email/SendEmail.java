package email;

import javax.swing.JOptionPane;


/**
 * Simple class designed to Auto-Send Email, unfortunately Java SE doesn't support it. 
 *
 * @author Tomas Sykora, jr
 * 
 * 
 */
public class SendEmail {

    /**
     * Just Alert Frame, to let you know what is going on.
     */
    public SendEmail() {
        
    JOptionPane.showMessageDialog(null,"Sorry, I know it's sad but JAVA SE does not support Java Mail API, so if you \n"
                                  + "really want to contact me you just need to email me on sykorto6@fit.cvut.cz",
                                  "Arrrgh!!! E-mail could'n be sent!!!",  JOptionPane.ERROR_MESSAGE);
    }
 
    
    

}