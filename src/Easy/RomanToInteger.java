package Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

//Leetcode problem: 13
public class RomanToInteger {

    public static int romanToInt(String str) {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < str.toCharArray().length; i++) q.offer(str.toCharArray()[i]);

        int total = 0;
        while(!q.isEmpty()) {
            char currentChar = q.poll();

            if(!q.isEmpty()) {
                if((currentChar == 'I' && q.peek() == 'V') || (currentChar == 'I' && q.peek() == 'X')) total += map.get(q.poll()) - map.get(currentChar);
                else if((currentChar == 'X' && q.peek() == 'L') || (currentChar == 'X' && q.peek() == 'C')) total += map.get(q.poll()) - map.get(currentChar);
                else if((currentChar == 'C' && q.peek() == 'D') || (currentChar == 'C' && q.peek() == 'M')) total += map.get(q.poll()) - map.get(currentChar);
                else total += map.get(currentChar);
            } else {
                total += map.get(currentChar);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        String str = "MCMXCIV";

        System.out.println(romanToInt(str));
    }
}
