package strings;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        // Explanation:
        // Use sliding window to check substrings of length needle.
        // If substring matches needle, return index.
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr iss = new ImplementStrStr();
        System.out.println("Index of 'sad': " + iss.strStr("sadbutsad", "sad")); // Expected: 0
    }
}

