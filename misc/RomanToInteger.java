package misc;

import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        // Explanation:
        // Map Roman symbols to values.
        // Traverse string, subtract if smaller value precedes larger one.
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println("Roman 'MCMXCIV' = " + rti.romanToInt("MCMXCIV")); // Expected: 1994
    }
}

