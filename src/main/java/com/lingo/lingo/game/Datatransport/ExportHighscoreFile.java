package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ExportHighscoreFile implements ExportHighscoreFileInterface {

    public void exportHighscoreList(HighscoreList hg, int aantalLetters) throws Exception {
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(new FileOutputStream(
                    new File("src/main/java/com/lingo/lingo/game/Resources/Highscore/highscore_"+aantalLetters+".csv"),
                    true /* append = true */));

            pw.println(hg.getPlayerName()+","+hg.getPlayerScore()+","+hg.getHighscoretime());

        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception("exporteren van de HighscoreList is niet gelukt");
        } finally {
            pw.close();
        }
    }

}
