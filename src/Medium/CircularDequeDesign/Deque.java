package Medium.CircularDequeDesign;

import java.util.LinkedList;

public class Deque {
    LinkedList<Integer> deque;
    int capacityLimit;

    public Deque(int k) {
        this.deque = new LinkedList<>();
        this.capacityLimit = k;
    }

    public boolean insertFirst(int val) {
        if(deque.size() >= capacityLimit) return false;
        deque.addFirst(val);
        return true;
    }
    public boolean insertLast(int val) {
        if(deque.size() >= capacityLimit) return false;
        deque.addLast(val);
        return true;
    }
    public boolean deleteFront() {
        if(!deque.isEmpty()) return false;
        deque.removeFirst();
        return true;
    }
    public boolean deleteRear() {
        if(!deque.isEmpty()) return false;
        deque.removeLast();
        return true;
    }
    public int getFront() {
        return deque.getFirst();
    }
    public int getRear() {
        return deque.getLast();
    }

    public boolean isEmpty() {return deque.isEmpty();}
    public boolean isFull() {
        return deque.size() == capacityLimit;
    }

}
