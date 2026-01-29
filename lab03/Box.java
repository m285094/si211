// Sam Pirkl

import java.util.*;

public class Box {

    private double minx, maxx, miny, maxy; //values for box bounds
    
    public Box(Point p) {
        minx = p.getx();
        maxx = p.getx();
        miny = p.gety();
        maxy = p.gety();
    }

    public Box(Point a, Point b) { //values for box bounds based on two pts 
        minx = Math.min(a.getx(), b.getx());
        maxx = Math.max(a.getx(), b.getx());
        miny = Math.min(a.gety(), b.gety());
        maxy = Math.max(a.gety(), b.gety());
    }

    public void growBy(Point p) { //increase box bounds given new point
        minx = p.getx() < minx ? p.getx() : minx; //set to new x if less than minx
        maxx = p.getx() > maxx ? p.getx() : maxx; //set to new x if more than maxx
        miny = p.gety() < miny ? p.gety() : miny; //set to new y if less than miny
        maxy = p.gety() > maxy ? p.gety() : maxy; //set to new y if more than maxy
    }

    public Point mapIntoUnitSquare(Point p) {
        if(p.getx() > minx && p.getx() < maxx && p.gety() > miny && p.gety() < maxy) {
            Point newPoint = new Point((p.getx() - minx)/(maxx - minx), (p.gety() - miny)/(maxy - miny));
            return newPoint;
        } else 
            return null;
    }

    public String toString() { //print box bounds
        return minx + " < x < " + maxx + ", " + miny + " < y < " + maxy;
    }
}