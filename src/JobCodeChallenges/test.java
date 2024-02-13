package JobCodeChallenges;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner; // Import the Scanner class to read text files

public class test {
    public static void main(String[] args) throws IOException {
        System.out.println(new File(".").getAbsoluteFile());
        File file = new File("src/server_address.txt");
        System.out.println(file.exists());
        Scanner scan = new Scanner(file);
    }
}
