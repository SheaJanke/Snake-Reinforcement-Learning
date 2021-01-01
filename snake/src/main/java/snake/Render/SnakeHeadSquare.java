package snake.Render;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.Direction;
import snake.Constants.SquareType;

public class SnakeHeadSquare extends Square {

    Direction direction;

    public SnakeHeadSquare(int row, int col, Board board, Direction direction) {
        super(row, col, SquareType.SNAKEHEAD, board);
        this.direction = direction;
    }

    public void render(Graphics g) {
        // Draw square
        g.setColor(Color.GREEN);
        g.fillRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());

        // Draw outline
        g.setColor(Color.BLACK);
        g.drawRect(board.indexToCoordinates(row), board.indexToCoordinates(col), board.getSquareSize(),
                board.getSquareSize());

        // Draw eyes
        g.setColor(Color.BLACK);
        int eyeOffset1 = board.getSquareSize() / 5;
        int eyeOffset2 = 3 * board.getSquareSize() / 5;
        int eyeSize = board.getSquareSize() / 5;
        switch (direction) {
            case UP:
                g.fillOval(board.indexToCoordinates(row) + eyeOffset1, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                g.fillOval(board.indexToCoordinates(row) + eyeOffset2, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                break;
            case LEFT:
                g.fillOval(board.indexToCoordinates(row) + eyeOffset1, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                g.fillOval(board.indexToCoordinates(row) + eyeOffset2, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                break;
            case RIGHT:
                g.fillOval(board.indexToCoordinates(row) + eyeOffset1, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                g.fillOval(board.indexToCoordinates(row) + eyeOffset2, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                break;
            case DOWN:
                g.fillOval(board.indexToCoordinates(row) + eyeOffset1, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                g.fillOval(board.indexToCoordinates(row) + eyeOffset2, board.indexToCoordinates(col) + eyeOffset1,
                        eyeSize, eyeSize);
                break;
        }
    }

}