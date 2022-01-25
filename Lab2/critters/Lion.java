import java.awt.*;
import java.util.*;

public class Lion extends Critter{
	/**
	 * 
	 */
	private Color CURRENTCOLOR;
	private int COUNT;
	/**
	 * 
	 */
	public Lion() {
		COUNT = 3;
		CURRENTCOLOR = nextColor();
	}
	/**
	 * 
	 */
	public Color getColor() {
		return CURRENTCOLOR;
	}
	/**
	 * 
	 */
	public Action getMove(CritterInfo info) {
		if(COUNT > 0) {
			COUNT--;
		}
		else {
			COUNT = 3;
			CURRENTCOLOR = nextColor();
		}
		
		
		
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
	 * 
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
