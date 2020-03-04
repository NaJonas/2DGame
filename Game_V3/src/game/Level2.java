package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.lang.Math.random;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_ORANGES = 10;
    private SoundClip music;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        // randomised jump pads
        for (int i=0; i<5; i++) {
            JumpPad jumpPad = new JumpPad(this);
            jumpPad.setPosition(new Vec2((float)Math.random() * 15 + -10, (float)Math.random() * 100));
            jumpPad.addCollisionListener(new JumpPadListener(game));
        }


        // for random numbers
        double temp;
        // make some randomized platforms with spikes
        Shape platformShape = new BoxShape(4, 0.5f);
        for (int i=0; i<5; i++){
            temp = Math.random() * 15;
            Body platform1 = new StaticBody(this, platformShape);
            platform1.setPosition(new Vec2((float)(-7 + temp), 5.5f * i*i));
            Spike spike = new Spike(this);
            spike.setPosition((new Vec2((float)(-7 + temp -1), (float)(5.5 * i*i) + (float)1.5 )));
            spike.addCollisionListener(new Pickup(getPlayer()));
        }
        // last platform
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(3f, 100f));
        // guarding knight
        Knight knight = new Knight(this);
        knight.setPosition(new Vec2(3f, 102f));
        knight.addCollisionListener(new Pickup(this.getPlayer()));




        // randomised oranges
        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new Orange(this);
            orange.setPosition(new Vec2(i * 2 - 10, (float)Math.random() * 100));
            ((Orange) orange).setGravityScale(0);
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(2f, 101.9f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >= 10;
    }
    @Override
    public Image getBackground(){
        return new ImageIcon("data/game-background2.jpg").getImage();

    }
    @Override
    public void respawnSpikes(){}
    @Override
    public boolean areDestroyed(){return false; }

    @Override
    public SoundClip getMusic(){
        try {
            music = new SoundClip("data/beyond.mp3");
            music.setVolume(0.2);// Open an audio input stream
            return music;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            return null;
        }
    }
}
