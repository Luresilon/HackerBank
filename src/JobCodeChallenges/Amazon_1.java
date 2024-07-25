package JobCodeChallenges;

import java.util.Arrays;
import java.util.List;

public class Amazon_1 {

    public static int distributePower(List<Integer> servers) {
        //Brute force
        //will require helper method for checking map status
        //O(N^2) time complexity, could be improved
        int totalIncrement = 0;

        while(!isMapIncreasing(servers)) {
            final int serverSize = servers.size() - 1;
            int index = 0;
            int increment = 0;

            for(int i = 0; i < serverSize; i++) {
                final int currentServer = servers.get(i);
                final int nextServer = servers.get(i + 1);

                if(currentServer > nextServer) {
                    index = i + 1;
                    increment = currentServer - nextServer;
                    totalIncrement += increment;
                    break;
                }
            }

            for(int i = index; i <= serverSize; i++) {
                servers.set(i, servers.get(i) + increment);
            }
        }

        return totalIncrement;
    }

    public static int betterDistributePower(List<Integer> servers) {
        //Improved O(N) complexity
        //could possibly be improved to O(Log(N)) while maintaining readability
        //no longer needs external helper
        //iterates once over the List instead of per element as the brute-force version
        int totalIncrement = 0;
        int[] increments = new int[servers.size()];

        for (int i = 0; i < servers.size() - 1; i++) {
            if (servers.get(i) > servers.get(i + 1)) {
                int increment = servers.get(i) - servers.get(i + 1);
                increments[i + 1] += increment;
                totalIncrement += increment;
            }
        }

        // Apply the increments
        for (int i = 1; i < servers.size(); i++) {
            servers.set(i, servers.get(i) + increments[i]);
        }

        return totalIncrement;
    }
    public static boolean isMapIncreasing(List<Integer> servers) {
        for(int i = 0; i < servers.size() - 1; i++) {
            if(servers.get(i) > servers.get(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> servers = Arrays.asList(4, 1,6, 3, 2);
        System.out.println(betterDistributePower(servers));
    }
}
