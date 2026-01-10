package dynamic_programming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Explanation:
        // We use bottom-up DP. dp[i] = minimum coins to make amount i.
        // Initialize with a large value, then update using each coin.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println("Min coins for amount 11: " + cc.coinChange(new int[]{1,2,5}, 11)); // Expected: 3
    }
}

