/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;

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
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
        
        Card luckyCard = new Card(Card.Value.SEVEN, Card.Suit.HEARTS); // Hardcoded lucky card
        System.out.println("\nLucky Card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
        if (game.isCardInHand(luckyCard)) {
            System.out.println("You win! Lucky card is in the magic hand.");
        } else {
            System.out.println("You lose! Lucky card is not in the magic hand.");
        }

    }

    private boolean isCardInHand(Card luckyCard) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
