/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Applies SRP: Responsible only for player logic and hand management.
 * Applies Encapsulation: Uses private fields with controlled access.
 * @author ks055
 */

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void showHand(boolean hideSecondCard) {
        for (int i = 0; i < hand.size(); i++) {
            if (i == 1 && hideSecondCard) {
                System.out.println("[Hidden]");
            } else {
                System.out.println(hand.get(i));
            }
        }
    }

    public int calculateHandValue() {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            total += card.getValue().getPoints();
            if (card.getValue() == Value.ACE) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public String getName() {
        return name;
    }
}