package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A jump pad
 */
public class JumpPad extends StaticBody {
    public static SoundClip jumpSound;
    static {
        try {
            jumpSound = new SoundClip("data/jumpPad.wav");
            jumpSound.setVolume(0.5);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public JumpPad(World world){
        super(world, new PolygonShape(-1.463f,0.47f, 1.487f,0.47f, 1.493f,-0.485f, -1.493f,-0.461f));
        addImage(new BodyImage("data/JumpPad.png", 1f));

    }
    public void playJumpSound(){
       jumpSound.play();
    }
}
