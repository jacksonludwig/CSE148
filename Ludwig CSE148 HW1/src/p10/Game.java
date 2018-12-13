package p10;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		String correct = "n";
		String direction;
		int guesses = 0;
		int max = 100;
		int min = 1;
		int newGuess = 50;
		
		System.out.println("Pick a number between 1 and 100 secretly. This program will try to guess it.");
		
		while(correct.equals("n")){
			 Scanner kboard = new Scanner(System.in);
			 guesses++;
			 
			 
			 System.out.println("Is this your number: " + newGuess + " (type \"y\" for yes and \"n\" for no)?");
			 correct = kboard.nextLine();
			 if(correct.equals("y"))
				 break;
			 System.out.println("Is it higher or lower (type \"h\" for higher and \"l\" for lower)?");
			 direction = kboard.nextLine();
			
			 // Binary Search
			 if(direction.equals("h")){
				 // newGuess = middle(guess, max);
				 min = newGuess;
				 newGuess = newGuess + ((max - newGuess) / 2);
				 
			 }
			 else if(direction.equals("l")) {
				// newGuess = middle(guess, min);
				 max = newGuess;
				 newGuess = newGuess - ((min + newGuess) / 2);
			 } 
		}
		System.out.println(guesses);
	}

}
