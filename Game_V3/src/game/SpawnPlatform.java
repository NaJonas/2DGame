
package game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A MouseListener that spawns a platform on each mouse press.
 */
public class SpawnPlatform extends MouseAdapter {

    private WorldView view;
    private World world;
    Shape userPlatformShape = new BoxShape(2, 0.5f);
    /**
     * Construct a listener.
     * @param view the view the mouse will be clicked on
     */
    public SpawnPlatform(WorldView view, World world) {
        this.view = view;
        this.world = world;
    }

    /**
     * Create a platform at the current mouse position.
     * @param e event object containing the mouse position
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Body userPlatform = new StaticBody(world, userPlatformShape);
        userPlatform.setPosition(view.viewToWorld(e.getPoint()));
    }

    
           
 
}
