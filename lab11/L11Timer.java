// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11Timer {

    public static void main(String[] args) {

        // make frame
        JFrame f = new JFrame();

        // make countdown panels
        JPanel p1 = new CountdownFrame();
        JPanel p2 = new CountdownFrame();
        JPanel p3 = new CountdownFrame();

        // add panels to the frame
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);
        f.add(p3, BorderLayout.SOUTH);

        // set to size, close program when click x, and show the frame
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}