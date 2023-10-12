import java.util.*;

class Next_Greater_Element_II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 })));
    }

    public static int[] nextGreaterElements(int[] nums) {
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        int ans[] = new int[nums.length * 2];
        int idx = (nums.length * 2) - 1;
        dq.push(nums[(nums.length * 2 - 1) % nums.length]);
        ans[idx--] = -1;
        System.out.println("-1");

        for (int i = (nums.length * 2) - 2; i >= 0; i--) {
            while (dq.isEmpty() == false && dq.getFirst() <= nums[i % nums.length])
                dq.pop();
            int nextG = (dq.isEmpty()) ? -1 : (dq.getFirst());
            System.out.println(nextG);
            ans[idx--] = nextG;
            dq.push(nums[i % nums.length]);
        }
        return Arrays.copyOf(ans, nums.length);
    }
}