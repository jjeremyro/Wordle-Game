/**
 * @author jeremyro
 * This class represents a Word-Linked-List. It stores each user inputted word guess
 * as an element in a linear node.
 */

public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;
	
/**
 * This is a constructor for the history linked list object and mysteryWord
 * @param mystery
 */
	public WordLL(Word mystery) {
		history = null;
		mysteryWord = mystery;
	}
	
/**
 * This is a method that will compare and adjust the guess word vs the mystery word using
 * the .label method. It will also store/prepend each attempted guess in a linked list with pointer
 * history pointing to the headnode.
 * @param guess
 * @return
 */
	public boolean tryWord(Word guess) {
	    guess.labelWord(mysteryWord); // applying .labelWord() to change labels of inputted guess word

	    LinearNode<Word> newNode = new LinearNode<Word>(guess); // creating new node to hold the guess word and prepend to the beginning of the linked list

	    if (history == null) { // if history == null, this means that the linked list is empty, thus we create an empty linked list history with one node
	    	history = newNode;
	    } else { // if there are nodes already present in linked list:
	        newNode.setNext(history.getNext()); // set newNode as the node after history node
	        history.setNext(newNode); //set history node as newNode
	    }

	    return guess.equals(mysteryWord); 
	}
	
	/**
	 * This toString method outputs the history of past guesses that a user has inputed
	 */
	public String toString() {
		
		LinearNode<Word> currentNode = new LinearNode<>();
		currentNode = history; // current pointer set to history node
		StringBuilder pastGuesses = new StringBuilder();
		
		while (currentNode != null) { // while we haven't reached the end of the linked list:
            pastGuesses.append("Word: ").append(currentNode.getElement()).append("\n"); // output each element from each node as a string representation
            currentNode = currentNode.getNext(); // iterates to next node
        }
		
		return pastGuesses.toString();
		
	}
}
