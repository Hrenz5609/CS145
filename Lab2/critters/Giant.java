import java.awt.*;

public class Giant extends Critter{
	/**
	 * this section includes a set of variables that store the
	 * count of the turn and an increment variable for the name 
	 * turn conversion. It also contains an array that stores
	 * the different names to be returned in toString() method
	 * and the name variable that is returned.
	 */
	private int TURNCOUNTER;
	private int INCRIMENTNAME;
	private String NAMEARRAY[] = {"fee", "fie", "foe", "fum"};
	private String NAME;
	/**
	 * Giant() constructs our giant and sets the Turn count to 6
	 */
	public Giant() {
		TURNCOUNTER = 6;
	}
	/**
	 * sets the color for Giant to gray
	 */
	public Color getColor() {
		return Color.GRAY;
	}
	/**
	 * returns the name of the gaint for simulation
	 */
	public String toString() {
		return NAME;
	}
	/**
	 * getMove contains the logic for incrementing 
	 * the name of the giant based on the turn count
	 * and INCRIMENTNAME variables declared above
	 * as well this method also contains the logic for
	 * determining the movements of the Giant.
	 */
	public Action getMove(CritterInfo info) {
		/**
		 * This is the name determination section of the method
		 * we use a turn counter and a name increment variable
		 * to determine what position in the name array we will 
		 * set the NAME variable to.
		 */
		if(TURNCOUNTER >0) {
			TURNCOUNTER--;
		}
		else {
			TURNCOUNTER = 6;
			if(INCRIMENTNAME == 3) {
				INCRIMENTNAME = 0;
			}
			else {
				INCRIMENTNAME++;
			}
			NAME = NAMEARRAY[INCRIMENTNAME];
		}
		/**
		 * this is the logic section of the getMove method
		 * used to determine what movements the giant should be making
		 */
		if(info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		else if(info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		else {
			return Action.RIGHT;
		}
	}
}
