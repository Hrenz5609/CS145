import java.awt.*;

public class Giant extends Critter{
	private int TURNCOUNTER;
	private int INCRIMENTNAME;
	private String NAMEARRAY[] = {"fee", "fie", "foe", "fum"};
	private String NAME;
	public Giant() {
		TURNCOUNTER = 6;
	}
	public Color getColor() {
		return Color.GRAY;
	}
	public String toString() {
		return NAME;
	}
	public Action getMove(CritterInfo info) {
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
