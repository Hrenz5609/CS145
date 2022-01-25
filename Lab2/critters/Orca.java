import java.awt.*;
public class Orca extends Critter{
	private int COLORCOUNTER;
	private Color CURRENTCOLOR;
	private String NAME;
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
			return Action.INFECT;
		}
		else {
			return Action.HOP;
		}
		
	}
}
