package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A player character
 */

public class Human extends Walker {

    private static final Shape shape = new PolygonShape(
            -0.692f,0.8f, 0.216f,0.792f, 0.456f,0.328f, 0.38f,-0.772f, 0.152f,-0.976f, -0.872f,-0.976f, -0.8f,-0.084f);
    private static final BodyImage image =
            new BodyImage("data/player.png", 2f);

    private int orangeCount;
    private int livesCount;
    private static SoundClip hitSound;
    static {
        try {
            hitSound = new SoundClip("data/hit.wav");
            hitSound.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public Human(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        livesCount=5;
    }

    /**
     *
     * @return Get the orange/points count
     */
    public int getOrangeCount() {
        return orangeCount;
    }

    /**
     * Set the orange/points count
     * @param count
     */
    public void setOrangeCount(int count){
        orangeCount = count;
    }

    /**
     * Set lives count
     * @param count
     */
    public void setLivesCount(int count){
        livesCount = count;
    }

    /**
     * Add 1 point to the points count
     */
    public void incrementOrangeCount() {
        orangeCount++;
        System.out.println("Got a point! Points count = " + orangeCount);
    }

    /**
     * Decrement 1 point from the lives count. Play a hit sound
     */
    public void decrementLivesCount(){
        hitSound.play();
        livesCount--;
        System.out.println("Ouch, lost a life. Current lives: " + livesCount);
    }

    /**
     * Get the current lives count
     * @return livesCount
     */
    public int getLivesCount(){ return livesCount;}

}

