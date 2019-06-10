//import javafx imports.
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
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;

//import images
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




/** **/
public class Main_Stage_Game extends Application {

	/** Instantiating HiloCards game */
	CardsHiLoGUI_Card_Game_Application hiLoGUI = new CardsHiLoGUI_Card_Game_Application();
	
	
	//Creating the Buttons
	Button btn_HiLoGUI_Game, btn_Blackjack_Game;
	
	
	
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
//				blackJack.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}//closing the init

	



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
