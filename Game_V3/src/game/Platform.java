package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Platform extends StaticBody {
    public Platform(World world){
        super(world, new PolygonShape(-19.5f,12.1f, 17.3f,11.2f, 8.6f,-11.5f, -0.5f,-13.2f, -17.0f,-5.0f));
        addImage(new BodyImage("data/platform.png", 30f));
    }
}
