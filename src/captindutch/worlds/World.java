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
    private boolean[][] mapCollision;
    private Handler handler;

    public World(Handler handler, String mapPath, String collisionMapPath) {
        this.handler = handler;
        loadWorld(mapPath, collisionMapPath);
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
        if (x < 0 || y < 0 || x >= width || y>= height) {
            return Tile.tiles[mapTiles[0][0]];
        }
        return Tile.tiles[mapTiles[x][y]];
    }

    public boolean getTileCollision(int x, int y) {
        return mapCollision[x][y];
    }

    private void loadWorld(String mapPath, String collisionMapPath) {
        String mapFile = Util.loadFileAsString(mapPath);
        String collisionFile = Util.loadFileAsString(collisionMapPath);

        // Find width and height of map
        String[] mapRows = mapFile.split("\n");
        String[] collisionRows = collisionFile.split("\n");
        String[] firstMapRow = mapRows[0].split(",");
        width = firstMapRow.length;
        height = mapRows.length;

        // Init the map
        mapTiles = new int[width][height];
        mapCollision = new boolean[width][height];

        // Populate the tile map and collision map
        for (int y=0; y<height; y++){
            String[] curMapRow = mapRows[y].split(",");
            String[] curCollisionRow = collisionRows[y].split(",");
            for (int x=0; x<width; x++) {
                mapTiles[x][y] = Util.patseInt(curMapRow[x]);
                if (curCollisionRow[x].equals("-1")){
                    mapCollision[x][y] = false;
                } else {
                    mapCollision[x][y] = true;
                }
            }
        }
    }

}
