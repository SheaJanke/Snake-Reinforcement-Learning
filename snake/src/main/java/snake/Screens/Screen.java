package snake.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import snake.Handler;
import snake.Constants.ScreenType;

public abstract class Screen {

    public Handler handler;

    public Screen(Handler handler){
        this.handler = handler;
    }

    public void onStart(){
        handler.isChangingState(false);
    };

    public void tick(){};

    public void render(Graphics g, int canvasSize){};

    public void onEnd(){};

    public void keyPressed(KeyEvent e){};

    public void mouseClicked(MouseEvent e){};

    public void changeGameState(ScreenType newState){
        handler.changeGameState(newState);
    }
}
