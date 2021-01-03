package snake;

import snake.Constants.Direction;
import snake.GameObjects.Board;
import snake.GameObjects.Snake;

import java.awt.Graphics;

public class Handler {
    
    private Game game;
    private Board board;
    private Snake playerSnake;
    private Snake aiSnake;

    public Handler(Game game, boolean twoPlayer){
        this.game = game;
        if(twoPlayer){
            setUpTwoPlayer();
        }else{
            setUpOnePlayer();
        }
    }

    public void tick(){
        playerSnake.move();
    }

    public void render(Graphics g){
        board.render(g);
    }

    private void setUpTwoPlayer(){

    }

    private void setUpOnePlayer(){
        board = new Board(600, 11);
        playerSnake = new Snake(7, 7, 3, 1, Direction.UP, board);
        game.addKeyListener(new KeyInput(playerSnake));
    }

}
