package Easy;

import java.util.*;

public class UncommonWordsFromTwoSentences {

    public static String[] uncommonFromSentences(String s1, String s2) {
        String merge = s1 + " " + s2;
        HashMap<String, Integer> map = new HashMap<>();

        for(String str: merge.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> S = new ArrayList<>();
        for(String word: map.keySet()) if(map.get(word) == 1) S.add(word);


        return S.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "I like this apple and fuck fuck";
        String s2 = "I like this banana and yes";

        HashMap<String, Integer> freq = new HashMap<>();
        freq.put("y", 2);
        freq.replace("y", freq.get("y") + 1);

        System.out.println(freq.entrySet());


        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }
}
