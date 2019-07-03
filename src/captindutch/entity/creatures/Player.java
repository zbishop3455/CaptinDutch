package captindutch.entity.creatures;

import captindutch.core.Animation;
import captindutch.core.Assets;
import captindutch.core.Game;
import captindutch.core.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Handler handler;
    private Animation animationDown, animationUp, animationLeft, animationRight;
    private BufferedImage prevAnimationFrame;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
        this.handler = handler;
        bounds.x = 21;
        bounds.y = 34;
        bounds.width = 21;
        bounds.height = 28;

        // Animations
        animationDown = new Animation(130, Assets.player_down);
        animationUp = new Animation(130, Assets.player_up);
        animationLeft = new Animation(130, Assets.player_left);
        animationRight = new Animation(130, Assets.player_right);
        prevAnimationFrame = animationDown.getCurrentFrame();

    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        animationDown.tick();
        animationUp.tick();
        animationLeft.tick();
        animationRight.tick();
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        // COLLISION DEBUG
        if (Game.HIT_BOX_DEBUG) {
            g.setColor(Color.PINK);
            g.fillRect( (int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                    bounds.width, bounds.height);
        }
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0){
            prevAnimationFrame = animationLeft.getCurrentFrame();
            return animationLeft.getCurrentFrame();
        } else if (xMove > 0) {
            prevAnimationFrame = animationRight.getCurrentFrame();
            return animationRight.getCurrentFrame();
        } else if (yMove < 0) {
            prevAnimationFrame = animationUp.getCurrentFrame();
            return animationUp.getCurrentFrame();
        } else if (yMove > 0) {
            prevAnimationFrame = animationDown.getCurrentFrame();
            return animationDown.getCurrentFrame();
        } else {
            return prevAnimationFrame;
        }

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
