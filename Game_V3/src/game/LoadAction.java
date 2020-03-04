package game;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadAction implements ActionListener, java.awt.event.ActionListener {
    public Game game;
    private String fileName;

    public LoadAction(Game game, String fileName) {
        this.game = game;
        this.fileName = fileName;
    }

    public void actionPerformed(ActionEvent e){
        FileReader fr = null;
        BufferedReader reader = null;
        try{
            try {
                System.out.println("Reading " + fileName + " ...");
                fr = new FileReader(fileName);
                reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    // file is assumed to contain level, score, lives per line
                    String[] tokens = line.split(",");
                    int level = Integer.parseInt(tokens[0]);
                    int score = Integer.parseInt(tokens[1]);
                    int lives = Integer.parseInt(tokens[2]);
                    System.out.println("Level: " + level + ", Score: " + score + ", Lives: " + lives);
                    game.getPlayer().setOrangeCount(score);
                    game.getPlayer().setLivesCount(lives);
                    game.setLevel(level);
                    game.goNextLevel();
                    line = reader.readLine();
                }
                System.out.println("...done.");
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
        }
        catch (IOException j){
            System.out.println(j);
        }


    }

}


