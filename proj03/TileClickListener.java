// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TileClickListener implements MouseListener {

    private Tile t;
    private BoardPanel p;
    public TileClickListener(Tile t, BoardPanel p) {
        this.t = t;
        this.p = p;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        // System.out.println(" Tile "+t.getPos()+" pressed");
        if(p.isGameRunning()) {        
            // if(t.getActivatedStatus() == false) {
            //     // System.out.println("Tile "+t.getPos()+" activated");
            //     t.setActivatedStatus(true);
            // } else {
            //     // System.out.println("Tile "+t.getPos()+" deactivated");
            //     t.setActivatedStatus(false);
            // }
            t.toggle();
        }
        // t.getTileListener().activated(t);
    }
    public void mouseReleased(MouseEvent e) {
        // System.out.println(" Tile "+t.getPos()+" released");
    }
}