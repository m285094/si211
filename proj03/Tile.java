// Sam Pirkl

import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

import si211.*;

public class Tile extends JPanel {

    private static final int WIDTH = 100;
    private Pos p;
    private int id;
    private Color color;
    private boolean tileActivated;
    private TileListener tl;
    private TileClickListener tcl;
    public Tile(int r, int c, int id) {

        p = new Pos(r, c);
        this.id = id;

        color = P3Tools.getSwatchColor(id);

        this.tileActivated = false;

        setPreferredSize(new Dimension(WIDTH, WIDTH));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setBackground(color);
    }

    public Pos getPos() { return p; }
    public boolean getActivatedStatus() { return tileActivated; }
    public void setActivatedStatus(boolean b) { 
        tileActivated = b; 
        if(b) tl.activated(this);
        else tl.deactivated(this);

        repaint();
    }

    public void toggle() {
        setActivatedStatus(!tileActivated);
    }

    public void addTileListener(TileListener tl) { this.tl = tl; }
    public void addTileClickListener(TileClickListener tcl) { this.tcl = tcl; }

    public boolean checkIDMatch(Tile t) { return this.id == t.id; }
    public void matched() { 
        System.out.println("Tile "+p+" was matched"); 
        color = Color.WHITE;

        removeMouseListener(tcl);
        tileActivated = false;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(color);
        g2.fill(new Rectangle2D.Double(0, 0, WIDTH, WIDTH));

        if(tileActivated) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(25));
            g2.draw(new Rectangle2D.Double(0, 0, WIDTH, WIDTH));
        }
    }
}