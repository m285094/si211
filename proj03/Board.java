// Sam Pirkl

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import si211.*;

public class Board extends JPanel {

    private static final int BOARD_SIZE = 6;
    private int[][] kindIDs;
    private JPanel grid;
    public Board(int seed ) {

        kindIDs = P3Tools.getRandomKindIdAssignments(seed, (BOARD_SIZE*BOARD_SIZE)/2, BOARD_SIZE);

        grid = new JPanel();
        grid.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for(int r = 0; r < BOARD_SIZE; r++) {

            for(int c = 0; c < BOARD_SIZE; c++) {
                Tile t = new Tile(r, c, kindIDs[r][c]);
                t.addMouseListener(new TileClickListener(t));
                grid.add(t);
            }
        }

        this.add(grid);
    }
}