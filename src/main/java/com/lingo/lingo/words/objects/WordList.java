package com.lingo.lingo.words.objects;

import java.util.ArrayList;
import java.util.List;

import com.lingo.lingo.words.Datatransport.ExportSortedWordFile;
import com.lingo.lingo.words.Datatransport.ImportBaseWordFile;


public class WordList {
	
	private int wordSize;
	private List<String> wordList;

	public WordList(int wordSize) throws Exception {
		super();
		if(wordSize == 5 || wordSize == 6 || wordSize ==7) {
			this.wordSize = wordSize;
		}else {
			throw new Exception("Deze lengte wordt niet onderteund");
		}
	}
	
	public void importBaseList(){
		wordList = ImportBaseWordFile.ReadFile();
	}
	
	public void shapeWordListToSize() {
		List<String> SorterdWordlist = new ArrayList<String>();
		for(String str : wordList) {
			if(str.matches("^[a-z]*$") && str.length() == wordSize) {
				SorterdWordlist.add(str);
			}
		}
		wordList = SorterdWordlist; 
	}
	
	public void exportSortedWordFile() {
		ExportSortedWordFile.exportSortedList(wordList, wordSize);
	}
}
