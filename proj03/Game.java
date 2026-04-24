// Sam Pirkl

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel {

    private GameController gc;
    private BoardPanel p;
    private Board b;
    public Game(int seed) {

        gc = new GameController();
        p = new BoardPanel(gc);
        b = new Board(seed, gc);

        gc.setPanel(p);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(p);
        add(b);
    }
}