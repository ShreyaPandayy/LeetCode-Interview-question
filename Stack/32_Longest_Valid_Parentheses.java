import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Character> ch = new Stack<Character>();
        Stack<Integer> index = new Stack<Integer>();
        index.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ch.push(s.charAt(i));
                index.push(i);

            } else {
                if (ch.isEmpty()) {

                    index.push(i);
                } else {
                    if (ch.peek() == '(')
                        ch.pop();
                    index.pop();
                    ans = Math.max(ans, i - index.peek());
                }
            }
        }
        return ans;
    }
}