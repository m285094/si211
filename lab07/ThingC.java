public class ThingC extends ThingB {
    // private char lab = 'r';
    public ThingC(int row, int col, char lab) {
        super(row, col, lab);
    }

    public void maybeTurn()
    {
        int i = rand.nextInt(3);
        timeSinceLast++; 
        if (timeSinceLast == 10)
        {
            timeSinceLast = 0;
            if (i == 1) {
                for(int j = 0; j < i; j++) {  
                    leftTurn();
                    step();
                    rightTurn(); 
                }
            }
            if (i == 2) { 
                for(int j = 0; j < i; j++) {  

                    rightTurn(); 
                    step();
                    leftTurn();   
                }
            }
        }
    }
}