public class Lab1c {

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

        int n = Integer.parseInt(args[args.length - 2]);
        int k = Integer.parseInt(args[args.length - 1]);
        String name = "";
        for(int i = 0; i < args.length - 2; i++) {
            if(i == args.length - 3) 
                name += args[i];
            else 
                name += args[i] + " ";
        }

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