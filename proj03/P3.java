// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P3 {

    public static void main(String[] args) {   

        int seed = -1;
        if(args.length > 0) seed = Integer.parseInt(args[0]);
        else seed = (int)System.currentTimeMillis();

        JFrame f = new JFrame();

        Game g = new Game(seed);
        // GameController gc = new GameController();
        // BoardPanel p = new BoardPanel(gc);
        // gc.setPanel(p);
        // Board b = new Board(seed, gc);

        // f.add(p, BorderLayout.NORTH);
        // f.add(b, BorderLayout.CENTER);

        f.add(g);

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}