import java.util.*;

class Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int fre[] = new int[256];
        int max = 0;
        int start = 0, end = 0;
        while (end < s.length()) {
            if (fre[s.charAt(end)] == 0) {
                // count++;
                fre[s.charAt(end)] = 1;
                end++;
            } else {
                fre[s.charAt(start)] = 0;
                start++;
            }

            max = Math.max(end - start, max);

        }
        return max;
    }
}