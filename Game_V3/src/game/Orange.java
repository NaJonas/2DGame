package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class Orange extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    private static SoundClip pointSound;

    static {
        try {
            pointSound = new SoundClip("data/point.wav");
            pointSound.setVolume(0.05);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    public Orange(World world) {
        super(world, shape);
        setFillColor(Color.orange);
    }
    @Override
    public void destroy(){
        pointSound.play();
        super.destroy();
    }
}
