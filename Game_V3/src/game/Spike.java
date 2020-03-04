package game;

import city.cs.engine.*;


public class Spike extends StaticBody {

    private static final Shape shape = new PolygonShape(
            -0.72f,0.983f, 0.737f,0.983f, 1.03f,-0.352f, 1.034f,-0.993f, -1.042f,-0.976f, -1.047f,-0.365f);
    private static final BodyImage image =
            new BodyImage("data/spike_a.png", 2f);
    public Spike(World world) {
        super(world, shape);
        addImage(image);
    }
}
