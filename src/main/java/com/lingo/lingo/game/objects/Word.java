package com.lingo.lingo.game.objects;

import java.util.List;

import com.lingo.lingo.game.Datatransport.ImportSortedWordFile;
import com.lingo.lingo.game.Datatransport.ImportSortedWordFileInterface;
import com.lingo.lingo.game.logic.CheckInputUser;
import com.lingo.lingo.game.logic.CheckInputUserInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Word {

	private static final Logger logger = LogManager.getLogger(Word.class);

	public int wordLength;
	public String exactWord;
	
	public Word(int wordLength) throws Exception {
		super();
		this.wordLength = wordLength;
		setWord(wordLength);
	}
	
	public void setWord(int wordLength) throws Exception {
		try {
			ImportSortedWordFileInterface importSortedWordFileI = new ImportSortedWordFile();
			List<String> wordList = importSortedWordFileI.ReadFile(wordLength);
			int randomInteger = 0 + (int) (Math.random() * ((wordList.size() - 0) + 1));
			exactWord = wordList.get(randomInteger);
		}catch(Exception e) {
			logger.error(e + " :Random woord kan niet uit de imported file bemachtigd worden");
		}
	}
	
	public List<String> makePlay(String userInput) throws Exception {
		try {
			CheckInputUserInterface checkInputUserI = new CheckInputUser();
			List<String> checkList = checkInputUserI.checkWord(userInput, exactWord, wordLength);

			return checkList;
		}catch(Exception e) {
			logger.error(e + " :Er kan geen play gemaakt worden vanuit de userInput.");
			return null;
		}
	}
}
