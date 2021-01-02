package snake.Squares.SnakeSquares;

import snake.Constants.SquareType;
import snake.GameObjects.Board;
import snake.Squares.Square;

public abstract class SnakeSquare extends Square {
    
    public int playerID;

    public SnakeSquare(int row, int col, int playerID, SquareType type, Board board){
        super(row, col, type, board);
        this.playerID = playerID;
    }
    
}
