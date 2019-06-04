package captindutch.worlds;

import captindutch.core.Game;
import captindutch.tiles.Tile;
import captindutch.util.Util;

import java.awt.*;

public class World {

    private final int DEFAULT_TILE_ID = 134;
    private int width, height;
    private int spawnx, spawny;
    private int[][] mapTiles;
    private Game game;

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                getTile(x, y).render(g,
                        (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
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
