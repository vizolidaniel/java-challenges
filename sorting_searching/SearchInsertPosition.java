package sorting_searching;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // Explanation:
        // Modified binary search: if target not found, return left boundary.
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println("Insert position of 5: " + sip.searchInsert(new int[]{1,3,5,6}, 5)); // Expected: 2
        System.out.println("Insert position of 2: " + sip.searchInsert(new int[]{1,3,5,6}, 2)); // Expected: 1
    }
}

