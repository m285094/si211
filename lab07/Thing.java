import java.util.*;

public class Thing {

    // dir: 0=North, 1=East, 2=South, 3=West. 
    // timeSinceLast: this is only important for "TypeB" Things.
    private int row, col, dir;
    protected char lab = 'r';
    protected static Random rand = new Random(System.currentTimeMillis());
    public Thing(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public char getLab() { return lab; }

    public void rightTurn() { 
        dir = (dir + 1) % 4; 
    }

    public void leftTurn() 
    { 
        dir = (dir + 3) % 4; 
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        if (i == 1) { rightTurn(); }
        if (i == 2) { leftTurn(); }      
    }

    public void step()
    {
        final int[] dc = {0,1,0,-1}, dr = {-1,0,1,0};
        row += dr[dir];
        col += dc[dir];
    }
}