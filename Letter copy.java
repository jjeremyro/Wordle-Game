/**
 * 150 Word Java Doc Summary
 * 
 * - class Letter - I started with the Letter class as this was the foundation for all the other classes and objects. I created a the class/blueprint Letter that has all the attributes and functions that we would use
 * in future classes such as the label/status of each instance of letter and the equals() method which were used to compare the letters in the user inputed guess word vs the mystery word. I also
 * had to implement the fromString() method in class Letter to convert/move each character in String s into a arrayLetters that would be used later to iterate through each letter in the array and
 * compare to the element in each node in the Word class. - class Word - I started off with the Word constructor method which used the letter array that we created using the fromString() method in class Letter to create a linked list to store each letter into each node.
 * The labelWord method was most definitely the most challenging method to successfully implement. The logic behind my code was that I was attempting to iterate through each node in the word linked list and on top of
 * that create a new linked list that would hold each letter of the mystery word. I would then use while loops to iterate through each node in each linked list simultaneously and use linearNode methods such as .getNext(),
 * .getElement(), assigning currentNode pointers to nextNodes and comparing them / adjust their status' accordingly. Unfortunately I ran out of time and couldbn't properly code this implementation, hence why I wrote
 * a hardcoded version instead. - class WordLL - This class is supposed to store a mystery word and all user inputed guesses tried so far. It keeps a history of the past word guesses in a linked structure. The hardest method in this class was the tryWord() method where
 * we are supposed to use .labelWord method to change the labels on each letter of each word. I had to create a new linked list history, and had to change the pointers of the newNode to be equal to the history head node in order to prepend/add the newest word inputed to
 * the front of the list. - class ExtendedLetter - This class just basically extended the functionality and attributes of the letter class so that it is more flexible by using inheritance. Instead of relying on a single char to represent the content of a Letter object, 
 * the objects will use a String instance variable. The hardest part about this class was differentiating between this and other object and using the proper syntax to compare the two.
 */



/**
 * 
 * @author jeremyro
 * This class represents a letter object that will be part of a linked list that creates a 
 * word. 
 */

public class Letter {
	
	private char letter;
	private int label;
	private final int UNSET = 0;
	private final int UNUSED = 1;
	private final int USED = 2;
	private final int CORRECT = 3;
	
	
	/**
	 * This method constructs Letter objects. Initialized label to status UNSET
	 * @param c
	 */
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	
	/**
	 * The equals method che
	 * @param otherObject
	 */
  	public boolean equals(Object otherObject) {
		  if (otherObject instanceof Letter) {
			  Letter otherLetter = (Letter) otherObject;
		      return this.letter == otherLetter.letter;
		  } else {
			  return false;
		}
  	}
  	
  	
	/**
	 * This decorator method returns the appropriate symbol for whichever status the label is currently in
	 * @return
	 */
	public String decorator() {
		if (label == USED) {
			return "+";
		} else if (label == UNUSED) {
			return "-";
		} else if (label == CORRECT) {
			return "!";
		} else if (label == UNSET) { // possibly add another else if. else if (label == USED) {}
			return " ";
		} else {
			return "N/A";
		}
	}
	
	/**
	 * This toString method overrides the other toString method and outputs the decorator symbols around the letter
	 */
	@Override
	public String toString() {
		String decorator = decorator();
		return (decorator + letter + decorator);	
	}
	
	/**
	 * This method sets the label to unused
	 */
	public void setUnused() {
		label = UNUSED;
	}
	
	/**
	 * This method sets the label to used
	 */
	public void setUsed() {
		label = USED;
	}
	
	/**
	 * This method sets the label to correct
	 */
	public void setCorrect() {
		label = CORRECT;
	}
	
	/**
	 * This method returns true if the label is unused and false if the label if not unused
	 */
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method takes the parameter s (a word) and iterates through each character and stores it into the array letters for future access
	 * @param s
	 * @return
	 */
	public static Letter[] fromString(String s) {
		Letter[] letters = new Letter[s.length()]; // initiate an array of length s (however many characters s is)
		for (int i = 0; i < s.length(); i++) { // iterates through each character in s
			letters[i] = new Letter(s.charAt(i)); // stores the character at at a specific index
		}
		
		return letters;
	}
	
	
}
