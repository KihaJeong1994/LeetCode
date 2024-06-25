class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack; // stack to store min value. you don't have to save the order of elements because the element will be removed in order, so pop behavior won't change the min value at certain moment

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offer(val);
        Integer lastMin = minStack.peekLast()!=null? Math.min(minStack.peekLast(),val) : val;
        minStack.offer(lastMin);
    }
    
    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */