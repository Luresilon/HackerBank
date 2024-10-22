package Medium;

public class MaximumSwap {
    public static int maximumSwap(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) arr[i] = str.charAt(i) - '0';

        int[] maxIndexFromRight = new int[len];
        int maxIndex = len - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
            maxIndexFromRight[i] = maxIndex;
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] < arr[maxIndexFromRight[i]]) {
                int temp = arr[i];
                arr[i] = arr[maxIndexFromRight[i]];
                arr[maxIndexFromRight[i]] = temp;
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j : arr) stringBuilder.append(j);

        return Integer.parseInt(stringBuilder.toString());
    }
    public static void main(String[] args) {
        int num = 98368;

        System.out.println(maximumSwap(num));
    }
}
