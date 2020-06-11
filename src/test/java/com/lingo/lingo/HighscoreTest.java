package com.lingo.lingo;

import com.lingo.lingo.game.objects.HighscoreList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HighscoreTest {

//    @ParameterizedTest
//    @MethodSource("isWordNotNull")
//    @DisplayName("Checks when the word is created, the word is imported and the length of the word is the length it had to be.")
//    void verifyMovesAndResults(int wordLenth, int expectedResult) {
//        assertEquals(wordLenth,expectedResult);
//    }

    @Test
    @DisplayName("Checks if all the getters from Highscore work.")
    void gettersHighscoreTest() {
        HighscoreList highscorelist = new HighscoreList("Kevin", 50,32);
        assertEquals(highscorelist.getPlayerName(),"Kevin");
        assertEquals(highscorelist.getPlayerScore(),50);
        assertEquals(highscorelist.getHighscoretime(),32);
    }

    @Test
    @DisplayName("Checks if the Top 10 list gets filled")
    void top10Test() {
        HighscoreList highscorelist = new HighscoreList();
        assertEquals(highscorelist.getTop10(5).size(),10);
        assertEquals(highscorelist.getTop10(6).size(),10);
        assertEquals(highscorelist.getTop10(7).size(),10);
    }

    @Test
    @DisplayName("Checks if the export Highscore function succesfully worked")
    void succesfullExportHighscoreList() {
        HighscoreList highscorelist = new HighscoreList("test",0,0);
        assertEquals(highscorelist.exportHighscore(highscorelist,8),true);

    }
}
