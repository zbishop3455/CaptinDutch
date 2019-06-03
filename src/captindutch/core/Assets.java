package captindutch.core;

import captindutch.util.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    public static BufferedImage player;


    public static void init() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spacedungeon.png"));

        player = sheet.crop(0, 0, WIDTH, HEIGHT);

    }

}
