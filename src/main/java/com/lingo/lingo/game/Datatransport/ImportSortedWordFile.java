package com.lingo.lingo.game.Datatransport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImportSortedWordFile implements ImportSortedWordFileInterface {

    private static final Logger logger = LogManager.getLogger(ImportSortedWordFile.class);

    //Import of the base word file depending on the amount of letters in the word.
    public List ReadFile(int wordLength) throws Exception {
        BufferedReader br = null;
        try {
            File file = new File("src/main/java/com/lingo/lingo/game/Resources/filteredFiles/LingoList_"+wordLength);
            br = new BufferedReader(new FileReader(file));
            List<String> wordlist = new ArrayList<>();
            String st;
            while ((st = br.readLine()) != null) {
                wordlist.add(st);
            }
            return wordlist;

        }
        catch(Exception e) {
            logger.error(e + " :Importeren van de woordenlijst is niet gelukt");
            return null;
        }finally {
            if(br != null) {
                br.close();
            }
        }
    }

}



