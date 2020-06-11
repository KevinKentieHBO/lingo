package com.lingo.lingo;

import com.lingo.lingo.game.logic.CheckInputUserInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CheckInputUserTest {

    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    @DisplayName("Gives feedback on the users input based on the exact word there guessing")
    void verifyMovesAndResults(ArrayList play, ArrayList expectedResult) {
        assertEquals(play,expectedResult);
    }


    private static Stream<Arguments> provideMovesAndResults() {
        return Stream.of(Arguments.of(CheckInputUserInterface.checkWord("ras","bep",3), new ArrayList<>(Arrays.asList("wrong", "wrong", "wrong"))),
                Arguments.of(CheckInputUserInterface.checkWord("rap","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("mep","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bep","bep",3), new ArrayList<>(Arrays.asList("correct","correct","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bop","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bas","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("set","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bes","bep",3), new ArrayList<>(Arrays.asList("correct","correct","wrong"))),

                        Arguments.of(CheckInputUserInterface.checkWord("epb","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","wrong_place"))),
                        Arguments.of(CheckInputUserInterface.checkWord("ebp","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bpe","bep",3), new ArrayList<>(Arrays.asList("correct","wrong_place","wrong_place"))),
                        Arguments.of(CheckInputUserInterface.checkWord("peb","bep",3), new ArrayList<>(Arrays.asList("wrong_place","correct","wrong_place"))),

                        Arguments.of(CheckInputUserInterface.checkWord("ebt","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("pas","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("rpl","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("ape","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","wrong_place"))),
                        Arguments.of(CheckInputUserInterface.checkWord("pab","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","wrong_place"))),
                        Arguments.of(CheckInputUserInterface.checkWord("ate","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong","wrong_place"))),

                        Arguments.of(CheckInputUserInterface.checkWord("esp","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("lbp","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","correct"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bne","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","wrong_place"))),
                        Arguments.of(CheckInputUserInterface.checkWord("bpn","bep",3), new ArrayList<>(Arrays.asList("correct","wrong_place","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("pet","bep",3), new ArrayList<>(Arrays.asList("wrong_place","correct","wrong"))),
                        Arguments.of(CheckInputUserInterface.checkWord("web","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","wrong_place"))));
    }
}
