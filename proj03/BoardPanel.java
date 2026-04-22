// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel {

    private JLabel text, time;
    private JButton b;
    private ButtonClickListener bcl;
    public BoardPanel() {
        
        text = new JLabel("Get ready to play!");

        b = new JButton("start");
        bcl = new ButtonClickListener(this, text, b, time);
        b.addActionListener(bcl);

        time = new JLabel("00:00");

        add(text);
        add(b);
        add(time);
    }

    public ButtonClickListener getButtonClickListener() { return bcl; }

    public void setFormatTime(int mm, int ss) {

        String mmString = String.valueOf(mm);
        if(mm < 10) mmString = "0" + mmString;

        String ssString = String.valueOf(ss);
        if(ss < 10) ssString = "0" + ssString;
        
        time.setText(mmString + ":" + ssString);
    }

    public void gameWon() {
        text.setText("You won!");
        b.setText("exit");

        bcl.gameFinished();
    }
}