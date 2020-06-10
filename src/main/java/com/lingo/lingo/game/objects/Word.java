package com.lingo.lingo.game.objects;

import java.util.List;
import java.util.Random;

import com.lingo.lingo.game.logic.CheckInputUser;
import nl.hu.lingo.game.Datatransport.ImportSortedWordFile;

public class Word {
	
	public int wordLength;
	public String exactWord;
	
	public Word(int wordLength) {
		super();
		this.wordLength = wordLength;
		setWord(wordLength);
	}
	
	public void setWord(int wordLength) {
		List<String> wordList = ImportSortedWordFile.ReadFile(wordLength);
		int randomInteger = 0 + (int)(Math.random() * ((wordList.size() - 0) + 1));
		exactWord = wordList.get(randomInteger);
	}
	
	public String beginWord() {
		
		String wordInPlay = Character.toString(exactWord.charAt(0));
		for(int i = 0; i < wordLength; i+=1) {
			wordInPlay += "_";
		}
		return wordInPlay;
		
	}
	
	public List<String> makePlay(String userInput) {
		List<String> checkList = CheckInputUser.checkWord(userInput, exactWord, wordLength);
		String checkString = "";
		for(String feedback : checkList) {
			checkString += "["+feedback+"]";
		}
		System.out.println();
		String wordInPlay = "";
		for(int i = 0; i < wordLength; i+=1) {
			if(checkList.get(i).equals("correct")) {
				wordInPlay += exactWord.charAt(i);
			}
			else {
				wordInPlay += "_";
			}
		}
		System.out.println(checkString);
		System.out.println(wordInPlay);

		return checkList;
		
	}
	
}
