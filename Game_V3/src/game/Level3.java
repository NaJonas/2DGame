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
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_ORANGES = 5;
    private Spike_B spike[];
    private int count=0;
    private SoundClip music;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        // Enemy
        BiggerKnight big_enemy = new BiggerKnight(this);
        big_enemy.setPosition(new Vec2(5, -10));
        this.addStepListener(new EnemyMoving(big_enemy, 5, 9, 7));
        big_enemy.addCollisionListener(new Pickup(this.getPlayer()));

        Knight knight_1 = new Knight(this);
        knight_1.setPosition(new Vec2(-6,1.5f));
        this.addStepListener(new EnemyMoving(knight_1, -6, -2, 6));
        knight_1.addCollisionListener(new Pickup(this.getPlayer()));




        // platforms
        Body platform_1 = new StaticBody(this, new BoxShape(5, 0.5f));
        platform_1.setPosition(new Vec2(-5, 0));
        Body platform_2 = new StaticBody(this, new BoxShape(6, 0.5f));
        platform_2.setPosition(new Vec2(-13.5f, -5));
        platform_2.setAngleDegrees(70);

        //Spikes
        Spike spike_1 = new Spike(this);
        spike_1.setPosition(new Vec2(-8, 1.5f));
        spike_1.addCollisionListener(new Pickup(this.getPlayer()));
        Spike spike_2 = new Spike(this);
        spike_2.setPosition(new Vec2(-8.5f, -1));
        spike_2.setAngleDegrees(180);

        // Falling spikes
        spike = new Spike_B[3];
        for (int i=0; i<3; i++){
            spike[i] = new Spike_B(this);
            spike[i].setPosition(new Vec2(5 +i, 15));
            spike[i].addCollisionListener(new Spike_BCollision(getPlayer(), this, spike[i]));
        }

        // oranges
        Body orange_1 = new Orange(this);
        orange_1.setPosition(new Vec2(-1,1.5f));
        ((Orange) orange_1).setGravityScale(0);
        orange_1.addCollisionListener(new Pickup(getPlayer()));
        Body orange_2 = new Orange(this);
        orange_2.setPosition(new Vec2(8, 10));
        ((Orange) orange_2).setGravityScale(0);
        orange_2.addCollisionListener(new Pickup(getPlayer()));
        Body orange_3 = new Orange(this);
        orange_3.setPosition(new Vec2(-11, 0.15f));
        ((Orange) orange_3).setGravityScale(0);
        orange_3.addCollisionListener(new Pickup(getPlayer()));

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-10, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(11, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() >= 13;
    }
    @Override
    public Image getBackground(){
        return new ImageIcon("data/game_background3.png").getImage();

    }
    @Override
    public void respawnSpikes(){
        for (int i=0; i<3; i++){
            spike[i] = new Spike_B(this);
            spike[i].setPosition(new Vec2(5 +i, 15));
            spike[i].addCollisionListener(new Spike_BCollision(getPlayer(), this, spike[i]));
        }
    }
    @Override
    public boolean areDestroyed(){
        count++;
        if (count>=3) {
            count=0;
            return true;
        }
        else return false;
    }

    @Override
    public SoundClip getMusic(){
        try {
            music = new SoundClip("data/dangerous_way.mp3");   // Open an audio input stream
            music.setVolume(0.2);
            return music;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            return null;
        }
    }
}
