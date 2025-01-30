/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Random;

public class CardGame {
    private Card[] magicHand = new Card[7]; // Array to store 7 cards

    public CardGame() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Random rand = new Random();
        
        for (int i = 0; i < magicHand.length; i++) {
            int number = rand.nextInt(13) + 1; // 1 to 13
            String suit = suits[rand.nextInt(4)];
            magicHand[i] = new Card(number, suit);
        }
    }
    
    public void printHand() {
        for (Card card : magicHand) {
            System.out.println(card);
        }
    }
}
