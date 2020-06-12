package com.lingo.lingo;

import com.lingo.lingo.game.objects.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class WordTest {

    @ParameterizedTest
    @MethodSource("isWordNotNull")
    @DisplayName("Checks when the word is created, the word is imported and the length of the word is the length it had to be.")
    void verifyMovesAndResults(int wordLenth, int expectedResult) {
        assertEquals(wordLenth,expectedResult);
    }

    @Test
    @DisplayName("Checks when the word is created, the word is imported and the length of the word is the length it had to be.")
    void MakePlayTest() {
        try {
            Word word = new Word(5);
            assertEquals(word.makePlay("poker").size(), 5);
        }
        catch(Exception e) {
            e.printStackTrace();
            fail("Should not have thrown any exception");
        }
    }


    private static Stream<Arguments> isWordNotNull() throws Exception {
            Word word5Letters = new Word(5);
            Word word6Letters = new Word(6);
            Word word7Letters = new Word(7);
            return Stream.of(Arguments.of(word5Letters.exactWord.length(), 5),
                    Arguments.of(word6Letters.exactWord.length(), 6),
                    Arguments.of(word7Letters.exactWord.length(), 7));

    }
}
