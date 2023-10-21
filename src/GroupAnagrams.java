import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strings) {
        Map<Map<Character,Long>, ArrayList<String>> groupAna = new HashMap<>();

        for (var string: strings) {
            Map<Character, Long> charCountString = separator(string);
            if(!groupAna.containsKey(charCountString)) {
                groupAna.put(charCountString, new ArrayList<>());
            }
            groupAna.get(charCountString).add(string);
        }
//        System.out.println(groupAna);
        List<List<String>> result = new ArrayList<>(groupAna.values());
        result.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                return a.size() - b.size();
            }
        });
        return result;
    }
//    private
    private static Map<Character, Long> separator(String string) {
        return string.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }
}
