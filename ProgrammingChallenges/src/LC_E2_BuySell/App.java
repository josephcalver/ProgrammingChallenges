package LC_E2_BuySell;

public class App {

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int i = 0, j = 1, profit = 0;

        while (i < prices.length - 1) {

            //System.out.println("i = " + i + ", j = " + j);

            if (prices[i] < prices[j]) {

                while (j + 1 < prices.length && prices[j + 1] > prices[j]) {
                    j++;
                }
                profit += (prices[j] - prices[i]);
                i = j + 1;
                j = i + 1;
            } else {
                i++;
                j++;
            }
        }
        return profit;
    }

    public static void main(String[] args) {

        //int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};

        int profit = maxProfit(prices);

        System.out.println(profit);

    }

}
