package snake.GameObjects;

import java.util.*;
import snake.Constants.Direction;
import snake.Squares.SnakeSquares.SnakeHeadSquare;
import snake.Squares.SnakeSquares.SnakePartSquare;
import snake.Squares.SnakeSquares.SnakeSquare;

public class Snake {
    private Deque<SnakeSquare> body;
    private Direction direction;
    private int playerID;
    private Board board;

    public Snake(int x, int y, int length, int playerID, Direction direction, Board board) {
        this.playerID = playerID;
        this.direction = direction;
        this.board = board;
        createSnake(x, y, length);
    }

    private void createSnake(int headX, int headY, int length) {
        if (length < 1) {
            throw new RuntimeException("Can't create a snake with length < 1.");
        }
        body = new LinkedList<SnakeSquare>();
        switch (direction) {
            case UP:
                body.addFirst(new SnakeHeadSquare(headX, headY + length - 1, playerID, board, direction));
                break;
            case LEFT:
                body.addFirst(new SnakeHeadSquare(headX + length - 1, headY, playerID, board, direction));
                break;
            case RIGHT:
                body.addFirst(new SnakeHeadSquare(headX - length + 1, headY, playerID, board, direction));
                break;
            case DOWN:
                body.addFirst(new SnakeHeadSquare(headX, headY - length + 1, playerID, board, direction));
                break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        for (int i = 0; i < length - 1; i++) {
            addToFront();
        }
    }

    // Add a body part to the front of the snake.
    public void addToFront() {
        if (body.isEmpty()) {
            throw new RuntimeException("Can't add a body part to an empty snake.");
        }

        // Replace the old head with a body part.
        SnakeSquare oldHead = body.getFirst();
        body.removeFirst();
        body.addFirst(new SnakePartSquare(oldHead));

        SnakeSquare newHead;
        switch (direction) {
            case UP:
                newHead = new SnakeHeadSquare(oldHead.row, oldHead.col - 1, playerID, board, direction);
                break;
            case LEFT:
                newHead = new SnakeHeadSquare(oldHead.row - 1, oldHead.col, playerID, board, direction);
                break;
            case RIGHT:
                newHead = new SnakeHeadSquare(oldHead.row + 1, oldHead.col, playerID, board, direction);
                break;
            case DOWN:
                newHead = new SnakeHeadSquare(oldHead.row, oldHead.col + 1, playerID, board, direction);
                break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        body.addFirst(newHead);
    };

    public void SetDirection(Direction direction) {
        this.direction = direction;
    }

    public Deque<SnakeSquare> getSnakeBody() {
        return body;
    }

}
