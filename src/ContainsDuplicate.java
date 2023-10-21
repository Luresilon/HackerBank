import java.util.*;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !numSet.add(num));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
}
