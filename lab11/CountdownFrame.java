// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownFrame extends JPanel {

    private JLabel l;
    private JTextField tf;
    private JButton b;
    public CountdownFrame() {
        
        // add label to hold time
        l = new JLabel("DONE");
        l.setForeground(Color.RED);
        l.setPreferredSize(new Dimension(60,15));
        add(l);

        // textfield for user input
        tf = new JTextField(10);
        add(tf);

        // button to be clicked to start countdown
        b = new JButton("countdown");
        b.addActionListener(new ButtonClickListener(this, l, tf));
        add(b);
    }
}