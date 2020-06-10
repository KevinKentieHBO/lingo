package nl.hu.lingo.words.main;


import nl.hu.lingo.words.objects.WordList;

public class main {

	public static void main(String[] args) throws Exception {
		
		WordList wordSize5 = new WordList(5);
		wordSize5.importBaseList();
		wordSize5.shapeWordListToSize();
		wordSize5.exportSortedWordFile();
		
		WordList wordSize6 = new WordList(6);
		wordSize6.importBaseList();
		wordSize6.shapeWordListToSize();
		wordSize6.exportSortedWordFile();
		
		WordList wordSize7 = new WordList(7);
		wordSize7.importBaseList();
		wordSize7.shapeWordListToSize();
		wordSize7.exportSortedWordFile();
	          
	    
	}

}
