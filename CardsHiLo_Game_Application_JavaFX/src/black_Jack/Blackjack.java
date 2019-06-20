package black_Jack;
import deck_of_cards.DeckOfCards;
import deck_of_cards.Card;

import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;

//import layout
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

//Import visual components
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
//import images
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;

import java.io.FileNotFoundException;

/** Create the class of the game Black Jack */
public class Blackjack {
	
	/** instantiating Deck of Cards to be accessed */
	DeckOfCards doc = new DeckOfCards();
	


	//Creating the menu
	/** (b) Add a menu bar and 'File' menu. The 'File' menu should contain the items 'New
	 * Game', 'Shuffle' and 'Exit'. Implement these menu items fully. Add a 'Help' menu
	 * with an 'About' item to show your student name and number in a dialog. */
	MenuBar mBar;
	Menu mnuFile, mnuHelp;
	MenuItem mnItNewGame, mnItShuffle, mnItExit, mnItAbout;

	//Create labels
	Label lblFirstCard, lblSecondCard, lblNextCard, lblWonLose, lblEndGame, lblVictory;

	//Create the Buttons
	Button btnDealFirst, btnDealSecond;

	//Create the toggle group
	/** Remember to create a ToggleGroup
	 * for the radio buttons and set the ToggleGroup for each button to ensure mutual
	 * exclusivity.*/
	ToggleGroup tgRadio;
	
	//Create the radio box
	RadioButton rdHigher, rdLower;


	//Create the image sets, to insert the images
	Image imgFirst, imgSecond;

	//Create the space to show the image
	ImageView imgLeft, imgRight;

	//Creating variables to the about menu
	Label lblLucas, lblAbout;
	Image imgLucas;
	ImageView imgVLucas;

	//Creatign progress bar
	Label lblProgress;
	ProgressBar progBar;
	ProgressIndicator progIndicator;

	//Creating the variables to present the default images of the new game, 
	//showing back of the cards when its game is initiating
	String card1Def, card2Def;
	
	//create the cards variables to manipulate the cards absorbed from the deck of cards
	Card card1 = null;
	Card card2 = null;
	
	//creating the variable to control the button access of the deal first and second cards
	boolean flag = false;

	//creating the variable to control the progress bar
	double progValue;

	public Blackjack() {
		
		/** To define structure of the BlackJack Game */
	}

}
