package Medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {

//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            int counter = 0;
//
//            if(i == temperatures.length - 1) res[i] = 0;
//
//            for(int j = i + 1; j < temperatures.length; j++) {
//                counter++;
//                if(temperatures[j] > temperatures[i]) {
//                    res[i] = counter;
//                    break;
//                }
//            }
//
//            if(temperatures.length == counter + i) res[i] = 0;
//        }
//        return res;
//    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = temperatures.length  - 1; i >= 0; i--) {
            while(!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();

            if(stack.isEmpty()) {
                ret[i] = 0;
            } else {
                ret[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] n = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(n);
        System.out.println(Arrays.toString(res));
    }
}
