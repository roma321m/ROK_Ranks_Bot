package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;

public interface PlayersList_View {
	// defining all the global variables for this scene
	void defineGlobalPlayersList();

	// Initialing the scene and all the elements in it
	void buildScenePlayersList();

	// Applying this scene to the window
	void showPlayersListScene();

	// Update players list
	void updatePlayersList(ArrayList<Player> arr);

	// sorting option buttons
	void sortByPower(EventHandler<ActionEvent> event);
	void sortByDeads(EventHandler<ActionEvent> event);
	void sortByKillPoints(EventHandler<ActionEvent> event);
	void sortByT4(EventHandler<ActionEvent> event);
	void sortByT5(EventHandler<ActionEvent> event);
}
