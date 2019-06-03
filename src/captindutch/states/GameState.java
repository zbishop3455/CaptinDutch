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
        world = new World("Default");
        player = new Player(game,10, 10);
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
