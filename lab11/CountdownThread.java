// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownThread extends Thread {

    private JLabel l;
    private int start;
    // get the label holding the time and the start time as params
    public CountdownThread(JLabel l, int start) {
        this.l = l;
        this.start = start;
    }

    public void run() {

        // create new countdown object
        Countdown c = new Countdown(start);

        // while countdown time is greater than 0
        while(c.getTime() > 0) {

            // print time
            l.setText(String.valueOf(c.getTime()));

            // sleep for 1 second
            try { Thread.sleep(1000); }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            }

            // decrease time by one second
            c.decTime();
        }

        // set to done when it's equal to zero
        l.setText("DONE");
    }
}