package inputs;
import main.Game;
import main.GameStates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseMotionListener, MouseListener {
    private Game game;

    public MyMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.game = game;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        switch(GameStates.gameState){
            case MENU:
            case PLAYING:
                game.getMenu().mouseMoved(e.getX(), e.getY());
                break;
            case SETTINGS:
                break;
            default:
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){

            switch(GameStates.gameState){
                case MENU:
                case PLAYING:
                    game.getMenu().mouseClicked(e.getX(), e.getY());
                    break;
                case SETTINGS:
                    break;
                default:
                    break;
            }
            System.out.println("Mouse pressed. Pos: " + e.getX() + " : " + e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch(GameStates.gameState){
            case MENU:
            case PLAYING:
                game.getMenu().mousePressed(e.getX(), e.getY());
                break;
            case SETTINGS:
                break;
            default:
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(GameStates.gameState){
            case MENU:
                game.getMenu().mouseReleased(e.getX(),e.getY());
                break;
            case PLAYING:
                game.getMenu().mouseReleased(e.getX(),e.getY());
                break;
            case SETTINGS:
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
