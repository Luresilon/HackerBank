package Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

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

    public static int[] topKFrequentTwo(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num: nums) frequencyMap.merge(num, 1, Integer::sum);

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2,2,2, 3,3 ,3, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequentTwo(nums, k)));
    }
}
