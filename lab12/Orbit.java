// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Orbit {

    private int x, y, r;
    private Color c;
    private Planet p;
    public Orbit(int x, int y, int r, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;

        p = new Planet(x + r, y, r, c);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return r; }
    public Color getColor() { return c; }

    public Planet getPlanet() { return p; }
}