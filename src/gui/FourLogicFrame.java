package gui;

import FourLogic.FourEval;
import FourLogic.FourEvalOperations;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * Class to which object is frame with minimalization gui
 * @author Tomas Sykora, jr
 */
public class FourLogicFrame extends JInternalFrame implements Runnable{

    private JLabel[] label;
    private JPanel homepanel;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel1;
    private JLabel label2;
    private JPanel panel4;
    private JLabel p1_label;
    private FourEvalOperations op;
    private FourEval[] qm_elements;
    private ArrayList<FourEval> set;
    private int x, inc;
    static final int xPosition = 30, yPosition = 30;

    /**
     * Creating new FourlogicFrame
     * 
     * @param CounterJInternalFrame, takes control of placing the new frame shifted so you can see bit of the earlier frame
     */
    public FourLogicFrame(int CounterJInternalFrame) {
        super("Frame #" + CounterJInternalFrame + " Logic Solver");
        this.setResizable(false);
        this.setClosable(true);
        this.setMaximizable(false);
        this.setIconifiable(true);


        setLocation(xPosition * CounterJInternalFrame, yPosition * CounterJInternalFrame);


        Thread FourLogicFrameThread = new Thread(this);
        FourLogicFrameThread.start();
        
    }
    /**
     * Overriding method run inherited from class Runnable to run new thread
     * 
     * 
     */
    @Override
    public void run() {
        
        op = new FourEvalOperations();
        GenerateSOP();

        label = new JLabel[16];
        homepanel = new JPanel();
        MouseHandler ml = new MouseHandler();


        panel2 = new JPanel();
        panel2.add(homepanel);
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        label2 = new JLabel();
        JLabel w = new JLabel("CD          00");

        w.setFont(new Font("A", Font.BOLD, 30));
        JLabel u = new JLabel("            01");

        u.setFont(new Font("A", Font.BOLD, 32));
        JLabel y = new JLabel("            11");

        y.setFont(new Font("A", Font.BOLD, 32));
        JLabel z = new JLabel("            10");

        z.setFont(new Font("A", Font.BOLD, 32));
        panel2.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 50, 0, 0);
        panel2.add(w, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;

        panel2.add(u, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel2.add(y, gbc);
        gbc.gridx = 6;
        gbc.gridy = 0;
        panel2.add(z, gbc);
        add(panel2, BorderLayout.NORTH);

        panel1 = new JPanel();
        //panel1.setBackground(Color.gray);
        panel1.setLayout(new GridLayout(4, 4));
        panel1.setPreferredSize(new Dimension(900, 300));
        p1_label = new JLabel("Here is your simplified expresion in VHDL");

        p1_label.setFont(new Font(panel1.getFont().getFontName(), p1_label.getFont().getStyle(), p1_label.getFont().getSize() - 2));


        panel3 = new JPanel();
        panel3.add(homepanel);
        panel3.add(p1_label);


        panel4 = new JPanel();
        panel4.add(homepanel);
        panel4.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.HORIZONTAL;

        w = new JLabel("AB  00");
        w.setFont(new Font("A", Font.BOLD, 30));
        u = new JLabel("      01");
        u.setFont(new Font("A", Font.BOLD, 32));
        y = new JLabel("      11");
        y.setFont(new Font("A", Font.BOLD, 32));
        z = new JLabel("      10");
        z.setFont(new Font("A", Font.BOLD, 32));
        panel4.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        panel4.add(w, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 1, 1, 1);
        panel4.add(u, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel4.add(y, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel4.add(z, gbc);


        add(panel4, BorderLayout.WEST);
        add(panel3, BorderLayout.SOUTH);
        for (int i = 0; i < 16; i++) {
            label[i] = new JLabel("0", (int) CENTER_ALIGNMENT);
            label[i].setFont(new Font("A", Font.BOLD, 80));
            label[i].setForeground(Color.blue);
            label[i].setBorder(LineBorder.createBlackLineBorder());
            label[i].addMouseListener(ml);
        }

        for (int i = 0, _x = 2, _inc = 3; i < 16; i++) {
            if (i < 8) {
                if (i % _x == 0 && i != 0) {
                    panel1.add(label[i + 1]);
                    panel1.add(label[i]);
                    _x = 2 * _inc;
                    _inc += 2;
                    i++;
                } else {
                    panel1.add(label[i]);
                }
            } else if (i >= 8 && i < 12) {
                if (i == 10) {
                    panel1.add(label[i + 5]); // switch column 14 15 <- 15 14
                    panel1.add(label[i + 4]); // observation regarding Gridlayout, I found something strange behaviour after adding 15 14 then add 15 result would be 14 15
                    i++;
                } else {
                    panel1.add(label[i + 4]);
                }
            } else {
                if (i == 14) {
                    panel1.add(label[i - 3]);
                    panel1.add(label[i - 4]);
                    i++;
                } else {
                    panel1.add(label[i - 4]);
                }
            }
        }
        

        panel1.setBorder(new EmptyBorder(new Insets(0, 0, 0, 0)));
        add(panel1, BorderLayout.CENTER);
        pack();
        setVisible(true);
        
    }

    /**
     *
     * Changing text label when the mouse button is triggered
     * 
     */
    public class MouseHandler extends MouseAdapter {

        int i;

        @Override
        public void mouseClicked(MouseEvent e) {
            for (i = 0; i < 16; i++) {
                if (e.getSource() == label[i]) {
                    break;
                }
            }
            if (i != 16) {
                if (label[i].getText().equals("0")) {
                    label[i].setText("1");
                } else {
                    label[i].setText("0");
                }
            }

            InitSet();
            for (i = 0; i < 16; i++) {
                if (label[i].getText().equals("1")) {
                    op.additem(set.get(2), qm_elements[i].product);
                    op.Qrec(set, 2);
                }
            }
            //p1_label.setText(op.CollectVar(set));

            String s = new String();
            s = op.CollectVar(set);

            if ("  +  +  + ".equals(s)) {
                s = "";

            } else {
                int index = 0;

                while (s.charAt(index) == ' ' || s.charAt(index) == '+') {

                    if (index - 1 == s.length()) {
                        break;
                    }
                    index++;
                }
                s = s.substring(index);



                index = s.length() - 1;

                while (s.charAt(index) == ' ' || s.charAt(index) == '+') {

                    if (index - 1 == s.length()) {
                        break;
                    }
                    index--;
                }


                s = s.substring(0, index);



                s = "( " + s + " )"; //Add ( and ) at the beginning and the end of boolean expresion

                s = s.replaceAll(" \\+ ", ") or (");

                if (s.contains(".")) {

                    s = s.replaceAll("\\.", " and ");
                }

                if (s.contains(")A")) {
                    s = s.replaceAll("\\)A", ") and A");
                }

                if (s.contains(")B")) {
                    s = s.replaceAll("\\)B", ") and B");
                }

                if (s.contains(")C")) {
                    s = s.replaceAll("\\)C", ") and C");
                }

                if (s.contains(")D")) {
                    s = s.replaceAll("\\)D", ") and D");
                }
                
                if (s.contains(")not")) {
                    s = s.replaceAll("\\)not", ") and not");
                }
                
                



            }

            
            p1_label.setText(s);
            
            
            



           
        }
    }

    /**
     *
     * Evaluating the expression
     * 
     */
    public void GenerateSOP() {
        qm_elements = new FourEval[16];
        int left, j;
        for (int i = 0; i < 16; i++) {
            qm_elements[i] = new FourEval();
            for (j = 4, left = i; j > 0; --j) {
                qm_elements[i].product[j - 1] = left % 2;
                left /= 2;
            }
            for (j = 0; j < 4; ++j) {
            }
        }
    }

    /**
     *
     * Initialization of memory
     * 
     */
    public void InitSet() {
        set = new ArrayList<FourEval>();
        for (int i = 0; i < 3; i++) {
            set.add(new FourEval());
        }
    }
}
