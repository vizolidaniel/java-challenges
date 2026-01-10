package sorting_searching;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] nums, int left, int right) {
        // Explanation:
        // Divide array into halves recursively, then merge sorted halves.
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
        while (i <= mid - left && j <= right - left) {
            if (temp[i] <= temp[j]) nums[k++] = temp[i++];
            else nums[k++] = temp[j++];
        }
        while (i <= mid - left) nums[k++] = temp[i++];
        while (j <= right - left) nums[k++] = temp[j++];
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] nums = {5,2,3,1};
        ms.mergeSort(nums, 0, nums.length - 1);
        System.out.print("Sorted array: ");
        for (int num : nums) System.out.print(num + " ");
        // Expected: 1 2 3 5
    }
}

