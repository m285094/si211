// Sam Pirkl

import java.util.*;

public class Point {

    private double x, y; //vars for points
    public Point(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public static Point read(Scanner sc) {

        //make point with user input for coords
        Point p = new Point(sc.nextDouble(), sc.nextDouble());
        return p;
    }

    public String toString() { //print the coords
        return x + " " + y;
    }

    public double getx() { //how to x coord
        return x;
    }

    public double gety() { //how to get y coord
        return y;
    }
}