package Medium;

public class CheckIfArrayPairsAreDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];

        for(int n: arr) {
            int tmp = ((n % k) + k) % k;
            frequency[tmp] += 1;
        }

        if(frequency[0] % 2 != 0) { return false; }

        for(int i = 1; i < k / 2; i++) {
            if(frequency[i] != frequency[k - 1]) { return false; }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9}; //[2, 2, 2, 2, 2]
        int k = 5;
        System.out.println(((1 % 3) + 3) % 3);
        System.out.println(2%7234);
        System.out.println(canArrange(arr, k));
    }
}
