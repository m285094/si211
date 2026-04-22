// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Orbit {

    private int x, y, r;
    private Color c;
    private Planet parent, p;

    // constructor if centered it on a point
    public Orbit(int x, int y, int r, Color c, double incAngleAmt) {
        this.parent = null;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;

        // orbit has its own planet
        p = new Planet(x, y, r, c, incAngleAmt);
    }

    // constructor if centered on a planet
    public Orbit(Planet parent, int r, Color c, double incAngleAmt) {
        this.parent = parent;
        this.x = parent.getX();
        this.y = parent.getY();
        this.r = r;
        this.c = c;

        // orbit has its own planet
        p = new Planet(x, y, r, c, incAngleAmt);
    }

    // getter methods
    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return r; }
    public Color getColor() { return c; }
    public Planet getPlanet() { return p; }

    // method to update position of orbit if it's centered on a planet
    public void updateOrbit() {

        if(parent != null) {
            x = parent.getX();
            y = parent.getY();

            // planet is updated of orbit's new position
            p.updatePos(this);
        }
    }
}