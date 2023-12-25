package Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    private static int countCarFleets(TreeMap<Integer, Integer> speedMap) {
        int carFleets = 0;
        double maxSpeed = -1;

        for (int speed : speedMap.values()) {
            double timeToReach = (double) speed / (double) (speedMap.floorKey(speed) + 1);

            if (timeToReach > maxSpeed) {
                // New car fleet is formed
                maxSpeed = timeToReach;
                carFleets++;
            }
        }

        return carFleets;
    }


    public static void main (String[] args){
        TreeMap<Integer, Integer> speedMap = new TreeMap<>((a, b) -> b - a);
        speedMap.put(10, 3);
//        speedMap.put(8, 4);
//        speedMap.put(0, 1);
//        speedMap.put(5, 1);
//        speedMap.put(3, 3);

        int carFleets = countCarFleets(speedMap);
        System.out.println("Number of car fleets: " + carFleets);
    }
}
