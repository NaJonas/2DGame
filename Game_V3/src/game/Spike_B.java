package game;

import city.cs.engine.*;


public class Spike_B extends DynamicBody {
    private int count=0;

    private static final Shape shape = new PolygonShape(
            -0.484f,0.996f, 0.476f,0.984f, 0.32f,-0.24f, -0.028f,-0.944f, -0.34f,-0.232f, -0.496f,0.556f
    );
    private static final BodyImage image =
            new BodyImage("data/spike_b.png", 2f);
    public Spike_B(World world) {
        super(world, shape);
        addImage(image);
    }


}
