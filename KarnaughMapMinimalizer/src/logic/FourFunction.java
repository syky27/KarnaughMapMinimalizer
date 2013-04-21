package logic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
//import sun.net.www.content.image.jpeg;

public class FourFunction extends Evaluation{

     public FourFunction(int f_0, int f_1, int f_2, int f_3, int f_4, int f_5, int f_6, int f_7, int f_8, int f_9, int f_10, int f_11, int f_12, int f_13, int f_14, int f_15) {
        
        super.matrix.put("0", f_0);
        super.matrix.put("1", f_1);
        super.matrix.put("2", f_2);
        super.matrix.put("3", f_3);
        super.matrix.put("4", f_4);
        super.matrix.put("5", f_5);
        super.matrix.put("6", f_6);
        super.matrix.put("7", f_7);
        super.matrix.put("8", f_8);
        super.matrix.put("9", f_9);
        super.matrix.put("10", f_10);
        super.matrix.put("11", f_11);
        super.matrix.put("12", f_12);
        super.matrix.put("13", f_13);
        super.matrix.put("14", f_14);
        super.matrix.put("15", f_15);
        
        
    
    }
     
     
    
     
    
     
    

 public JFrame getResult(){
           JFrame result = new JFrame("Result");
           result.setSize(640, 480);
           result.setVisible(true);
           
           int x;
           x =  super.matrix.get(1);
           
           
           JButton j = new JButton(Integer.toString(x));
           result.add(j);
           
           return result;
     }
 
 
}