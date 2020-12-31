package snake.GameObjects;

import snake.Constants.GameObjectType;

public class SnakePart extends GameObject {
    private int playerID;

    public SnakePart(int x, int y, int playerID) {
        super(x, y, GameObjectType.SNAKEPART);
        this.playerID = playerID;
    }
    
    public int getPlayerID() {
        return playerID;
    }
}
