//import javafx imports.
import java.io.FileNotFoundException;

import hilo_game.CardsHiLoGUI_Card_Game_Application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import layout
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

//import visual components
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import images
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;


/** **/
public class Main_Stage_Game extends Application {

	/** Instantiating HiloCards game */
	CardsHiLoGUI_Card_Game_Application hiLoGUI = new CardsHiLoGUI_Card_Game_Application();

	/** Instantiating BlackJack game */
	
	//Creating the Buttons
	Button btn_HiLoGUI_Game, btn_Blackjack_Game;
	
	//Creating the menu
		/** (b) Add a menu bar and 'File' menu. The 'File' menu should contain the items 'New
		 * Game', 'Shuffle' and 'Exit'. Implement these menu items fully. Add a 'Help' menu
		 * with an 'About' item to show your student name and number in a dialog. */
		MenuBar mBar;
		Menu mnuFile, mnuHelp;
		MenuItem mnItNewGame, mnItShuffle, mnItExit, mnItAbout;
	
	
	/** Creating the constructor for the games **/
	public Main_Stage_Game() {
		
	}//closing constructor
	
	/** Create the override init, to initiate the game **/
	@SuppressWarnings("static-access")
	@Override
	public void init() {
		
		//creating the button component
		btn_HiLoGUI_Game = new Button("HiLoGame");
		btn_HiLoGUI_Game.setOnAction(ae-> {
			try {
				hiLoGUI.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		btn_Blackjack_Game = new Button("BlackJack");
		btn_Blackjack_Game.setOnAction(ae-> {
			try {
				Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
				dialogBox.setTitle("Black Jack - Card Games");
				dialogBox.setHeaderText("Game in construction!");
				dialogBox.setContentText("Thank you!");
				dialogBox.showAndWait();
				
//				blackJack.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//Instantiating components
				mBar = new MenuBar();
				mnuFile = new Menu("File");		
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
				
		
	}//closing the init

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
		imgVBlackJack = new ImageView(imgVBlack);
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



	@Override
	public void start(Stage mainStage) throws Exception {
		
		
		//Create the main layout of the main interface
		mainStage.setWidth(800);
		mainStage.setHeight(500);

		//Set title of the BOX
		mainStage.setTitle("Card_Games");

		//Creating the containers and components to the layout of the main stage
		VBox vbMain = new VBox();

		//Create a layout / organizing containers in the Border Pane, with the components.
		GridPane gp = new GridPane();

		

		//Populating the containers with the components
		vbMain.getChildren().add(gp);


		/** ADD components, labels and texts field in the Grid Pane, 
		*   and also the vertical boxes 
		*/
		gp.add(btn_HiLoGUI_Game, 1, 1);
		gp.add(btn_Blackjack_Game, 3, 1);
		btn_HiLoGUI_Game.setMinWidth(300);
		btn_HiLoGUI_Game.setMinHeight(100);
		btn_Blackjack_Game.setMinWidth(300);
		btn_Blackjack_Game.setMinHeight(100);
		
		//Beautification... 
		btn_HiLoGUI_Game.setStyle("-fx-Background-color: yellow;");
		vbMain.setStyle("-fx-Background-color: gray;");

		//positioning the aligment of the vertical box in the center


		//Set padding and gaps
		gp.setPadding(new Insets(10));
		gp.setHgap(10);
		gp.setVgap(10);

		//Giving spaces between child in the boxes inside the VBleft, VBright, VBCenter, centerR and B.




		//Create the Scene
		Scene s = new Scene(vbMain);

		//Identifying style sheet
		s.getStylesheets().add("cardsHiLoGUI_Main.css");

		
		

		//Setting the Scene
		mainStage.setScene(s);

		//Show the Stage 
		mainStage.show();

		
	}//closing the start method
	
	/** Creating the main method **/
	public static void main(String[] args) {
		
		launch();

		
	}//closing the main method

}//closing the main class
