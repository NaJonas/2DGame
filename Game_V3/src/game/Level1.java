package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_ORANGES = 5;
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

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-9, 5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(4, -2.5f));

        // Set some knights
        for (int i=0; i<2; i++){
        Knight knight = new Knight(this);
        knight.setPosition(new Vec2(3 * i-2,7));
        knight.addCollisionListener(new Pickup(getPlayer()));}

        // Oranges
        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new Orange(this);
            orange.setPosition(new Vec2(i * 4 - 8, (float)Math.random() * 10));
            ((Orange) orange).setGravityScale(0);
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >= NUM_ORANGES;
    }
    @Override
    public Image getBackground(){
        return new ImageIcon("data/game-background.jpg").getImage();

    }
    @Override
    public void respawnSpikes(){}

    @Override
    public boolean areDestroyed(){return false; }
    @Override
    public SoundClip getMusic(){
        try {
            music = new SoundClip("data/autumn_voyage.mp3");   // Open an audio input stream
            music.setVolume(0.2);
            return music;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            return null;
        }
    }
}
