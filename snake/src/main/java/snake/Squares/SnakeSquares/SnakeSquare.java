package snake.Squares.SnakeSquares;

import snake.Constants.SquareType;
import snake.Squares.Square;

public abstract class SnakeSquare extends Square {
    
    public int playerID;

    public SnakeSquare(int row, int col, int playerID, SquareType type){
        super(row, col, type);
        this.playerID = playerID;
    }
    
}
