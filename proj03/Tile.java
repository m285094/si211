// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tile extends JPanel {

    private boolean tileActivated;
    public Tile() {

        this.tileActivated = false;

        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.WHITE);
    }

    public boolean getActivatedStatus() { return tileActivated; }
    public void setActivatedStatus(boolean b) { tileActivated = b; }
}