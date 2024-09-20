package Easy;

import javax.annotation.processing.SupportedAnnotationTypes;

public class ConvertDateTOBinary {

    private static String convertDateToBinary(String date) {
        String[] dates = date.split("-");
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < dates.length; i++) {
            stringBuilder.append(Integer.toBinaryString(Integer.parseInt(dates[i])));
            if(i == dates.length - 1) continue;
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String date = "2080-02-29";

        System.out.println(convertDateToBinary(date).equals("100000100000-10-11101"));


    }
}
