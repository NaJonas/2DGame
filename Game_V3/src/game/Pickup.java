package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the player to collect points and get damaged from enemies
 */
public class Pickup implements CollisionListener {
    private Human human;
    
    public Pickup(Human human) {
        this.human = human;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == human && e.getReportingBody() instanceof Orange) {
            human.incrementOrangeCount();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() == human && e.getReportingBody() instanceof Knight){
            human.decrementLivesCount();
            if (human.getLivesCount() == 0) {
                e.getOtherBody().destroy();
            }

        }
        else if (e.getOtherBody() == human && e.getReportingBody() instanceof Spike){
            human.decrementLivesCount();
            if (human.getLivesCount() == 0) {
                e.getOtherBody().destroy();
            }

        }
        else if (e.getOtherBody() == human && e.getReportingBody() instanceof BiggerKnight){
            human.decrementLivesCount();
            if (human.getLivesCount() == 0) {
                e.getOtherBody().destroy();
            }
        }
    }
    
}
