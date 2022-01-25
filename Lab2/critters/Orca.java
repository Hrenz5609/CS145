import java.awt.*;
public class Orca extends Critter{
	private int COLORCOUNTER;
	private Color CURRENTCOLOR;
	private String NAME;
	private boolean DIDINFECT;
	public Orca() {
		COLORCOUNTER = 0;
	}
	public Color getColor() {
		return CURRENTCOLOR;
	}
	public String toString() {
		NAME = "O";
		return NAME;
	}
	public Action getMove(CritterInfo info) {
		COLORCOUNTER++;
		if(COLORCOUNTER % 3 == 2) {
			CURRENTCOLOR = Color.GREEN;
		}
		else {
			CURRENTCOLOR = Color.BLUE;
		}
		
		
		if(info.getFront() == Neighbor.OTHER) {
			DIDINFECT = true;
			return Action.INFECT;
		}
		else if(DIDINFECT){
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
