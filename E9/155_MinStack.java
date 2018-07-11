Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


class MinStack {
    
    private LinkedList<Integer> stack;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){//这里必须要是<=,不能只是<
            stack.offerLast(min);
            min = x;
        }
        stack.offerLast(x);
    }
    
    public void pop() {
        if(min==stack.pollLast()){
            min = stack.pollLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min;
    }
}