package captindutch.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[6080];

    public static final int TILEWIDTH = 64;
    public static final int TILEHEIGHT = 64;

    protected boolean solid = false;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public int getId(){
        return this.id;
    }

    public boolean isSolid() {
        return solid;
    }

}
