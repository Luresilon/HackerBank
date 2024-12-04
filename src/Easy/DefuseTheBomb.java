package Easy;

import java.util.Arrays;

//Leetcode problem: 1652
public class DefuseTheBomb {

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];

        if(len < k) return new int[len];
        if(k == 0) return res;



        return code;
    }
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }
}
