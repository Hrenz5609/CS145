import java.awt.Color;

public class Bear extends Critter{
	/**
	 * private variables to determine name and 
	 * status of is polar bear
	 */
	private boolean POLAR;
	private String NAME;
	/**
	 * Constructs Bear and sets POLAR to true or flase
	 * depending on what is passed
	 * @param polar
	 */
	public Bear(boolean polar) {
		NAME = "/";
		POLAR = polar;
	}
	/**
	 * this is where the actions of Bear are determined
	 * and where we iterate name change based off of 
	 * number of turns 
	 */
	public Action getMove(CritterInfo info) {
		/**
		 * Name iteration logic
		 */
		if(NAME.equals("/")) {
			NAME = "\\";
		}
		else {
			NAME = "/";
		}
		/**
		 * movement determination
		 */
		if(info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		else if(info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		else {
			return Action.LEFT;
		}
    }
	/**
	 * determines the color of the bear based on
	 * the current value of POLAR 
	 * sets to white if POLAR is true
	 */
    public Color getColor() {
        if(POLAR) {
        	return Color.WHITE;
        }
        else {
        	return Color.BLACK;
        }
    }
    /**
     * returns the name of the bear. which is 
     * iterated about in the getMove() method
     */
    public String toString() {
        return NAME;
    }
}
