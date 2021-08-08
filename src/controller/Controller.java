package controller;

import model.Model;
import view.View;

public class Controller {
	private View theView;
	private Model theModel;

	public Controller(Model model, View view) {
		theView = view;
		theModel = model;
	}
}
