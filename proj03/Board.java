// Sam Pirkl

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Board extends JPanel implements TileListener {

    private static final int BOARD_SIZE = 6;
    private int[][] kindIDs;
    private Tile selectedTile;
    private int remainingTiles;
    private BoardControl bc;
    public Board(int seed, BoardControl bc) {

        // get ids for each tile
        kindIDs = P3Tools.getRandomKindIdAssignments(seed, (BOARD_SIZE*BOARD_SIZE)/2, BOARD_SIZE);

        // make the board gridlayout
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        this.bc = bc;
        for(int r = 0; r < BOARD_SIZE; r++) {

            for(int c = 0; c < BOARD_SIZE; c++) {
                Tile t = new Tile(r, c, kindIDs[r][c], bc);

                // tile is its own mouse click listener
                t.addMouseListener(t);

                // board is a tile listener
                t.addTileListener(this);

                add(t);
            }
        }

        selectedTile = null;

        remainingTiles = BOARD_SIZE*BOARD_SIZE;
    }

    public void activated(Tile t) {

        System.out.println("Tile "+t.getPos()+" activated");

        if(selectedTile == null) { 
            selectedTile = t; 
            return; 
        }

        if(selectedTile.checkMatch(t) == true) remainingTiles -= 2;
        else selectedTile.reset();

        selectedTile = null;

        if(remainingTiles == 0) {
            bc.gameWon();
        }
    }

    public void deactivated(Tile t) {

        System.out.println("Tile " + t.getPos() + " deactivated");

        selectedTile = null;
    }
}