/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame.view;

import cardgame.model.*;

import java.util.Scanner;

/**
 *
 * @author ks055
 * VIEW in MVC - handles user input and console output.
 * Applies SRP: Only handles input/output, not game logic or data manipulation.
 */
public class GameView {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome to Blackjack!");
    }

    public void displayPlayerHand(Player player, boolean hideSecondCard) {
        System.out.println("\n" + player.getName() + "'s Hand:");
        player.showHand(hideSecondCard);
    }

    public void displayDealerHand(Dealer dealer, boolean hideSecondCard) {
        System.out.println("\nDealer's Hand:");
        dealer.showHand(hideSecondCard);
    }

    public String promptHitOrStand() {
        System.out.print("\nDo you want to Hit or Stand? (h/s): ");
        return scanner.nextLine();
    }

    public void displayBust(Player player) {
        System.out.println(player.getName() + " busts! Dealer wins.");
    }

    public void displayResults(Player player, Dealer dealer) {
        int playerScore = player.calculateHandValue();
        int dealerScore = dealer.calculateHandValue();

        System.out.println("\n--- Final Results ---");
        System.out.println(player.getName() + ": " + playerScore);
        System.out.println("Dealer: " + dealerScore);

        if (playerScore > dealerScore) {
            System.out.println(player.getName() + " wins!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}