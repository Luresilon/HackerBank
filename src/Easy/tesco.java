package Easy;

public class tesco {

    public static boolean clubcardValidate(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int total = Integer.parseInt(String.valueOf(chars[len - 1]));


        for(int i = s.length() - 2; i >= 0; i--) {
            int num = Integer.parseInt(String.valueOf(chars[i]));
            if(len % 2 != 0) {
                if(i % 2 != 0) {
                    int tmp = num * 2;
                    if(tmp > 9) total += tmp - 9;
                    else  {
                        total += tmp;
                    }
                } else {
                    total += num;
                }
            } else {
                if(i % 2 == 0) {
                    int tmp = num * 2;
                    if(tmp > 9) total += tmp - 9;
                    else  {
                        total += tmp;
                    }
                } else {
                    total += num;
                }
            }
        }
        return total % 10 == 0;
    }
    public static void main(String[] args) {
        String tmp = "346088197380157";
        String tmp2 = "4916283358950480";
        String tmp3 = "5454411550469035";
        System.out.println(clubcardValidate(tmp2));
    }
}
