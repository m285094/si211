// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TileClickListener implements MouseListener {

    private Tile t;
    public TileClickListener(Tile t) {
        this.t = t;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        System.out.println(" Tile "+t.getPos()+" pressed");
        if(t.getActivatedStatus() == false) {
            t.setActivatedStatus(true);
            System.out.println("Tile activated");
        } else {
            t.setActivatedStatus(false);
            System.out.println("Tile deactivated");
        }
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println(" Tile released");
    }
}