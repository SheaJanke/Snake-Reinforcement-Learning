package snake.GameObjects;

import java.util.*;
import snake.Constants.Direction;

public class Snake {

    private Deque<SnakePart> body;
    private Direction direction;
    private int playerID;

    public Snake(int playerID) {
        this.playerID = playerID;
        body = new LinkedList<SnakePart>();
    }

    private void createNewSnake(int length) {
        body = new LinkedList<SnakePart>();
        direction = Direction.FORWARD;
    }

    // Add a body part to the front of the snake.
    private void addBodyPart() {
        SnakePart curHead = body.getFirst();
        SnakePart newHead;
        switch (direction) {
            case FORWARD:
                newHead = new SnakePart(curHead.getX(), curHead.getY() + 1, playerID);
                break;
            case LEFT:
                newHead = new SnakePart(curHead.getX() - 1, curHead.getY(), playerID);
                break;
            case RIGHT:
                newHead = new SnakePart(curHead.getX() + 1, curHead.getY(), playerID);
            default:
                throw new RuntimeException("Invalid direction.");
        }
        body.addFirst(newHead);
    };
}
