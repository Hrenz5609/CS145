public class PhonebookManager {
	/**
	 * declaration of private variables
	 */
	private ListNode head;
	private int length;
	/**
	 * Constructor for empty node
	 */
	public PhonebookManager() {
		head = null;
		length = 0;
	}
	/**
	 * Constructor for populated node
	 * @param name : String variable representing the name of the contact
	 * @param address : String representing the address of the contact
	 * @param city : String representing the current city of contact
	 * @param phoneNumber : String representing the current phone number
	 * 					    of the contact
	 */
	public void addContact(String name, String address, String city, String phoneNumber) {
		/**
		 * declaration of current node, previous node, and new node (temp)
		 */
		ListNode current = head;
		ListNode previous = null;
		ListNode temp = new ListNode(name, address, city, phoneNumber);
		/**
		 * here we determine if the current list is empty
		 */
		if(length == 0) {
			head = temp;
			length++;
		}
		else {
			/**
			 * if the list is not empty then we insert the new
			 * node into the proper location based off of 
			 * the last name provided
			 */
			for(int i = 0; i < length; i++) {
				String name1[] = current.getName().split(" ");
				String name2[] = temp.getName().split(" ");
				/**
				 * we compare the last names of the current node
				 * and the new node
				 */
				int isFirst = name1[name1.length - 1].compareToIgnoreCase(name2[name2.length - 1]);
				/**
				 * here we check if the new name comes before the current last name
				 * and if it does then we set the new name.next to the
				 */
				if(isFirst > 0) {
					if(previous == null) {
						temp.next = current;
						head = temp;
						length++;
						break;
					}
					previous.next = temp;
					temp.next = current;
					length++;
					break;
				}
				else {
					if(current.next == null) {
						current.next = temp;
						temp.next = null;
						length++;
						break;
					}
					previous = current;
					current = current.next;
				}
			}
		}
	}
	/**
	 * the print method provides a formatted output of
	 * the current contents of the phone book
	 */
	public void print() {
		ListNode tempNode = head;
		if(head == null) {
			System.out.println("There are no current contacts in your phonebook.");
		}
		else {
			/**
			 * here we print out a menu to state name
			 * address city and phone number then
			 * use a for loop to iterate through the 
			 * linked list
			 */
			System.out.printf("    %-20s %-20s %-20s %-20s\n", "Name.", "Address.", "City.", "Phonenumber.");
			for(int i = 1; i <= length; i++) {
				String name = tempNode.getName();
				String address = tempNode.getAddress();
				String city = tempNode.getCity();
				String number = tempNode.getPhoneNumber();
				System.out.printf("%2d. %-20s %-20s %-20s %-20s\n", i, name, address, city, number);
				tempNode = tempNode.next;
			}
		}
	}
	/**
	 * the edit contact method pulls a node from the list
	 * sets a temp node to its values sets the field that
	 * is to be edited to the new input and then removes 
	 * the existing node at the index and adds a new
	 * node to the list utilizing the sort function in 
	 * the addContact method.
	 * 
	 * @param index : int of the index to be edited
	 * @param switchCase : String representing the contact
	 * 					   field that the user wants to edit
	 * @param newEntry : String representing the new value of
	 * 					 field that the user edits
	 */
	public void editContact(int index, String switchCase, String newEntry) {
		ListNode editNode = pullNode(index);
		if(editNode == null) {
			System.out.println("There was no contact for the index you entered.");
		}
		else {
			switch(switchCase) {
				case "name":
					editNode.setName(newEntry);
					break;
				case "address":
					editNode.setAddress(newEntry);
					break;
				case "city":
					editNode.setCity(newEntry);
					break;
				case "phonenumber":
					editNode.setNumber(newEntry);
					break;
			}
			removeContact(index);
			addContact(editNode.getName(), editNode.getAddress(), editNode.getCity(), editNode.getPhoneNumber());
		}
	}
	/**
	 * 
	 * @param index : int representing the index of the node
	 * 				  that the user wishes to pull from the list
	 * @return ListNode : representing the node at the index
	 */
	public ListNode pullNode(int index) {
		ListNode current = head;
		ListNode previous = null;
		for(int i = 1; i <= length; i++) {
			if(index == i) {
				return current;
			}
			else {
				previous = current;
				current = current.next;
			}
		}
		return null;
	}
	/**
	 * the removeContact method sorts through the linked
	 * list until it finds the node represented by the
	 * index then removes the node and sets the pointers
	 * of the previous to that of the one that was 
	 * removed.
	 * @param index : int representing the index of the
	 * 				  node in the list that needs to be
	 * 				  removed.
	 */
	public void removeContact(int index) {
		ListNode current = head;
		ListNode previous = null;
		boolean notFound = true;
		
		if(length == 0) {
			System.out.println("Sorry you currently have no entries into this phoenbook.");
		}
		else {
			for(int i = 1; i <= length; i++) {
				if(index == i) {
					if(previous == null) {
						head = head.next;
						length--;
						notFound = false;
					}
					else if(current.next == null) {
						previous.next = null;
						length--;
						notFound = false;
					}
					else {
						previous.next = current.next;
						length--;
						notFound = false;
					}
				}
				else {
					previous = current;
					current = current.next;
				}
			}
			if(notFound) {
				System.out.println("No index matching your input was found.");
			}
			else {
				System.out.println("Index: " + index + " was successfully removed.");
			}
		}
	}
}
