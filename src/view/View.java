package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View {
	public static final double HEIGHT = 720, WIDTH = 1080;
	private Stage window;
	private Scene sceneMain;
	private BorderPane bpMain;
	private Group root;

	public View(Stage primaryStage) {
		// set the stage
		window = primaryStage;

		// defining all the global variables that need access in other functions for
		// sending and receiving data to the model through the controller
		defineGlobal();

		// building all the scenes
		buildAllScenes();

		// starting the program on the first scene
		window.setScene(sceneMain);
		window.setTitle("ROK bot");
		window.show();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// functions for defining all the global variables
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void defineGlobal() {
		root = new Group();

		defineGlobalMain();
	}

	private void buildAllScenes() {
		main();
	}

	private void defineGlobalMain() {

	}

	// Scene: main menu
	private void main() {
		// The title of the scene
		Label title = new Label("ROK stats bot");
		title.setFont(new Font(35));
		title.setTextFill(Color.DARKBLUE);

		// Final box
		VBox vCenter = new VBox();
		vCenter.getChildren().addAll();

		// Defining all the panes
		StackPane spTop = new StackPane();
		Pane pCenter = new Pane();

		// Attaching all the view tools to the panes
		spTop.getChildren().add(title);
		pCenter.getChildren().addAll(root, vCenter);

		// Defining the main pane of the scene and attaching all the side pane to it.
		bpMain = new BorderPane();
		bpMain.setTop(spTop);
		bpMain.setCenter(pCenter);

		// creating the scene
		sceneMain = new Scene(bpMain, WIDTH, HEIGHT);
	}
}
