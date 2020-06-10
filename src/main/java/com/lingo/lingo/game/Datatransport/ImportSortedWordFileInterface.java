package com.lingo.lingo.game.Datatransport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public interface ImportSortedWordFileInterface {
    static List ReadFile(int wordLength) {
        try {
        File file = new File("src/main/java/com/lingo/lingo/words/Recources/filteredFiles/LingoList_"+wordLength);
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
