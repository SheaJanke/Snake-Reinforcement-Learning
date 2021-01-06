package snake.Squares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public class FruitSquare extends Square {

    public FruitSquare(int row, int col) {
        super(row, col, SquareType.FRUIT);
    }

    @Override
    public void render(Graphics g, int topLeftX, int topLeftY, int squareSize) {
        super.render(g, topLeftX, topLeftY, squareSize, Color.RED);
    }
}
