package snake.Squares;

import snake.Constants.SquareType;
import snake.GameObjects.Board;

public abstract class Square {

    public int row;
    public int col;
    private SquareType type;
    public Board board;

    public Square(int row, int col, SquareType type, Board board) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.board = board;
    }

    public abstract void render();

    public SquareType getType() {
        return type;
    }

}
