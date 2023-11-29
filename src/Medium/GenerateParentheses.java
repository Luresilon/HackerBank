package Medium;

import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {
    protected static Stack<String> res = new Stack<>();
    protected static Stack<String> stack = new Stack<>();

    public static void backtrack(int openN, int closeN, int n) {
        if((openN == closeN) & (openN == n)) {
            res.push(stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
        }
        if(openN < n) {
            stack.push("(");
            backtrack(openN + 1, closeN, n);
            stack.pop();
        }
        if(openN > closeN) {
            stack.push(")");
            backtrack(openN, closeN + 1, n);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        backtrack(0, 0, n);
        System.out.println(res);
    }
}
