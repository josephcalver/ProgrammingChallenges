package _8_5_RecursiveMultiply;

public class App {

    /*
    Write a recursive function to multiply two positive integers without using the * operator (or / operator).
    You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
     */

    public static int recursiveMultiply(int a, int b) {

        if (b == 1) return a;
        return a + recursiveMultiply(a, b - 1);
    }

    public static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {

        if (smaller == 0) return 0; // 0 * bigger = 0
        if (smaller == 1) return bigger; // 1 * bigger = bigger

        int s = smaller >> 1; // divide by 2
        System.out.println("s = " + s);
        int halfProd = minProductHelper(s, bigger);
        System.out.println("halfProd = " + halfProd);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }

    public static void main(String[] args) {

        int result = minProduct(5, 5);
        System.out.println(result);
    }

}
