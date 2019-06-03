package captindutch.entity.creatures;

import captindutch.entity.Entity;

public abstract class Creature extends Entity {

    public static final int DEFUALT_HEALTH = 100;
    public static final float DEFAULT_SPEED = 6.0f;
    public static final int DEFAULT_WIDTH = 32;
    public static final int DEFAULT_HEIGHT = 32;

    protected int health;
    protected float speed;
    protected int width;
    protected int height;

    protected float xMove;
    protected float yMove;

    public Creature (float x, float y, int width, int height) {
        super (x, y, width, height);
        health = DEFUALT_HEALTH;
        speed = DEFAULT_SPEED;
        this.width = width;
        this.height = height;
        this.xMove = 0;
        this.yMove = 0;
    }

    public void move() {
        this.y += yMove;
        this.x += xMove;
    }


    // GETTERS & SETTERS

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
