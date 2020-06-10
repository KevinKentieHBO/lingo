package com.lingo.lingo.game;

import java.util.Scanner;

import com.lingo.lingo.game.objects.Word;

public class StartGame {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			int turnAmount = 5;
			
			System.out.print("Welcome to Lingo!");
			System.out.print("Would you like to play a new game or view the highscore?");
			System.out.print("Typ 'New Game' or 'Highscore'");
			String inputHighOrNew = scanner.nextLine();
			
			if(inputHighOrNew.toLowerCase().equals("new game")) {
				
				System.out.print("Do you want to play a 5, 6 or 7 letter word?");
				int wordLetterLength = scanner.nextInt();
				scanner.nextLine();
				Word word = new Word(wordLetterLength);
				
				System.out.print("Here is your word, good luck!");
				System.out.print(word.beginWord());
				for(int i = 0; i < turnAmount + 1; i+=1) {
						System.out.print("Make a guess!:");
						String userInput = scanner.nextLine();
						word.makePlay(userInput);
				}
				
			}else if(inputHighOrNew.toLowerCase().equals("highscore")) {
				
			}
		}

	}

}
