package snake.src.main.java.snake.gameobjects;

import snake.src.main.java.snake.Constants.GameObjectType;

public class SnakePart extends GameObject {
    private int player;

    public SnakePart(int x, int y, int player) {
        super(x, y, GameObjectType.SNAKEPART);
        this.player = player;
    }
    
    public int getPlayer() {
        return player;
    }
}
