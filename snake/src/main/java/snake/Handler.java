package snake;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import snake.Constants.ScreenType;
import snake.Screens.GameScreen;
import snake.Screens.Screen;
import snake.Screens.StartScreen;

public class Handler {

    private Map<ScreenType, Screen> screens;
    private ScreenType gameState;
    private AtomicBoolean changingState = new AtomicBoolean(false);

    public Handler(Game game) {
        game.addKeyListener(new KeyInput(this));
        screens = new HashMap<ScreenType, Screen>();
        screens.put(ScreenType.GAMESCREEN, new GameScreen(this));
        screens.put(ScreenType.STARTSCREEN, new StartScreen(this));
        init();
        
    }

    public void tick() {
        screens.get(gameState).tick();
    }

    public void render(Graphics g) {
        if(!changingState.get()){
            screens.get(gameState).render(g, Game.WIDTH);
        }
    }

    public void keyPressed(KeyEvent e) {
        screens.get(gameState).keyPressed(e);
    }

    public void mouseClicked(MouseEvent e){
        screens.get(gameState).mouseClicked(e);
    }

    private void init(){
        gameState = ScreenType.STARTSCREEN;
        screens.get(ScreenType.STARTSCREEN).onStart();
    }

    public void changeGameState(ScreenType screenType){
        isChangingState(true);
        screens.get(gameState).onEnd();
        gameState = screenType;
        screens.get(gameState).onStart();
        isChangingState(false);
    }

    public void isChangingState(boolean bool){
        changingState.set(bool);
    }

}
