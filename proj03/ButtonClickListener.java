// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickListener implements ActionListener {

    private BoardPanel p;
    private JLabel text, time;
    private JButton b;
    private boolean started, running, finished;
    private TimerThread t;
    public ButtonClickListener(BoardPanel p, JLabel text, JButton b, JLabel time) {
        this.p = p;
        this.text = text;
        this.b = b;
        this.time = time;

        started = false;
        running = false;
        finished = false;

        t = new TimerThread(p);
    }

    public boolean getRunningValue() { return running; }

    public void gameFinished() { 
        running = false;
        finished = true; 
    }

    public void actionPerformed(ActionEvent e) {

        if(!started) {
            started = true;
            text.setText("Hurry up, the clock's running!");
            b.setText("pause");

            t.start();
        }

        if(finished) {
            System.exit(0);
        }

        if(!running) {
            running = true;
            text.setText("Hurry up, the clock's running!");
            b.setText("pause");
        } else if(running) {
            running = false;
            text.setText("Get ready to play!");
            b.setText("resume");
        }
    }
}