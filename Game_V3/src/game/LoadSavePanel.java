package game;

import javax.swing.*;
import java.awt.*;

/**
 * A panel for loading and saving
 */
public class LoadSavePanel extends JPanel {
    Game game;
    public LoadSavePanel(Game game) {
        super();
        this.game = game;
        setBackground(Color.getHSBColor(240, 100, 100));
        setPreferredSize(new Dimension(35, 35));
        JPanel panel = new JPanel(new BorderLayout());

        JButton loadButton = new JButton("LOAD");
        loadButton.addActionListener(new LoadAction(game, "data/data.txt"));
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new SaveAction(game, "data/data.txt"));
        panel.add(loadButton, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);

    }
}
