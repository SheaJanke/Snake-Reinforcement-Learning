package snake.GameObjects;

import snake.Constants.GameObjectType;

public abstract class GameObject {
    private int x;
    private int y;
    private GameObjectType type;

    public GameObject(int x, int y, GameObjectType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GameObjectType getType() {
        return type;
    }
}
