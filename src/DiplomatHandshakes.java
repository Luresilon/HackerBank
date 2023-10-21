import java.util.ArrayList;
import java.util.List;

public class DiplomatHandshakes {
    public static List<Integer> diplomats(List<String> inputs) {
        int n = inputs.size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String diplomats = inputs.get(i);
            int totalHandshakes = 0;
            for (int j = 0; j < diplomats.length(); j++) {
                String burandaDiplomats = diplomats.substring(j);
                int handshakes = 0;
                for (int k = 0; k < burandaDiplomats.length(); k++) {
                    if (diplomats.charAt(k) == burandaDiplomats.charAt(k)) {
                        handshakes++;
                    } else {
                        break;
                    }
                }
                totalHandshakes += handshakes;
            }
            result.add(totalHandshakes);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("abcabcd");
        inputs.add("aba");
        List<Integer> result = diplomats(inputs);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
