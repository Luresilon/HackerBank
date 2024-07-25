package Medium;

public class ContainerWithMostWater {
//    public static int maxArea(int[] height) {
//        //Brute force
//        int max = 0;
//        for(int i = 0; i < height.length; i++) {
//            for(int j = i + 1; j < height.length; j++) {
//                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//
//        return max;
//    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int water = 0;

        while(l < r) {
            water = Math.max(water, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]) l++;
            else r--;
        }

        return water;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
