package main;

import javax.swing.*;

public class Game extends JFrame {
    private GameScreen gameScreen;
    public Game(){
    setSize(400,400);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    gameScreen = new GameScreen();
    add(gameScreen);
    }
    public static void main(String[] args) {
        System.out.println("Start of my td game. Hello there!");
        Game game = new Game();

    }
}