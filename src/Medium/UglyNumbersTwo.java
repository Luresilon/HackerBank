package Medium;

import java.util.LinkedList;

public class UglyNumbersTwo {

    public static int nthUglyNumber(int num) {
        LinkedList<Integer> uglyNumbers = new LinkedList<>();
        int counter = 1;

        while(uglyNumbers.size() != num) {
            if(checker(counter)) uglyNumbers.add(counter);
            counter++;
        }

        return uglyNumbers.stream().mapToInt(i -> i).toArray()[num - 1];
    }

    public static boolean checker(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
    public static void main(String[] args) {
        int num = 10;
        System.out.println(nthUglyNumber(num));
//        System.out.println(checker(6));
    }
}
