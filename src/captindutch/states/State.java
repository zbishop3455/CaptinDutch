package captindutch.states;

import captindutch.core.Game;

import java.awt.*;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick ();

    public abstract void render(Graphics g);

}
