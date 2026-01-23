import java.util.Scanner;

public class HW02 {

    public static int maxLength(String[] A) {

        int max = A[0].length(); //sets max to len of first string
        for(int i = 1; i < A.length; i++) {
            if(A[i].length() > max) //if current string length greater than max
                max = A[i].length(); //set new max
        }

        return max; //return max
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //scanner for user input

        int n = scanner.nextInt(); //find number of strings

        String[] strings = new String[n]; //make array of users strings
        for(int i = 0; i < n; i++) //add the strings to the array
            strings[i] = scanner.next();

        int maxLength = maxLength(strings); //find the max string length
        for(int i = 0; i < maxLength; i++) { //loop through chars in strings
            for(int j = 0; j < n; j++) { //loop through strings in array

                if(i <= strings[j].length() - 1) //if under string length
                    System.out.print(strings[j].charAt(i) + " "); //print char
                else
                    System.out.print("  "); //otherwise print a space
            }
            System.out.println(); //new line
        }
    }
}