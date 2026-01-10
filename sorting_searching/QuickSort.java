package sorting_searching;

public class QuickSort {
    public void quickSort(int[] nums, int low, int high) {
        // Explanation:
        // Choose a pivot, partition array so smaller elements are left, larger are right.
        // Recursively sort partitions.
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
            }
        }
        int temp = nums[i + 1]; nums[i + 1] = nums[high]; nums[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] nums = {10,7,8,9,1,5};
        qs.quickSort(nums, 0, nums.length - 1);
        System.out.print("Sorted array: ");
        for (int num : nums) System.out.print(num + " ");
        // Expected: 1 5 7 8 9 10
    }
}

