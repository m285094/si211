// Sam Pirkl and Sean Beckford

public class ThingC extends ThingB {

    // new variables for thingc
    private int leftDiagonalsRemaining, rightDiagonalsRemaining;
    public ThingC(int row, int col, char lab) {
        super(row, col, lab);
        leftDiagonalsRemaining = 0;
        rightDiagonalsRemaining = 0;
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        if(leftDiagonalsRemaining > 0) { // has to do at least 10 moves in diagonal

            leftTurn();
            step();
            rightTurn();

            leftDiagonalsRemaining--; // subtract number of diagonal moves by 1
        } else if(rightDiagonalsRemaining > 0) { // has to do at least 10 moves in diagonal

            rightTurn();
            step();
            leftTurn();
            
            rightDiagonalsRemaining--; // subtract number of diagonal moves by 1
        } else if(i == 1) { // if there are no diagonal moves left

            leftDiagonalsRemaining = 9; // i = 1 means start left diagonal

            leftTurn();
            step();
            rightTurn();
        } else if(i == 2) { // no diagonal moves left

            rightDiagonalsRemaining = 9; // i = 1 means start right diagonal

            rightTurn();
            step();
            leftTurn();
        }
    }
}