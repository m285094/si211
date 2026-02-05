// Sam Pirkl

import si211.*;
import java.util.*;

public class Week {

    private char[][] A; //2D array for the grid
    private static final int ROW = 6; //constants for the grid size
    private static final int COL = 5;
    public Week() {
        A = new char[6][5]; 
        for(int i = 0; i < ROW; i++) { //fill the grid with blank spaces
            for(int j = 0; j < COL; j++)
                A[i][j] = ' ';
        }
    }

    public void printWeek() {

        for(int i = 0; i < ROW; i++) { //loop through rows

            if(i == 0) //if in first row
                System.out.println("  M T W R F"); //print the days
            System.out.print((i + 1)); //and print the period number

            for(int j = 0; j < COL; j++) //loop through cols
                System.out.print(" " + A[i][j]); //print the schedule
            System.out.println();
        }
    }

    // private int[] getRowCol(String period) {

    //     char c = period.charAt(0); //get the char for the day
    //     //get the period of that day
    //     int row = Integer.parseInt(period.substring(1)) - 1;

    //     int col = 
    //         c == 'M' ? 0 :
    //         c == 'T' ? 1 :
    //         c == 'W' ? 2 :
    //         c == 'R' ? 3 :
    //         4; //get an integer value for the index pertaining that day

    //     int[] A = {row, col};
    //     return A;
    // }

    public void buildWeek(String pat) {

        String[] periods = DrBrown.explode(pat); //get the periods
        for(int i = 0; i < periods.length; i++) { //loop through periods
            int[] rowCol = getRowCol(periods[i]);
            A[rowCol[0]][rowCol[1]] = 'x'; //fill that spot with an x
        }
    }

    // public void checkFits(String pat) {

    //     String[] periods = DrBrown.explode(pat);
    //     boolean canFit = true;
    //     for(int i = 0; i < periods.length; i++) {
    //         int[] rowCol = getRowCol(periods[i]);
    //         if(A[rowCol[0]][rowCol[1]] == 'x') canFit = false;
    //     }

    //     if(canFit == true) {

    //     }
    // }

    public static void main(String[] args) {

        Week w = new Week(); //make new week
        Scanner sc = new Scanner(System.in); //and scanner 

        w.printWeek(); //print the empty grid
        while(sc.hasNext()) { //loop while user input

            String s = sc.next(); //read input
            if(s.equals("quit")) //break if user wants to quit
                break;
            else {
                w.buildWeek(s); //otherwise add periods to week
            }

            w.printWeek(); //display grid
        }
    }
}