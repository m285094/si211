// Sam Pirkl

import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

import si211.*;

public class Tile extends JPanel implements MouseListener {

    private static final int WIDTH = 100;
    private Pos p;
    private int id;
    private Color color;
    private boolean tileActivated, matched;
    private TileListener tl;
    private BoardControl bc;
    public Tile(int r, int c, int id, BoardControl bc) {

        p = new Pos(r, c);
        this.id = id;
        this.bc = bc;

        color = P3Tools.getSwatchColor(id);

        this.tileActivated = false;
        this.matched = false;

        setPreferredSize(new Dimension(WIDTH, WIDTH));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setBackground(color);
    }

    public Pos getPos() { return p; }

    public void addTileListener(TileListener tl) { this.tl = tl; }

    public boolean checkMatch(Tile t) {

        if(this.id == t.id) {
            System.out.println("Tile "+p+" and Tile "+t.p+" colors match");

            this.matched();
            t.matched();
             
            return true;
        }

        System.out.println("Tile "+p+" and Tile "+t.p+" colors don't match");

        this.tileActivated = false;
        t.tileActivated = false;

        return false;
    }

    public void matched() { 
        System.out.println("Tile "+p+" was matched"); 
        matched = true;
        color = Color.WHITE;

        // removeMouseListener(tcl);
        tileActivated = false;
        repaint();
    }

    public void reset() {
        tileActivated = false;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // draw the tile in its position within the grid
        g2.setColor(color);
        g2.fill(new Rectangle2D.Double(0, 0, WIDTH, WIDTH));

        // if the tile is activated, draw empty black square over it
        if(tileActivated) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(25));
            g2.draw(new Rectangle2D.Double(0, 0, WIDTH, WIDTH));
        }
    }

    // these are all the functions for mouselistener
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        // System.out.println(" Tile "+t.getPos()+" pressed");

        if(bc.isGameRunning() && !matched) {        

            if(tileActivated == true) tileActivated = false;
            else tileActivated = true;

            if(tileActivated) tl.activated(this);
            else tl.deactivated(this);

            repaint();
        }
    }
    public void mouseReleased(MouseEvent e) {
        // System.out.println(" Tile "+t.getPos()+" released");
    }
}