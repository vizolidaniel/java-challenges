package arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Explanation:
        // We use a HashMap to store numbers already seen and their indices.
        // For each element, we calculate the complement (target - nums[i]).
        // If the complement exists in the map, we return the pair of indices.
        // This approach runs in O(n) time, much faster than brute force.

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Expected: 0, 1
    }
}
