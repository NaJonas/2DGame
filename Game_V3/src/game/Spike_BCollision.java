package game;

import city.cs.engine.*;

/**
 * Collision listener that allows falling spikes to deal damage to a player
 * And respawns them after all spikes are destroyed
 */
public class Spike_BCollision implements CollisionListener {
    private Human human;
    private GameLevel gameLevel;
    private Spike_B spike;

    public Spike_BCollision(Human human, GameLevel gamelevel, Spike_B spike) {
        this.human = human;
        this.gameLevel = gamelevel;
        this.spike = spike;


    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == human){
            human.decrementLivesCount();
            e.getReportingBody().destroy();
            if (human.getLivesCount()==0) e.getOtherBody().destroy();
            System.out.println(gameLevel.areDestroyed());
            if (gameLevel.areDestroyed()){
                gameLevel.respawnSpikes();
            }
        }
        else if (e.getOtherBody() instanceof Body){
            e.getReportingBody().destroy();
            System.out.println(gameLevel.areDestroyed());
            if (gameLevel.areDestroyed()){
                gameLevel.respawnSpikes();
            }

        }
    }

}
