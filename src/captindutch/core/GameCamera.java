package captindutch.core;

import captindutch.entity.Entity;

public class GameCamera {

    private float xOffset;
    private float yOffset;
    private Game game;

    public GameCamera (Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void move(float xAmount, float yAmount) {
        xOffset += xAmount;
        yOffset += yAmount;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() -  game.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() -  game.getHeight() / 2 + e.getHeight() /2;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
