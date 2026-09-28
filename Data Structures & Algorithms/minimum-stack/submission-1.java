class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mirrorStack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        mirrorStack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
        mirrorStack.push(min);
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();
        mirrorStack.pop();
        min = mirrorStack.peek();    
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mirrorStack.peek();
    }
}
