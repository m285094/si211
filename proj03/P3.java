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

        BoardPanel p = new BoardPanel();
        Board b = new Board(seed, p);

        f.add(p, BorderLayout.NORTH);
        f.add(b, BorderLayout.CENTER);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}