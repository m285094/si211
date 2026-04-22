// Sam Pirkl

import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class DrawArea extends JComponent {

    private ArrayList<Orbit> orbits;
    public DrawArea(ArrayList<Orbit> orbits) {
        super();
        setPreferredSize(new Dimension(600,600));
        this.orbits = orbits;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(
            RenderingHints.KEY_RENDERING, 
            RenderingHints.VALUE_RENDER_QUALITY);

        // draw two circles
        for(Orbit o : orbits)
            drawCenteredCircle(g2, o);

        Toolkit.getDefaultToolkit().sync();
    }

    public void drawCenteredCircle(Graphics2D g2, Orbit o) {

        // calc coord of upper left of circle bc that's how it's formatted
        int x = o.getX() - o.getRadius();
        int y = o.getY() - o.getRadius();

        // set color, thickness, and draw circle
        g2.setColor(o.getColor());
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Ellipse2D.Double(x, y, 2*o.getRadius(), 2*o.getRadius()));

        // get the upper left coord of the planet
        int px = o.getPlanet().getX() - o.getPlanet().getRadius();
        int py = o.getPlanet().getY() - o.getPlanet().getRadius();
        
        // draw planet for orbit
        g2.fill(new Ellipse2D.Double(px, py, 2*o.getPlanet().getRadius(), 2*o.getPlanet().getRadius()));

    }
}
