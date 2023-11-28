package Medium;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        }
        else {
            Integer tmp = val < minStack.peek() ? val : minStack.peek();
            minStack.push(tmp);
        };
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        obj.top();
        System.out.println(obj.getMin());
    }
}
