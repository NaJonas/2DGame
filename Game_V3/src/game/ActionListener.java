package game;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.EventListener;

public interface ActionListener extends EventListener {
    void actionPerformed(ActionEvent e) throws IOException;
}