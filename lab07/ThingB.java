// Sam Pirkl and Sean Beckford

public class ThingB extends Thing {

    protected int timeSinceLast; // jas its own variable
    public ThingB(int row, int col, char lab) {
        super(row, col);
        this.lab = lab;
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        timeSinceLast++; // turn every 10 turns
        if (timeSinceLast == 10)
        {
            timeSinceLast = 0;
            if (i == 1) { rightTurn();}
            if (i == 2) { leftTurn(); }
        }
    }
}