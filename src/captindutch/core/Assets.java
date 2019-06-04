package captindutch.core;

import captindutch.tiles.BackgroundTile;
import captindutch.util.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int SPRITE_COUNT = 6080;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    private static BufferedImage[] assetList;

    public static BufferedImage player;
    public static BufferedImage grass1;
    public static BufferedImage rock1;


    public static void init() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/fullTileSet.png"));

        assetList = new BufferedImage[SPRITE_COUNT];

        int curID = 0;
        int sheetRows = sheet.getHeight() / HEIGHT;
        int sheetColumns = sheet.getWidth() / WIDTH;


        for (int i=0; i<sheetRows; i++) {
            for (int j=0; j<sheetColumns; j++) {
                assetList[curID] = sheet.crop(j *WIDTH, i*HEIGHT, WIDTH, HEIGHT);
                curID += 1;
            }
        }

        player = getAsset(3793);

        for (int i=0; i<SPRITE_COUNT; i++) {
            new BackgroundTile(i);
        }

    }

     public static BufferedImage getAsset(int id) {
        return assetList[id];
    }

}
