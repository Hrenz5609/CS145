import java.util.*;
public class PhoneBookTest {
	public static void main(String args[]) {
		/**
		 * Initialize variables for the phonebook
		 */
		PhonebookManager bellingham = new PhonebookManager();
		Scanner kbReader = new Scanner(System.in);
		boolean end = false;
		String input;
		String editCase;
		String newString;
		int index;
		/**
		 * do while loop to run the user interface of the phone
		 * book.
		 */
		do {
			/**
			 * user prompt for phone book menu
			 */
			System.out.println("[A]dd new contact. \n[E]dit existing contact. \n[R]emove contact"
					+ "\n[P]rint a list of your contacts. \n[Q]uit this program.");
			System.out.print("Please enter a command: ");
			input = kbReader.nextLine().toUpperCase();
			/**
			 * switch case for determining user input
			 */
			switch(input) {
			case "A":
				/*
				 * variable declarations for new contact fields
				 */
				String name;
				String address;
				String city;
				String number;
				/*
				 * prompts for user input and scanner nextlines to
				 * populate contact fields
				 */
				System.out.print("Please enter a name (first last): ");
				name = kbReader.nextLine();
				System.out.print("Please enter an address: ");
				address = kbReader.nextLine();					
				System.out.print("Please enter a city: ");
				city = kbReader.nextLine();					
				System.out.print("Please enter a phone number ( (XXX) XXX-XXXX ): ");
				number = kbReader.nextLine();
				/*
				 * addContact call to create new entry in phonebook
				 */
				bellingham.addContact(name, address, city, number);
				break;
			case "E":
				/**
				 * for the edit the user needs to know the index of the contact
				 * to edit so we will first print the current contacts of the
				 * phonebook
				 */
				bellingham.print();
				/**
				 * first we prompt the user to select an index to edit
				 * and set the index variable to the user input using
				 * Integer.parseInt so we can maintain a line based scanner
				 */
				System.out.print("Please select an index to edit: ");
				index = Integer.parseInt(kbReader.nextLine());
				/**
				 * then we prompt the user for the field they wish to
				 * edit and set editCase to that input
				 */
				System.out.print("Please enter a field to edit (name, address, city, phone number): ");
				editCase = kbReader.nextLine().toLowerCase();
				/**
				 * then we prompt the user to input the new contents of
				 * the field that they want to edit
				 */
				System.out.print("Please enter the new " + editCase + ": ");
				newString = kbReader.nextLine();
				/**
				 * then we use editContact and pass the above variables
				 */
				bellingham.editContact(index, editCase, newString);
				break;
			case "R":
				/**
				 * since remove requires an index we first print the 
				 * current contents of the phonebook and prompt the 
				 * user to select one the current contacts to be removed
				 */
				bellingham.print();
				System.out.print("Please select an index to remove: ");
				index = Integer.parseInt(kbReader.nextLine());
				/**
				 * we then pass the user submitted index and remove the
				 * node referenced
				 */
				bellingham.removeContact(index);
				break;
			case "P":
				/**
				 * for the print selection we simply call .print()
				 */
				bellingham.print();
				break;
			case "Q":
				/**
				 * selecting "Q" simply sets end to true and the loop
				 * will not repeat
				 */
				end = true;
				break;
			}
		}while(!end);
	}
}
