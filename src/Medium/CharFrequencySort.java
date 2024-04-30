package Medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharFrequencySort {

//    public static String frequencySort(String s) {
//        Map<Character, Integer> map = s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.summingInt(c -> 1)));
//
//        LinkedHashMap<Character, Integer> sortedMap = map.entrySet().stream()
//                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
//                ));
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for(var entry: sortedMap.entrySet()) stringBuilder.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
//
//        return stringBuilder.toString();
//    }





    public static String func(String s) {
        //Collect character frequency in a map {key: char -> value: frequency in string)
        //Sort it
        //Put it together with string builder
        Map<Character, Integer> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(c -> 1)));

        LinkedHashMap<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        StringBuilder stringBuilder = new StringBuilder();
        for(var entry: sortedMap.entrySet()) {
            stringBuilder.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return stringBuilder.toString();
    }



    public static String funcR(final String s) {
        Map<Character, Integer> map = s.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.summingInt(c -> 1)));

        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> newValue, LinkedHashMap::new));

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: sortedMap.entrySet()) {
            stringBuilder.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return stringBuilder.toString();
    }























    public static void main(String[] args) {
        String s = "tree";

        System.out.println(funcR(s));
    }
}
