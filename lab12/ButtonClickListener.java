// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ButtonClickListener implements ActionListener {

    private JButton b;
    private boolean started;
    private ArrayList<Orbit> orbits;
    private DrawArea da;
    public ButtonClickListener(JButton b, ArrayList<Orbit> orbits, DrawArea da) {
        this.b = b;
        this.orbits = orbits;
        this.da = da;
        this.started = false;
    }

    public void actionPerformed(ActionEvent e) {

        // if there's already a thread return and ignore button click
        if(started) return;

        // otherwise signal that thread is created
        started = true;

        // make thread to start orbit
        OrbitThread ot = new OrbitThread(orbits, da);
        ot.start();
    }
}