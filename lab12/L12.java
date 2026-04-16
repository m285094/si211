// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class L12 {

    public static void main(String[] args) {

        // make new frame
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        Orbit o1 = new Orbit(400, 400, 200, Color.PINK);
        Orbit o2 = new Orbit(o1.getPlanet().getX(), o1.getPlanet().getY(), 100, Color.BLUE);
        DrawArea d = new DrawArea(o1, o2);
        p.add(d);

        JButton b = new JButton("countdown");
        b.addActionListener(new ButtonClickListener(this, l, tf));
        p.add(new JButton());
        f.add(p);


        // set to size, close program when click x, and show the frame
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}