package Medium;

import java.util.Objects;
import java.util.Stack;

public class evalRPN {
    public static int solution(String[] tokens) {
        Stack<Integer> tmp = new Stack<>();
        for(String str: tokens) {
            if(Objects.equals(str, "+")) {
                tmp.push(tmp.pop() + tmp.pop());
            } else if(Objects.equals(str, "-")) {
                    int a = tmp.pop();
                    int b = tmp.pop();
                    tmp.push(b - a);
            } else if(Objects.equals(str, "*")) {
                tmp.push(tmp.pop() * tmp.pop());
            } else if(Objects.equals(str, "/")) {
                int a = tmp.pop();
                int b = tmp.pop();
                tmp.push(b / a);
            } else {
                tmp.push(Integer.parseInt(str));
            }
        }
        return tmp.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution(tokens));
    }
}
