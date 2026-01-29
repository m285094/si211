// Sam Pirkl

import java.util.*;

public class HW5 {

    public static void main(String[] args) {

        Countdown C = new Countdown(99, 0); //create new countdown objext

        //get the first number from the countdown
        String num = C.next();
        while(!C.done()) { //keep looping until countdown is finished
            //create string that has first letter capitalized
            String caps = num.substring(0,1).toUpperCase() + 
                            num.substring(1,num.length());

                String bottle = "bottles";
                if(num.equals("one")) //edge case to print current num if 1
                    bottle = "bottle";

                //print current number in countdown
                System.out.println(caps + " " + bottle + " of beer on the wall, " + num + " " + bottle + " of beer.");

                num = C.next(); //iterate to the next number in the countdown
                if(num.equals("one")) //edge case to print next num if 1
                    bottle = "bottle";
                if(num.equals("zero")) { //edge case when next num is 0
                    num = "no more";
                    bottle = "bottles";
                }

                //print next number in countdown
                System.out.print("Take one down and pass it around, " + num + " " + bottle + " of beer on the wall.");
                System.out.println();
                System.out.println();
        }


    }
}