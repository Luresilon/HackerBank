package Easy;

import java.util.*;

public class RankTransformOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return new int[]{};

        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);

        HashMap<Integer, Integer> rank = new HashMap<>();
        for(int num: A) rank.putIfAbsent(num, rank.size() + 1);


        for(int i = 0; i < arr.length; i++) A[i] = rank.get(arr[i]);

        return A;
    }


    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30, 40};
        int[] arr2 = {37,12,28,9,100,56,80,5,12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
