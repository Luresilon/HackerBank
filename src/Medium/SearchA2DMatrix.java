package Medium;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr: matrix) {
            int tmp = 0;
            while(tmp != arr.length) {
                if(arr[tmp] == target) return true;
                tmp++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1}};
        int target = 1;
        System.out.println(searchMatrix(nums, target));
    }
}
