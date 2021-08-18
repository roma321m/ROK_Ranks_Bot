package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import model.Model;
import model.User;
import view.View;

public class Controller {
	private View theView;
	private Model theModel;

	public Controller(Model model, View view) {
		theView = view;
		theModel = model;

		// updating the kingdom number label in the gathering data view
		theView.updateKingdomNumberLabel(theModel.getKingdomNumber());

		// set kingdom
		EventHandler<ActionEvent> eventSetKingdom = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (theView.checkKingdomNumberInput()) {
					String number = theView.getKingdomNumber();
					if (theModel.setKingdom(number)) {
						theView.updateKingdomNumberLabel(theModel.getKingdomNumber());
						theView.popSuccessfully("New kingdom Set", "You set new kingdom for gathering info",
								"Successfully set a new kingdom");
					} else {
						theView.popInputError("kingdom number should be between " + User.MIN_KINGDOM_NUMBER + " to "
								+ User.MAX_KINGDOM_NUMBER);
					}
				} else {
					theView.popInputError("must type a kingdom");
				}
				theView.resetKingdomTextfield();
			}
		};
		theView.setKingdom(eventSetKingdom);

		// sort by power
		EventHandler<ActionEvent> eventSortByPower = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theModel.sortPlayersListByPower();
				theView.updatePlayersList(theModel.getPlayersList());
			}
		};
		theView.sortByPower(eventSortByPower);

		// sort by deads
		EventHandler<ActionEvent> eventSortByDeads = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theModel.sortPlayersListBydeads();
				theView.updatePlayersList(theModel.getPlayersList());
			}
		};
		theView.sortByDeads(eventSortByDeads);

		// sort by kill points
		EventHandler<ActionEvent> eventSortByKillPoints = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theModel.sortPlayersListByKillPoints();
				theView.updatePlayersList(theModel.getPlayersList());
			}
		};
		theView.sortByKillPoints(eventSortByKillPoints);

		// sort by t4 kills
		EventHandler<ActionEvent> eventSortByT4Kills = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theModel.sortPlayersListByT4Kills();
				theView.updatePlayersList(theModel.getPlayersList());
			}
		};
		theView.sortByT4(eventSortByT4Kills);

		// sort by t5 kills
		EventHandler<ActionEvent> eventSortByT5Kills = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				theModel.sortPlayersListByT5Kills();
				theView.updatePlayersList(theModel.getPlayersList());
			}
		};
		theView.sortByT5(eventSortByT5Kills);

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
