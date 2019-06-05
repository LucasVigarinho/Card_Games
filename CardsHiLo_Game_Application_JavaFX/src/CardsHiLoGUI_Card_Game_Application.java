/** 
 * 
 * (a) Create a project called 'CardsHiLoGUI'. Create a main interface for the
 * application similar to that shown in Figure 1. Remember to create a ToggleGroup
 * for the radio buttons and set the ToggleGroup for each button to ensure mutual
 * exclusivity. At application startup, the card images are populated with default
 * cards. Use comments in your code to explain your approach in relation to the GUI
 * construction. 
 * 
 * (b) Add a menu bar and 'File' menu. The 'File' menu should contain the items 'New
 * Game', 'Shuffle' and 'Exit'. Implement these menu items fully. Add a 'Help' menu
 * with an 'About' item to show your student name and number in a dialog.
 * 
 * (c) Create classes for Card and DeckOfCards to help manage the game. The Card
 * class should include methods such as isEqual( ), isLower( ), isHigher( ) and
 * toString( ). The class DeckOfCards should include methods such as
 * dealTopCard( ), isEmpty( ) and shuffle( ). Provide one or more constructors as
 * appropriate for each class.
 * 
 * (d) Implement dealing of each card, determination of a win/lose and user feedback in
 * a label as shown in Figure 1. Store wins and inform the user of an overall game
 * win on achieving 5 consecutive, correct guesses.
 * 
 * (e) Add a progress bar and progress indicator to indicate progress towards 5
 * consecutive wins leading to an overall game win. Provide appropriate feedback on
 * achieving an overall game win. Use a stylesheet to apply an attractive look and
 * feel to the application.
 * 
 * 
 * @author Lucas Maximo 
 * */
//Standard javafx imports.
import java.io.FileNotFoundException;
import javafx.application.Application;
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
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

//import images
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;


/** Create the main class of the game */
public class CardsHiLoGUI_Card_Game_Application {

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

