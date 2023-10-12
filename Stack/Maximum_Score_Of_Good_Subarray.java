import java.util.Stack;

public class Maximum_Score_Of_Good_Subarray {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] { 1, 4, 3, 7, 4, 5 }, 3));
    }

    public static int maximumScore(int[] nums, int k) {
        return Area(nums, k);
    }

    public static int Area(int[] arr, int k) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {

                int r = i;// r interval part nhi hai , r-1 tk interval
                int h = arr[st.pop()];
                if (r - 1 >= k) {
                    if (!st.isEmpty()) {
                        int l = st.peek();// l interval part nhi hai , l+1 se hoga interval
                        if (l + 1 <= k) {
                            ans = Math.max(ans, h * (r - l - 1));
                        }
                    }

                    else {
                        ans = Math.max(ans, h * r);
                    }
                }
            }
            st.push(i);

        }

        int r = arr.length;

        while (!st.isEmpty() && r - 1 >= k) {
            // area

            int h = arr[st.pop()];

            if (!st.isEmpty()) {
                int l = st.peek();// l interval part nhi hai , l+1 se hoga interval
                if (l + 1 <= k) {
                    ans = Math.max(ans, h * (r - l - 1));
                }
            }

            else {
                ans = Math.max(ans, h * r);
            }

        }
        return ans;
    }
}
