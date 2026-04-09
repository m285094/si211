// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L11Timer {

    public static void main(String[] args) {

        // make new countdown frame
        JFrame f = new CountdownFrame();

        // set to size, close program when click x, and show the frame
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}