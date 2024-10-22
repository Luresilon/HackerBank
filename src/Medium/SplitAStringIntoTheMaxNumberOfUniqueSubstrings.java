package Medium;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public static int maxUniqueSplit(String s) {
        Set<String> seen = new HashSet<>();
        return backtrack(s, 0, seen);
    }

    private static int backtrack(String s, int start, Set<String> seen) {
        // Base case: If we reach the end of the string, return 0 (no more substrings to add)
        if (start == s.length()) return 0;
        int[] it = {1, 2, 3, 1};

        int maxCount = 0;

        // Try every possible substring starting from 'start'
        for (int end = start + 1; end <= s.length(); ++end) {
            String substring = s.substring(start, end);
            // If the substring is unique
            if (!seen.contains(substring)) {
                // Add the substring to the seen set
                seen.add(substring);
                // Recursively count unique substrings from the next position
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen));
                // Backtrack: remove the substring from the seen set
                seen.remove(substring);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "ababccc";

        System.out.println(maxUniqueSplit(s));
    }
}
