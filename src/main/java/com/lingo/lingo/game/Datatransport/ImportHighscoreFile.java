package com.lingo.lingo.game.Datatransport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.lingo.lingo.game.objects.HighscoreList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImportHighscoreFile implements ImportHighscoreFileInterface {
    private static final Logger logger = LogManager.getLogger(ImportHighscoreFile.class);

    public List<HighscoreList> ReadFile(int wordlength) throws Exception {
        BufferedReader br = null;
        try {
            File file = new File("src/main/java/com/lingo/lingo/game/Resources/Highscore/highscore_"+wordlength+".csv");
            br = new BufferedReader(new FileReader(file));
            List<HighscoreList> map = new ArrayList<HighscoreList>();
            String st;
            System.out.println("1");
            while ((st = br.readLine()) != null) {
                String[] data = st.split(",");
                System.out.println(st.toString());
                map.add(new HighscoreList(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
            }

            Collections.sort(map, (d1, d2)-> {
                return d2.getPlayerScore() - d1.getPlayerScore();
            });
            return map;

        }
        catch(Exception e) {
            logger.error(e + " :importeren van de HighscoreList is niet gelukt");
            return null;
        }finally {
            if (br != null) {
                br.close();
            }
        }
    }

}



