package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ImportHighscoreFileInterface {
    static List<HighscoreList> ReadFile(int wordlength) {
        try {
        File file = new File("src/main/java/com/lingo/lingo/game/Resources/Highscore/highscore_"+wordlength+".csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
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
        catch(Exception ec) {
        }
        return null;
      }
}