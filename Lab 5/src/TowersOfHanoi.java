/**
 * @author hunter
 * CS145 Lab 5 Towers Of Hanoi
 * 3-1-2022
 */
public class TowersOfHanoi {
	/**
	 * Main method of the program calls hanoi for a given number of
	 * disks passed as the first parameter of Hanoi
	 */
	public static void main(String args[]) {
		hanoi(10, "First", "Second", "Third");
	}
	/**
	 * 
	 * @param num
	 * @param fRod - the starting rod
	 * @param oRod - the other rod
	 * @param tRod - the ending rod
	 * 
	 * This method takes three string objects representing the three
	 * rods. It recursively calls itself. We alter the position of the 
	 * the rods in the method call to alter which disk goes where. The 
	 * method will print the beginning Rod, ending rod, and the disk
	 * number with the number 1 representing the smallest disk.
	 */
	public static void hanoi(int num, String fRod, String oRod, String tRod) {
		if(num == 0) {
			return;
		}
		hanoi(num - 1, fRod, tRod, oRod);
		System.out.println("Disk " + num + " moved from " + fRod + " to " + tRod);
		hanoi(num - 1, oRod, fRod, tRod);
	}
}
