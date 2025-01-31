/**
 * @author Diya Patel
 * @modified_by Diya Patel
 * @student_id 991752600
 * @date 2025-01-29
 */
package cardgame;

import java.util.Random;
import java.util.Scanner;

public class CardGame {
    private Card[] magicHand = new Card[7]; // Array to store 7 cards
    private Card luckyCard; // Hardcoded lucky card

    public CardGame() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Random rand = new Random();
        
        // Generate 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            int number = rand.nextInt(13) + 1; // 1 to 13
            String suit = suits[rand.nextInt(4)];
            magicHand[i] = new Card(number, suit);
        }

        // Hardcoded lucky card
        luckyCard = new Card(7, "Hearts"); // Change values as needed
    }

    public void printHand() {
        System.out.println("Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card);
        }
    }

    public void checkLuckyCard() {
        System.out.println("\nChecking for the lucky card: " + luckyCard);
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(luckyCard)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("🎉 Congratulations! Your lucky card is in the magic hand! 🎉");
        } else {
            System.out.println("❌ Sorry, your lucky card is not in the magic hand. ❌");
        }
    }

    public void userCardCheck() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter a card number (1-13): ");
        int userNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Enter a suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.nextLine();

        Card userCard = new Card(userNumber, userSuit);
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("🎉 Your chosen card is in the magic hand! 🎉");
        } else {
            System.out.println("❌ Your chosen card is NOT in the magic hand. ❌");
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
        game.checkLuckyCard();
        game.userCardCheck();
    }
}
