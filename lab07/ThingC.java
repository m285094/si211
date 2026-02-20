public class ThingC extends ThingB {
    // private char lab = 'r';
    private int leftTurnsRemaining, rightTurnsRemaining;
    public ThingC(int row, int col, char lab) {
        super(row, col, lab);
        leftTurnsRemaining = 0;
        rightTurnsRemaining = 0;
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        timeSinceLast++; 
        if (timeSinceLast == 10)
        {
            timeSinceLast = 0;
            if (i == 1 && leftTurnsRemaining == 0) {
                leftTurn();
                leftTurnsRemaining = 9;
            } else if(i == 1) {
                leftTurn();
                leftTurnsRemaining--;
            } else if (i == 2 && rightTurnsRemaining == 0) { 
                rightTurn(); 
                rightTurnsRemaining = 9;
            } else if(i == 2) {
                rightTurn();
                rightTurnsRemaining--;
            }
        }
    }
}