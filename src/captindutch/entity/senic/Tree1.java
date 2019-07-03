package captindutch.entity.senic;

import captindutch.core.Assets;
import captindutch.core.Handler;
import captindutch.entity.StaticEntity;
import captindutch.tiles.Tile;

import java.awt.*;

public class Tree1 extends StaticEntity {

    private static final int TEXTURE_ID = 845;

    public Tree1(Handler handler, int x, int y){
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getAsset(TEXTURE_ID), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
