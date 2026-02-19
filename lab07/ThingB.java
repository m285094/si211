public class ThingB extends Thing {

    protected int timeSinceLast;
    // private char lab = 'r';
    public ThingB(int row, int col, char lab) {
        super(row, col);
        this.lab = lab;
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        timeSinceLast++; 
        if (timeSinceLast == 10)
        {
            timeSinceLast = 0;
            if (i == 1) { rightTurn();}
            if (i == 2) { leftTurn(); }
        }
    }
}