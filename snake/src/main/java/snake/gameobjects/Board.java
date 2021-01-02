package snake.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;

import snake.Squares.EmptySquare;
import snake.Squares.Square;
import snake.Squares.SnakeSquares.SnakeSquare;

public class Board {

    private int squaresPerRow;
    private int squareSize;
    private int boarderSize;
    private int boardSize;
    private Square board[][];
    private Graphics g;

    public Board(int boardSize, int squaresPerRow, Graphics g) {
        this.boardSize = boardSize;
        this.squaresPerRow = squaresPerRow;
        this.g = g;
        squareSize = boardSize / (squaresPerRow + 1);
        boarderSize = squareSize / 2;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Square[squaresPerRow][squaresPerRow];
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                board[i][j] = new EmptySquare(i, j, this);
            }
        }
    }

    public void render() {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, boardSize, boardSize);
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                board[i][j].render();
            }
        }

    }

    public void addSquareToBoard(Square square) {
        board[square.row][square.col] = square;
        square.render();
    }

    public int indexToCoordinates(int index) {
        return boarderSize + squareSize * index;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public Graphics getGraphics(){
        return g;
    }

}
