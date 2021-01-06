package snake.Screens;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import snake.Constants.Direction;
import snake.GameObjects.Board;
import snake.GameObjects.FruitSpawner;
import snake.GameObjects.Snake;

public class GameScreen extends Screen {

    private Board board;
    private Snake playerSnake;
    private FruitSpawner fruitSpawner;

    @Override
    public void onStart() {
        setUpOnePlayer();
    }

    @Override
    public void tick() {
        playerSnake.move();
        fruitSpawner.tick();

    }

    @Override
    public void render(Graphics g, int canvasSize) {
        board.render(g, canvasSize);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                playerSnake.setDirection(Direction.LEFT);
                break;
            case 38:
                playerSnake.setDirection(Direction.UP);
                break;
            case 39:
                playerSnake.setDirection(Direction.RIGHT);
                break;
            case 40:
                playerSnake.setDirection(Direction.DOWN);
                break;
            default:
                break;
        }

    }

    private void setUpOnePlayer() {
        board = new Board(11);
        playerSnake = new Snake(7, 7, 3, 1, Direction.UP, board);
        fruitSpawner = new FruitSpawner(board);
    }

}
