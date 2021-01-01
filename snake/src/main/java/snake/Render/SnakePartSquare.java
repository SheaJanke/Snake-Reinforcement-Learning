package snake.Render;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public class SnakePartSquare extends Square {
    public SnakePartSquare(int row, int col, Board board) {
        super(row, col, SquareType.SNAKEPART, board);
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
        g.setColor(Color.BLACK);
        g.drawRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
    }
}
