import java.util.*;
public class Game {
	private static ArrayList<Card> DEALER = new ArrayList<Card>();
	private static ArrayList<Card> PLAYER = new ArrayList<Card>();
	private static Deck current = new Deck();
	private static boolean DEALERBUST= false;
	private static boolean PLAYERBUST = false;
	private static boolean WINCON = false;
	
	public static void main(String args[]) throws EmptyStackException
	{
		boolean playGame = true;
		introduction();
		while(playGame) {
			playGame();
		}
	}
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
	public static void newGame() {
		current = new Deck();
		DEALER = new ArrayList<Card>();
		PLAYER = new ArrayList<Card>();
		WINCON = false;
		PLAYERBUST = false;
		DEALERBUST = false;
	}
	public static void dealBlackJack() {
		PLAYER.add(current.deal());
		PLAYER.add(current.deal());
		DEALER.add(current.deal());
		DEALER.add(current.deal());
	}
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
	public static int playerScore() {
		int playerTotal = 0;
		for(int i = 0; i < PLAYER.size(); i++) {
			playerTotal += PLAYER.get(i).getValue();
		}
		return playerTotal;
	}
	public static int dealerScore() {
		int dealerTotal = 0;
		for(int i = 0; i < DEALER.size(); i++) {
			dealerTotal += DEALER.get(i).getValue();
		}
		return dealerTotal;
	}
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
	public static void isBust() {
		if(dealerScore() > 21) {
			DEALERBUST = true;
		}
		else if(playerScore() > 21) {
			PLAYERBUST = true;
		}
	}
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
	public static boolean playAgain(String input) {
		if(input.substring(0,1).equalsIgnoreCase("y")) {
			System.out.println("You have decided to play again!");
			return true;
		}
		else {
			System.out.println("You have decided not to play again...");
			System.out.println("Good Bye!");
			return false;
		}
	}
	public static void winCondition() {
		if(dealerScore() > playerScore() || PLAYERBUST) {
			System.out.println("Sorry Player the dealer has won this time!");
		}
		else if(dealerScore() < playerScore() || DEALERBUST) {
			System.out.println("Good news Player you won!");
		}
		else if(dealerScore() == playerScore()){
			System.out.println("It looks like we got a tie today!");
		}
	}
	public static void introduction() {
		
	}
}
