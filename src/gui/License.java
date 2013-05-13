package gui;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 * Class designed to handle License JInternalFrame
 * @author syky
 */
public class License extends JInternalFrame {

    static final int xPosition = 30, yPosition = 30;
    JLabel infoLabel = new JLabel("<html><div style=\\\"text-align: center;\\\"><font size=-1>"
            + "Copyright (c) 2013, <b>Tomas Sykora</b> <jump@syky.cz>\n"
            + "\n"
            + "\n"
            + "\n"
            + "Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted, provided that the above copyright notice and this permission notice appear in all copies.\n"
            + "\n"
            + "\n"
            + "<br>"
                        + "<br>"

            + "THE SOFTWARE IS PROVIDED \"AS IS\" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE."
            + "</html>");

    /**
     * Constructor to create License JInteralFrame window
     * 
     * @param CounterJInternalFrame, takes control of placing the new frame shifted so you can see bit of the earlier frame
     */
    public License(int CounterJInternalFrame) {
        super("Frame #" + CounterJInternalFrame + " License",
                false, // resizable
                true, // closable
                false, // maximizable
                true);// iconifiable
        setSize(400, 350);
        // Set the window's location.
        setLocation(xPosition * CounterJInternalFrame, yPosition * CounterJInternalFrame);
        initAuthor();

    }

    /**
     *
     * Just help function to draw Author window
     * 
     */
    protected void initAuthor() {

        infoLabel.setPreferredSize(new Dimension(500, 400));
        infoLabel.setHorizontalTextPosition(JLabel.CENTER);
        infoLabel.setVerticalTextPosition(JLabel.CENTER);


        add(infoLabel);

        setVisible(true);


    }
}
