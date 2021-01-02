package snake.Squares.SnakeSquares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;
import snake.GameObjects.Board;

public class SnakePartSquare extends SnakeSquare {
    public SnakePartSquare(int row, int col, int playerID, Board board) {
        super(row, col, playerID, SquareType.SNAKEPART, board);
    }

    public SnakePartSquare(SnakeSquare oldPart){
        super(oldPart.row, oldPart.col, oldPart.playerID, SquareType.SNAKEPART, oldPart.board);
    }

    public void render() {
        Graphics g = board.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
        g.setColor(Color.BLACK);
        g.drawRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());
    }
}
