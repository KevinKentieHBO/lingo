package com.lingo.lingo.game.Datatransport;

import com.lingo.lingo.game.objects.HighscoreList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ImportHighscoreFileInterface {
    List<HighscoreList> ReadFile(int wordlength);
}
