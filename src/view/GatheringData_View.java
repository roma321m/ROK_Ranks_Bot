package view;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Toggle;

public interface GatheringData_View {

	// defining all the global variables for this scene
	void defineGlobalGatherData();

	// Initialing the scene and all the elements in it
	void buildSceneGatheringData();

	// if the gather type changes in view updating it in the model
	void typeChange(ChangeListener<Toggle> listener);

	// returns the type (in a String format) that is currently selected in the view
	String getGatherType();

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
}
