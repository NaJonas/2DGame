package game;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAction implements ActionListener, java.awt.event.ActionListener {
    public Game game;
    private String fileName;

    public SaveAction(Game game, String fileName) {
        this.game = game;
        this.fileName = fileName;
    }

    public void actionPerformed(ActionEvent e){
            FileWriter writer = null;
            try{
                try {
                    writer = new FileWriter(fileName);
                    writer.write(game.getLevel() + "," + game.getPlayer().getOrangeCount() + "," + game.getPlayer().getLivesCount() + "\n");
                    System.out.println("SAVING");
                }
                finally {
                if (writer != null) {
                    writer.close();
                    }
                }
            }
            catch (IOException j){
                System.out.println(j);
            }


        }

    }


