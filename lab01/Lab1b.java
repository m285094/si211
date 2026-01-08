import java.util.*;

public class Lab1b {

    public static int partialFactorial(int n, int m) {
        int x = 1;
        for(int i = n; i >= m; i--)
            x *= i;

        return x;
    }

    public static int factorial(int n) {
        int x = 1;
        for(int i = n; i > 1; i--)
            x *= i;

        return x;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.print("Please input an integer ");
        int n = in.nextInt();
        System.out.print("Please input a second integer ");
        int k = in.nextInt();
        System.out.println("The two ints were " + n + " and " + k);


        int numerator = partialFactorial(n, n - k + 1);
        int denom = factorial(k);
        double odds = numerator/denom;

        System.out.println("numerator = " + numerator);
        System.out.println("denominator = " + denom);
        System.out.println("odds = 1 in " + ((int)odds) + " = " + (1/(odds)));
        System.out.println("Goodbye " + name + ".");
    }
}