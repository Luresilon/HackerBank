package Easy;

public class SumOfDigitsOfStringAfterConvert {

    private static int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int total = 0;

        for(char chr: chars) stringBuilder.append(chr - 'a' + 1);


        char[] str = stringBuilder.toString().toCharArray();
        for (char c : str) total += Integer.parseInt(String.valueOf(c));

        if(k >= 2) {
            for(int i = 1; i < k; i++) {
                str = String.valueOf(total).toCharArray();
                total = 0;
                for (char c : str) total += c - '0';
            }
        }

        return total;
    }

    public static void main(String[] args) {
        final int k = 2;
        final String str = "leetcode";
        System.out.println(getLucky(str, k));
    }
}
