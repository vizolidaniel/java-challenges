package sorting_searching;

public class BinarySearch {
    public int search(int[] nums, int target) {
        // Explanation:
        // Classic binary search: repeatedly divide the array in half.
        // Compare target with middle element, adjust left/right boundaries.
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println("Index of 9: " + bs.search(new int[]{-1,0,3,5,9,12}, 9)); // Expected: 4
    }
}

