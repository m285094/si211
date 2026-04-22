// Sam Pirkl

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Board extends JPanel implements TileListener {

    private static final int BOARD_SIZE = 6;
    private int[][] kindIDs;
    private JPanel grid;
    private Tile firstSelected, secondSelected;
    private int remainingTiles;
    private BoardPanel p;
    public Board(int seed, BoardPanel p) {

        kindIDs = P3Tools.getRandomKindIdAssignments(seed, (BOARD_SIZE*BOARD_SIZE)/2, BOARD_SIZE);

        grid = new JPanel();
        grid.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        this.p = p;
        for(int r = 0; r < BOARD_SIZE; r++) {

            for(int c = 0; c < BOARD_SIZE; c++) {
                Tile t = new Tile(r, c, kindIDs[r][c]);
                // t.addTileClickListener(new TileClickListener(t));

                // t.addMouseListener(t.getTileClickListener());
                t.addMouseListener(new TileClickListener(t, this.p.getButtonClickListener()));
                t.addTileListener(this);

                grid.add(t);
            }
        }

        this.add(grid);

        firstSelected = null;
        secondSelected = null;

        remainingTiles = BOARD_SIZE*BOARD_SIZE;
    }

    public void activated(Tile t) {

        System.out.println("Tile "+t.getPos()+" activated");

        if (t == firstSelected) {
            System.out.println("Tile " + t.getPos() + " deselected");

            t.setActivatedStatus(false);
            firstSelected = null;
            secondSelected = null;
            return;
        }

        if(firstSelected == null) {firstSelected = t; secondSelected = null; return; }
        if(t != firstSelected) secondSelected = t; // dont make the second selected the same tile if clicked twice

        // if(firstSelected != null)
        //     System.out.println("first tile selected: " + firstSelected.getPos());
        // if(secondSelected != null)
        //     System.out.println("second tile selected: " + secondSelected.getPos());

        // if there are two tiles selected
        if(firstSelected != null && secondSelected != null) {


            // if the ids of the tiles match
            if(firstSelected.checkIDMatch(secondSelected)) {
                System.out.println("Tile "+firstSelected.getPos()+" and Tile "+secondSelected.getPos()+" colors match");

                firstSelected.matched();
                secondSelected.matched();

                remainingTiles -= 2;

                // // remove the listeners
                // firstSelected.removeMouseListener(firstSelected.getTileClickListener());
                // secondSelected.removeMouseListener(secondSelected.getTileClickListener());

                // firstSelected.setActivatedStatus(false);
                // secondSelected.setActivatedStatus(false);

                firstSelected = secondSelected = null;

            // if the ids don't match
            } else {
                System.out.println("Tile "+firstSelected.getPos()+" and Tile "+secondSelected.getPos()+" colors don't match");

                firstSelected.setActivatedStatus(false);
                secondSelected.setActivatedStatus(false);

                // firstSelected = secondSelected;
                firstSelected = null;
                secondSelected = null;

                // firstSelected.setActivatedStatus(true);
            }

            
        }

        if(remainingTiles == 0) {
            p.gameWon();
        }
    }

    // public void activated(Tile t) {

    //     System.out.println("Tile " + t.getPos() + " activated");

    //     // if the same tile is clicked twice in a row
    //     if(t == firstSelected) {
    //         System.out.println("Tile " + t.getPos() + " deselected");

    //         // set activated to false
    //         t.setActivatedStatus(false);
    //         firstSelected = null;
    //         secondSelected = null;
    //         return; // and quit
    //     }

    //     // select the first tile
    //     if(firstSelected == null) {
    //         firstSelected = t;
    //         secondSelected = null;
    //         return;
    //     }

    //     // select the second tile
    //     if(secondSelected == null && t != firstSelected) {
    //         secondSelected = t;
    //     }

    //     // if there are two tiles selected that are different
    //     if(firstSelected != null && secondSelected != null) {

    //         if(firstSelected.checkIDMatch(secondSelected)) {

    //             System.out.println("Match!");

    //             firstSelected.matched();
    //             secondSelected.matched();

    //         } else {

    //             System.out.println("No match");

    //             firstSelected.setActivatedStatus(false);
    //             secondSelected.setActivatedStatus(false);

    //             deactivated(firstSelected);
    //             deactivated(secondSelected);
    //         }

    //         firstSelected = null;
    //         secondSelected = null;
    //     }
    // }

    // public void deactivated(Tile t) {

    //     System.out.println("Tile "+t.getPos()+" deactivated");        

    //     // t.setActivatedStatus(false);
    // }

    public void deactivated(Tile t) {

        System.out.println("Tile " + t.getPos() + " deactivated");

        // t.repaint();
    }
}