package com.lingo.lingo.game.objects;

import java.util.List;

import com.lingo.lingo.game.Datatransport.ImportSortedWordFile;
import com.lingo.lingo.game.Datatransport.ImportSortedWordFileInterface;
import com.lingo.lingo.game.logic.CheckInputUser;
import com.lingo.lingo.game.logic.CheckInputUserInterface;

public class Word {
	
	public int wordLength;
	public String exactWord;
	
	public Word(int wordLength) {
		super();
		this.wordLength = wordLength;
		setWord(wordLength);
	}
	
	public void setWord(int wordLength) {
		ImportSortedWordFileInterface importSortedWordFileI = new ImportSortedWordFile();
		List<String> wordList = importSortedWordFileI.ReadFile(wordLength);
		int randomInteger = 0 + (int)(Math.random() * ((wordList.size() - 0) + 1));
		exactWord = wordList.get(randomInteger);
	}
	
	public List<String> makePlay(String userInput) {
		CheckInputUserInterface checkInputUserI = new CheckInputUser();
		List<String> checkList = checkInputUserI.checkWord(userInput, exactWord, wordLength);
		String checkString = "";
		for(String feedback : checkList) {
			checkString += "["+feedback+"]";
		}
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
