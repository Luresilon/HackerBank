package Medium.MyCalendarTwo;

public class Main {
    public static void main(String[] args) {
        MyCalendar2 myCalendar2 = new MyCalendar2();
        System.out.println(myCalendar2.book(10, 20));
        System.out.println(myCalendar2.book(50, 60));
        System.out.println(myCalendar2.book(10, 40));
        System.out.println(myCalendar2.book(5, 15));
        System.out.println(myCalendar2.book(25, 55));
        myCalendar2.printTimeTables();
    }
}
