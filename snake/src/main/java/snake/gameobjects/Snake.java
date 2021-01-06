package snake.GameObjects;

import java.util.Deque;
import java.util.LinkedList;

import snake.Handler;
import snake.Constants.Direction;
import snake.Constants.ScreenType;
import snake.Squares.EmptySquare;
import snake.Squares.Square;
import snake.Squares.SnakeSquares.SnakeHeadSquare;
import snake.Squares.SnakeSquares.SnakePartSquare;
import snake.Squares.SnakeSquares.SnakeSquare;

public class Snake {
    private Deque<SnakeSquare> body;
    private Direction direction;
    private int playerID;
    private Board board;
    private Handler handler;
    private boolean removeBackFlag;

    public Snake(int x, int y, int length, int playerID, Direction direction, Board board, Handler handler) {
        this.playerID = playerID;
        this.direction = direction;
        this.board = board;
        this.handler = handler;
        createSnake(x, y, length);
        removeBackFlag = true;
    }

    private void createSnake(int headX, int headY, int length) {
        if (length < 1) {
            throw new RuntimeException("Can't create a snake with length < 1.");
        }
        body = new LinkedList<SnakeSquare>();
        SnakeHeadSquare head;
        switch (direction) {
            case UP:
                head = new SnakeHeadSquare(headX, headY + length - 1, playerID, direction);
                break;
            case LEFT:
                head = new SnakeHeadSquare(headX + length - 1, headY, playerID, direction);
                break;
            case RIGHT:
                head = new SnakeHeadSquare(headX - length + 1, headY, playerID, direction);
                break;
            case DOWN:
                head = new SnakeHeadSquare(headX, headY - length + 1, playerID, direction);
                break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        body.addFirst(head);
        board.addSquareToBoard(head);
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
        SnakeSquare oldHead = body.removeFirst();
        SnakeSquare newPart = new SnakePartSquare(oldHead);
        body.addFirst(newPart);
        board.addSquareToBoard(newPart);

        SnakeSquare newHead;
        switch (direction) {
            case UP:
                newHead = new SnakeHeadSquare(oldHead.row, oldHead.col - 1, playerID, direction);
                break;
            case LEFT:
                newHead = new SnakeHeadSquare(oldHead.row - 1, oldHead.col, playerID, direction);
                break;
            case RIGHT:
                newHead = new SnakeHeadSquare(oldHead.row + 1, oldHead.col, playerID, direction);
                break;
            case DOWN:
                newHead = new SnakeHeadSquare(oldHead.row, oldHead.col + 1, playerID, direction);
                break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        boolean alive = handleCollision(newHead);
        if(alive){
            body.addFirst(newHead);
            board.addSquareToBoard(newHead);
        }
    };

    public void removeFromBack() {
        if (removeBackFlag) {
            if (body.size() < 1) {
                throw new RuntimeException("Snake is too short to removeFromBack().");
            }
            SnakeSquare oldBack = body.removeLast();
            board.addSquareToBoard(new EmptySquare(oldBack));
        } else {
            removeBackFlag = true;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Deque<SnakeSquare> getSnakeBody() {
        return body;
    }

    // Returns true if alive, false otherwise;
    public void move() {
        addToFront();
        removeFromBack();
    }

    private boolean handleCollision(SnakeSquare newHead) {
        if(newHead.row < 0 || newHead.row >= board.getSquaresPerRow() || newHead.col < 0 || newHead.col >= board.getSquaresPerRow()){
            if(newHead.playerID == 1){
                handler.changeGameState(ScreenType.GAMEOVER);
            }
            return false;
        }
        Square collision = board.getSquare(newHead.row, newHead.col);
        switch (collision.getType()) {
            case EMPTY:
                break;
            case FRUIT:
                removeBackFlag = false;
                break;
            case SNAKEHEAD:
                if(newHead.playerID == 1){
                    handler.changeGameState(ScreenType.GAMEOVER);
                }
                return false;
            case SNAKEPART:
                if(newHead.playerID == 1){
                    handler.changeGameState(ScreenType.GAMEOVER);
                }
                return false;
        }
        return true;
    }

}
