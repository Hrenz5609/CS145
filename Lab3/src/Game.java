/**
 * @author Hunter Renz
 * @date 02-01-2022
 * CS 145 
 * Lab 4 Deck of Cards
 */
import java.util.*;
public class Game {
	/**
	 * This is a series of private variables used to keep track
	 * of all the aspects of the game
	 * There are two arraylists that handle the hands for the player
	 * and the dealer
	 * there is a deck Object used to store the deck for the
	 * current game.
	 * There are boolean values for if the dealer or player
	 * has gone bust and if there is a win condition met
	 * There are ints representing the player and dealers
	 * wins
	 */
	private static ArrayList<Card> DEALER = new ArrayList<Card>();
	private static ArrayList<Card> PLAYER = new ArrayList<Card>();
	private static Deck current = new Deck();
	private static boolean DEALERBUST= false;
	private static boolean PLAYERBUST = false;
	private static boolean WINCON = false;
	private static int DEALERSCORE = 0;
	private static int PLAYERSCORE = 0;
	/**
	 * This is the main method of the program and runs
	 * the basic operations of the game inside of a try catch
	 * statement that prevents the application from crashing
	 * when the user decides to end the game.
	 * @throws EmptyStackException
	 */
	public static void main(String args[]) throws EmptyStackException	{
		try {
			boolean playGame = true;
			introduction();
			while(playGame) {
				playGame();
			}
		}catch(EmptyStackException e) {
		}
	}
	/**
	 * The playGame method is used to play a single game
	 * as well it passes a scanner object to the player method
	 */
	public static void playGame() {
		Scanner kbReader = new Scanner(System.in);
		String again;
		current.Shuffle();
		dealBlackJack();
		while((!DEALERBUST && !PLAYERBUST) && !WINCON) {
			player(kbReader);
			isBust();
			if(PLAYERBUST) {
				break;
			}
			dealer();
			isBust();
		}
		winCondition();
		System.out.println("Would you like to play again?");
		again = kbReader.next();
		if(playAgain(again)) {
			newGame();
		}
	}
	/**
	 * The new game method is used to reset the per game
	 * dependent variables and objects so that another
	 * game can be played with a fresh slate
	 */
	public static void newGame() {
		current = new Deck();
		DEALER = new ArrayList<Card>();
		PLAYER = new ArrayList<Card>();
		WINCON = false;
		PLAYERBUST = false;
		DEALERBUST = false;
	}
	/**
	 * dealBlackJack is called at the beginning of a game
	 * and deals two cards to each player.
	 * This is done by calling the deal method in the 
	 * Deck class and adding the card object returned
	 * to the arraylist for the player and dealer.
	 */
	public static void dealBlackJack() {
		PLAYER.add(current.deal());
		PLAYER.add(current.deal());
		DEALER.add(current.deal());
		DEALER.add(current.deal());
	}
	/**
	 * the player method prompts the user for input to either
	 * hit or stay based off of their current score.
	 * if the user decides to stay than it indicates that the
	 * player is ready to see if they have won or lost the game. 
	 * if the user stays than the WINCON variable is set to true
	 * @param kbReader - Scanner object used for taking user input
	 */
	public static void player(Scanner kbReader) {
		String userInput;
		int playerTotal = playerScore();
		System.out.println("Your Current Score is: " + playerTotal);
		System.out.println("Would you like to \"Stay\" or \"Hit\"?");
		userInput = kbReader.next();
		if(hit(userInput)) {
			PLAYER.add(current.deal());
			System.out.print("You got a " + PLAYER.get(PLAYER.size()-1).getRank());
			System.out.println(" of " + PLAYER.get(PLAYER.size()-1).getSuit());
			System.out.println("Your new score is: " + playerScore());
		}
		else {
			WINCON = true;
		}
	}
	/**
	 * The playerScore method returns a int representing their score
	 * @return int - representing the players current score 
	 * 				 based on the total of the cards in their hand
	 */
	public static int playerScore() {
		int playerTotal = 0;
		for(int i = 0; i < PLAYER.size(); i++) {
			playerTotal += PLAYER.get(i).getValue();
		}
		return playerTotal;
	}
	/**
	 * the dealerScore method returns a int representing their score
	 * @return int - representing the dealers current score
	 * 				 based on the total of the cards in their hands
	 */
	public static int dealerScore() {
		int dealerTotal = 0;
		for(int i = 0; i < DEALER.size(); i++) {
			dealerTotal += DEALER.get(i).getValue();
		}
		return dealerTotal;
	}
	/**
	 * The dealer method determines if the dealer will hit or stay 
	 * based off of the current value of their starting hand.
	 * if the dealer is delt a hand with a total value of less than
	 * 17 the dealer is forced to hit. if the hand is greater than 17
	 * the dealer will stay.
	 */
	public static void dealer() {
		int dealerTotal = dealerScore();
		System.out.println("The Dealers current score is: "+ dealerScore());
		if(dealerTotal < 17) {
			DEALER.add(current.deal());
			System.out.println("The Dealer hits. With a new score of: " + dealerScore());
		}
		else {
			System.out.println("The Dealer Stays. With a score of: " + dealerScore());
		}
	}
	/**
	 * the is bust method is called when the game needs to check
	 * if either the player or the dealer is bust
	 * and if either have a score over 21 than the variable
	 * representing them will be set to true
	 */
	public static void isBust() {
		if(dealerScore() > 21) {
			DEALERBUST = true;
		}
		if(playerScore() > 21) {
			PLAYERBUST = true;
		}
	}
	/**
	 * the hit method is called to determine if the user wishes to
	 * stay or hit on their turn
	 * @param input - String object representing the users input
	 * @return boolean - representing if a hit is requited
	 */
	public static boolean hit(String input) {
		if(input.substring(0,1).equalsIgnoreCase("h")) {
			System.out.println("The Player has decided to hit!");
			return true;
		}
		else {
			System.out.println("The Player has decided to stay!");
			return false;
		}
	}
	/**
	 * 
	 * @param input - String object representing the users input
	 * @return boolean - returns true if the player wishes to play
	 * 					 another game and false if not
	 */
	public static boolean playAgain(String input) {
		if(input.substring(0,1).equalsIgnoreCase("y")) {
			System.out.println("You have decided to play again!");
			return true;
		}
		else {
			System.out.println("You have decided not to play again...");
			System.out.println("The ending score was:");
			System.out.println("PLAYER: " + PLAYERSCORE);
			System.out.println("DEALER: " + DEALERSCORE);
			System.out.println("Good Bye!");
			return false;
		}
	}
	/**
	 * the winCondition method is used to determine who won
	 * the most recent game of Black Jack. It utilizes if statements
	 * to determine if the dealer or play has gone bust and from there
	 * who has won the game. 
	 */
	public static void winCondition() {
		if((dealerScore() > playerScore() && !DEALERBUST) || (PLAYERBUST)) {
			System.out.println("Sorry Player the dealer has won this time!");
			DEALERSCORE++;
		}
		else if((dealerScore() < playerScore() && !PLAYERBUST) || (!PLAYERBUST && DEALERBUST)) {
			System.out.println("Good news Player you won!");
			PLAYERSCORE++;
		}
		else if(dealerScore() == playerScore()){
			System.out.println("It looks like we got a tie today!");
		}
		
	}
	/**
	 * the introduction method is called at the beginning of
	 * the program to print a introductory statement for the 
	 * program.
	 */
	public static void introduction() {
		System.out.println("This program is going to simulate a game");
		System.out.println("of blackjack. For this game we will assume that");
		System.out.println("the ace will always be high.");
	}
}
