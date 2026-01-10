package arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // Explanation:
        // We compute two auxiliary arrays:
        // left[i] = product of all elements before index i
        // right[i] = product of all elements after index i
        // The result for each position is left[i] * right[i].
        // This avoids division and works even with zeros in the array.

        int n = nums.length;
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf pa = new ProductOfArrayExceptSelf();
        int[] result = pa.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.print("Product Except Self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected: 24 12 8 6
    }
}

