package snake.Squares;

import snake.Constants.SquareType;
import snake.GameObjects.Board;

import java.awt.Color;
import java.awt.Graphics;

public class EmptySquare extends Square {

    public EmptySquare(int row, int col, Board board) {
        super(row, col, SquareType.EMPTY, board);
    }

    public EmptySquare(Square square){
        super(square.row, square.col, SquareType.EMPTY, square.board);
    }

    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
        g.setColor(Color.BLACK);
        g.drawRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
    }
}
