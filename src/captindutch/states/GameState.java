package captindutch.states;

import captindutch.Entity.creatures.Player;

import java.awt.*;

public class GameState extends State{

    private Player player;

    public GameState() {
         player = new Player(10, 10);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
