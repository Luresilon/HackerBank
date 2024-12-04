package Easy;
//Leetcode problem: 1957
public class DeleteCharactersToMakeFancyString {

    public static String makeFancyString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();

        int counter = 0;
        char prev = chars[0];

        for(char chr: chars) {
            if(prev == chr) {
                counter++;
                if(counter < 3) stringBuilder.append(chr);
            } else {
                counter = 1;
                prev = chr;
                stringBuilder.append(chr);
            }
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String str = "leeetcode";

        System.out.println(makeFancyString(str));
    }
}
