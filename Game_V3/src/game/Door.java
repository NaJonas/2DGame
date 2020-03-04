package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level.
 */
public class Door extends StaticBody {

    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new PolygonShape(-0.267f,-0.66f, -0.259f,0.292f, 0.269f,0.308f, 0.285f,-0.652f, 0.261f,-0.656f));
        addImage(new BodyImage("data/door.png", 2.8f));
    }
}
