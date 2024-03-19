package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicates {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums) {
            if(set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};

        boolean isDuplicate = containsDuplicate(nums);
        System.out.println(isDuplicate);
    }
}
