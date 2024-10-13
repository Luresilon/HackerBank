package Medium;
//LeetCode Problem: 1942

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TheNumberOfTheSmallestUnoccupiedChair {

    public static int smallestChair(int[][] AA, int target) {
        SortedMap<Integer, Integer> map = new TreeMap<>();

        for(int[] A: AA) map.put(A[0], A[1]);

        int[] newA = new int[AA.length];
        int counter = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(newA[counter] == 0) {
                newA[counter] = entry.getKey();
                counter++;
            }



        }





        System.out.println(map);
        System.out.println(Arrays.toString(newA));


        return -1;
    }

    public static void main(String[] args) {
        int[][] AA = {{1, 4}, {2,3}, {4, 6}};
        int targetFriend = 1;

        System.out.println(smallestChair(AA, 1));
    }
}