	/** Constructor of the class */ 
	public CardsHiLoGUI_Card_Game_Application() {
		
	

//	/** Create the override init, to initiate the game */
//	@Override
//	public void init() {


		//Instantiating components
		mBar = new MenuBar();
		mnuFile = new Menu("File");
		mnItNewGame = new MenuItem("New Game");
		//creating the action of the new game menu, in the main stage, to make possible utilize the native methods 
				mnItNewGame.setOnAction(ae-> {		
					
					//using the instance of the deck of cards to create the deck of cards 
					doc.deckOfCards();
					//defining which the initial game starts with the cards shuffled 
					doc.shuffle();
					//initiating all the components for a new game
					flag = false;
					progValue = 0;
					rdLower.setSelected(true);
					rdHigher.setDisable(true);
					btnDealFirst.setDisable(false);
					btnDealSecond.setDisable(false);
					progBar.setProgress(progValue);
				
					lblEndGame.setText("  ");
					lblWonLose.setText("  ");
					//defining the default cards for every new game
					card1Def = "file:cards/blue_back.jpg";
					card2Def = "file:cards/blue_back.jpg";
					imgFirst = new Image(card1Def, 180, 250, false, false);
					imgLeft.setImage(imgFirst);
					imgSecond = new Image(card2Def, 180, 250, false, false);
					imgRight.setImage(imgSecond);
				
				
				});//closing the new game action menu
		mnItShuffle = new MenuItem("Shuffle");
		//defining the action of the shuffle menu
		mnItShuffle.setOnAction(ae->{ doc.shuffle();});
		mnItExit = new MenuItem("Exit");
		mnItExit.setOnAction(ae -> Platform.exit());
		mnuHelp = new Menu("Help");
		mnItAbout = new MenuItem("About");
		mnItAbout.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
		//setting action of the about menu
		mnItAbout.setOnAction(ae -> {
			//open try catch statement
			try {
				aboutMenu();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//close the try catch
		});//close the action of the about menu
		
		//creating progress bar components
		lblProgress = new Label("Progress");
		progBar = new ProgressBar(0);
		progIndicator = new ProgressIndicator(0);
		
		//defining progress bar size
		progBar.setMinWidth(200);
		progBar.setMinHeight(35);
		progIndicator.setMinSize(40, 40);
		progIndicator.progressProperty().bind(progBar.progressProperty());

		//Create the menu
		mBar.getMenus().addAll(mnuFile, mnuHelp);
		mnuFile.getItems().addAll(mnItNewGame, mnItShuffle, mnItExit);
		mnuHelp.getItems().add(mnItAbout);

		//Instantiating labels
		lblFirstCard = new Label("First Card Dealt");
		lblSecondCard = new Label("Second Card Dealt"); 
		lblNextCard = new Label("Next card will be");
		lblVictory = new Label("");
		
		//Instantiating  Buttons
		btnDealFirst= new Button("⇦ Deal First Card");
		btnDealSecond = new Button("Deal Second Card ⇨");
		btnDealFirst.setDisable(false);
		btnDealSecond.setDisable(true);
		btnDealFirst.setMinWidth(140);
		btnDealSecond.setMinWidth(140);

		//defining the action of the buttons deal first and deal second
		btnDealFirst.setOnAction(ae-> {
			
			//open the if statement, using the variable flag, 
			//in order to limit the user the moment to press which button
			if(flag == false) {
				
				//change the boolean variable to make the user only can use the second deal button
				flag = true;
				btnDealFirst.setDisable(true);
				btnDealSecond.setDisable(false);
				rdHigher.setDisable(false);
				rdLower.setDisable(false);
				//Clean the text field which interact with user, every time the user play again
				lblWonLose.setText("");

				//open an if statement in order to check if the deck of cards is empty,
				//and interact through a message with the user
				if(doc.isEmpty()) {
				
					//set the new message to the user start a new game 
					lblEndGame.setText("Start a new game!");
				
				//open an else in case of the deck of card were not empty
				}else {
					//using the card variable to absorb the card which of pushed from the deck of cards,
					//to be used in the comparisons with the action of the button deal second 
					card1 = doc.dealTopCard();
					
					//instantiating a new image using the card absorbed above and changing it to a string 
					//using the tostring() method from the card class, in order to localize the correct file
					//on the directory 
					imgFirst = new Image(card1.toString(), 180, 250, false, false);
					
					//settign the new image on the image view variable on the left of the user
					imgLeft.setImage(imgFirst);
				}//closing if statement of the empty test
				
			}//close the if statement of the flag test	
		});//closing the button deal first action
		btnDealSecond.setOnAction(ae-> {

			//open the if statement, using the variable flag, 
			//in order to limit the user the moment to press which button
			if(flag == true) {
				
				//change the boolean variable to make the user only can use the second deal button
				flag = false;
				btnDealFirst.setDisable(false);
				btnDealSecond.setDisable(true);
				rdHigher.setDisable(true);
				rdLower.setDisable(true);
				
				//open an if statement in order to check if the deck of cards is empty,
				//and interact through a message with the user
				if(doc.isEmpty()) {
					
					//set the new message to the user indicating that the game is over
					lblEndGame.setText("GAME OVER!");
					lblVictory.setText("");
				//open an else in case of the deck of card were not empty
				}else {
					
					//using the card variable to absorb the card which of pushed from the deck of cards,
					//to be used in the follow comparisons 
					card2 = doc.dealTopCard();
					
					//instantiating a new image using the card absorbed above and changing it to a string 
					//using the tostring() method from the card class, in order to localize the correct file
					//on the directory 
					imgSecond = new Image(card2.toString(), 180, 250, false, false);
					
					//settign the new image on the image view variable on the right of the user
					imgRight.setImage(imgSecond);
					
					//open the if statement in order to compare the cards whether were greater 
					if(card1.rankIsGreaterThan(card2) && rdHigher.isSelected()) {
						
						//Get the current progress.
						progValue = progBar.getProgress();
						
						//increase the value of the variable to be used on the progressive bar
						progValue = progValue + 0.2;
						
						//Set the new increased progress.
						progBar.setProgress(progValue);
						
					
						//interact with the user in case of the correct guess greater 
						lblWonLose.setText("Greater! You win!");
						lblVictory.setText("");
						
					//open the else if statement to compare whether the user guess lower but was greater	
					}else if(card1.rankIsGreaterThan(card2) && rdLower.isSelected()) {
						
						//make the variable which is used to control the progressive bar goes to zero, for the mistake
						progValue = 0;
						
						//set the new value, in this case zero
						progBar.setProgress(progValue);
						
					
						
						//interact with the user through the message, clarifying the mistake 
						lblWonLose.setText("Greater! You loose!");
						lblVictory.setText("");
						
					}//closing the if statement of the test if is greatear
					
					//open the if statement in order to compare the cards whether were lower 
					if(card1.rankIsLessThan(card2) && rdLower.isSelected()) {

						//Get the current progress.
						progValue = progBar.getProgress();
						
						//increase the value of the variable to be used on the progressive bar
						progValue = progValue + 0.2;

						//Set the new increased progress.
						progBar.setProgress(progValue);
						
						
						
						//interact with the user in case of the correct guess lower 
						lblWonLose.setText("Lower! You win!");
						lblVictory.setText("");
					//open the else if statement to compare whether the user guess greater but was lower
					}else if(card1.rankIsLessThan(card2) && rdHigher.isSelected()) { 

						//make the variable which is used to control the progressive bar goes to zero, for the mistake
						progValue = 0;
						
						//set the new value, in this case zero
						progBar.setProgress(progValue);
						
						
						
						//interact with the user through the message,  clarifying the mistake 
						lblWonLose.setText("Lower! You loose!");
						lblVictory.setText("");
						
					//open the if statement in order to compare the cards whether were equals 
					}else if (card1.rankIsEqualTo(card2)){

						//make the variable which is used to control the progressive bar goes to zero, 
						progValue = 0;
						
						//set the new value, in this case zero
						progBar.setProgress(progValue);
						
						//also set the new value to the indicator
						
						
						//interact with the user through the message,  clarifying the mistake 
						lblWonLose.setText("OPS! Draw! You loose!");
						lblVictory.setText("");

					}//closing the if statement of the equals, greater or lower, tests.
					
				}//closing if statement of the empty test
				
				//Open the if statement in order to interact with the user when the user reach the 5 correct guesses consecutive.
				if(progValue == 1) {
					
					//setting the message of the victory
					lblWonLose.setText("CONGRATULATIONS!");
					lblVictory.setText("5 CONSECUTIVE!");
					
				}//close the consecutive 5 if statement
			
				//Open the if statement in order to interact with the user when the user reach the 5 correct guesses consecutive.
				if(progValue == 2) {
					
					//setting the message of the victory
					lblWonLose.setText("CONGRATULATIONS!");
					lblVictory.setText(" 10 CONSECUTIVE!");
					
				}//close the consecutive 5 if statement
			}//close the if statement of the flag test	
			
		});//closing the button deal second action
		
		
		//Instantiating radio box
		rdHigher = new RadioButton("Higher");
		rdLower = new RadioButton("Lower");
		rdLower.setSelected(true);
		rdHigher.setDisable(true);
		rdLower.setDisable(true);

		//Instantiating toggle group
		tgRadio = new ToggleGroup();
		rdHigher.setToggleGroup(tgRadio);
		rdLower.setToggleGroup(tgRadio);
		
		//defining the default cards for every new game
		card1Def= "file:cards/blue_back.jpg";
		card2Def  = "file:cards/blue_back.jpg";

		//Instantiating text Field, used to interact to the user
		lblWonLose = new Label("");
		lblEndGame = new Label("");
		
		//Instantiating images
		imgLeft = new ImageView();
		imgRight = new ImageView();

	}//close constructor 
	
//	}//Close init()

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

		Stage stageHiloStage = new Stage();
		//using the instance of the deck of cards to create the deck of cards 
		doc.deckOfCards();
		//defining which the initial game starts with the cards shuffled 
		doc.shuffle();
		
		//Create the main layout of the main interface
		stageHiloStage.setWidth(700);
		stageHiloStage.setHeight(500);

		//Set title of the BOX
		stageHiloStage.setTitle("Hi-Lo Card Game");

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
		stageHiloStage.setScene(s);

		//Show the Stage 
		stageHiloStage.show();

	}//Close start of mainStage

//	/** Creating the main method to run the application */
//	public static void main(String[] args) {
//
//		//Initiating launching program
//		launch();
//
//	}//close the main method

}//close the class
