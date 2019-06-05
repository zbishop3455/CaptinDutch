package captindutch.core;

import captindutch.input.KeyManager;
import captindutch.worlds.World;

public class Handler {

    private Game game;
    private World world;

    public Handler (Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera () {
        return game.getGameCamera();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
}
