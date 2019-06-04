package captindutch.entity.creatures;

import captindutch.core.Assets;
import captindutch.core.Game;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(game, x, y, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
        this.game = game;

    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up) {
            this.yMove = -speed;
        }

        if(game.getKeyManager().down) {
            this.yMove = +speed;
        }

        if(game.getKeyManager().left) {
            this.xMove = -speed;
        }

        if(game.getKeyManager().right) {
            this.xMove = +speed;
        }
    }

}
