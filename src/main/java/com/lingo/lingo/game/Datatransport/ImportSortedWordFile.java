package com.lingo.lingo.game.Datatransport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportSortedWordFile {
	
	public static List ReadFile(int wordLength) {
		try {
		File file = new File("C:\\Users\\kevin\\Desktop\\lingo\\src\\main\\java\\com\\lingo\\lingo\\words\\Recources\\filteredFiles\\LingoList_"+wordLength);
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		List<String> Wordlist = new ArrayList<String>();
		String st; 
			while ((st = br.readLine()) != null) {
					Wordlist.add(st); 
				}
		return Wordlist;
		
		}
		catch(Exception ec) {
		}
		return null;
	  } 
	}



