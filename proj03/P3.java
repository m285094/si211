// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class P3 {

    public static void main(String[] args) {   

        int seed = -1;
        if(args.length > 0) seed = Integer.parseInt(args[0]);
        else seed = (int)System.currentTimeMillis();

        JFrame f = new JFrame();

        Board b = new Board(seed);
        f.add(b);
        f.setVisible(true);
        f.pack();
    }
}