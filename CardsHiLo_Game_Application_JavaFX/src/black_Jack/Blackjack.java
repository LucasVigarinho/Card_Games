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

	/** Creating the about menu with the file not found exception for using image */
	public  void aboutMenu() throws FileNotFoundException {

		//Creating the about menu layout
		Stage aboutMenu = new Stage();
		VBox vbAboutMn = new VBox();
		GridPane gpA = new GridPane();
		
		
		//defining measures to about menu
		aboutMenu.setWidth(572);
		aboutMenu.setHeight(180);

		//defining the title of the about menu 
		aboutMenu.setTitle("About");

		//defining the components and the data of the components 
		imgVLucas = new ImageView(imgLucas);
		lblAbout = new Label(" HiLo is a card game where a card is dealt and the player \n" +
				" has to guess whether the next card that is dealt will be \n" + 
				" higher or lower than the first card."+ 
				"\n \n Created by: \n              Lucas Maximo  \n" +
				"              \n " + 
				"             CardsHiLoGUI_Card_Game_Application");
		lblLucas = new Label("");
		imgLucas = new Image("file:cards/black_joker.png", 220, 170, true, true);
		imgVLucas.setImage(imgLucas);

		//defining layout of the menu about
		vbAboutMn.getChildren().add(gpA);
		gpA.add(lblAbout, 1, 1);
		gpA.add(lblLucas, 1, 1);
		gpA.add(imgVLucas, 3, 1);

		//defining about menu squema
		aboutMenu.setAlwaysOnTop(true);
		aboutMenu.setResizable(false);
		aboutMenu.setMaximized(false);
	

		//creating the scene of the about menu
		Scene ab = new Scene (vbAboutMn);

		//setting the scene of the about menu
		aboutMenu.setScene(ab);

		//creating the show to about menu
		aboutMenu.show();
	
	}//closing the about menu method
	
	/** Creating the start method with the main stage, using throw exception */
//	@Override
//	public void start(Stage stageHiloStage) throws Exception {
	public void start() throws Exception {

		Stage stageBlackJack= new Stage();
		//using the instance of the deck of cards to create the deck of cards 
		doc.deckOfCards();
		//defining which the initial game starts with the cards shuffled 
		doc.shuffle();
		
		//Create the main layout of the main interface
		stageBlackJack.setWidth(700);
		stageBlackJack.setHeight(500);

		//Set title of the BOX
		stageBlackJack.setTitle("Hi-Lo Card Game");

		//Creating the containers and components to the layout of the main stage
		VBox vbLeft = new VBox();
		VBox vbImgLeft = new VBox();
		VBox vbCenterR = new VBox();
		VBox vbCenterB = new VBox();
		VBox vbRight = new VBox();
		VBox vbImgRight = new VBox();
		VBox vbMain = new VBox();
		VBox vbCenter = new VBox();

		//Create a layout / organizing containers in the Border Pane, with the components.
		GridPane gp = new GridPane();

		
		//Defining the default images to the main stage
		imgFirst = new Image(card1Def, 180, 250, false, false);
		imgLeft.setImage(imgFirst);
		imgSecond = new Image(card2Def ,180, 250, false, false);
		imgRight.setImage(imgSecond);

		//Populating the containers with the components
		vbMain.getChildren().add(mBar);
		vbMain.getChildren().add(gp);
		vbImgLeft.getChildren().add(imgLeft);
		vbLeft.getChildren().addAll(lblFirstCard, vbImgLeft);
		vbImgRight.getChildren().add(imgRight);
		vbRight.getChildren().addAll(lblSecondCard, vbImgRight);
		vbCenterR.getChildren().addAll(lblNextCard, rdHigher, rdLower);
		vbCenterB.getChildren().addAll(btnDealFirst, btnDealSecond);
		vbCenter.getChildren().addAll(vbCenterR, vbCenterB);


		/** ADD components, labels and texts field in the Grid Pane, 
		*   and also the vertical boxes 
		*/
		gp.add(vbLeft, 1, 1);
		gp.add(vbCenter, 3, 1);
		gp.add(vbRight, 6, 1 );
		gp.add(lblWonLose, 6, 5);
		gp.add(lblVictory, 6, 6);
		gp.add(progBar, 3, 5);
		gp.add(progIndicator, 4, 5);
		gp.add(lblEndGame, 3, 6);

		
		//Beautification... 
				
		//positioning the aligment of the vertical box in the center
		vbCenter.setAlignment(Pos.CENTER);

		//Set padding and gaps
		gp.setPadding(new Insets(10));
		gp.setHgap(10);
		gp.setVgap(10);

		//Giving spaces between child in the boxes inside the VBleft, VBright, VBCenter, centerR and B.
		vbLeft.setSpacing(20);
		vbRight.setSpacing(20);
		vbCenter.setPadding(new Insets(10));
		vbCenter.setSpacing(5);
		vbCenterR.setPadding(new Insets(20));
		vbCenterR.setSpacing(10);
		vbCenterB.setPadding(new Insets(20));
		vbCenterB.setSpacing(10);



		//Create the Scene
		Scene s = new Scene(vbMain);

		//Identifying style sheet
		s.getStylesheets().add("cardsHiLoGUI_Main.css");

		
		

		//Setting the Scene
		stageBlackJack.setScene(s);

		//Show the Stage 
		stageBlackJack.show();

	}//Close start of mainStage

	
}
