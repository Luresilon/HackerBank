package JobCodeChallenges;

public class carFactory {
    public static int solution(int[] A, int[] B, int X, int Y) {

        int ATime = A[0];
        int BTime = B[0];

        for (int i = 1; i < A.length; i++) {
            int checkA = Math.min(ATime + A[i], BTime + Y + A[i]);
            int checkB = Math.min(BTime + B[i], ATime + X + B[i]);

            ATime = checkA;
            BTime = checkB;
        }

        // Choose the minimum of the two total times
        return Math.min(ATime, BTime);
    }

public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A1 = {1, 6, 2};
        int[] B1 = {3, 2, 5};
        int X1 = 2;
        int Y1 = 1;
        int result1 = solution(A1, B1, X1, Y1);
        System.out.println("Test 1: " + (result1 == 8));  // Expected output: true

        int[] A2 = {2, 11, 4, 4};
        int[] B2 = {9, 2, 5, 11};
        int X2 = 8;
        int Y2 = 4;
        int result2 = solution(A2, B2, X2, Y2);
        System.out.println("Test 2: " + (result2 == 21));  // Expected output: true

        int[] A3 = {1, 10, 1};
        int[] B3 = {10, 1, 10};
        int X3 = 1;
        int Y3 = 5;
        int result3 = solution(A3, B3, X3, Y3);
        System.out.println("Test 3: " + (result3 == 9));  // Expected output: true

        int[] A4 = {8, 3, 3};
        int[] B4 = {6, 1, 10};
        int X4 = 4;
        int Y4 = 3;
        int result4 = solution(A4, B4, X4, Y4);
        System.out.println("Test 4: " + result4);  // Expected output: true

        // You can add more test cases here.
    }
}
