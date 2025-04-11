/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame.controller;

import cardgame.model.*;
import cardgame.view.GameView;

/**
 *
 * @author ks055
 * CONTROLLER in MVC - manages game flow and logic.
 * Applies SRP: Handles only the game flow, nothing else.
 * Applies DIP: Depends on abstractions like GameView and model classes.
 */
public class GameController {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private GameView view;

    public GameController() {
        this.deck = new Deck();  // SRP: Deck is responsible only for managing cards.
        this.player = new Player("Player");  // LSP: Dealer is interchangeable with Player.
        this.dealer = new Dealer();
        this.view = new GameView();  // SRP: View handles only I/O
    }

    public void playGame() {
        view.showWelcome();

        // Initial deal
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        view.displayPlayerHand(player, false);
        view.displayDealerHand(dealer, true);

        // Player turn
        while (player.calculateHandValue() < 21 && view.promptHitOrStand().equalsIgnoreCase("h")) {
            player.addCard(deck.drawCard());
            view.displayPlayerHand(player, false);
        }

        if (player.calculateHandValue() > 21) {
            view.displayBust(player);
            return;
        }

        // Dealer turn
        while (dealer.shouldDrawCard()) {
            dealer.addCard(deck.drawCard());
        }

        view.displayDealerHand(dealer, false);
        view.displayResults(player, dealer);
    }
}
