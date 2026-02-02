// Sam Pirkl

import si211.*;
import java.util.*;

public class Week {

    private char[][] A;
    private static final int ROW = 6;
    private static final int COL = 5;
    public Week() {
        A = new char[6][5];
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++)
                A[i][j] = ' ';
        }
    }

    public void printWeek() {

        for(int i = 0; i < ROW; i++) {

            if(i == 0)
                System.out.println("  M T W R F");
            System.out.print((i + 1) + " ");

            for(int j = 0; j < COL; j++)
                System.out.print(A[i][j] + " ");
            System.out.println();
        }
    }

    public void buildWeek(String pat) {

        String[] periods = DrBrown.explode(pat);
        // String[] periods = {"M2","W2","F2","R1","R2"};
        for(int i = 0; i < periods.length; i++) {
            char c = periods[i].charAt(0);
            int row = Integer.parseInt(periods[i].substring(1)) - 1;

            int col = 
                c == 'M' ? 0 :
                c == 'T' ? 1 :
                c == 'W' ? 2 :
                c == 'R' ? 3 :
                4;

            A[row][col] = 'X';
        }
    }

    public static void main(String[] args) {

        Week w = new Week();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {

            String s = sc.next();
            if(s.equals("quit"))
                break;
            else {
                w.buildWeek(s);
            }

            w.printWeek();
        }
    }
}