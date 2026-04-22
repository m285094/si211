// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerThread extends Thread {

    private BoardPanel p;
    private ButtonClickListener bcl;
    public TimerThread(BoardPanel p, ButtonClickListener bcl) {
        this.p = p;
        this.bcl = bcl;
    }

    public void run() {

        Timer t = new Timer();

        while(true) {
            try { Thread.sleep(1000); }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());
                return;
            }

            if(bcl.getRunningValue()) t.incTime();
            p.setFormatTime(t.getMM(), t.getSS());
        }
    }
}