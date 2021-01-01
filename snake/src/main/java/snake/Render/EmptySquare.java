package snake.Render;

import snake.Constants.SquareType;

import java.awt.Color;
import java.awt.Graphics;

public class EmptySquare extends Square {
    
    public EmptySquare(int x, int y, int size){
        super(x, y, size, SquareType.EMPTY);
    }

    public void render(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
