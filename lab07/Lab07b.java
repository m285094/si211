// Sam Pirkl and Sean Beckford

import java.util.*;

public class Lab07b {

    public static void main(String[] args) {
        int N = 200;
        if (args.length != 0) N = Integer.parseInt(args[0]);

        ThingList L = new ThingList();
        int count = 0;
        while(true)
        {
            // every N rounds add another typeA and typeB Thing
            if (count % N == 0)
            {
                L.addToList(new Thing(45, 50));
                L.addToList(new ThingB(55, 50, 'b'));
            }

            L.printThings();
            L.moveThings();

            count++;
        }
    }
}