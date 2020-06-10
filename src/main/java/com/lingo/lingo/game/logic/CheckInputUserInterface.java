package com.lingo.lingo.game.logic;

import java.util.ArrayList;
import java.util.List;

public interface CheckInputUserInterface {
    static List<String> checkWord(String userInput, String exactWord, int wordLength){
        List<String> checkList = new ArrayList<String>();
        try{
        for(int i = 0; i < wordLength; i+=1) {
            if(userInput.charAt(i) == exactWord.charAt(i)) {
                checkList.add("correct");
            }else if(exactWord.indexOf(userInput.charAt(i)) != -1) {
                checkList.add("wrong_place");
            }
            else {
                checkList.add("wrong");
            }
        }} catch (Exception e) {
            for(int i = 0; i < wordLength; i+=1) {
                checkList.add("wrong");
            }
        }
        return checkList;

    }
}
