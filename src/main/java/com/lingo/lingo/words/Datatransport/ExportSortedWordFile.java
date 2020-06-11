package com.lingo.lingo.words.Datatransport;

import java.io.PrintWriter;
import java.util.List;

public class ExportSortedWordFile implements ExportSortedWordFileInterface {
    public void exportSortedList(List<String> sortedList, int aantalLetters) {
        try
        {
            PrintWriter pr = new PrintWriter("C:\\Users\\kevin\\Desktop\\lingo\\src\\main\\java\\com\\lingo\\lingo\\words\\Recources\\filteredFiles\\LingoList_"+aantalLetters);

            for (String str : sortedList)
            {
                pr.println(str);
            }
            pr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }

}
