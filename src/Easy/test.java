package Easy;

public class test {
    test() {
        System.out.println("One, ");
    }
}

class test2 extends test{
    test2() {
        System.out.println("Two");
    }

    public static void main(String[] args) {
        new test2();
    }
}


