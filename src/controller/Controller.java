package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import model.Model;
import view.View;

public class Controller {
	private View theView;
	private Model theModel;

	public Controller(Model model, View view) {
		theView = view;
		theModel = model;

		// changing the type in the model base on the selection in the view
		ChangeListener<Toggle> gatherTypeChangeListener = new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// 1.get the new type that is selected from the view
				String type = theView.getGatherType();
				// 2.update model
				theModel.updateGatheringType(type);
			}
		};
		theView.typeChange(gatherTypeChangeListener);

		// changing the game window name in the model base on the selection in the view
		ChangeListener<Toggle> gameWindowNameChangeListener = new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// 1.get the new type that is selected from the view
				String name = theView.getGameWindowName();
				// 2.update model
				theModel.updateGameWindowName(name);
			}
		};
		theView.gameWindowNameChange(gameWindowNameChangeListener);
	}
}
