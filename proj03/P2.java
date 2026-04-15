// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class P1 {

    public static void main(String[] args) {    
        JFrame f = new JFrame();

        f.setSize(200,200);
        f.setVisible(true);

        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("NORTH"));
        f.add(top, BorderLayout.NORTH);

        JPanel middle = new JPanel(new FlowLayout());
        middle.add(new JLabel("WEST"));
        Tile t = new Tile();
        middle.add(t);
        middle.add(new JLabel("EAST"));
        f.add(middle, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(new JLabel("SOUTH"));
        f.add(bottom, BorderLayout.SOUTH);

        t.addMouseListener(new TileClickListener(t));

        f.pack();
    }
}