import java.util.Scanner;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input sentence from the user
        System.out.println("Enter a sentence: ");
        String inputSentence = scanner.nextLine();

        // Split the sentence into words
        String[] words = inputSentence.split(" ");

        // Initialize an empty string to store the reversed sentence
        String reversedSentence = "";

        // Iterate through the words in reverse order and append them to the reversed sentence
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence += words[i] + " ";
        }

        // Print the reversed sentence
        System.out.println("Reversed sentence: " + reversedSentence);

        // Close the scanner
        scanner.close();
    }
}
