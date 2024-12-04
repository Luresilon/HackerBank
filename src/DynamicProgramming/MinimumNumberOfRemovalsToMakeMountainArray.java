package DynamicProgramming;

//Leetcode Problem: 1671

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfRemovalsToMakeMountainArray {

    public static int minimumMountainRemoval(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);

        int peak = 0;
        int index = 0;
        for(int num: nums) peak = Math.max(peak, num);

        while(arr[2] != 5) {
            arr[index] = nums[index];
            index++;
                if(nums[index] > arr[index - 1]) {
                    arr[index] = nums[index];
                } else {
                    for(int j = index - 1; j >= 0; j--) {
//                        if(nums[index] > arr[index - 1])
                    }
                }
            System.out.println(Arrays.toString(arr));
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5};
        System.out.println(minimumMountainRemoval(arr));
    }
}
