package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameScreen extends JPanel {
    private Random random;
    private BufferedImage img;

    public GameScreen(BufferedImage img){
        random = new Random();
        this.img = img;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);

//        for (int x=0; x < 20; x++){
//            for(int y=0; y<20; y++){
//            g.setColor(getRandomColor());
//            g.fillRect(x*32, y*32, 32,32);
//        }}
    }
    private Color getRandomColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

    return new Color(r,g,b);
    }
}
