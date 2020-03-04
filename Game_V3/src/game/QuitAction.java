package game;

import java.awt.event.ActionEvent;

public class QuitAction implements ActionListener, java.awt.event.ActionListener {
    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}