package Easy;
//Leetcode problem: 2490
public class CircularSentence {

    public static boolean isCircularSentence(String s) {
        String[] sentence = s.split(" ");
        char firstChar = sentence[0].charAt(0);
        char lastChar = sentence[sentence.length - 1].charAt(sentence[sentence.length - 1].length() - 1);

        if(firstChar != lastChar) return false;

        char prev = sentence[0].charAt(sentence[0].length() - 1);
        for(int i = 1; i < sentence.length; i++) {
            char curr = sentence[i].charAt(0);
            if(prev != curr) return false;
            prev = sentence[i].charAt(sentence[i].length() - 1);
        }
        return true;
    }

    public static boolean isPrime(int n) {
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "leetcode exercises sound delightful";
//        System.out.println(isCircularSentence(s));
        System.out.println(isPrime(7));
    }
}
