package com.lingo.lingo.game.objects;

import com.lingo.lingo.game.Datatransport.ExportHighscoreFile;
import com.lingo.lingo.game.Datatransport.ExportHighscoreFileInterface;
import com.lingo.lingo.game.Datatransport.ImportHighscoreFile;
import com.lingo.lingo.game.Datatransport.ImportHighscoreFileInterface;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HighscoreList implements Comparable<HighscoreList> {

	private static final Logger logger = LogManager.getLogger(HighscoreList.class);

	private String playerName;
	private int playerScore;
	private int highscoretime;
	private List<HighscoreList> fullHighscoreList;
	
	public HighscoreList(String playerName, int playerScore, int highscoretime) {
		super();
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.highscoretime = highscoretime;
	}

	public HighscoreList() {
		super();
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getHighscoretime() {
		return highscoretime;
	}

	public List<HighscoreList> getTop10(int wordLength) throws Exception {
		ImportHighscoreFileInterface importHighscoreFileI = new ImportHighscoreFile();
		try {
			fullHighscoreList = importHighscoreFileI.ReadFile(wordLength);
			List<HighscoreList> top10 = new ArrayList<HighscoreList>(fullHighscoreList.subList(fullHighscoreList.size() - 10, fullHighscoreList.size()));
			return top10;
		}catch(Exception e) {
			logger.error(e + " :HighscoreList kan niet gesorteerd worden naar een top 10 lijst");
			return null;
		}
	}

	@Override
	public int compareTo(HighscoreList o) {
		return this.getPlayerScore() - o.getPlayerScore();
	}

	public Boolean exportHighscore(HighscoreList hs, int wordLength) throws Exception {
		try {
			ExportHighscoreFileInterface exportHighscoreFileI = new ExportHighscoreFile();
			exportHighscoreFileI.exportHighscoreList(hs, wordLength);
			return true;
		}catch(Exception e) {
			logger.error(e + " :Exporteren van de Highscore wordt niet mogelijk gemaakt door HighscoreList object");
			return null;
		}
	}
}
