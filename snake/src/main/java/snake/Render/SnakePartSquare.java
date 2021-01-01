package snake.Render;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public class SnakePartSquare extends Square{
    public SnakePartSquare(int x, int y, int size){
        super(x, y, size, SquareType.SNAKEPART);
    }

    public void render(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
