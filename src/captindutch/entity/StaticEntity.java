package captindutch.entity;

import captindutch.core.Handler;

/*
    Static entity is an entity that does not move around. Trees and Rocks are static entities
 */
public abstract class StaticEntity extends Entity{

    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}
