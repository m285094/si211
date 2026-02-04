import java.util.*;

public class NRRandom extends Random {

    private int lastNum; //make new variable for the previous number
    public NRRandom(long seed) {
        super(seed); //pass in seed to use for the Random class
        lastNum = -1; //init it to be -1 because the range is 1 to 6
    }

    public int nextInt(int n) {
        
        int res = super.nextInt(n); //get the random number
        while(res == lastNum) //while they're equal
            res = super.nextInt(n); //keep getting a new number

        lastNum = res; //reset the previous number
        return res; //return the new number
    }
}