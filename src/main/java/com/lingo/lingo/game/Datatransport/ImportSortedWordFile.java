package com.lingo.lingo.game.Datatransport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportSortedWordFile implements ImportSortedWordFileInterface {

    //Import of the base word file depending on the amount of letters in the word.
    public List ReadFile(int wordLength) {
        try {
            File file = new File("src/main/java/com/lingo/lingo/game/Resources/filteredFiles/LingoList_"+wordLength);
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> Wordlist = new ArrayList<String>();
            String st;
            while ((st = br.readLine()) != null) {
                Wordlist.add(st);
            }
            return Wordlist;

        }
        catch(Exception ec) {
        }
        return null;
    }

}



