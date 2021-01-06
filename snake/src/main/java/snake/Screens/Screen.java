package snake.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class Screen {

    public void onStart(){};

    public void tick(){};

    public void render(Graphics g, int canvasSize){};

    public void onEnd(){};

    public void keyPressed(KeyEvent e){};

    public void mouseClicked(MouseEvent e){};
}
