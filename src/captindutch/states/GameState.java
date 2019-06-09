package captindutch.states;

import captindutch.core.Handler;
import captindutch.entity.creatures.Player;
import captindutch.worlds.World;

import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/map1_tiles.csv", "res/worlds/map1_collision.csv");
        handler.setWorld(world);
        player = new Player(handler,100, 100);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {

        world.render(g);
        player.render(g);
    }
}
