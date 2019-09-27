import java.util.Scanner;

/**
 * Tester class for our object Eliza
 * 
 * @author Jarrick Pang
 * @version 1.0
 * @since 15-06-2015
 * 
 */
public class ElizaTester {
	/**
	 *In a way, is a test class, for our Eliza object, in a way it is also to simply run 
	 *and use the program. 
	 *
	 *@param args Not used in the program.
	 */
	public static void main(String[] args) {
		Eliza Eunice = new Eliza();
		Scanner input = new Scanner(System.in);
		Eunice.introduction();
		String sentence = "";
		while(!sentence.equalsIgnoreCase("bye"))
		{
			System.out.print("- ");
			sentence = input.nextLine();
			System.out.print("\n");
			Eunice.interpretSentence(sentence);
		}
		input.close();
	}

}
