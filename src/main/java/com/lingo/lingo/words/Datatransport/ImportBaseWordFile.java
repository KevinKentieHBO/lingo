package com.lingo.lingo.words.Datatransport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportBaseWordFile implements ImportBaseWordFileInterface {

    public List ReadFile() {
        try {
            File file = new File("C:\\Users\\kevin\\Desktop\\lingo\\src\\main\\java\\com\\lingo\\lingo\\words\\Recources\\Basefiles\\basiswoorden-gekeurd.txt");
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



