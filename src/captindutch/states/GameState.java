package captindutch.states;

import captindutch.entity.creatures.Player;
import captindutch.core.Game;

import java.awt.*;

public class GameState extends State{

    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game,10, 10);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
