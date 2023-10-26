package JobCodeChallenges;

class Solution {
    public static int luckyMoney(int money, int giftees) {
        // If money is less than the number of giftees, return 0
        if (money < giftees) {
            return 0;
        }

        // Calculate the number of gifts equal to 8 that can be given
        int giftsOfEight = money / 8;

        // If the number of gifts of 8 is more than the number of giftees, return giftees
        if (giftsOfEight >= giftees) {
            return giftees;
        }

        // If not, return the number of gifts of 8
        return giftsOfEight;
    }


    public static void main(String[] args) {
        int money1 = 12;
        int giftees1 = 2;
        System.out.println(luckyMoney(money1, giftees1)); // Output: 8

        int money2 = 24;
        int giftees2 = 4;
        System.out.println(luckyMoney(money2, giftees2)); // Output: 8

        int money3 = 7;
        int giftees3 = 2;
        System.out.println(luckyMoney(money3, giftees3)); // Output: 3
    }
}



