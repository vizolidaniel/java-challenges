package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // Explanation:
        // dp[i] = length of LIS ending at index i.
        // For each j < i, if nums[j] < nums[i], update dp[i] = max(dp[i], dp[j] + 1).
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("Length of LIS: " + lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})); // Expected: 4
    }
}
