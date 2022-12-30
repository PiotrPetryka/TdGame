package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Game extends JFrame {
    private GameScreen gameScreen;
    private BufferedImage img;
    private double timeForFrame;
    private long lastFrame;


    public Game(){
        timeForFrame = 1000000000.0 / 60.0;

        importImg();
        setSize(640,640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen(img);
        add(gameScreen);
        setVisible(true);

    }

    private void importImg() {

        InputStream is = getClass().getResourceAsStream("../spriteatlas.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void gameLoop(){
        while (true) {
            if (System.nanoTime() - lastFrame >= timeForFrame) {
                lastFrame = System.nanoTime();
                repaint();
            } else {
                //do nothing
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameLoop();

    }

}