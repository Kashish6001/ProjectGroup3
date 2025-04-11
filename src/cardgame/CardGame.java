/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;
import java.util.Scanner;
import cardgame.controller.GameController;


/**
 * Entry Point - Delegates to Controller
 * Principle: SRP (main method only launches game)
 */
public class CardGame {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.playGame();
    }
}