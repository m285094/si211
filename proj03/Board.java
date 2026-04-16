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
    public Board(int seed) {

        kindIDs = P3Tools.getRandomKindIdAssignments(seed, (BOARD_SIZE*BOARD_SIZE)/2, BOARD_SIZE);

        grid = new JPanel();
        grid.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for(int r = 0; r < BOARD_SIZE; r++) {

            for(int c = 0; c < BOARD_SIZE; c++) {
                Tile t = new Tile(r, c, kindIDs[r][c]);
                t.addTileClickListener(new TileClickListener(t));

                t.addMouseListener(t.getTileClickListener());
                t.addTileListener(this);

                grid.add(t);
            }
        }

        this.add(grid);

        firstSelected = null;
        secondSelected = null;
    }

    public void activated(Tile t) {

        System.out.println("Tile "+t.getPos()+" activated");

        if(firstSelected == null) firstSelected = t;
        else if(t != firstSelected) secondSelected = t;

        if(firstSelected != null && secondSelected != null) {

            if(firstSelected.checkIDMatch(secondSelected)) {
                System.out.println("Tile "+firstSelected.getPos()+" and Tile "+secondSelected.getPos()+" colors match");

                firstSelected.matched();
                secondSelected.matched();

                // remove the listeners
                firstSelected.removeMouseListener(firstSelected.getTileClickListener());
                secondSelected.removeMouseListener(secondSelected.getTileClickListener());
            } else {
                System.out.println("Tile "+firstSelected.getPos()+" and Tile "+secondSelected.getPos()+" colors don't match");

                firstSelected.setActivatedStatus(false);
                secondSelected.setActivatedStatus(false);
            }

            firstSelected = secondSelected = null;
        }
    }

    public void deactivated(Tile t) {

        System.out.println("Tile "+t.getPos()+" deactivated");

        // t.setActivatedStatus(false);
    }
}