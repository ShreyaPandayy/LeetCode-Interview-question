package sliding_window;

import java.util.HashMap;

public class Longest_Substring_With_Atleast_K_rpeating {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        // count
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) < k) {
                if (isPossible(s, start, i - 1, k)) {
                    max = Math.max(max, i - start);
                }
                start = i + 1;
            }
        }
        if (isPossible(s, start, s.length() - 1, k)) {
            max = Math.max(max, s.length() - start);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public boolean isPossible(String s, int start, int end, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;

        for (int i = start; i <= end; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            if (hm.get(s.charAt(i)) == k) {
                count++;
            }
        }
        return count == hm.size();
    }
}
