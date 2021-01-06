package snake;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;


import snake.Constants.ScreenType;
import snake.Screens.GameScreen;
import snake.Screens.Screen;

public class Handler {

    private Map<ScreenType, Screen> screens;
    private ScreenType gameState;

    public Handler(Game game) {
        game.addKeyListener(new KeyInput(this));
        screens = new HashMap<ScreenType, Screen>();
        screens.put(ScreenType.GAMESCREEN, new GameScreen());
        screens.get(ScreenType.GAMESCREEN).onStart();
        gameState = ScreenType.GAMESCREEN;
    }

    public void tick() {
        screens.get(gameState).tick();
    }

    public void render(Graphics g) {
        screens.get(gameState).render(g, Game.WIDTH);
    }

    public void keyPressed(KeyEvent e) {
        screens.get(gameState).keyPressed(e);
    }

    public void mouseClicked(MouseEvent e){
        screens.get(gameState).mouseClicked(e);
    }

}
