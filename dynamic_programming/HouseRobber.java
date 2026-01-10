package dynamic_programming;

public class HouseRobber {
    public int rob(int[] nums) {
        // Explanation:
        // dp[i] = max money robbed up to house i.
        // Transition: dp[i] = max(dp[i-1], dp[i-2] + nums[i]).
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println("Max money robbed: " + hr.rob(new int[]{2,7,9,3,1})); // Expected: 12
    }
}

