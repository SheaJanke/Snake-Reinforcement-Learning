package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snake.Constants.Direction;
import snake.GameObjects.Snake;

public class KeyInput implements KeyListener{

    private Snake snake;

    public KeyInput(Snake snake){
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()){
            case 37:
                snake.setDirection(Direction.LEFT);
                break;
            case 38:
                snake.setDirection(Direction.UP);
                break;
            case 39:
                snake.setDirection(Direction.RIGHT);
                break;
            case 40:
                snake.setDirection(Direction.DOWN);
                break;
            default:
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    
    
}
