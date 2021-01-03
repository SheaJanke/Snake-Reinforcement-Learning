package snake;

import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.WindowConstants;

import snake.Constants.Direction;
import snake.GameObjects.Board;
import snake.GameObjects.Snake;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    
    public boolean running = false;
    public int tickCount = 0;
    private static Graphics g;
    private Window window;
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 600, HEIGHT = 600;
    public int secondsPast = 0;
    public Board board;
    public Snake snake;
    
    public Game() { 
        window = new Window(WIDTH,HEIGHT,"Gravity Gauntlet",this);
        setUp();
    }
    
    public synchronized void start() {
        new Thread(this).start();
        running = true;
    }
    
    public synchronized void stop() {
        running = false;
    }
    
    
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 64;
        
        int ticks = 0;
        int frames = 0;
        
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            
            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }
            
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            if (shouldRender) {
                frames++;
                render();
            }
            
            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                if(snake != null){
                    snake.move();
                }
                System.out.println(ticks + " ticks, " + frames + " frames");
                frames = 0;
                ticks = 0;
            }
        }
    }
    
    public void tick() {
        tickCount++;
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        board.render(g);

        g.dispose();
        bs.show();
    }

    public void setUp(){
        board = new Board(600, 11);
        snake = new Snake(5, 5, 3, 1, Direction.DOWN, board);
        this.addKeyListener(new KeyInput(snake));
    }

    public static void main(String[] args) {
        new Game();
    }
}
