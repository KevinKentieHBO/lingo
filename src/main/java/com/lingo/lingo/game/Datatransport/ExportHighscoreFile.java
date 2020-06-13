package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExportHighscoreFile implements ExportHighscoreFileInterface {
    private static final Logger logger = LogManager.getLogger(ExportHighscoreFile.class);

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
            logger.error(e + " :exporteren van de HighscoreList is niet gelukt");
        } finally {
            if(pw != null) {
                pw.close();
            }
        }
    }

}
