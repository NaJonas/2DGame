package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BiggerKnight extends Walker {
    private static final Shape shape = new PolygonShape(
            -1.3f,1.48f, -0.52f,2.8f, 1.16f,1.54f, 0.8f,-2.34f, -1.04f,-2.56f, -1.76f,-0.46f);
    private static final BodyImage image =
            new BodyImage("data/knight.png", 10f);


    public BiggerKnight(World world) {
        super(world, shape);
        addImage(image);
    }


    }
