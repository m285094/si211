// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonClickListener implements ActionListener {


    public ButtonClickListener(CountdownFrame f, JLabel l, JTextField tf) {

    }

    public void actionPerformed(ActionEvent e) {
        
        // // get start time from the user
        // int startTime = -1;
        // try { startTime = Integer.parseInt(tf.getText()); }
        // catch(NumberFormatException nfe) { 
        //     l.setText("ERROR"); // error if the user enters in string format
        //     return;
        // }

        // // set textfield to blank
        // tf.setText("");
        
        // // start thread to countdown
        // CountdownThread ct = new CountdownThread(l, startTime);
        // ct.start();

        // // reset label to done when finished
        // l.setText("DONE");
    }
}