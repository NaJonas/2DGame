package game;

import javax.swing.*;
import java.awt.*;

/**
 * A control panel for quitting and shifting through the levels
 */

public class ControlPanel extends JPanel {
    Game game;
    public ControlPanel(Game game) {
        super();
        this.game = game;
        setBackground(Color.getHSBColor(240, 100, 100));
        setPreferredSize(new Dimension(35, 35));
        JPanel panel = new JPanel(new BorderLayout());

        // Quit button
        JButton quitButton = new JButton("QUIT");
        quitButton.addActionListener(new QuitAction());
        // Previous level button
        JButton previousLevelButton = new JButton("PREVIOUS LEVEL");
        previousLevelButton.addActionListener(new PreviousLevelAction(game));
        // Next level button
        JButton nextLevelButton = new JButton("NEXT LEVEL");
        nextLevelButton.addActionListener(new NextLevelAction(game));

        // Adding to the panel
        panel.add(previousLevelButton, BorderLayout.CENTER);
        panel.add(quitButton, BorderLayout.WEST);
        panel.add(nextLevelButton, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);

    }
}