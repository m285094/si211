import javax.swing.*;
import java.awt.event.*;

public class Mystery implements ActionListener
{
    private JLabel label;
    public Mystery(JLabel label) { this.label = label; }
    public void actionPerformed(ActionEvent e) {
        // System.out.println("Thread ID: " + Thread.currentThread().getId());
        // CChange.changeColor(label);
        MysteryThread mt = new MysteryThread(label);
        mt.start();
    }
}