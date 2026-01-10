package strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Explanation:
        // Sort each string alphabetically and use it as a key in HashMap.
        // Strings with same sorted key are anagrams and grouped together.
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> result = ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println("Grouped anagrams: " + result);
        // Expected: [["eat","tea","ate"],["tan","nat"],["bat"]]
    }
}

