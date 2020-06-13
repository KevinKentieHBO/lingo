package com.lingo.lingo.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.lingo.lingo.game.objects.HighscoreList;
import com.lingo.lingo.game.objects.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class restController {

    Word word = null;

    @GetMapping("/inputword/{length}")
    public String inputWord(@PathVariable int length) throws Exception {
        JsonObject wordJson = new JsonObject();
        word = new Word(length);
        wordJson.addProperty("exactword", word.exactWord);
        System.out.println(word.exactWord);
        return wordJson.toString();
    }

    @GetMapping("/wordplay/{input}")
    public String checkInput(@PathVariable String input) throws Exception {
        JsonArray checkJsonArray = new JsonArray();
        List<String> checkList = word.makePlay(input);
        for (int i = 0; i < checkList.size(); i+=1){
            JsonObject checkJson = new JsonObject();
            checkJson.addProperty("value", checkList.get(i));
            checkJsonArray.add(checkJson);
        }
        return checkJsonArray.toString();
    }

    @GetMapping("/setHighscore/{name}/{score}/{time}/{length}")
    public void setHighscore(@PathVariable String name, @PathVariable int score, @PathVariable int time, @PathVariable int length) throws Exception {
        HighscoreList newScore = new HighscoreList(name,score,time);
        newScore.exportHighscore(newScore,length);
    }

    @GetMapping("/highscore/{length}")
    public String getHighscore(@PathVariable int length) throws Exception {
        JsonArray highscoreList = new JsonArray();
        HighscoreList highscoreListObject = new HighscoreList();
        List<HighscoreList> top10 = highscoreListObject.getTop10(length);
        int position = 1;
        for(HighscoreList row : top10){
            JsonObject checkJson = new JsonObject();
            checkJson.addProperty("positie", position);
            checkJson.addProperty("name", row.getPlayerName());
            checkJson.addProperty("score",row.getPlayerScore());
            checkJson.addProperty("time",row.getHighscoretime());
            highscoreList.add(checkJson);
            position +=1;
        }
        return highscoreList.toString();
    }
}
