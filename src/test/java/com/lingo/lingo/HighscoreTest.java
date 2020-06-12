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
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class HighscoreTest {

    @Test
    @DisplayName("Checks if all the getters from Highscore work.")
    void gettersHighscoreTest() {
        try {
            HighscoreList highscorelist = new HighscoreList("Kevin", 50, 32);
            assertEquals(highscorelist.getPlayerName(), "Kevin");
            assertEquals(highscorelist.getPlayerScore(), 50);
            assertEquals(highscorelist.getHighscoretime(), 32);
        }
        catch(Exception e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
    }

    @Test
    @DisplayName("Checks if the Top 10 list gets filled")
    void top10Test() {
        try {
            HighscoreList highscorelist = new HighscoreList();
            assertEquals(highscorelist.getTop10(5).size(), 10);
            assertEquals(highscorelist.getTop10(6).size(), 10);
            assertEquals(highscorelist.getTop10(7).size(), 10);
        }
        catch(Exception e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
    }

    @Test
    @DisplayName("Checks if the export Highscore function succesfully worked")
    void succesfullExportHighscoreList() {
        try {
            HighscoreList highscorelist = new HighscoreList("test", 0, 0);
            assertEquals(highscorelist.exportHighscore(highscorelist, 8), true);
        }
        catch(Exception e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }

    }
}
