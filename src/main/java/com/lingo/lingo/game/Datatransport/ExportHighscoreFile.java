package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ExportHighscoreFile implements ExportHighscoreFileInterface {

    public void exportHighscoreList(HighscoreList hg, int aantalLetters) {
        try
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(
                    new File("src/main/java/com/lingo/lingo/game/Resources/Highscore/highscore_"+aantalLetters+".csv"),
                    true /* append = true */));
            //PrintWriter pr = new PrintWriter("C:\\Users\\kevin\\Desktop\\lingo\\src\\main\\java\\com\\lingo\\lingo\\game\\Resources\\Highscore\\highscore_"+aantalLetters+".csv");

            pw.println(hg.getPlayerName()+","+hg.getPlayerScore()+","+hg.getHighscoretime());

            pw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }

}
