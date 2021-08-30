package view;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import model.User;

public interface GatheringData_View {

	// defining all the global variables for this scene
	void defineGlobalGatherData();

	// Initialing the scene and all the elements in it
	void buildSceneGatheringData();

	// if the gather type changes in view updating it in the model
	void allStatsChange(ChangeListener<Toggle> listener);

	String getAllStats();

	// if the gather type changes in view updating it in the model
	void gameWindowNameChange(ChangeListener<Toggle> listener);

	// returns the type (in a String format) that is currently selected in the view
	String getGameWindowName();

	// applying this scene to the window
	void showGatherDataScene();

	// returns the kingdom number (in a String format) from the text field
	String getKingdomNumber();

	// checks if there is input in the text field
	boolean checkKingdomNumberInput();

	// resets the text field 
	void resetKingdomTextfield();
	
	// updating the label of the kingdom number from the data in the model
	void updateKingdomNumberLabel(String kingdomNumber);
	
	// changing the kingdom in the user data into the new one that was typed in the view
	void setKingdom(EventHandler<ActionEvent> event);
	
	// starting the bot script
	void startTheBot(EventHandler<ActionEvent> event);
	
	void startGameChange(ChangeListener<Toggle> listener);

	String getStartGame();
	
	void openRanksChange(ChangeListener<Toggle> listener);

	String getOpenRanks();
	
	void lastRankChange(ChangeListener<Toggle> listener);

	String getLastRank();
}
