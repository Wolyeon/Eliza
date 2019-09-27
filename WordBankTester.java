/**
 * Tester class for our word bank
 * 
 * @author Jarrick Pang
 * @version 1.0
 * @since 15-06-2015
 * 
 */

public class WordBankTester {
	/**
	 * Tests all methods in the WordBank class except for one, which is tested
	 * in our Eliza tester class, essentially using it.
	 * 
	 * @param args Not used in the program.
	 */
	public static void main(String[] args) {
		WordBank bank = new WordBank();
		System.out.println("The expected result is: True");
		System.out.println("The result is: " + bank.hasResponse("should"));
		System.out.println("The expected result is: \"Why not?\" ");
		System.out.println("The result is: " + bank.elizaResponse("no"));
		System.out.println("The expected result may vary from: What does that suggest to you?\n"
				+ "I see.\n"
				+ "I'm not too sure I understand you fully.\n"
				+ "Can you elaborate?\n"
				+ "That is quite interesting.");
		System.out.println("The result is: " + bank.elizaDefaults());
		//There is no real way to test the overloaded elizaResponse method
		//without using the program itself, so we test it in the Eliza Testing class.
	}

}
