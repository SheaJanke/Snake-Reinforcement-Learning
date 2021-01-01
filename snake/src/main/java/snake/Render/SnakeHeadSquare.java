package snake.Render;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.Direction;
import snake.Constants.SquareType;

public class SnakeHeadSquare extends Square{
    
    Direction direction;

    public SnakeHeadSquare(int x, int y, int size, Direction direction){
        super(x, y, size, SquareType.SNAKEHEAD);
        this.direction = direction;
    }

    public void render(Graphics g){
        // Draw square
        g.setColor(Color.GREEN);
        g.fillRect(x, y, size, size);

        // Draw outline
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

        // Draw eyes
        g.setColor(Color.BLACK);
        int eyeOffset1 = size/5;
        int eyeOffset2 =  3*size/5;
        int eyeSize = size/5;
        switch(direction){
            case UP:
                g.fillOval(x+eyeOffset1, y+eyeOffset1, eyeSize, eyeSize);
                g.fillOval(x+eyeOffset2, y+eyeOffset1, eyeSize, eyeSize);
                break;
            case LEFT:
                g.fillOval(x+eyeOffset1, y+eyeOffset1, eyeSize, eyeSize);
                g.fillOval(x+eyeOffset2, y+eyeOffset1, eyeSize, eyeSize);
                break;
            case RIGHT:
                g.fillOval(x+eyeOffset1, y+eyeOffset1, eyeSize, eyeSize);
                g.fillOval(x+eyeOffset2, y+eyeOffset1, eyeSize, eyeSize);
                break;
            case DOWN:
                g.fillOval(x+eyeOffset1, y+eyeOffset1, eyeSize, eyeSize);
                g.fillOval(x+eyeOffset2, y+eyeOffset1, eyeSize, eyeSize);
                break;
        }
    }
    
}
