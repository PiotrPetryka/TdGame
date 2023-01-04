package scenes;

import main.Game;
import ui.MyButton;

import java.awt.*;


import static main.GameStates.PLAYING;
import static main.GameStates.SETTINGS;
import static main.GameStates.SetGameState;

public class Menu extends GameScene implements SceneMethods{
    private MyButton bPlaying, settingsButton, quitButton;

    public Menu(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        bPlaying = new MyButton("Play", 100, 100, 100, 30);
        settingsButton = new MyButton("Settings", 100, 200, 100, 30);
        quitButton = new MyButton("Quit", 100, 300, 100,30);
    }

    @Override
    public void render(Graphics g) {

        drawButtons(g);

    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)){
            SetGameState(PLAYING);
        }else if (settingsButton.getBounds().contains(x,y)){
            SetGameState(SETTINGS);
        } else if (quitButton.getBounds().contains(x,y)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        resetButtons();
        if (bPlaying.getBounds().contains(x, y)){
            bPlaying.setMouseOver(true);
        }else if (settingsButton.getBounds().contains(x,y)){
            settingsButton.setMouseOver(true);
        }else if (quitButton.getBounds().contains(x,y)){
            quitButton.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)){
            bPlaying.setMousePressed(true);
        }else if (settingsButton.getBounds().contains(x,y)){
            settingsButton.setMousePressed(true);
        }else if (quitButton.getBounds().contains(x,y)){
            quitButton.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
        settingsButton.resetBooleans();
        quitButton.resetBooleans();
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        settingsButton.draw(g);
        quitButton.draw(g);
    }

}
