import java.lang.Math;

/**
 * This is a word and response repository for the object Eliza, this object
 * helps determine whether a word is in the bank, or is not, to allow the object to
 * deliver an appropriate response.
 * 
 * @author Jarrick Pang
 * @version 1.0
 * @since 15-06-2015
 */
public class WordBank {
	//Our primary word bank.
	private final static String[][] words= 
	{
		//words we needed to implement
		{"always", "Can you think of a specific example?"},
		{"because", "Is that the real reason?"}, 
		{"sorry", "Please don't apologize."},
		{"maybe", "You don't seem very certain."},
		{"I think", "Do you really think so?"},
		{"you", "We were discussing you, not me."},
		{"yes", "Why do you think so?", "How come?", "I think so too."},
		{"no", "Why not?"},
		{"I am", "I am sorry to hear you are *rest*"}, 
		{"I'm", "I am sorry to hear you are *rest*"}, 
		{"my", "Your *rest*"},	
		//Words I implemented
		{"I should", "How come you haven't done so already?"},
		{"should", "I think that's a good idea.", "Yes you should."},
		{"I would", "Is there anything stopping you?"},
		{"Thanks", "I'm only doing my job.", "You're welcome.", "I'm glad I could help.", "No, thank you."},
		{"would", "The probability, should be very high.", "The probability, is very low."},
		{"I can't", "What's stopping you from *rest*"},
		{"I want", "Why do you want it?"},
		{"bye", "It was nice talking to you, goodbye.", "Goodbye.", "See you next time."},
		{"about", "Do you know specifically", "Can you be a bit more precise?"},
		{"why", "I wouldn't know the answer to that."},
		{"Hi", "Salutations my friend.", "Hi.", "How do you do."},
		{"hello", "Hello.", "Greetings."}
	};
	
	//default responses if it is not in the word bank.
	private final static String[] defaultResponses = 
	{
		"What does that suggest to you?",
		"I see.",
		"I'm not too sure I understand you fully.",
		"Can you elaborate?",
		"That is quite interesting."
	};
	
	/**
	 * Default constructor, left blank because there are no instance
	 * variables to initiate.
	 */
	public WordBank()
	{
		//no variables to set.
	}
	
	/**
	 * This checks the main word bank to see if the word given has an
	 * appropriate response.
	 * 
	 * @param word The word to check against our word bank
	 * @return True or false, depending on whether the word is in the bank or not.
	 */
	public boolean hasResponse(String word)
	{
		int column = 0;
		boolean hasWord = false;
		for(int row = 0; row < words.length && hasWord != true; row++)
		{//we only want to check the first column of each row which is the word.
			hasWord = word.equalsIgnoreCase(words[row][column]);
		}
		return hasWord;
	}
	
	/**
	 * Grabs, and gives the according response in accordance to the word given.
	 * <p>
	 * The method allows for a variety of responses for one given word,
	 * an example is the word hello has the responses hello and greetings, one
	 * of these responses are picked at random.
	 * 
	 * @param word The word in which we are searching for the response.
	 * @return the response to the word that was given to the method.
	 */
	public String elizaResponse(String word)
	{
		int column = 0;
		int row = 0;
		while(!word.equalsIgnoreCase(words[row][column]) && row < words.length)
		{
			row++;
		}//this allows us to pick at random the many responses given for a single word
		column = (int)((Math.random()*(words[row].length - 1)) + 1) ;
		
		return words[row][column];
	}
	
	/**
	 * A helper function to the elizaResponse method. If we need to integrate part of the
	 * users sentence into the response.
	 * <p>
	 * It uses the list of words we split to check if we had an appropriate response
	 * to any of the words in the given sentence.
	 * 
	 * @param wordList The sentence we were given as input
	 * @param index The index of the word in which eliza has responded to
	 * @return the rest of the sentence in which will be included with the response
	 */
	public String elizaResponse(String[] wordList, int index)
	{
		String restOfResponse = "";
		for(int i = index ; i < wordList.length ; i++)
		{
			if(wordList[i].equalsIgnoreCase("me"))
			{//change subject from "me" to "you" when responding
				//as we are not talking about the AI, but rather the user.
				restOfResponse = restOfResponse.concat("you ");
			}
			else
			{
			restOfResponse = restOfResponse.concat(wordList[i] + " ");
			}
		}
		return restOfResponse;
	}
	
	/**
	 * If none of the words in the sentence are present in our word bank,
	 * a random default response is picked and used as the response.
	 * 
	 * @return A random default response.
	 */
	public String elizaDefaults()
	{
		int randomNumber = (int)(Math.random()*(defaultResponses.length));
		return defaultResponses[randomNumber];
	}
	
}
