package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * Step Listener to move bodies in x axis
 */

public class EnemyMoving implements StepListener {
    private DynamicBody body;
    private int startP;
    private int endP;
    private int speed;

    /**
     *
     * @param body The body which need to be moves
     * @param start Start position of moving
     * @param end End position of moving
     * @param speed The speed of the movement
     */
    public EnemyMoving(DynamicBody body, int start, int end, int speed){
        this.body = body;
        this.startP = start;
        this.endP = end;
        this.speed = speed;

    }
    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {

        if ((int)body.getPosition().x == startP) {
            body.setLinearVelocity(new Vec2(speed, 0));
        }
        if ((int)body.getPosition().x == endP){
            body.setLinearVelocity(new Vec2(-speed, 0));
        }

    }

}

