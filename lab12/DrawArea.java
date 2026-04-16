// Sam Pirkl

import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class DrawArea extends JComponent {

    private Orbit o1, o2;
    public DrawArea(Orbit o1, Orbit o2) {
        super();
        setPreferredSize(new Dimension(800,800));
        this.o1 = o1;
        this.o2 = o2;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        drawCenteredCircle(g2, o1);
        drawCenteredCircle(g2, o2);
    }

    public void drawCenteredCircle(Graphics2D g2, Orbit o) {

        int x = o.getX() - o.getRadius();
        int y = o.getY() - o.getRadius();

        // draw orbit
        g2.setColor(o.getColor());
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Ellipse2D.Double(x, y, 2*o.getRadius(), 2*o.getRadius()));

        int px = o.getPlanet().getX() - o.getPlanet().getRadius();
        int py = o.getPlanet().getY() - o.getPlanet().getRadius();
        
        // draw planet for orbit
        g2.fill(new Ellipse2D.Double(px, py, 2*o.getPlanet().getRadius(), 2*o.getPlanet().getRadius()));

    }
}
