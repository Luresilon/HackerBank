package Medium.MyCalendarTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalendar2 {
    List<Event> bookings;
    List<Event> duplicates;
    protected MyCalendar2 () {
        bookings = new ArrayList<>();
        duplicates = new ArrayList<>();
    }
    protected boolean book(int start, int end) {
        for(Event e: duplicates) {
            if(isOverlap(e, start, end)) return false;
        }

        for(Event e: bookings) {
            if(isOverlap(e, start, end)) duplicates.add(getOverlappedInterval(e, start, end));
        }

        bookings.add(new Event(start, end));
        return true;
    }

    private boolean isOverlap(Event e, int start, int end) {
        return Math.max(e.start, start) < Math.min(e.end, end);
    }

    private Event getOverlappedInterval(Event e, int start, int end) {
        return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
    public void printTimeTables() {
        for(Event e: bookings) System.out.print(Arrays.toString(new int[]{e.start, e.end}));
        System.out.println();
        for(Event e: duplicates) System.out.print(Arrays.toString(new int[]{e.start, e.end}));
    }
}
