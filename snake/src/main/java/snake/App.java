package snake;


import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

import snake.Render.EmptySquare;


public class App extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake.ai");
        Canvas canvas = new App();
        canvas.setSize(1000, 1000);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        EmptySquare s = new EmptySquare(100, 100, 100);
        s.render(g);
    }
}
