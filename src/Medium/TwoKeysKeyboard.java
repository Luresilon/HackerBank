package Medium;

public class TwoKeysKeyboard {
    protected static int minSteps(int n) {

        return -1;
    }

    protected static int checker(int n) {
        int res = n;
        int total = 0;

        while (res != 1) {
            for (int i = 2; i <= res; i++) {
                if (res % i == 0) {
                    res /= i;
                    total += i;
                    break;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int n = 0;
        System.out.println(checker(3));
//        System.out.println(Math.sqrt(3));
    }
}
