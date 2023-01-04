package scenes;

import helpMethods.LevelBuilder;
import main.Game;
import managers.TileManager;
import ui.MyButton;
import java.io.InputStream;
import java.awt.*;

import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

public class Playing extends GameScene implements SceneMethods{

    private int lvl[][];
    private TileManager tileManager;
    private MyButton backToMenuButton;



    public Playing(Game game) {
        super(game);
        lvl = LevelBuilder.getLevelData();        //lvl
        initButtons();
        tileManager = new TileManager();//TileManager


    }
    private void initButtons() {

        backToMenuButton = new MyButton("Back to Menu", 540, 30, 100, 30);
    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < lvl.length; y++){
            for (int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
            }
        }
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
