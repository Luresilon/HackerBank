package Hard;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

    public static double findMedian(final int[] nums1,final int[] nums2) {
        int[] newArr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, newArr, 0, nums1.length);
        System.arraycopy(nums2, 0, newArr, nums1.length, nums2.length);
        int n = newArr.length;
        Arrays.sort(newArr);

        if(n % 2 == 0) {
            int index = Math.abs(newArr.length / 2);
            return (double) (newArr[index] + newArr[index - 1]) / 2;
        }
        return newArr[Math.abs(newArr.length / 2)];
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        double res = findMedian(nums1, nums2);
        System.out.println(res);
    }
}
