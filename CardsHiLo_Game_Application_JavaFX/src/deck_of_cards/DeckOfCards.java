package deck_of_cards;
/**
 * 
 * The class DeckOfCards should include methods such as
 * 				dealTopCard( ), 
 * 					isEmpty( ) 
 * 			 	and shuffle( ).
 * Provide one or more constructors as appropriate for each class.
 * 
 * @author Lucas Maximo 
 * 
 *  */

//importing the necessary libraries
import java.util.Collections;
import java.util.Stack;

/** Creating  the deck of cards class */
public class DeckOfCards {

	/** Create the stack list of the card */
	Stack<Card> deckCards = new Stack<>();

	/** Create the method to populate the deckCards stack created above*/
	public void deckOfCards() {			
		
			//creating the for loop to define the rank 1 to 13
			for (int j = 1; j <= 13; j++){
				
				//creating the nested for loop to define the suit 0 to 3
				for(int k = 0; k <= 3; k++) {			
					
					//inserting one card element into the deckCards in every loop, 
					//using the j as rank and K as suit
					deckCards.push(new Card (j, k));	
					
				}//close for loop of suit
				
			}//close for loop of rank
			
		}//close populate method deckOf Cards	
	
	/** Create the deal top card method */
	public Card dealTopCard() {
		
		//the return statement is the card took off from the stack
		return deckCards.pop();
		
	}//close method deal top card
	
	/** Create the is Empty method */
	public boolean isEmpty() {
		
		//crating a if statement to check if the deck cards is empty, using the native method of the stack
		if (deckCards.isEmpty()) {
			
			//return statement with the answer whether positive 
			return true;
			
		//if statement whether the deckCards were not empty
		}else {
			
			//return statement with the answer whether negative 
			return false;
			
		}//close if statement
		
	}//close method is Empty

	/** Create the method for shuffle */
	public void shuffle() {
		
		//utilizing the shuffle method native of the stack collections, defining the deckCards as a collection
		Collections.shuffle(deckCards);
		
	}//close the shuffle method
	
}//close deck of cards
