/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

    private final Card[] hand;
    private static final int HAND_SIZE = 7;
    private static final Card.Suit[] suits = Card.Suit.values();

    public CardGame() {
        hand = new Card[HAND_SIZE];
        generateHand();
    }

    private void generateHand() {
        Random random = new Random();
        for (int i = 0; i < HAND_SIZE; i++) {
            int value = random.nextInt(13) + 1; // Random value between 1 and 13
            Card.Suit suit = suits[random.nextInt(suits.length)]; // Random suit
            hand[i] = new Card(value, suit);
        }
    }

    public void printHand() {
        System.out.println("Magic Hand:");
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    private boolean isCardInHand(Card card) {
        for (Card c : hand) {
            if (c.equals(card)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();

        // Lucky card
        Card luckyCard = new Card(7, Card.Suit.HEARTS); // Hardcoded lucky card
        System.out.println("\nLucky Card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
        if (game.isCardInHand(luckyCard)) {
            System.out.println("You win! Lucky card is in the magic hand.");
        } else {
            System.out.println("You lose! Lucky card is not in the magic hand.");
        }

        try ( // Task 8: picks a card
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nPick a card:");
            System.out.print("Enter a card number (1 for Ace, 11 for Jack, 12 for Queen, 13 for King): ");
            int userValue = scanner.nextInt();
            System.out.println("Choose a suit: 1 for HEARTS, 2 for DIAMONDS, 3 for CLUBS, 4 for SPADES");
            int suitChoice = scanner.nextInt();
            Card.Suit userSuit = suits[suitChoice - 1];
            
            Card userCard = new Card(userValue, userSuit);
            System.out.println("Your card: " + userCard.getValue() + " of " + userCard.getSuit());
            
            if (game.isCardInHand(userCard)) {
                System.out.println("You win! Your card is in the magic hand.");
            } else {
                System.out.println("You lose! Your card is not in the magic hand.");
            }
        }
    }
}
