import java.util.Scanner;

public class MinMaxArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the stock prices as a space-separated string
        System.out.print("Enter the stock prices separated by spaces: ");
        String input = scanner.nextLine();

        // Split the input string into an array of strings
        String[] priceStrings = input.split(" ");

        // Convert the string array to an integer array
        int[] prices = new int[priceStrings.length];
        for (int i = 0; i < priceStrings.length; i++) {
            prices[i] = Integer.parseInt(priceStrings[i]);
        }

        int minPrice = Integer.MAX_VALUE; // Initialize minPrice to a large value
        int maxProfit = 0; // Initialize maxProfit to 0

        for (int price : prices) {
            // Update minPrice to the minimum of the current price and minPrice
            minPrice = Math.min(minPrice, price);

            // Calculate the profit that can be obtained by selling at the current price
            int currentProfit = price - minPrice;

            // Update maxProfit if the current profit is greater
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        // Print the maximum profit
        System.out.println("Maximum Profit: " + maxProfit);

        // Close the scanner
        scanner.close();
    }
}
