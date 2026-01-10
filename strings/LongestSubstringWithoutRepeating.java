package strings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        // Explanation:
        // Use sliding window with a HashSet to track characters.
        // Expand window until duplicate found, then shrink from left.
        int left = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating lsw = new LongestSubstringWithoutRepeating();
        System.out.println("Longest substring length: " + lsw.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
    }
}

