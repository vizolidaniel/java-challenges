package arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // Explanation:
        // We use a pointer (index) to track where the next non-zero element should be placed.
        // First, move all non-zero elements forward.
        // Then, fill the remaining positions with zeros.
        // This preserves the relative order of non-zero elements.

        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
        System.out.print("Array after moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected: 1 3 12 0 0
    }
}
