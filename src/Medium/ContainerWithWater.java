package Medium;

public class ContainerWithWater {

    public static int maxArea(final int[] height) {
        int i = 0;
        int j = height.length - 1;
        int water = 0;

        while(i < j) {
            water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) i++;
            else j--;
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
