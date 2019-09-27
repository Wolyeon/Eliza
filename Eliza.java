import java.lang.String;

/**
 * Eliza, is a very simple watered down version of the very well known program,
 * it tries to simulate artificial intelligence by scanning through the input of the 
 * user and tries to give a response accordingly
 * 
 * @author Jarrick Pang
 * @version 1.0
 * @since 15-06-2015
 */
public class Eliza {
	//Objects attributes
	
	//I decided to make the responses a whole new object in itself
	//and called it wordbank
	WordBank wordBank;
	String name;
	
	//Objects Behaviours
	//Public Methods
	/**
	 * default constructor with the name defaulted to Eliza
	 */
	public Eliza()
	{
		wordBank = new WordBank();
		name = "Eliza";
	}
	/**
	 * overloaded constructor in case you wish to name the AI
	 * 
	 * @param aName the name in which the AI will refer to itself
	 */
	public Eliza(String aName)
	{
		wordBank = new WordBank();
		name = aName;
	}
	
	//Just a short introduction sequence 
	/**
	 * A method that gives a short introduction to who you will be talking to
	 * <p>
	 * Isn't actually anything important to the program, I put it in simply for 
	 * elegance per say.
	 * 
	 * @return Prints out an introduction to the console.
	 */
	public void introduction()
	{
		System.out.println("Hello, my name is " + name + ", I will be your doctor for today.");
		System.out.println("How may I help you today?");
	}
	
	/**
	 * This method takes a string, which is a sentence and breaks it up into an array of
	 * strings. Each word is sent through an array in our wordBank object to check if
	 * we have an appropriate response. whether we do or not, we send it to the response method
	 * to give a response accordingly.
	 * <p>
	 * If a sentence has two responses in a sentence, it gives the one that it checks first, in theory
	 * it does not even get to the second word.
	 * 
	 * @param statement The sentence in which we send to the AI
	 */
	public void interpretSentence(String statement)
	{
		int i = 0;
		boolean responseAvailable = false;
		String wordToAnalyze = "";
		String[] wordList = statement.split(" ");
		for(i = 0; i <wordList.length && responseAvailable != true; i++ )
		{
			if(wordList[i].equalsIgnoreCase("I"))
			{//Our word bank is not built to cope with 2 seperate words, so we put I + am or think
				//together
				wordToAnalyze = wordList[i] + " " + wordList[i + 1];
				responseAvailable = wordBank.hasResponse(wordToAnalyze);
			}
			else
			{
			wordToAnalyze = wordList[i];
			responseAvailable = wordBank.hasResponse(wordToAnalyze);
			}
		}
		giveResponse(responseAvailable, i, wordToAnalyze, wordList);
	}
	
	/**
	 * Takes whether we have a response or not, and gives a reply to the 
	 * statement given, if there is no match, we respond with one of the default 
	 * answers.
	 * 
	 * @param responseAvailable whether we have a response in the word bank
	 * @param index The index at which we found a matching response
	 * @param wordList The list of words in which we broke up to see if we had a matching word.
	 */
	private void giveResponse(boolean responseAvailable, int index, String word, String[] wordList)
	{
		if(responseAvailable == true)
		{
			String response = wordBank.elizaResponse(word);
			if(response.contains("*rest*"))
			{//for the case where we need to insert the rest of the user input
				String restOfResponse = wordBank.elizaResponse(wordList, index + 1);
				response = response.replace("*rest*", restOfResponse);
			}
				System.out.println(response);
		}
		else
		{
			System.out.println(wordBank.elizaDefaults());
		}
	}
	
	
}
