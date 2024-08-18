package Easy;

public class NumberOfSeniorCitizens {
    protected static int countSeniors(final String[] details) {
        int res = 0;
        for(String e: details) if(Integer.parseInt(e.substring(11, 12)) >= 6) res++;
        return res;
    }
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println("\n" + countSeniors(details));
//        countSeniors(details);
    }
}
