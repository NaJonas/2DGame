package game;

import java.awt.event.ActionEvent;

public class PreviousLevelAction implements ActionListener, java.awt.event.ActionListener {
    public Game game;
    public PreviousLevelAction(Game game){
        this.game = game;
    }

    public void actionPerformed(ActionEvent e){
        game.goPreviousLevel();
    }
}
