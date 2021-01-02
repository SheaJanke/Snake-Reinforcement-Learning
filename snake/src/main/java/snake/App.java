package snake;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import snake.Constants.Direction;
import snake.GameObjects.Board;
import snake.GameObjects.Snake;


public class App extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake.ai");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Canvas canvas = new App();
        canvas.setSize(600, 600);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Board board = new Board(600, 11, g);
        board.render();
        Snake snake = new Snake(5, 5, 3, 1, Direction.DOWN, board);
    }
}
