package snake.Screens;

import snake.Handler;
import snake.Constants.ScreenType;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameOverScreen extends Screen {

    public GameOverScreen(Handler handler) {
        super(handler);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void render(Graphics g, int canvasSize){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, canvasSize, canvasSize);
        int center = canvasSize/2;
        g.setColor(Color.green);
        g.fillRect(center-100, center-50, 200, 100);
        g.setColor(Color.GREEN);
        g.drawRect(center-100, center-50, 200, 100);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
        g.drawString("Play Again", center-50, center-30);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 32:
                changeGameState(ScreenType.GAMESCREEN);
                break;
            default:
                break;
        } 
    }
    
}
