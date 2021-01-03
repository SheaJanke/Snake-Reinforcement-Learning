package snake.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import snake.Constants.SquareType;
import snake.Squares.EmptySquare;
import snake.Squares.FruitSquare;
import snake.Squares.Square;

public class Board {

    private int squaresPerRow;
    private int squareSize;
    private int boarderSize;
    private int boardSize;
    private Square board[][];
    private boolean changed[][];
    private Random rand;

    public Board(int boardSize, int squaresPerRow) {
        this.boardSize = boardSize;
        this.squaresPerRow = squaresPerRow;
        squareSize = boardSize / (squaresPerRow + 1);
        boarderSize = squareSize / 2;
        initializeBoard();
        rand = new Random();
    }

    private void initializeBoard() {
        board = new Square[squaresPerRow][squaresPerRow];
        changed = new boolean[squaresPerRow][squaresPerRow];
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                board[i][j] = new EmptySquare(i, j, this);
                changed[i][j] = true;
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                if(changed[i][j]){
                    board[i][j].render(g);
                    changed[i][j] = false;
                }
            }
        }

    }

    public void addSquareToBoard(Square square) {
        board[square.row][square.col] = square;
        changed[square.row][square.col] = true;
    }

    public int indexToCoordinates(int index) {
        return boarderSize + squareSize * index;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void addFruitToEmpty(){
        int numEmpty = 0;
        for(int i = 0; i < squaresPerRow; i++){
            for(int j = 0; j < squaresPerRow; j++){
                if(board[i][j].getType() == SquareType.EMPTY){
                    numEmpty++;
                }
            }
        }
        int random = rand.nextInt(numEmpty);
        numEmpty = 0;
        for(int i = 0; i < squaresPerRow; i++){
            for(int j = 0; j < squaresPerRow; j++){
                if(board[i][j].getType() == SquareType.EMPTY){
                    if(numEmpty == random){
                        addSquareToBoard(new FruitSquare(i, j, this));
                        return;
                    }
                    numEmpty++;
                }
            }
        }
    }

}
