import java.awt.*;
public class Orca extends Critter{
	/**
	 * Here we have a series of private variables
	 * used to store information from one
	 * turn to the next turn.
	 */
	private int COLORCOUNTER;
	private Color CURRENTCOLOR;
	private String NAME;
	private boolean DIDINFECT;
	/**
	 * Here we construct our Orca and
	 * set the COLORCOUNTER to 0
	 */
	public Orca() {
		COLORCOUNTER = 0;
		NAME = "O";
	}
	/**
	 * Here we return the current color of the
	 * Orca to the simulation
	 */
	public Color getColor() {
		return CURRENTCOLOR;
	}
	/**
	 * here we return the NAME variable to 
	 * the simulation and alternate NAME
	 * between either O or <>
	 */
	public String toString() {
		if(NAME.equals("O")) {
			NAME = "<>";
		}
		else {
			NAME = "O";
		}
		return NAME;
	}
	/**
	 * There are two sections of code in the getMove method
	 * one is used to determine color change
	 * and the other is used to determine the 
	 * Behavior of our Critter
	 */
	public Action getMove(CritterInfo info) {
		/**
		 * This first block of code is used to change the 
		 * color between green and blue if the number of 
		 * turns % 3 is equal to 2
		 */
		COLORCOUNTER++;
		if(COLORCOUNTER % 3 == 2) {
			CURRENTCOLOR = Color.GREEN;
		}
		else {
			CURRENTCOLOR = Color.BLUE;
		}
		/**
		 * this section of code determines what action the
		 * Orca should take based off of its surroundings
		 * and if the Orca has previously infected another
		 * Critter than the Orca will make a different move
		 * than it will if another Critter has been Infected
		 */
		if(info.getFront() == Neighbor.OTHER) {
			DIDINFECT = true;
			return Action.INFECT;
		}
		else if(DIDINFECT){
			DIDINFECT = false;
			return Action.RIGHT;
		}
		else if(info.getFront() == Neighbor.WALL) {
			return Action.LEFT;
		}
		else {
			return Action.HOP;
		}
	}
}
