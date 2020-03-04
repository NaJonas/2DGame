package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public abstract class GameLevel extends World {
    private Human player;
    Game game;

    public Human getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        player = new Human(this);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));


    }


    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();
    /** Background image of the level **/
    public abstract Image getBackground();

    /**
     * Respawning the falling spikes
     */
    public abstract void respawnSpikes();

    /**
       Are the spike destroyed?
     */
    public abstract boolean areDestroyed();

    /**
     * Background music
     */
    public abstract SoundClip getMusic();
}
