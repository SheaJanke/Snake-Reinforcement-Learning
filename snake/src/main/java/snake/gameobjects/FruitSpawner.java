package snake.GameObjects;

public class FruitSpawner {
    
    private final int SPAWN_RATE = 5;
    
    private Board board;
    private int ticksSinceSpawn;

    public FruitSpawner(Board board){
        this.board = board;
        ticksSinceSpawn = 0;
    }

    public void tick(){
        ticksSinceSpawn++;
        if(ticksSinceSpawn >= SPAWN_RATE){
            spawnFruit();
            ticksSinceSpawn -= SPAWN_RATE;
        }
    }

    private void spawnFruit(){
        board.addFruitToEmpty();
    }

}
