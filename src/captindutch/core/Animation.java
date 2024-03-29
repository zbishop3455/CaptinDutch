package captindutch.core;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;
    private BufferedImage defaultFrame;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length) {
                index = 0;
            }
        }
    }
}
