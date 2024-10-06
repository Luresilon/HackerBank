package Medium.CircularDequeDesign;

import java.util.LinkedList;
import java.util.Stack;

public class CustomStack {
    int maxSize;
    Stack<Integer> customStack;

    public CustomStack(int maxSize) {
        this.customStack = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(customStack.size() < maxSize) customStack.push(x);
    }

    public int pop() {
        if(customStack.isEmpty()) return -1;
        return customStack.pop();
    }

    public void increment(int k, int val) {
        if(!customStack.isEmpty()) {
            for(int i = 0; i < Math.min(customStack.size(), k); i++) {
                int num = customStack.get(i);
                customStack.set(i, num + val);
            }
        }
    }
}

class main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.pop();
        customStack.push(3);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
    }
}