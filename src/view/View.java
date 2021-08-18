package view;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.User;

public class View implements GatheringData_View, PopUps_View {
	public static final double HEIGHT = 720, WIDTH = 1080;
	private Stage window;
	private Scene sceneMain, sceneGatherData;
	private BorderPane bpMain, bpGatherData;
	private RadioButton rbFullStats, rbPowerOnly, rb1, rb2, rb3, rb4;
	private ToggleGroup tgGatherType, tgBuleStacks;
	private TextField tfKingdomNumber;
	private Label lbKingdomNumber;
	Button btSetKingdom;
	private Group root;

	public View(Stage primaryStage) {
		// set the stage
		window = primaryStage;
		window.setResizable(false);

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

	private void defineGlobal() {
		root = new Group();
		defineGlobalGatherData();
	}

	private void buildAllScenes() {
		buildSceneMain();
		buildSceneGatheringData();
	}

	private void buildSceneMain() {
		// The title of the scene
		Label title = new Label("Main Menu");
		title.setFont(new Font(35));
		title.setTextFill(Color.DARKBLUE);

		Button btGatherData;
		btGatherData = new Button("Gather Data");
		btGatherData.setPrefSize(600, 45);
		btGatherData.setFont(new Font(16));

		btGatherData.setOnAction((event) -> {
			showGatherDataScene();
		});

		// Final box
		VBox vCenter = new VBox();
		vCenter.getChildren().addAll(btGatherData);
		VBox.setMargin(btGatherData, new Insets(20, 100, 0, 250));

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

	public void showMainMenuScene() {
		window.setScene(sceneMain);
	}

	@Override
	public void defineGlobalGatherData() {
		tgGatherType = new ToggleGroup();
		tgBuleStacks = new ToggleGroup();
		rbFullStats = new RadioButton("Full Stats");
		rbFullStats.setFont(new Font(22));
		rbFullStats.setToggleGroup(tgGatherType);
		rbPowerOnly = new RadioButton("Power Only");
		rbPowerOnly.setFont(new Font(22));
		rbPowerOnly.setToggleGroup(tgGatherType);
		rb1 = new RadioButton("BlueStacks1");
		rb1.setFont(new Font(22));
		rb1.setToggleGroup(tgBuleStacks);
		rb2 = new RadioButton("BlueStacks2");
		rb2.setFont(new Font(22));
		rb2.setToggleGroup(tgBuleStacks);
		rb3 = new RadioButton("BlueStacks3");
		rb3.setFont(new Font(22));
		rb3.setToggleGroup(tgBuleStacks);
		rb4 = new RadioButton("BlueStacks4");
		rb4.setFont(new Font(22));
		rb4.setToggleGroup(tgBuleStacks);
		tfKingdomNumber = new TextField();
		tfKingdomNumber.setPromptText("ex: 1001");
		tfKingdomNumber.setPrefSize(350, 40);
		tfKingdomNumber.setFont(new Font(20));
		tfKingdomNumber.getText();
		lbKingdomNumber = new Label("0");
		lbKingdomNumber.setFont(new Font(32));
		lbKingdomNumber.setTextFill(Color.DARKCYAN);
		btSetKingdom = new Button("Set Kingdom");
		btSetKingdom.setPrefSize(150, 45);
		btSetKingdom.setFont(new Font(16));
	}

	@Override
	public void buildSceneGatheringData() {
		// The title of the scene
		Label title = new Label("Data Gathering");
		title.setFont(new Font(35));
		title.setTextFill(Color.DARKBLUE);

		// show the current kingdom selected
		HBox hCurrentKingdom = new HBox();
		Label lbCurrentKingdom = new Label("Current Selected kingdom: ");
		lbCurrentKingdom.setFont(new Font(32));
		lbCurrentKingdom.setTextFill(Color.DARKCYAN);
		hCurrentKingdom.getChildren().addAll(lbCurrentKingdom, lbKingdomNumber);

		// 1) choose kingdom
		Label lKingdom = new Label("1) Choose the kingdom:");
		lKingdom.setFont(new Font(20));
		lKingdom.setTextFill(Color.CADETBLUE);
		HBox hKingdom = new HBox();
		hKingdom.getChildren().addAll(tfKingdomNumber, btSetKingdom);
		VBox vKingdom = new VBox();
		vKingdom.getChildren().addAll(lKingdom, hKingdom);

		// 2) gathering type
		Label lType = new Label("2) select the type of gathering you want:");
		lType.setFont(new Font(20));
		lType.setTextFill(Color.CADETBLUE);
		HBox hType = new HBox();
		hType.getChildren().addAll(rbFullStats, rbPowerOnly);
		rbFullStats.setSelected(true);
		VBox vType = new VBox();
		vType.getChildren().addAll(lType, hType);

		// 3) game window name
		Label lWindowName = new Label("3) select the name of the BlueStacks window:");
		lWindowName.setFont(new Font(20));
		lWindowName.setTextFill(Color.CADETBLUE);
		HBox hWindowName = new HBox();
		hWindowName.getChildren().addAll(rb1, rb2, rb3, rb4);
		rb2.setSelected(true);
		VBox vWindowName = new VBox();
		vWindowName.getChildren().addAll(lWindowName, hWindowName);

		// back to main menu
		Button btMainMenu;
		btMainMenu = new Button("Main Menu");
		btMainMenu.setPrefSize(150, 45);
		btMainMenu.setFont(new Font(16));
		btMainMenu.setOnAction((event) -> {
			showMainMenuScene();
		});

		// Final box
		VBox vCenter = new VBox();
		vCenter.getChildren().addAll(hCurrentKingdom, vKingdom, vType, vWindowName, btMainMenu);

		// Defining all the panes
		StackPane spTop = new StackPane();
		Pane pCenter = new Pane();

		// Attaching all the view tools to the panes
		spTop.getChildren().add(title);
		pCenter.getChildren().addAll(root, vCenter);

		// Defining the main pane of the scene and attaching all the side pane to it.
		bpGatherData = new BorderPane();
		bpGatherData.setTop(spTop);
		bpGatherData.setCenter(pCenter);

		// creating the scene
		sceneGatherData = new Scene(bpGatherData, WIDTH, HEIGHT);
	}

	@Override
	public void typeChange(ChangeListener<Toggle> listener) {
		tgGatherType.selectedToggleProperty().addListener(listener);
	}

	@Override
	public String getGatherType() {
		if (rbFullStats.isSelected())
			return User.FULL_STATS;
		else
			return User.POWER_ONLY;
	}

	@Override
	public void gameWindowNameChange(ChangeListener<Toggle> listener) {
		tgBuleStacks.selectedToggleProperty().addListener(listener);
	}

	@Override
	public String getGameWindowName() {
		if (rb1.isSelected())
			return User.BLUESTACKS_1;
		else if (rb2.isSelected())
			return User.BLUESTACKS_2;
		else if (rb3.isSelected())
			return User.BLUESTACKS_3;
		else
			return User.BLUESTACKS_4;
	}

	@Override
	public void showGatherDataScene() {
		window.setScene(sceneGatherData);
	}

	@Override
	public String getKingdomNumber() {
		return tfKingdomNumber.getText();
	}

	@Override
	public boolean checkKingdomNumberInput() {
		if (tfKingdomNumber.getText() != null && !tfKingdomNumber.getText().isEmpty())
			return true;
		return false;
	}

	@Override
	public void resetKingdomTextfield() {
		tfKingdomNumber.clear();
	}

	@Override
	public void updateKingdomNumberLabel(String kingdomNumber) {
		lbKingdomNumber.setText(kingdomNumber);
	}

	@Override
	public void setKingdom(EventHandler<ActionEvent> event) {
		btSetKingdom.setOnAction(event);
	}

	@Override
	public void popInputError(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Input error");
		alert.setHeaderText("You have an input error");
		alert.setContentText(msg);
		alert.showAndWait();
	}

	@Override
	public void popSuccessfully(String title, String Header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(Header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
