package email;

import java.util.Properties;
import javax.swing.JOptionPane;

public class SendEmail {

    public SendEmail() {
        
    JOptionPane.showMessageDialog(null,"Sorry, I know it's sad but JAVA SE does not support Java Mail API, so if you \n"
                                  + "really want to contact me you just need to email me on sykorto6@fit.cvut.cz",
                                  "Arrrgh!!! E-mail could'n be sent!!!",  JOptionPane.ERROR_MESSAGE);
    }
 
    
    

}