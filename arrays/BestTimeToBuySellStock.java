package arrays;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        // Explanation:
        // We track the lowest price seen so far (minPrice).
        // For each price, calculate the profit if we sold at that day.
        // Update maxProfit if this profit is greater than the current maximum.
        // Runs in O(n) time with a single pass.

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock bt = new BestTimeToBuySellStock();
        int result = bt.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("Maximum Profit: " + result); // Expected: 5
    }
}

