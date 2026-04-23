// Sam Pirkl

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Board extends JPanel implements TileListener {

    private static final int BOARD_SIZE = 6;
    private int[][] kindIDs;
    private Tile firstSelected, secondSelected;
    private int remainingTiles;
    private BoardPanel p;
    public Board(int seed, BoardPanel p) {

        // get ids for each tile
        kindIDs = P3Tools.getRandomKindIdAssignments(seed, (BOARD_SIZE*BOARD_SIZE)/2, BOARD_SIZE);

        // make the board gridlayout
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        this.p = p;
        for(int r = 0; r < BOARD_SIZE; r++) {

            for(int c = 0; c < BOARD_SIZE; c++) {
                Tile t = new Tile(r, c, kindIDs[r][c]);
                // t.addTileClickListener(new TileClickListener(t));

                // t.addMouseListener(t.getTileClickListener());
                t.addMouseListener(new TileClickListener(t, this.p));
                t.addTileListener(this);

                add(t);
            }
        }

        firstSelected = null;
        secondSelected = null;

        remainingTiles = BOARD_SIZE*BOARD_SIZE;
    }

    public void activated(Tile t) {

        System.out.println("Tile "+t.getPos()+" activated");

        // if the tile selected is the same as the one already selected
        if (t == firstSelected) {
            System.out.println("Tile " + t.getPos() + " deselected");

            // set it to false and make no tiles selected
            t.setActivatedStatus(false);
            firstSelected = null;
            secondSelected = null;
            return;
        }

        if(firstSelected == null) { firstSelected = t; secondSelected = null; return; }
        if(t != firstSelected) secondSelected = t; // dont make the second selected the same tile if clicked twice

        // if there are two tiles selected
        if(firstSelected != null && secondSelected != null) {

            // if the ids of the tiles match
            if(firstSelected.checkIDMatch(secondSelected)) {
                System.out.println("Tile "+firstSelected.getPos()+" and Tile "+secondSelected.getPos()+" colors match");

                firstSelected.matched();
                secondSelected.matched();

                remainingTiles -= 2;

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

    public void deactivated(Tile t) {

        System.out.println("Tile " + t.getPos() + " deactivated");

        // t.repaint();
    }
}