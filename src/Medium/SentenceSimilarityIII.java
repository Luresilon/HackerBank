package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SentenceSimilarityIII {

    public static boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));

        while(!deque1.isEmpty() && !deque2.isEmpty() && deque1.peek().equals(deque2.peek())) {
            deque1.poll();
            deque2.poll();
        }

        while(!deque1.isEmpty() && !deque2.isEmpty() && deque1.peekLast().equals(deque2.peekLast())) {
            deque1.pollLast();
            deque2.pollLast();
        }


        return deque1.isEmpty() || deque2.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "name Haley";

        System.out.println(areSentencesSimilar(s1, s2));
    }
}
