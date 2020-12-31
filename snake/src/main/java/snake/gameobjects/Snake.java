package snake.GameObjects;

import java.util.*;
import snake.Constants.Direction;

public class Snake {

    private Deque<SnakePart> body;
    private Direction direction;
    private int playerID;

    public Snake(int x, int y, int length, int playerID, Direction direction) {
        this.playerID = playerID;
        this.direction = direction;
        createSnake(x, y, length);
    }

    private void createSnake(int headX, int headY, int length) {
        if (length < 1) {
            throw new RuntimeException("Can't create a snake with length < 1.");
        }
        body = new LinkedList<SnakePart>();
        switch (direction) {
            case UP:
                body.addFirst(new SnakePart(headX, headY - length + 1, playerID));
                break;
            case LEFT:
                body.addFirst(new SnakePart(headX + length - 1, headY, playerID));
                break;
            case RIGHT:
                body.addFirst(new SnakePart(headX - length + 1, headY, playerID));
                break;
            case DOWN:
            body.addFirst(new SnakePart(headX, headY + length - 1, playerID));
            break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        for(int i = 0; i < length-1; i++){
            addBodyPart();
        }
    }

    // Add a body part to the front of the snake.
    public void addBodyPart() {
        if (body.isEmpty()) {
            throw new RuntimeException("Can't add a body part to an empty snake.");
        }
        SnakePart curHead = body.getFirst();
        SnakePart newHead;
        switch (direction) {
            case UP:
                newHead = new SnakePart(curHead.getX(), curHead.getY() + 1, playerID);
                break;
            case LEFT:
                newHead = new SnakePart(curHead.getX() - 1, curHead.getY(), playerID);
                break;
            case RIGHT:
                newHead = new SnakePart(curHead.getX() + 1, curHead.getY(), playerID);
                break;
            case DOWN:
                newHead = new SnakePart(curHead.getX(), curHead.getY()-1, playerID);
                break;
            default:
                throw new RuntimeException("Invalid direction.");
        }
        body.addFirst(newHead);
    };

    public void SetDirection(Direction direction) {
        this.direction = direction;
    }

    public Deque<SnakePart> getSnakeBody() {
        return body;
    }
}
