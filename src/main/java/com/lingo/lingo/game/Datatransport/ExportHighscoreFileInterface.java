package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public interface ExportHighscoreFileInterface {
    void exportHighscoreList(HighscoreList hg, int aantalLetters) throws Exception;
}
