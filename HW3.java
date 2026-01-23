import java.util.*;

public class HW3 {

    public static Mid createMid(Scanner sc) {
        Mid m = new Mid(); //create a new Mid object 
        m.alpha = sc.next(); //init its variables
        m.firstName = sc.next();
        m.lastName = sc.next();
        m.company = sc.nextInt();

        return m; //return the mid object to main
    }

    public static void printMid(Mid m) {
        System.out.println(m.alpha + " " + m.firstName + " " + m.lastName
                            + " " + m.company); //print out student info
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //create a scanner

        int numMids = sc.nextInt(); //read the number of mids to input
        Mid[] mids = new Mid[numMids]; //make an array of those mids
        for(int i = 0; i < numMids; i++) {
            Mid m = createMid(sc); //create new mid and put in array
            mids[i] = m;
        }

        int company = sc.nextInt(); //read the company number
        for(int i = 0; i < numMids; i++) { //loop through mids 
            if(mids[i].company == company) //if they are in the company
                printMid(mids[i]); //print their info
        }
    }
}