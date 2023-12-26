package Hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class largestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 1) return heights[0];

        int lar = 0;
        for(int i = 0; i < heights.length; i++) {
            int tmp = 0;
            int j = i + 1;
            int lowest = heights[i];

            while(j != heights.length + 1) {
                int tmpTwo = 0;
                if(j == heights.length) {
                    tmpTwo = heights[i];
                } else {
                    lowest = Math.min(lowest, heights[j]);
                    tmpTwo = Math.max(heights[i], lowest * (1 + j - i));
                }
                tmp = Math.max(tmp, tmpTwo);
                j++;
            }
            lar = Math.max(lar, tmp);
        }
        return lar;
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 2};
        System.out.println(largestRectangleArea(heights));
    }
}
