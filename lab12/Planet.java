// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;

public class Planet {

    private int ox, oy, or, pr, x, y;
    private double a, incAngleAmt = 0.01;
    private Color c;
    public Planet(int ox, int oy, int or, Color c, double incAngleAmt) {

        // position of center of orbit
        this.ox = ox;
        this.oy = oy;
        this.or = or; // and orbit radius

        this.pr = 8; // planet radius

        this.c = c;

        // initial angle and angle increase amount
        this.a = 0;
        this.incAngleAmt = incAngleAmt;

        // actually calculates planet's position based on orbit
        calcPos();
    }

    // getter methods
    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return pr; }
    public double getAngle() { return a; }

    // update center of orbit if it changes
    public void updatePos(Orbit o) {
        ox = o.getX();
        oy = o.getY();
    }

    // trig to get the planet's pos based on orbit pos and angle
    public void calcPos() {
        x = (int)(ox + or*Math.cos(a)); 
        y = (int)(oy + or*Math.sin(a)); 
    }

    // increases the angle and recalculates position
    public void incAngle() { 
        a = (a - incAngleAmt)%(2*Math.PI);
        calcPos();
    }
}