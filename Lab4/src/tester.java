
public class tester {
	public static void main(String args[]) {
		LetterInventory inventory1 = new LetterInventory("Isaac Newton");

		LetterInventory inventory2 = new LetterInventory("Michael Faraday");

		LetterInventory sum = inventory1.add(inventory2);


		System.out.println(sum.toString());
		sum.set('g', 5);
		System.out.println(sum.toString());
		System.out.println(sum.get('g'));
		System.out.println(sum.size());
		System.out.println(sum.isEmpty());
		LetterInventory sum2 = inventory1.subtract(inventory2);
		System.out.println(sum2.toString());

		
	}
}
