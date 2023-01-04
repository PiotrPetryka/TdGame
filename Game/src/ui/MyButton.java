package ui;

import java.awt.*;

public class MyButton {
    private int x, y, width, height;
    private String text;
    private Rectangle bounds;
    private boolean mouseOver, mousePressed;

    public MyButton( String text, int x, int y, int width, int height){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        initBounds();
    }

    private void initBounds(){
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g){

        //Body
        drawBody(g);
        //Border
        drawBorder(g);
        //Text
        drawText(g);

    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
        if (mousePressed) {
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 2, y + 2, width - 4, height - 4);
        }


    }

    public void resetBooleans(){
        this.mouseOver = false;
        this.mousePressed = false;
    }

    private void drawBody(Graphics g) {
        if (mouseOver){
            g.setColor(Color.GRAY);
        }else{
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,width,height);
    }

    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }

    private void drawText(Graphics g) {
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textHeight = g.getFontMetrics().getHeight();
        g.drawString(text,x - textWidth / 2 + width /2, y + textHeight /2 + height /2);

    }


    public Rectangle getBounds(){
        return bounds;
    }

}
