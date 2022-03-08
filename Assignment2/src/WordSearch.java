import java.io.*;
import java.util.*;
public class WordSearch {
	private static char[][] answerSearch;
	private static char[][] printSearch;
	private static ArrayList<String> wordList = new ArrayList<String>();
	public static void printIntro() {
		System.out.println("Welcome to my word search generator!");
		System.out.println("This program will allow you to generate"
				+ " your own word search puzzle");
	}
	public static char menu() throws FileNotFoundException{
		char returnChar;
		String input;
		Scanner kbReader = new Scanner(System.in);
		System.out.println("Please select an option:");
		System.out.println("Generate a new word search: (G)");
		System.out.println("Print out your word search: (P)");
		System.out.println("Show the solution to your word search: (S)");
		System.out.println("Quit the program: (Q)");
		input = kbReader.next().toLowerCase();
		returnChar = input.charAt(0);
		if(returnChar == 'g') {
			System.out.println("Would you like to enter your own words \n"
					+"or would you like to generate a search from a list of word?"
					+"Please enter: (P)ersonal or (L)ist");
			input = kbReader.next().toLowerCase();
			returnChar = input.charAt(0);
			if(returnChar == 'l') {
				try {
					String fileString;
					System.out.println("Please enter the name of a file to read from:");
					fileString = kbReader.next();
					File inputFile = new File(fileString);
					Scanner wordListFile = new Scanner(inputFile);
					while(wordListFile.hasNext()) {
						wordList.add(wordListFile.next());
					}
				}
				catch(Exception e){
					System.out.println("Unfortunately the word list file was not found!");
					returnChar = 'p';
				}
			}
			if(returnChar == 'p') {
				char isQuit = ' ';
				System.out.println("Please enter a word: ");
				do {
					System.out.println("Would you like to enter another word? (Y/N): ");
					input = kbReader.next().toLowerCase();
					if(input.charAt(0) == 'y') {
						System.out.println("Please enter a word to add to the puzzle: ");
						wordList.add(kbReader.next());
					}
					else {
						isQuit = 'q';
					}
				}while(isQuit != 'q');
			}
		}
		return returnChar;
	}
	public static void generate() {
		
	}
	public static void print() {
		
	}
	public static void showSolution() {
		
	}
	public static void setGridSize() {
		String strLen = "";
		for(String temp : wordList) {
			strLen += temp;
		}
		int size = (int)Math.ceil(Math.sqrt(strLen.length())) + 5;
		answerSearch = new char[size][size];
		printSearch = answerSearch;
	}
	public static void fillEmpty() {
		Random rand = new Random();
		for(int line = 0; line < answerSearch.length; line++) {
			for(int col = 0; col < answerSearch.length; col++) {
				if(answerSearch[line][col] == 0) {
					answerSearch[line][col] = 'X';
					printSearch[line][col] = (char) (rand.nextInt(122) - 97);
				}
			}
		}
	}
}
