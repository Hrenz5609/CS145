import java.awt.Color;

public class Bear extends Critter{
	
	
	private boolean POLAR;
	private String NAME;
	
	
	public Bear(boolean polar) {
		NAME = "/";
		POLAR = polar;
	}
	public Action getMove(CritterInfo info) {
		if(NAME.equals("/")) {
			NAME = "\\";
		}
		else {
			NAME = "/";
		}
		
		
		
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

    public Color getColor() {
        if(POLAR) {
        	return Color.WHITE;
        }
        else {
        	return Color.BLACK;
        }
    }

    public String toString() {
        return NAME;
    }
}
