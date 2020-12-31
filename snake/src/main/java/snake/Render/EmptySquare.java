package snake.Render;

import snake.Constants.SquareType;
import java.awt.Graphics;

public class EmptySquare extends Square {
    
    public EmptySquare(int x, int y, int size){
        super(x, y, size, SquareType.EMPTY);
    }

    public void render(Graphics g){
        g.fillRect(x, y, size, size);
    }
}
