package JobCodeChallenges;

import java.util.HashSet;

public class A {
    public static boolean containsNumber(int[] ints, int k) {
        HashSet<Integer> intSet = new HashSet<>();

        for(int number: ints) intSet.add(number);

        return intSet.contains(k);
    }
}
