package Easy;

public class GeneratePyramids {

    public static void printPyramid(final int s) {

        for(int i = 0; i < s; i++) {
            String str = " ".repeat(s - (i + 1)) +
                    "#".repeat(i + 1) +
                    "  " +
                    "#".repeat(i + 1) +
                    " ".repeat(s - (i + 1));
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        printPyramid(8);
    }
}
