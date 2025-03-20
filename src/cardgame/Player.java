/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author ks055
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
    protected String name;
    protected List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int calculateHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public void showHand(boolean hideFirstCard) {
        System.out.print(name + "'s hand: [ ");

        for (int i = 0; i < hand.size(); i++) {
            if (hideFirstCard && i == 1) {
                System.out.print("Hidden Card ");
            } else {
                System.out.print(hand.get(i) + " ");
            }
        }

        if (!hideFirstCard) {
            System.out.println("] Total: " + calculateHandValue());
        } else {
            System.out.println("]");
        }
    }

    public List<Card> getHand() {
        return hand;
    }
}