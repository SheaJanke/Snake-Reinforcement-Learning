package snake.Squares;

import snake.Constants.SquareType;
import snake.GameObjects.Board;

import java.awt.Color;
import java.awt.Graphics;

public class FruitSquare extends Square {

    public FruitSquare(int row, int col, Board board) {
        super(row, col, SquareType.FRUIT, board);
    }

    public void render() {
        Graphics g = board.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
        g.setColor(Color.BLACK);
        g.drawRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
    }
}