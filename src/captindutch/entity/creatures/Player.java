package captindutch.entity.creatures;

import captindutch.core.Assets;
import captindutch.core.Handler;

import java.awt.*;

public class Player extends Creature {

    private Handler handler;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
        this.handler = handler;

    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up) {
            this.yMove = -speed;
        }

        if(handler.getKeyManager().down) {
            this.yMove = +speed;
        }

        if(handler.getKeyManager().left) {
            this.xMove = -speed;
        }

        if(handler.getKeyManager().right) {
            this.xMove = +speed;
        }
    }

}
