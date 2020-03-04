package game;
import java.awt.event.ActionEvent;

public class NextLevelAction implements ActionListener, java.awt.event.ActionListener {
    public Game game;
    public NextLevelAction(Game game){
        this.game = game;
    }

    public void actionPerformed(ActionEvent e){
        game.goNextLevel();
    }
}
