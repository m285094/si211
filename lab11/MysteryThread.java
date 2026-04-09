import javax.swing.*;
import java.awt.event.*;

public class MysteryThread extends Thread {

    private JLabel label;
    public MysteryThread(JLabel label) {
        this.label = label;
    }

    public void run() {
        CChange.changeColor(label);
    }
}