package graphs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Explanation:
        // We use BFS to find the shortest transformation.
        // Each level corresponds to one transformation step.
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chars[i] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest transformation length: " + wl.ladderLength("hit", "cog", wordList)); // Expected: 5
    }
}

