/**
 * @author jeremyro
 * This class represents a word made up of letter objects stored in linear nodes that are connected together 
 * by a linked list.
 */
public class Word {
	
	private LinearNode<Letter> firstLetter;
	private LinearNode<Letter> newNode;
	
	/**
	 * This method is a constructor that initializes the Word object so the Letter objects in array “letters” are stored within its
	 * linked structure.
	 * @param letters
	 */
	public Word(Letter[] letters) {
		
		if (letters.length == 0) { // if there is no word, create a linearNode with element null
			firstLetter = new LinearNode<Letter>(null);
		} else {
			firstLetter = new LinearNode<Letter>(letters[0]); // else starts the linked list by creating a new node containing the first character of the word as the node's element
			LinearNode<Letter> currentNode = firstLetter; // set current nodes pointer to firstLetter
			
			for (int i = 1; i < letters.length; i++) { // iterates through each character in letters array and stores it into a new node to connect to the end of the linked list
				if (letters[i] != null) {
					LinearNode<Letter> newNode = new LinearNode<>(letters[i]); // new node is created with ith element in letters array
					currentNode.setNext(newNode); // sets current nodes pointer to the new node we just created
					currentNode = currentNode.getNext(); // sets current node to current node next so that we can continue "appending" to the end of the linked list
				} else {
					newNode = new LinearNode<>(null);
					currentNode.setNext(newNode);
				}
			}
		}
	}
	
	/**
	 * This toString method outputs the each element from the word linked list that we created using the word constructor
	 */
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder("Word: ");
		LinearNode<Letter> currentNode = firstLetter;

		while (currentNode != null) { // while we having reached the end of linked list
		    Letter letter = currentNode.getElement(); // Access the data stored in the current node
		    stringBuilder.append(letter.toString());
		    stringBuilder.append(" ");
		    currentNode = currentNode.getNext(); // Get next node
		}
		
		return stringBuilder.toString(); // .trim() ?
	}
	

	/**
	 * This labelWord class is used to compare the inputted user guess word and the mystery word and update the status of each letter accordingly
	 * Ex. if guessed letter was equal to the position and letter that the guessed letter was in, this method would update the guessed letter to be "!A!", where A is the correct letter
	 * @param mystery
	 * @return
	 */
    public boolean labelWord(Word mystery){ 
        int numIterator = 0; // used as an iterator to keep track of the # of times we loop through
        String mysteryWord = mystery.toString(); // applied toString method to mystery word to convert it into a string so that the characters would be easier to access and store in an array

        Letter[] arrayLetters = new Letter[(mysteryWord.length() - 6) / 4]; // created a new arrayLetter array with the length of letters in the word. 
        for (int i = 6; i < mysteryWord.length(); i = i + 4) { // Mathematical operations performed to take into account the extra characters "Word: " outputted as a result of using .toString().
            arrayLetters[(i - 6) / 4] = new Letter(mysteryWord.charAt(i + 1)); // iterating through each character in mystery word and storing it in the appropriate index in arrayLetters
        }
        LinearNode<Letter> currentNode = firstLetter; // current node now points to firstLetter
        
        while(currentNode != null){ // while we haven't reached the end of the word linked list:
            boolean used = false; // set used to false so that we have a condition to set our different status to each character
            for(int i = 0; i < arrayLetters.length; i++){ // iterates through each node in linked list
                if(arrayLetters[i].equals(currentNode.getElement())){ // if the character at ith index matches the letter object in current node: 
                    currentNode.getElement().setUsed(); // get the element of current node and change status to used
                    used = true;
                }
            }
            if(used == false){ // if used is still false, currentNode element is set to unused
                currentNode.getElement().setUnused();
            }
            currentNode = currentNode.getNext(); // iterates to the next node
        }

        currentNode = firstLetter;
        boolean identical = true;
        while(currentNode != null && numIterator < arrayLetters.length){ // while we haven't reached the end of the linked list and the iterator is smaller than the length of arrayLetters:

            if(currentNode.getElement().equals(arrayLetters[numIterator])){ // if the currentNodes element is exactly equal to the character in arrayLetter:
                currentNode.getElement().setCorrect(); // sets this element to correct
            }
            else{
                identical = false;
            }
            currentNode = currentNode.getNext(); // iterates to next node
            numIterator++; // adjusts iterator #
        }

        if(currentNode == null && numIterator == arrayLetters.length && identical == true){ // if all of these conditions are true, then return true
            return true;
        }

        return false;
    }
    
}
	

/**
 * Below I attempted to use a different implementation of labelWord. I attempted to iterate through each node in the word linked list and create a new linked list that
 * held each letter of the mystery word. I would then use while loops to iterate through each node in each linked list simultaneously and compare them and adjust there status accordingly.
 * Unfortunately I ran out of time and couldbn't properly code this implementation, hence why I used a hardcoded version instead.
 */

//	public boolean labelWord(Word mystery) {
//		
//		LinearNode<Letter> currentNode = firstLetter;
//		String mysteryString = mystery.toString();
//		
//		Letter[] mysteryArray = new Letter[mysteryString.length()];
//        for (int i = 0; i < mysteryString.length(); i++) {
//            mysteryArray[i] = new Letter(mysteryString.charAt(i));
//        }
//        
//		boolean identical = true;
//		
//		while (currentNode != null) {
//			boolean used = false;
//            for(int i = 0; i < mysteryArray.length; i++){
//                if (mysteryArray[i] == currentNode.getElement()) {
//                	Letter tempLetter = currentNode.getElement();
//                	tempLetter.setUsed();
//                    used = true;
//                }
//            }
//            if (used == false) {
//                Letter tempElement = currentNode.getElement();
//                tempElement.setUnused();
//            }
//            currentNode = currentNode.getNext();
//		}
//		
//		int while = 0;
//        boolean correct = true;
//        while (currentNode != null && count < mysteryArray.length) {
//
//            if (currentNode.getElement().equals(mysteryArray[count])) {
//                currentNode.getElement().setCorrect();
//            } else {
//                correct = false;
//            }
//            currentNode = currentNode.getNext();
//            count++;
//        }
//
//        if (currentNode == null && count == mysteryArray.length && correct == true) {
//            return true;
//        }
//
//        return false;
//    }
//		
//			
//			
//			
//			Letter currentLetter = currentNode.getElement ();
//			Letter mysteryLetter = mysteryCurrentNode.getElement ();
//			
//			if (currentLetter == mysteryLetter) {
//				currentLetter.setCorrect();
//			} else if (mystery.containsLetter(currentLetter)) {
//				currentLetter.setUsed();
//			} else {
//				currentLetter.setUnused();
//				identical = false;
//			}
//			
//			currentNode = currentNode.getNext();
//			mysteryCurrentNode = mysteryCurrentNode. getNext ();
//		}
//		
//		return identical;
//	}
//	
//	
//	private boolean containsLetter(Letter letter) {
//		
//		LinearNode<Letter> current = firstLetter;
//		
//		while (current != null) {
//			
//			if (current.getElement().equals(letter)) {
//				return true;
//			}
//			
//		current = current.getNext ();
//		
//		}
//		
//		return false;
//		
//	}
//	
//}

