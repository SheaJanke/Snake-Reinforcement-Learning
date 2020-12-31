package snake.GameObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import snake.Constants.Direction;

public class SnakeTest {

    private int initialX = 3;
    private int initialY = 3;
    private int playerID = 1;
    private int length = 3;

    @Test
    public void test_CreateSnake_Up() {
        initialX = 3;
        initialY = 3;
        playerID = 1;
        length = 3;
        Snake snake = new Snake(initialX, initialY, length, playerID, Direction.UP);
        assertEquals(snake.getSnakeBody().size(), length);
        assertEquals(snake.getSnakeBody().getFirst().getX(), initialX);
        assertEquals(snake.getSnakeBody().getFirst().getY(), initialY);
        assertEquals(snake.getSnakeBody().getLast().getX(), initialX);
        assertEquals(snake.getSnakeBody().getLast().getY(), initialY - length + 1);
    }

    @Test
    public void test_CreateSnake_Left() {
        Snake snake = new Snake(initialX, initialY, length, playerID, Direction.LEFT);
        assertEquals(snake.getSnakeBody().size(), length);
        assertEquals(snake.getSnakeBody().getFirst().getX(), initialX);
        assertEquals(snake.getSnakeBody().getFirst().getY(), initialY);
        assertEquals(snake.getSnakeBody().getLast().getX(), initialX + length - 1);
        assertEquals(snake.getSnakeBody().getLast().getY(), initialY);
    }

    @Test
    public void test_CreateSnake_Right() {
        Snake snake = new Snake(initialX, initialY, length, playerID, Direction.RIGHT);
        assertEquals(snake.getSnakeBody().size(), length);
        assertEquals(snake.getSnakeBody().getFirst().getX(), initialX);
        assertEquals(snake.getSnakeBody().getFirst().getY(), initialY);
        assertEquals(snake.getSnakeBody().getLast().getX(), initialX - length + 1);
        assertEquals(snake.getSnakeBody().getLast().getY(), initialY);
    }

    @Test
    public void test_CreateSnake_Down() {
        Snake snake = new Snake(initialX, initialY, length, playerID, Direction.DOWN);
        assertEquals(snake.getSnakeBody().size(), length);
        assertEquals(snake.getSnakeBody().getFirst().getX(), initialX);
        assertEquals(snake.getSnakeBody().getFirst().getY(), initialY);
        assertEquals(snake.getSnakeBody().getLast().getX(), initialX);
        assertEquals(snake.getSnakeBody().getLast().getY(), initialY + length - 1);
    }

}
