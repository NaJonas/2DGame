package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to a default position
 */
public class DefaultView implements StepListener {
    /** The view */
    private WorldView view;


    public DefaultView(WorldView view) {
        this.view = view;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(0,0));
    }

}
