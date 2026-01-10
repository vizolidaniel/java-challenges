package strings;

public class ReverseString {
    public void reverseString(char[] s) {
        // Explanation:
        // Use two pointers: one at the start, one at the end.
        // Swap characters until pointers meet in the middle.
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = {'h','e','l','l','o'};
        rs.reverseString(s);
        System.out.println("Reversed string: " + new String(s)); // Expected: "olleh"
    }
}

