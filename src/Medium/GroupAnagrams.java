package Medium;

import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> res;

    public static List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            public List<String> get(int index) {
                if (res == null) init();
                return res.get(index);
            }

            public int size() {
                if (res == null) init();
                return res.size();
            }

            private void init() {
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                    int[] count = new int[26];
                    for (char c : s.toCharArray()) {

                        count[c - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (count[i] != 0) {
                            sb.append('a' + i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
                    res = new ArrayList<>(map.values());
                }
            }
        };
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> strList = groupAnagrams(str);
        for(List<String> s: strList) {
            System.out.println(s);
        }
    }
}
