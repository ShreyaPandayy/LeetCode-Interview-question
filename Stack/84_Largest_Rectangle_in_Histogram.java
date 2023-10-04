class 84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
        return Area(heights);
    }
   public static int Area(int[] arr) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				int h = arr[st.pop()];
				int r = i;
				if (st.isEmpty()) {
					int a = h * r;
					ans = Math.max(ans, a);
				} else {
					int l = st.peek();
					int a = h * (r - l - 1);
					ans = Math.max(ans, a);
				}
			}
			st.push(i);
		}
		int r = arr.length;
		while (!st.isEmpty()) {
			int h = arr[st.pop()];

			if (st.isEmpty()) {
				int a = h * r;
				ans = Math.max(ans, a);
			} else {
				int l = st.peek();
				int a = h * (r - l - 1);
				ans = Math.max(ans, a);
			}
		}
		return ans;

	}

}