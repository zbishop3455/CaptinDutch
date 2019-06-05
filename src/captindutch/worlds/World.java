package captindutch.worlds;

import captindutch.core.Handler;
import captindutch.tiles.Tile;
import captindutch.util.Util;

import java.awt.*;

public class World {

    private final int DEFAULT_TILE_ID = 134;
    private int width, height;
    private int spawnx, spawny;
    private int[][] mapTiles;
    private Handler handler;

    public World(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {

        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH );
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y=yStart; y<yEnd; y++) {
            for (int x=xStart; x<xEnd; x++) {
                getTile(x, y).render(g,
                        (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }

    }

    public Tile getTile(int x, int y) {
        return Tile.tiles[mapTiles[x][y]];
    }

    private void loadWorld(String path) {
        String file = Util.loadFileAsString(path);

        // Find width and height of map
        String[] rows = file.split("\n");
        String[] firstRow = rows[0].split(",");
        width = firstRow.length;
        height = rows.length;

        // Init the map
        mapTiles = new int[width][height];

        // Populate the map
        for (int y=0; y<height; y++){
            String[] curRow = rows[y].split(",");
            for (int x=0; x<width; x++) {
                mapTiles[x][y] = Util.patseInt(curRow[x]);
            }
        }

    }

}
