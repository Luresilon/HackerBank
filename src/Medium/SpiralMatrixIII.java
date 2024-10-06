package Medium;

public class SpiralMatrixIII {

    protected static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] seq = new int[cols*rows][2];
        for(int i = 0; i < cols*rows; i++) {
            seq[i] = new int[]{rStart, cStart};
            if(cStart != cols) rStart--;

        }

        return new int[][]{};
    }
    public static void main(String[] args) {
        int[][] seq = spiralMatrixIII(5, 6, 1, 4);
    }
}
