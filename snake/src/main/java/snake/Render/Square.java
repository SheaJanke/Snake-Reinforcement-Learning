package snake.Render;

import snake.Constants.SquareType;
import java.awt.Graphics;

public abstract class Square {
    
    public int x;
    public int y;
    public int size;
    private SquareType type;

    public Square(int x, int y, int size, SquareType type){
        this.x = x;
        this.y = y;
        this.size = size;
        this.type = type;
    }

    public abstract void render(Graphics g);

    public SquareType getType(){
        return type;
    }

}
