package scenes;

import main.Game;
import ui.MyButton;

import java.awt.*;

import static main.GameStates.MENU;
import static main.GameStates.PLAYING;
import static main.GameStates.SETTINGS;
import static main.GameStates.SetGameState;

public class Settings extends GameScene implements SceneMethods{
    private MyButton backToMenuButton;

    public Settings(Game game) {
        super(game);
        initButtons();
    }
    private void initButtons() {

        backToMenuButton = new MyButton("Back to Menu", 540, 30, 100, 30);
    }
    @Override
    public void render(Graphics g) {
//        g.setColor(Color.blue);
//        g.fillRect(0,0,640,640);
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (backToMenuButton.getBounds().contains(x, y)){
            SetGameState(MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        resetButtons();
        if (backToMenuButton.getBounds().contains(x, y)) {
            backToMenuButton.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (backToMenuButton.getBounds().contains(x, y)) {
            backToMenuButton.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    private void resetButtons() {
        backToMenuButton.resetBooleans();
    }
    private void drawButtons(Graphics g) {
        backToMenuButton.draw(g);
    }

}


