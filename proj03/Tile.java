// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Tile extends JPanel {

    // private boolean tileActivated;
    // public Tile() {

    //     this.tileActivated = false;

    //     setPreferredSize(new Dimension(100, 100));
    //     setBorder(BorderFactory.createLineBorder(Color.black));
    //     setBackground(Color.WHITE);
    // }

    private Pos p;
    private int id;
    private boolean tileActivated;
    public Tile(int r, int c, int id) {

        p = new Pos(r, c);
        this.id = id;

        this.tileActivated = false;

        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(P3Tools.getSwatchColor(id));
    }

    public Pos getPos() { return p; }
    public boolean getActivatedStatus() { return tileActivated; }
    public void setActivatedStatus(boolean b) { tileActivated = b; }
}