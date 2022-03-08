
public class LetterInventory {
	private int LETTERCOUNT[] = new int[26];
	private String DATA;
	private int SIZE;
	public LetterInventory(String data) {
		DATA = data.replaceAll("\\s", "");
		DATA = DATA.toLowerCase();
		char temp[] = DATA.toCharArray();
		for(char current : temp) {
			LETTERCOUNT[(int)current - 97]++;
			SIZE++;
		}
	}
	public LetterInventory(int letterArray[], int size) {
		LETTERCOUNT = letterArray;
		SIZE = size;
	}
	public int[] getLetterCount() {
		return LETTERCOUNT;
	}
	public int get(char letter) {
		return LETTERCOUNT[(int)letter - 97];
	}
	public void set(char letter, int value) throws IllegalArgumentException{
		if((int)letter < 97) {
			LETTERCOUNT[(int)letter - 65] += value;
			SIZE += value;
		}
		else if((int)letter > 96) {
			LETTERCOUNT[(int)letter - 97] += value;
			SIZE += value;
		}
		
	}
	public int size() {
		return SIZE;
	}
	public boolean isEmpty() {
		if(SIZE == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		char temp[] = new char[SIZE];
		int indexCounter = 0;
		for(int i = 0; i < 26; i++) {
			for(int o = LETTERCOUNT[i]; o > 0; o--) {
				temp[indexCounter] = (char)(i + 97);
				indexCounter++;
			}
		}
		String rtnStr = new String(temp);
		return rtnStr;
	}
	public LetterInventory add(LetterInventory other) {
		int count = 0;
		int temp[] = other.getLetterCount();
		for(int i = 0; i < 26; i++) {
			temp[i] += LETTERCOUNT[i];
			count += temp[i];
		}
		LetterInventory rtnInv = new LetterInventory(temp, count);
		return rtnInv;
	}
	public LetterInventory subtract(LetterInventory other) {
		int count = 0;
		int temp[] = other.getLetterCount();
		int hold[] = this.getLetterCount();
		for(int i = 0; i < 26; i++) {
			if(hold[i] - temp[i] >= 0) {
				hold[i] -= temp[i];
				count += hold[i];
			}
			else {
				return null;
			}
		}
		LetterInventory rtnInv = new LetterInventory(hold, count);
		return rtnInv;
	}
}
