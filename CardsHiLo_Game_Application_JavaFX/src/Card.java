/** 
 * 
 *  * (c) Create classes for Card and DeckOfCards to help manage the game. The Card
 * class should include methods such as isEqual( ), isLower( ), isHigher( ) and
 * toString( ). The class DeckOfCards should include methods such as
 * dealTopCard( ), isEmpty( ) and shuffle( ). Provide one or more constructors as
 * appropriate for each class.
 * 
 * @author Lucas Maximo 
 *  
 * */


/** Creating the card class */
public class Card {

	//defining the attributes of this object
	public int rank;
	public int suit;

	/** creating a constructor to this object */
	public Card(int r, int s) {
		rank = r;
		suit = s;

	}//closing the card constructor 

	/** creating the get Rank  method*/
	public int getRank() {
		
		//return statement with the data in the rank variable 
		return this.rank;
	
	}//closing the getRank() method
	
	/** creating the get Suit method*/
	public int getSuit() {
		
		//return statement with the data in the suit variable 
		return this.suit;
		
	}//closing the getSuit() method

	/** creating the boolean method to test if the object is less than */
	public boolean rankIsLessThan(Card c) {
		
		//defining the boolean variable as false
		boolean rankIsLess = false;

		//creating the if statement to be change the local boolean variable in a positive case
		if(rank > c.getRank()) {
			
			//changing the local boolean variable
			rankIsLess = true;

		}//if statement
		
		//return statement to return the value if positive or not
		return rankIsLess;
		
	}//rank Is Less Than()

	/** creating the boolean method to test if the object is Greater than */
	public boolean rankIsGreaterThan(Card c) {
		
		//defining the boolean variable as false
		boolean rankIsGreater = false;

		//creating the if statement to be change the local boolean variable in a positive case
		if(rank < c.getRank()) {
			
			//changing the local boolean variable
			rankIsGreater = true;

		}//if statement
		
		//return statement to return the value if positive or not
		return rankIsGreater;
		
	}//rank Is Less Than()

	/** creating the boolean method to test if the object is equal than */
	public boolean rankIsEqualTo(Card c) {
		
		//defining the boolean variable as false
		boolean rankIsEqualTo = false;

		//creating the if statement to be change the local boolean variable in a positive case
		if(rank == c.getRank()) {
			
			//changing the local boolean variable
			rankIsEqualTo = true;
			
		}//if statement
		
		//return statement to return the value if positive or not
		return rankIsEqualTo;
		
	}//close rankIsEqualTo()
	
	/** Creating the String method to return the String of the object Card*/
	public String toString() {

		//Creating the local variables to  be used in the method
		String cardSuit = "";
		String cardRank = "";
		String cardString = "";

		//utilizing the getters methods to absorb the data in the local variables for rank and suit
		int cs = getSuit();
		int cr = getRank();

		//creating the switch statement to define the string for each rank
		//Got a string representation of the rank.
		switch(cr) {
		case 1:
			cardRank = "ace";
			break;
		case 2:
			cardRank = "2";
			break;
		case 3:
			cardRank = "3";
			break;
		case 4:
			cardRank = "4";
			break;
		case 5: 
			cardRank = "5";
			break;
		case 6:
			cardRank = "6";
			break;
		case 7:
			cardRank = "7";
			break;
		case 8:
			cardRank = "8";
			break;
		case 9:
			cardRank = "9";
			break;
		case 10:
			cardRank = "10";
			break;
		case 11:
			cardRank = "jack";
			break;
		case 12:
			cardRank = "queen";
			break;
		case 13:
			cardRank = "king";
			break;
		default:
			cardRank = "n/a";

		}//switch rank

		
		//Now get a string representation of the suit.

		switch(cs) {
		case 0:
			cardSuit = "hearts";
			break;
		case 1:
			cardSuit = "diamonds";
			break;
		case 2: 
			cardSuit = "clubs";
			break;
		case 3: 
			cardSuit = "spades";
			break;
		default:
			cardSuit = "n/a";

		}//switch card suit.

		//defining the string which is going to be returned 
		cardString = "file:cards/" + cardRank + "_of_" + cardSuit + ".png";
		
		return cardString ;

	}//toString()
	
}//close the Card class 
