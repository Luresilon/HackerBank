package Medium;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        //brute force
        //time complexity: O(n * m)
        for(int[] arr: matrix) {
            int tmp = 0;
            while(tmp != arr.length) {
                if(arr[tmp] == target) return true;
                tmp++;
            }
        }
        return false;
    }

    public static boolean betterSearchMatrix(int[][] matrix, int target) {
        int columns = matrix[0].length; // 4
        int rows = matrix.length; // 3

        int lo = 0;
        int hi = columns * rows - 1;

        while(lo < hi) {
            int mid = lo + (int) Math.floor((double) (hi - lo + 1) / 2);
            if(target < matrix[mid / columns][mid % columns]) hi = mid - 1;
            else lo = mid;
        }
        return matrix[lo / columns][lo % columns] == target;
    }
    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] numsOne = {{1}};
        int target = 3;
        System.out.println(searchMatrix(nums, target));
    }
}
