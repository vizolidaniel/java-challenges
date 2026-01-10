package sorting_searching;

public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        // Explanation:
        // Use binary search twice: once to find left boundary, once for right boundary.
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true);
        result[1] = findBound(nums, target, false);
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return bound;
    }

    public static void main(String[] args) {
        FirstLastPosition flp = new FirstLastPosition();
        int[] result = flp.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println("First and Last Position: " + result[0] + ", " + result[1]); // Expected: 3, 4
    }
}

