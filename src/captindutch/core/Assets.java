package captindutch.core;

import captindutch.tiles.BackgroundTile;
import captindutch.util.ImageLoader;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int SPRITE_COUNT = 6080;
    private static final int WIDTH = 32;
    private static final int HEIGHT = 32;

    private static BufferedImage[] assetList;

    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;


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

        // player animations
        player_down = new BufferedImage[2];
        player_down[0] = getAsset(6039);
        player_down[1] = getAsset(6040);

        player_up = new BufferedImage[2];
        player_up[0] = getAsset(6041);
        player_up[1] = getAsset(6042);

        player_right = new BufferedImage[4];
        player_right[0] = getAsset(6043);
        player_right[1] = getAsset(6044);
        player_right[2] = getAsset(6045);
        player_right[3] = getAsset(6046);

        player_left = new BufferedImage[4];
        player_left[0] = getAsset(6047);
        player_left[1] = getAsset(6048);
        player_left[2] = getAsset(6049);
        player_left[3] = getAsset(6050);

        for (int i=0; i<SPRITE_COUNT; i++) {
            new BackgroundTile(i);
        }

    }

     public static BufferedImage getAsset(int id) {
        return assetList[id];
    }

}
