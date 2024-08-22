package DynamicProgramming.Easy;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PropertyResourceBundle;

public class FibonacciSequence {
    private static final HashMap<Integer, BigInteger> memo = new HashMap<>();
    private static int fib(int n) {
        //Brute Force recursion
        //TimeComplexity = O(n^n/2)
        //Very unoptimised, can't handle long or biginteger

        if(n <= 1) return n;
        else return fib(n-1) + fib(n - 2);
    }
    private static BigInteger memoFib(int n) {
        //Memoization approach
        //TimeComplexity: O(n)

        if (memo.containsKey(n)) return memo.get(n);

        BigInteger result;

        if (n <= 2) result = BigInteger.ONE;
        else result = memoFib(n - 1).add(memoFib(n - 2));

        memo.put(n, result);
        System.out.println("Fib of: " + n + " is: " + result);
        return result;
    }
    private static BigInteger bottomUpApproachMemoFib(int n) {
        //Optimised Bottom-Up Approach + Memoization
        //Time Complexity: O(n) | Space Complexity: O(n)
        //Easy to see and analyse

        LinkedList<BigInteger> memo = new LinkedList<>();
        memo.add(BigInteger.ZERO);
        memo.add(BigInteger.ONE);

        for(int i = 2; i <= n; i++) memo.add(memo.get(i - 1).add(memo.get(i - 2)));

        return memo.get(n);
    }
    private static BigInteger bottomUpApproachFib(int n) {
        //Optimised Bottom-Up Approach
        //Time Complexity: O(n) | Space Complexity: O(1)

        if(n < 2) return BigInteger.valueOf(n);

        BigInteger prevFibOne = BigInteger.ONE;
        BigInteger prevFibTwo = BigInteger.ZERO;
        BigInteger result = BigInteger.ZERO;

        for(int i = 2; i <= n; i++) {
            result = prevFibOne.add(prevFibTwo);
            prevFibTwo = prevFibOne;
            prevFibOne = result;
        }

        return result;
    }
    public static void main(String[] args) {
        final int n = 6;

//        System.out.println(fib(n));
//        System.out.println(memoFib(n));
//        System.out.println(bottomUpApproachMemoFib(n));
//        System.out.println(bottomUpApproachFib(n));
    }
}
