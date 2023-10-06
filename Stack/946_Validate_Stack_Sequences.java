class 946_Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      int N = pushed.length;  
        Stack<Integer> stack = new Stack();
        int j=0;
        for(int item: pushed){
            stack.push(item);
            while(!stack.isEmpty()&& j<N && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return j==N;
    }
}