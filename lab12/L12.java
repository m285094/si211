// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class L12 {

    public static void main(String[] args) {

        // make new frame
        JFrame f = new JFrame();
        JPanel p = new JPanel();

        // make an arraylist to hold orbits
        ArrayList<Orbit> orbits  = new ArrayList<Orbit>();
        orbits.add(new Orbit(300, 300, 150, Color.PINK, 0.01));
        orbits.add(new Orbit(orbits.get(0).getPlanet(), 75, Color.BLUE, 0.03));

        // add orbit to drawarea class
        DrawArea da = new DrawArea(orbits);
        p.add(da); // and add draw area to the panel

        // add start buttom to the panel
        JButton b = new JButton("start");
        b.addActionListener(new ButtonClickListener(b, orbits, da));
        p.add(b); // add start button to the panel

        // add the panel to the frame
        f.add(p);

        // set to size, close program when click x, and show the frame
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}