
public class tester {
	public static void main(String args[]) {
		char temp[][] = new char[20][20];
		for(char[] line : temp) {
			for(char index : line) {
				if(index == 0) {
					System.out.println("cv");
				}
			}
		}
	}
}
