import java.util.*;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if(!numSet.contains(tmp)) numSet.add(tmp);
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr));
    }
}
