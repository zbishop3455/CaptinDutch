package captindutch.states;

import captindutch.core.Game;
import captindutch.entity.creatures.Player;
import captindutch.worlds.World;

import java.awt.*;

public class GameState extends State{

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        world = new World(game, "res/worlds/level1.csv");
        player = new Player(game,100, 100);
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
