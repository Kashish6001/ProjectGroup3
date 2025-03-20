/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Scanner;

public class CardGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;

    public CardGame() {
        deck = new Deck();
        player = new Player("Player");
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    public void playRound() {
        // Initial dealing
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        // Show initial hands
        player.showHand(false);
        dealer.showHand(true); // Hides dealer's second card

        // Player's turn
        while (true) {
            System.out.print("\nDo you want to Hit or Stand? (h/s): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h")) {
                player.addCard(deck.drawCard());
                player.showHand(false);

                if (player.calculateHandValue() > 21) {
                    System.out.println("Busted! You lost.");
                    return;
                }
            } else if (choice.equals("s")) {
                break;
            }
        }

        // Dealer's turn
        dealer.showHand(false);
        while (dealer.shouldDrawCard()) {
            dealer.addCard(deck.drawCard());
            dealer.showHand(false);
        }

        // Determine winner
        int playerScore = player.calculateHandValue();
        int dealerScore = dealer.calculateHandValue();

        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Congratulations! You win!");
        } else if (playerScore == dealerScore) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins!");
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.playRound();
    }
}