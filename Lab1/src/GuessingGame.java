/**
 * @author Hunter Renz
 * CS 145
 * 
 * 1-12-22
 * 
 * This program is meant to play a game with the user
 * where the computer generates a random number between 1 and 100
 * and the user is prompted to make a guess.
 * The computer then responds in one of three ways
 * either responding with higher, lower or correct.
 * After all play has concluded the computer will
 * report the overall results for all games played.
 */
import java.util.*;
public class GuessingGame {
	public static void main(String args[]) {
		/**
		 * This block of code is where all the variables for the main method
		 * get declared. First we set bestGuess to the upper bound of guesses
		 * so we only have to check to see if and number of user guesses is lower
		 * if the guess is lower then the value of bestGuess is changed.
		 * numGuesses and numGames both count the number of guesses and games respectively
		 * 
		 */
		int numGuesses = 0;
		int numGames = 0;
		int bestGuess = 9999;
		int currentGuesses = 0;
		String playAgain;
		boolean nextGame = true;
		Random rand = new Random();
		Scanner kbd = new Scanner(System.in);
		introduction();
		/**
		 * This while loop calls the game method and stores the result in
		 * a integer variable currentGuesses. Then currentGuesses is checked
		 * against bestGuess, and if currentGuess is less than bestGuess
		 * the value of bestGuess is changed to currentGuess.
		 * This process repeats until the user inputs they no longer
		 * wish to play the game.
		 */
		while(nextGame) {
			numGames += 1;
			currentGuesses = game(kbd, rand);
			numGuesses += currentGuesses;
			if(currentGuesses < bestGuess) {
				bestGuess = currentGuesses;
			}
			System.out.print("Do you want to play again? ");
			playAgain = kbd.next().substring(0, 1);
			nextGame = nextGame(playAgain);
			System.out.println();
		}
		results(numGames, numGuesses, bestGuess);
	}
	/**
	 * 
	 * @param test: is a one character string representing user input
	 * @return isNextGame: is a boolean variable 
	 * 				       returning true if the user wants to play again
	 * 					   returning false if the user wants to end the game
	 */
	public static boolean nextGame(String test) {
		boolean isNextGame = false;
		if(test.equalsIgnoreCase("y")) {
			isNextGame = true;
		}
		return isNextGame;
	}
	/**
	 * This method is called to print the introductory statement at
	 * the beginning of the game.
	 */
	public static void introduction() {
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and ");
		System.out.println("100 and will allow you to guess until");
		System.out.println("you get it.  For each guess, I will tell you");
		System.out.println("whether the right answer is higher or lower");
		System.out.println("than your guess.");
		System.out.println();
	}
	/**
	 * This method is the core of the game and is called each time that
	 * the program is either started or nextGame returns true to main
	 * @return guesses: integer variable returning the number of guesses that
	 * 					the user made over the course of a single game.
	 */
	public static int game(Scanner guess, Random rand) {
		int guessRange = 9999;
		int currentGuess = 0;
		int guesses = 0;
		int num;
		num = rand.nextInt(guessRange - 1) + 1;
		System.out.println("I'm thinking of a number between 1 and 100...");
		while(num != currentGuess) {
			guesses += 1;
			System.out.print("Your guess? ");
			currentGuess = guess.nextInt();
			if(currentGuess > num) {
				System.out.println("It's lower.");
			}
			else if(currentGuess < num) {
				System.out.println("It's higher.");
			}
			else if(guesses == 1 && currentGuess == num) {
				System.out.println("You got it right in 1 guess");
			}
			else {
				System.out.printf("You got it right in %d guesses\n", guesses);
			}
		}
		return guesses;
	}
	/**
	 * 
	 * @param games: integer variable representing the total number of games played
	 * @param guesses: integer representing the total number of guesses that the user made
	 * 				   over the course of all games.
	 * @param bestGuess: integer variable representing the lowest number of guesses to get
	 * 					 a right answer over the course of a single game.
	 */
	public static void results(int games, int guesses, int bestGuess) {
		double guessPer = (double)guesses / (double)games;
		System.out.println("Overall results:");
		System.out.printf("    total games   = %d\n", games);
		System.out.printf("    total guesses = %d\n", guesses);
		System.out.printf("    guesses/game  = %.1f\n", guessPer);
		System.out.printf("    best game     = %d\n", bestGuess);
	}
}

