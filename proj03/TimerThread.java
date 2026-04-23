// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerThread extends Thread {

    private BoardControl c;
    public TimerThread(BoardControl c) {
        this.c = c;
    }

    public void run() {


        while(true) {
            try { Thread.sleep(1000); }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            }

            if(c.isGameRunning()) 
                c.tick();
        }
    }
}