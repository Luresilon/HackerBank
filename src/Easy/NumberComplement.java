package Easy;

public class NumberComplement {

    private static int findComplement(final int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder();
        for(char chr: str.toCharArray()) {
            if(chr == '1') stringBuilder.append(0);
            else stringBuilder.append(1);
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
    public static void main(String[] args) {
        int n  = 5;
        System.out.println(findComplement(n));
    }
}
