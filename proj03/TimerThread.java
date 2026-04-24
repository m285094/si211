// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerThread extends Thread {

    private BoardControl bc;
    public TimerThread(BoardControl bc) {
        this.bc = bc;
    }

    public void run() {

        while(true) {

            try { Thread.sleep(1000); }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            }

            if(bc.isGameRunning())
                bc.tick();
        }
    }
}