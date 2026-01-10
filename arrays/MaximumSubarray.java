package arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Explanation:
        // Kadane’s Algorithm iterates through the array keeping track of the maximum sum ending at the current position.
        // At each step, we decide whether to start a new subarray or extend the existing one.
        // maxSoFar stores the global maximum found so far.
        // Runs in O(n) time.

        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int result = ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("Maximum Subarray Sum: " + result); // Expected: 6
    }
}
