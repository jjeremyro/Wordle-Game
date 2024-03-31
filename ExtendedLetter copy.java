/**
 * @author jeremyro
 * This class is used to broaden the "notion" of a letter that we use in this word guessing game. It inherits from letter and thus also has class letter functionalities
 */
public class ExtendedLetter extends Letter {
	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	/**
	 * This method is a constructor to initialize the instance variables
	 * @param s
	 */
	public ExtendedLetter(String s) {
		super('c'); // super() initializes the variables of the superclass
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * This is an overloaded method that also initializes the instance variables
	 * @param s
	 * @param fam
	 */
	public ExtendedLetter(String s, int fam) {
		super('c'); // super() initializes the variables of the superclass
		content = s;
		related = false;
		family = fam;
	}
	
	/**
	 * This method checks to see if otherObject attributes are equal to thisObjects attributes
	 * @param other
	 */
	public boolean equals(Object other) {
		
		if (((ExtendedLetter)other).family == this.family) {
			this.related = true; // if they are equal, sets this.related to true
		}
		
		if (!(other instanceof ExtendedLetter)) { // if other object is not an instance of the class ExtendedLetter returns false
			return false;
		} else if (((ExtendedLetter)other).content == this.content) { // else if the otherObject's content attribute is equal to this objects attribute, return true
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method outputs a string representation of this ExtendedLetter object
	 */
	public String toString() {
		String decorator = decorator();
		if (this.isUnused() && this.related) { // if isUnused AND related are equal, then returns the following:
			return "." + this.content + ".";
		} else {  // if they don't equal each other, returns the following:
			return decorator + this.content + decorator; 
		}
	}
	/**
	 * This method creates an array letters of Letter objects of the same size as the size of
	the array content received as parameter. 
	 * @param content
	 * @param codes
	 * @return
	 */
	public static Letter[] fromStrings (String[] content, int[] codes) {
		Letter[] letters = new Letter [content. length];
		for (int i = 0; i < content.length; i++) {
			if (codes == null) { // if codes is null then the i-th entry of array letters will store an ExtendedLetter object created with the constructor ExtendedLetter(content[i]).
				letters[i] = new ExtendedLetter (content [1]);
			} else { // else  i-th entry of array letters will store an extendedLetter object created by constructor
				letters[i] = new ExtendedLetter (content [i], codes[i]);
			}
			return letters;
		}
		return letters;
	}
	
}
