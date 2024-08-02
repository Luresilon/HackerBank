package Medium;

public class TwoDMatrixSolution {
    static public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int lo = 0;
        int hi = rows * columns - 1;

        while(lo < hi) {
            int mid = lo + (int) Math.floor( (double) (hi - lo + 1) / 2);

            if(target < matrix[mid/columns][mid % columns]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return target == matrix[lo / columns][lo % columns];
    }

    public static void main(String[] args) {
        int target = 34;
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr, target));
    }
}
