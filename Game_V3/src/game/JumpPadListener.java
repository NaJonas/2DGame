package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * A listener for player to jump high when touching the jump pad
 */

public class JumpPadListener implements CollisionListener {
    private Game game;

    public JumpPadListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Human player = game.getPlayer();
        if (e.getOtherBody() == player && e.getReportingBody() instanceof JumpPad) {

            game.getPlayer().setLinearVelocity(new Vec2(0, 25));
            ((JumpPad) e.getReportingBody()).playJumpSound();
        }
    }
}
