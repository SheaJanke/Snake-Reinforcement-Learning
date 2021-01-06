package snake.Squares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public class EmptySquare extends Square {

    public EmptySquare(int row, int col) {
        super(row, col, SquareType.EMPTY);
    }

    public EmptySquare(Square square){
        super(square.row, square.col, SquareType.EMPTY);
    }

    public void render(Graphics g, int topLeftX, int topLeftY, int squareSize) {
        super.render(g, topLeftX, topLeftY, squareSize, Color.LIGHT_GRAY);
    }
}
