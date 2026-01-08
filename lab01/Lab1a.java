public class Lab1a {

    public static void main(String[] args) {

        int[] x = new int[10];
        //int k = 0;
        // while(k < 10) {
        //     x[k] = k*k;
        //     k++;
        // }
        for(int i = 0; i < 10; i++)
            x[i] = i*i;

        for (int j = 0; j < 10; j++)
            System.out.println(j + " squared is " + x[j]);
    }
}