package inputs;



import main.GameStates;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static main.GameStates.*;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            GameStates.gameState = SETTINGS;
                    System.out.println("Escape pressed! Settings opened!");
        }
        else if(e.getKeyCode() == KeyEvent.VK_P){
            gameState = PLAYING;
            System.out.println("P pressed! Playing scene opened!");
        }
        else if(e.getKeyCode() == KeyEvent.VK_M){
            GameStates.gameState = MENU;
            System.out.println("M pressed! Playing scene opened!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
