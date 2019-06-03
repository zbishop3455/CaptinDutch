package captindutch.worlds;

import captindutch.tiles.Tile;

import java.awt.*;

public class World {

    private final int DEFAULT_TILE_ID = 134;
    private int width, height;
    private int[][] mapTiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
            }
        }

    }

    public Tile getTile(int x, int y) {
        return Tile.tiles[mapTiles[x][y]];
    }

    private void loadWorld(String path) {
        width = 5;
        height = 5;
        mapTiles = new int[width][height];
        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                mapTiles[i][j] = DEFAULT_TILE_ID;
            }
        }
    }

}
