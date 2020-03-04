package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Human human;
    GameLevel world;
    
    private Image background;
    
    public MyView(GameLevel world, Human human, int width, int height) {
        super(world, width, height);
        this.human = human;
        this.world = world;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + world.getPlayer().getOrangeCount(), 100, 100);
        g.drawString("Lives: " + world.getPlayer().getLivesCount(), 100, 90);
    }

    /**
     * Set the background image
     * @param img
     */
    public void setBackgroundImage(Image img){
        this.background = img;
    }
    public void setGameWorld(GameLevel world){this.world = world;}

}
