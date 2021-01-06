package snake.Squares.SnakeSquares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.Direction;
import snake.Constants.SquareType;

public class SnakeHeadSquare extends SnakeSquare {

    Direction direction;

    public SnakeHeadSquare(int row, int col, int playerID, Direction direction) {
        super(row, col, playerID, SquareType.SNAKEHEAD);
        this.direction = direction;
    }

    @Override
    public void render(Graphics g, int topLeftX, int topLeftY, int squareSize) {
        super.render(g, topLeftX, topLeftY, squareSize, Color.GREEN);

        // Draw eyes
        g.setColor(Color.BLACK);
        int eyeOffset1 = squareSize / 5;
        int eyeOffset2 = 3 * squareSize / 5;
        int eyeSize = squareSize / 5;
        switch (direction) {
            case UP:
                g.fillOval(topLeftX + eyeOffset1, topLeftY + eyeOffset1, eyeSize, eyeSize);
                g.fillOval(topLeftX + eyeOffset2, topLeftY + eyeOffset1, eyeSize, eyeSize);
                break;
            case LEFT:
                g.fillOval(topLeftX + eyeOffset1, topLeftY + eyeOffset1, eyeSize, eyeSize);
                g.fillOval(topLeftX + eyeOffset1, topLeftY + eyeOffset2, eyeSize, eyeSize);
                break;
            case RIGHT:
                g.fillOval(topLeftX + eyeOffset2, topLeftY + eyeOffset1, eyeSize, eyeSize);
                g.fillOval(topLeftX + eyeOffset2, topLeftY + eyeOffset2, eyeSize, eyeSize);
                break;
            case DOWN:
                g.fillOval(topLeftX + eyeOffset1, topLeftY + eyeOffset2, eyeSize, eyeSize);
                g.fillOval(topLeftX + eyeOffset2, topLeftY + eyeOffset2, eyeSize, eyeSize);
                break;
        }

    }

}
