// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel implements ActionListener {

    private JLabel text, time;
    private JButton b;
    private boolean running, finished;
    // private TimerThread tt;
    // private Timer t;
    // private BoardControl bc;
    private BoardControl bc;
    public BoardPanel(BoardControl bc) { // GameController gc) {

        this.bc = bc;
        
        text = new JLabel("Get ready to play!");

        b = new JButton("start");
        b.addActionListener(this);

        time = new JLabel("00:00");

        add(text);
        add(b);
        add(time);

        running = false;
        finished = false;

        // tt = new TimerThread(gc);
        // t = new Timer();
    }

    // public boolean isGameRunning() { return running; }

    // public void updateTime() {
    //     t.incTime();
    //     setFormatTime(t.getMM(), t.getSS());
    // }

    public void setFormatTime(int mm, int ss) {

        String mmString = String.valueOf(mm);
        if(mm < 10) mmString = "0" + mmString;

        String ssString = String.valueOf(ss);
        if(ss < 10) ssString = "0" + ssString;
        
        time.setText(mmString + ":" + ssString);
    }

    // public void gameWon() {
    //     text.setText("You won!");
    //     b.setText("exit");

    //     running = false;
    //     finished = true;
    // }

    public void showWin() {
        text.setText("You won!");
        b.setText("exit");
    }

    public void actionPerformed(ActionEvent e) {

        // if(!started) {
        //     started = true;
        //     text.setText("Hurry up, the clock's running!");
        //     b.setText("pause");

        //     tt.start();
        // }

        // if(finished) {
        //     System.exit(0);
        // }

        // if(!running) {
        //     running = true;
        //     text.setText("Hurry up, the clock's running!");
        //     b.setText("pause");
        // } else if(running) {
        //     running = false;
        //     text.setText("Get ready to play!");
        //     b.setText("resume");
        // }

        if(bc.isFinished()) System.exit(0);

        bc.toggleRunning();

        if(bc.isGameRunning()) {
            text.setText("Hurry up, the clock's running!");
            b.setText("pause");
        } else {
            text.setText("Get ready to play!");
            b.setText("resume");
        }

        // ga.toggleMode();
    }

    // public void setRunningText() {
    //     text.setText("Hurry up, the clock's running!");
    //     b.setText("pause");
    // }

    // public void setPausedText() {
    //     text.setText("Get ready to play!");
    //     b.setText("resume");
    // }
}