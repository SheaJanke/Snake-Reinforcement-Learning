package snake.Squares.SnakeSquares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public class SnakePartSquare extends SnakeSquare {
    public SnakePartSquare(int row, int col, int playerID) {
        super(row, col, playerID, SquareType.SNAKEPART);
    }

    public SnakePartSquare(SnakeSquare oldPart){
        super(oldPart.row, oldPart.col, oldPart.playerID, SquareType.SNAKEPART);
    }

    @Override
    public void render(Graphics g, int topLeftX, int topLeftY, int squareSize) {
        super.render(g, topLeftX, topLeftY, squareSize, Color.GREEN);
    }
}
