package com.lingo.lingo.game.logic;

import java.util.ArrayList;
import java.util.List;

public interface CheckInputUserInterface {
    List<String> checkWord(String userInput, String exactWord, int wordLength);
}
