// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownFrame extends JFrame {

    private JPanel p;
    private JLabel l;
    private JTextField tf;
    private JButton b;
    public CountdownFrame() {

        // make new panel to contain elements
        p = new JPanel();

        // add label to hold time
        l = new JLabel("DONE");
        l.setForeground(Color.RED);
        l.setPreferredSize(new Dimension(60,15));
        p.add(l);

        // textfield for user input
        tf = new JTextField(10);
        p.add(tf);

        // button to be clicked to start countdown
        b = new JButton("countdown");
        b.addActionListener(new ButtonClickListener(this, l, tf));
        p.add(b);

        // add panel to the frame
        this.add(p);
    }
}