package snake.GameObjects;

import java.awt.Graphics;
import java.util.Random;

import snake.Constants.SquareType;
import snake.Squares.EmptySquare;
import snake.Squares.FruitSquare;
import snake.Squares.Square;

public class Board {

    private int squaresPerRow;
    private Square board[][];
    private boolean changed[][];
    private Random rand;

    public Board(int squaresPerRow) {
        this.squaresPerRow = squaresPerRow;
        initializeBoard();
        rand = new Random();
    }

    private void initializeBoard() {
        board = new Square[squaresPerRow][squaresPerRow];
        changed = new boolean[squaresPerRow][squaresPerRow];
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                board[i][j] = new EmptySquare(i, j);
                changed[i][j] = true;
            }
        }
    }

    public void render(Graphics g, int canvasSize) {
        int squareSize = canvasSize / (squaresPerRow + 1);
        for (int i = 0; i < squaresPerRow; i++) {
            for (int j = 0; j < squaresPerRow; j++) {
                if(changed[i][j]){
                    board[i][j].render(g, indexToCoordinates(i, canvasSize), indexToCoordinates(j, canvasSize), squareSize);
                    changed[i][j] = false;
                }
            }
        }

    }

    public void addSquareToBoard(Square square) {
        board[square.row][square.col] = square;
        changed[square.row][square.col] = true;
    }

    public int indexToCoordinates(int index, int canvasSize) {
        int squareSize = canvasSize / (squaresPerRow + 1);
        int boarderSize = (canvasSize - squaresPerRow * squareSize) / 2;
        return boarderSize + squareSize * index;
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
                        addSquareToBoard(new FruitSquare(i, j));
                        return;
                    }
                    numEmpty++;
                }
            }
        }
    }

    public Square getSquare(int row, int col){
        return board[row][col];
    }

    public int getSquaresPerRow(){
        return squaresPerRow;
    }

}
