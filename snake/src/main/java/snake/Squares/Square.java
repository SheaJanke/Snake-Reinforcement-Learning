package snake.Squares;

import java.awt.Color;
import java.awt.Graphics;

import snake.Constants.SquareType;

public abstract class Square {

    public int row;
    public int col;
    private SquareType type;

    public Square(int row, int col, SquareType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public abstract void render(Graphics g, int topLeftX, int topLeftY, int squareSize);

    public void render(Graphics g, int topLeftX, int topLeftY, int squareSize, Color squareColor){
        g.setColor(squareColor);
        g.fillRect(topLeftX, topLeftY, squareSize, squareSize);
        g.setColor(Color.BLACK);
        g.drawRect(topLeftX, topLeftY, squareSize, squareSize);
    }

    public SquareType getType() {
        return type;
    }

}
