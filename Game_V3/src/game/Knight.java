package game;

import city.cs.engine.*;

/**
 * A simple enemy
 */
public class Knight extends Walker { // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.55f,1.14f, 0.55f,1.15f, 0.54f,-0.98f, -0.74f,-1.03f, -0.62f,0.54f);
    private static final BodyImage image =
            new BodyImage("data/knight.png", 4f);


    public Knight(World world) {
        super(world, shape);
        addImage(image);
    }

}
