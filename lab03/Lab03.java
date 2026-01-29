// Sam Pirkl

import java.util.*;

public class Lab03 {

    public static void main(String[] args) {

        //make new scanner and box object
        Scanner sc = new Scanner(System.in);
        Box b = null;
        while(sc.hasNext()) {

            //read users command and declare vars for coords
            String cmd = sc.next();
            double x, y;
            if(cmd.equals("add")) { //if user chooses to add

                Point p = Point.read(sc); //get new point object
                if(b == null) //if box has no points
                    b = new Box(p); //make new box with the point
                else
                    b.growBy(p); //otherwise add the point to the box

            } else if(cmd.equals("box")) { //if user chooses to print, tostring
                System.out.println(b.toString());
            } else if(cmd.equals("map")) { //if user chooses to map

                Point p = Point.read(sc); //get new point object
                Point mapped = b.mapIntoUnitSquare(p); //map it into unit square
                if(mapped != null) //if it can be mapped 
                    System.out.println(mapped.toString()); //print mapped coord
                else
                    System.out.println("error"); //otherwise print error
                
            } else if(cmd.equals("done")) //exit if user wants to quit 
                break;
            else //error for unknown command
                System.out.println("Error! Unknown command \"" + cmd + "\"!");

        }
    }
}