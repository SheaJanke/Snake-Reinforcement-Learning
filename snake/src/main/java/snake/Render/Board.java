package snake.Render;

import java.awt.Graphics;
import java.awt.Color;

public class Board {

    private int squaresPerRow;
    private int squareSize;
    private int boarderSize;
    private int boardSize;
    private Square board[][];

    public Board(int boardSize, int squaresPerRow){
        this.boardSize = boardSize;
        this.squaresPerRow = squaresPerRow;
        squareSize = boardSize/(squaresPerRow+1);
        boarderSize = squareSize/2;
        initializeBoard();
    }

    private void initializeBoard(){
        board = new Square[squaresPerRow][squaresPerRow];
        for(int i = 0; i < squaresPerRow; i++){
            for(int j = 0; j < squaresPerRow; j++){
                board[i][j] = new EmptySquare(boarderSize + squareSize *i, boarderSize + squareSize * j, squareSize);
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, boardSize, boardSize);
        for(int i = 0; i < squaresPerRow; i++){
            for(int j = 0; j < squaresPerRow; j++){
                board[i][j].render(g);
            }
        }

    }
}
