package OO_Project;

import java.util.*;
import java.io.*;

public class Scoreboard {
    private ArrayList<Player> scores = new ArrayList<Player>();

    public Scoreboard(){
        readFile();
    }

    public void addScore(Player player) {
        scores.add(player);
        sortScore();
        writeFile();
    }

    public void sortScore() {
        Collections.sort(scores, Collections.reverseOrder());
    }

    public void printTop5Scores() {
        int place = 1;

        System.out.println("Top 5 Scores");

        try {
            FileWriter fileWriter = new FileWriter("TopScore.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Write the header
            bufferedWriter.write("Top 5 Scores");
            bufferedWriter.newLine();

            // Print and write only the top 5 scores
            for (int i = 0; i < Math.min(5, scores.size()); i++) {
                Player p = scores.get(i);
                System.out.printf("%d\t%s\t%d%n", place, p.getPlayerName(), p.getScore());
                bufferedWriter.write(p.getPlayerName() + "\t" + p.getScore());
                bufferedWriter.newLine();
                place++;
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter("TopScore.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Player p : scores) {
                bufferedWriter.write(p.getPlayerName() + "\t" + p.getScore());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader("TopScore.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    scores.add(new Player(playerName, score));
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

