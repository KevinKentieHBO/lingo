package com.lingo.lingo;

import com.lingo.lingo.game.logic.CheckInputUser;
import com.lingo.lingo.game.logic.CheckInputUserInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootTest
public class CheckInputUserTest {

    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    @DisplayName("Gives feedback on the users input based on the exact word there guessing")
    void verifyMovesAndResults(ArrayList play, ArrayList expectedResult) {
        assertEquals(play,expectedResult);
    }


    private static Stream<Arguments> provideMovesAndResults() {
        CheckInputUserInterface checkInputUserI = new CheckInputUser();
        return Stream.of(Arguments.of(checkInputUserI.checkWord("ras","bep",3), new ArrayList<>(Arrays.asList("wrong", "wrong", "wrong"))),
                Arguments.of(checkInputUserI.checkWord("rap","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong","correct"))),
                        Arguments.of(checkInputUserI.checkWord("mep","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","correct"))),
                        Arguments.of(checkInputUserI.checkWord("bep","bep",3), new ArrayList<>(Arrays.asList("correct","correct","correct"))),
                        Arguments.of(checkInputUserI.checkWord("bop","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","correct"))),
                        Arguments.of(checkInputUserI.checkWord("bas","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("set","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("bes","bep",3), new ArrayList<>(Arrays.asList("correct","correct","wrong"))),

                        Arguments.of(checkInputUserI.checkWord("epb","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","wrong_place"))),
                        Arguments.of(checkInputUserI.checkWord("ebp","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","correct"))),
                        Arguments.of(checkInputUserI.checkWord("bpe","bep",3), new ArrayList<>(Arrays.asList("correct","wrong_place","wrong_place"))),
                        Arguments.of(checkInputUserI.checkWord("peb","bep",3), new ArrayList<>(Arrays.asList("wrong_place","correct","wrong_place"))),

                        Arguments.of(checkInputUserI.checkWord("ebt","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong_place","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("pas","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("rpl","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("ape","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","wrong_place"))),
                        Arguments.of(checkInputUserI.checkWord("pab","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","wrong_place"))),
                        Arguments.of(checkInputUserI.checkWord("ate","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong","wrong_place"))),

                        Arguments.of(checkInputUserI.checkWord("esp","bep",3), new ArrayList<>(Arrays.asList("wrong_place","wrong","correct"))),
                        Arguments.of(checkInputUserI.checkWord("lbp","bep",3), new ArrayList<>(Arrays.asList("wrong","wrong_place","correct"))),
                        Arguments.of(checkInputUserI.checkWord("bne","bep",3), new ArrayList<>(Arrays.asList("correct","wrong","wrong_place"))),
                        Arguments.of(checkInputUserI.checkWord("bpn","bep",3), new ArrayList<>(Arrays.asList("correct","wrong_place","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("pet","bep",3), new ArrayList<>(Arrays.asList("wrong_place","correct","wrong"))),
                        Arguments.of(checkInputUserI.checkWord("web","bep",3), new ArrayList<>(Arrays.asList("wrong","correct","wrong_place"))));
    }
}
