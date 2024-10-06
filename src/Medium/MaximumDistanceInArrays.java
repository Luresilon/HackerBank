package Medium;

import JobCodeChallenges.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDistanceInArrays {
//    public static int maxDistance(List<List<Integer>> arrays) {
//        int max = arrays.get(0).get(0);
//        int min = Integer.MAX_VALUE;
//
//        if(arrays.size() == 2 && arrays.get(0).size() == 1) {
//            int max = Collections.max(arrays.get(0).get(0), arrays.get(1).get(0));
//            int min = Collections.min(arrays.get(0).get(0), arrays.get(1).get(0));
//            return max - min;
//        }
//
//        for(List<Integer> lst: arrays) {
//            if(Collections.max(lst) > max) {
//                max = Collections.max(lst);
//                continue;
//            }
//            if(Collections.min(lst) < min){
//                min = Collections.min(lst);
//            }
////            max = Math.max(max, Collections.max(lst));
////            min = Math.min(min, Collections.min(lst));
//        }
//
////        System.out.println("\nmax is: " + max + "\nmins is: " + min);
//        return max - min;
//    }
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>(){};
        arrays.add(new ArrayList<>(){{add(1); add(2); add(3);}});
        arrays.add(new ArrayList<>(){{add(4); add(5);;}});
        arrays.add(new ArrayList<>(){{add(1); add(2); add(3);}});

//        System.out.println(maxDistance(arrays));
    }
}
