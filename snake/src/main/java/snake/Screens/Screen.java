package snake.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class Screen {

    public abstract void onStart();

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onEnd();

    public abstract void keyPressed(KeyEvent e);

}
