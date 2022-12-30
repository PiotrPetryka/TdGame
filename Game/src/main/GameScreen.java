package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {
    private Random random;
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private long lastTime;
    private int frames;


    public GameScreen(BufferedImage img){
        random = new Random();
        this.img = img;
        loadSprites();

    }

    private void loadSprites() {
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                sprites.add(img.getSubimage(x * 32,y * 32,32,32));
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        g.drawImage(sprites.get(19), 0, 0, null);
//        g.drawImage(img.getSubimage(32*9, 32, 32, 32), 0, 0, null);

        for (int x=0; x < 20; x++){
            for(int y=0; y<20; y++){
            g.setColor(getRandomColor());
        g.drawImage(sprites.get(getRandomInt()), x*32, y*32, null);

            }
        }
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000){
            System.out.println("Fps: " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }
        repaint();
    }
    private int getRandomInt(){
        return random.nextInt(100);
    }
    private Color getRandomColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

    return new Color(r,g,b);
    }
}
