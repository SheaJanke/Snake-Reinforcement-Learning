package snake.Render;

import snake.Constants.SquareType;

import java.awt.Color;
import java.awt.Graphics;

public class FruitSquare extends Square {
    public FruitSquare(int x, int y, int size){
        super(x, y, size, SquareType.FRUIT);
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
