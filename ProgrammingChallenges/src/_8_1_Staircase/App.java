package _8_1_Staircase;

import java.util.Arrays;

public class App {

    /*
    A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
    Implement a method to count how many possible ways the child can run up the stairs.
     */

    public static int climbStairs(int n) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
    }

    public static int climbStairsMemo(int n) {

        if (n == 0) return 1;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairsMemo(n, memo);
    }

    private static int climbStairsMemo(int n, int[] memo) {

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo) + climbStairsMemo(n-3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {

//        System.out.println(climbStairs(12));
        System.out.println(climbStairsMemo(15));

    }

}
