// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OrbitThread extends Thread {

    private ArrayList<Orbit> orbits;
    private DrawArea da;
    public OrbitThread(ArrayList<Orbit> orbits, DrawArea da) {
        this.orbits = orbits;
        this.da = da;
    }

    public void run() {

        while(true) {
            
            // sleep for certain time
            try { Thread.sleep(10); }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            }

            // loop through orbits and update orbit and planets
            for(Orbit o : orbits) {
                o.updateOrbit();
                o.getPlanet().incAngle();
            }

            // redraw the drawarea
            da.repaint();
        }
    }
}