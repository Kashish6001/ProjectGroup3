/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

/**
 *
 * @author ks055
 */
public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
    }

    public boolean shouldDrawCard() {
        return calculateHandValue() < 17;
    }
}