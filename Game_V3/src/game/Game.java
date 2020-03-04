package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;


/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    /**
     * A level
     */
    private int level;

    /**
     * Player controller
     */

    private Controller controller;

    /**
     * Level background music
     */
    private SoundClip backgroundMusic;



    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);




        // make a view
        view = new MyView(world, world.getPlayer(), 500, 600);
        view.setBackgroundImage(world.getBackground());

        // put background music on
        try {
            backgroundMusic = world.getMusic();
            backgroundMusic.loop();
        }
        catch(NullPointerException e){
            System.out.println(e);
        }


        // display the view in a frame
        final JFrame frame = new JFrame("Multi-level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        // add CONTROL PANEL and Load and Save panel
        Container controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.NORTH);
        Container loadSavePanel = new LoadSavePanel(this);
        frame.add(loadSavePanel, BorderLayout.SOUTH);


        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));



        // add controls to the player
        controller = new Controller(world.getPlayer());

        MouseTest mt = new MouseTest();
        view.addMouseListener(mt);


        frame.addKeyListener(controller);

        // debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /**
     * The player in the current level.
     */
    public Human getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }


    /**
     * Go to the previous game level
     */
    public void goPreviousLevel(){
        if (level - 1 >= 1){
            level=level -2;
            this.goNextLevel();
        }
        else System.exit(0);
    }

    /**
     * Get the current level
     * @return level
     */
    public int getLevel(){
        return level;
    }

    /**
     * Set the next level
     * @param level
     */
    public void setLevel(int level){
        this.level = level - 1;
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        // When using the buttons to shift through the levels
        // Set the lives count to 5 when it's 0
        if (this.getPlayer().getLivesCount()<=0){
            this.getPlayer().setLivesCount(5);
        }
        try {
            backgroundMusic.close();
        }
        catch(NullPointerException e){
            System.out.println(e);
        }
        if (level == 3) {
            System.exit(0);
        } else if (level == 1) {
            Human oldPlayer = world.getPlayer();
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // set the background music
            try {
                backgroundMusic = world.getMusic();
                backgroundMusic.loop();
            }
            catch(NullPointerException e){
                System.out.println(e);
            }
            // Keeping the points
            world.getPlayer().setOrangeCount(oldPlayer.getOrangeCount());
            world.getPlayer().setLivesCount(oldPlayer.getLivesCount());
            view.setGameWorld(world);

            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            view.setBackgroundImage(world.getBackground());

            // tracking the player
            world.addStepListener(new Tracker(view, world.getPlayer()));
            // Platform spawning
            SpawnPlatform db = new SpawnPlatform(view, world);
            view.addMouseListener(db);

            //start
            world.start();
        }
        else if (level==2){

            Human oldPlayer = world.getPlayer();
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new DefaultView(view));
            // set the background music
            try {
                backgroundMusic = world.getMusic();
                backgroundMusic.loop();
            }
            catch(NullPointerException e){
                System.out.println(e);
            }

            // Keeping the points
            world.getPlayer().setOrangeCount(oldPlayer.getOrangeCount());
            world.getPlayer().setLivesCount(oldPlayer.getLivesCount());
            view.setGameWorld(world);



            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);

            view.setBackgroundImage(world.getBackground());



            // start
        world.start();
    }
        else if (level==0){
            Human oldPlayer = world.getPlayer();
            level++;
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // set the background music
            try {
                backgroundMusic = world.getMusic();
                backgroundMusic.loop();
            }
            catch(NullPointerException e){
                System.out.println(e);
            }

            // Keeping the points
            world.getPlayer().setOrangeCount(oldPlayer.getOrangeCount());
            world.getPlayer().setLivesCount(oldPlayer.getLivesCount());
            view.setGameWorld(world);

            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            view.setBackgroundImage(world.getBackground());

            // start
            world.start();
        }

    }
    /** Run the game. */

    public static void main(String[] args) {
        new Game();
    }
}
