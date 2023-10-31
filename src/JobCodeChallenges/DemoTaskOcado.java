package JobCodeChallenges;

import java.util.*;
import java.util.stream.Collectors;

public class DemoTaskOcado {


    public static String solution(String S, int K) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        // Find the index of the input day
        int initialDayIndex = 0;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (S.equals(daysOfWeek[i])) {
                initialDayIndex = i;
                break;
            }
        }

        // Calculate the index of the resulting day
        int resultingDayIndex = (initialDayIndex + K) % 7;

        // Return the resulting day
        return daysOfWeek[resultingDayIndex];
    }

    public static void main(String[] args) {
        String S = "Wed";
        int K = 2;
        System.out.println(solution(S, K));  // Output: "Fri"

        S = "Sat";
        K = 23;
        System.out.println(solution(S, K));  // Output: "Mon"
    }
}
