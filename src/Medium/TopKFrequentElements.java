package Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

//    public static int[] topKFrequent(int[] nums, int k) {
//        return Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(it -> it, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
//                .limit(k)
//                .mapToInt(Map.Entry::getKey).toArray();
//    }

//    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(
//                Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()
//                )
//        );
//
//        return map.entrySet().stream()
//                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
//                .limit(k)
////                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
//                .mapToInt(Map.Entry::getKey).toArray();
//
////        return new int[] {};
//    }




    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey).toArray();
    }






    public static int[] func(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey).toArray();
    }





    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2,2,2, 3,3 ,3, 3};
        int k = 2;

        System.out.println(Arrays.toString(func(nums, k)));
    }
}
