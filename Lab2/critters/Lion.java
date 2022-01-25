import java.awt.*;
import java.util.*;

public class Lion extends Critter{
	/**
	 * Here we declare a pair of variables relating
	 * to the lions current color and the count for 
	 * the number of turns since that last color change.
	 */
	private Color CURRENTCOLOR;
	private int COUNT;
	/**
	 * This is where we construct our Lion and
	 * set the turn count to 3 as well as
	 * call the nextColor() method to determine
	 * the starting color of our lion
	 */
	public Lion() {
		COUNT = 3;
		CURRENTCOLOR = nextColor();
	}
	/**
	 * in the getColor method we pass CURRENTCOLOR
	 * to the simulation
	 */
	public Color getColor() {
		return CURRENTCOLOR;
	}
	/**
	 * In getMove we have two sections one for determining
	 * the number of turns since that last color change
	 * and one section for determining the movements of the 
	 * Lion within the simulation
	 */
	public Action getMove(CritterInfo info) {
		/**
		 * In this section we have a series of if statements used
		 * to determine the number of turns since the last color 
		 * change. If there has been 3 turns since the last color
		 * than the count will reset and the nextColor method will
		 * be called changing the value of CURRENTCOLOR.
		 */
		if(COUNT > 0) {
			COUNT--;
		}
		else {
			COUNT = 3;
			CURRENTCOLOR = nextColor();
		}
		/**
		 * This section of the getMove method is related to how
		 * the lion will move inside the simulation
		 * we use a series of if and if else statements
		 * to determine the actions based on the surroundings
		 * of the lion at the current turn.
		 */
		if(info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		}
		else if(info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}
		else {
			return Action.HOP;
		}
	}
	/**
	 * Here we return a string "L" to be displayed
	 * in the simulation
	 */
	public String toString() {
		return "L";
	}
	/**
	 * This Color method is used to pick a random color after 3 turns
	 * it utilizes an array of RED GREEN BLUE colors and a random into to
	 * select which color is returned
	 */
	public Color nextColor() {
		Random rand = new Random();
		Color returnColor[] = {Color.RED, Color.GREEN, Color.BLUE};
		return returnColor[rand.nextInt(3)];
	}
}
