package model;

import java.util.Map;

import command.CreateDir_Command;
import command.GatheringDataScene_Command;
import command.PasteName_Command;
import command.TesseractUse_Command;
import command.UserCommand;

public class Model {
	private UserCommand userCommand;

	public Model() {
		User user = User.getInstance();

		CreateDir_Command createDirCommand = new CreateDir_Command(user);
		TesseractUse_Command tesseractUse_Command = new TesseractUse_Command(user);
		PasteName_Command pasteName_Command = new PasteName_Command();
		GatheringDataScene_Command gatheringDataScene_Command = new GatheringDataScene_Command(user);

		userCommand = new UserCommand(createDirCommand, tesseractUse_Command, pasteName_Command,
				gatheringDataScene_Command);
	}

	public void updateGameWindowName(String name) {
		userCommand.setGameWindowName(name);
	}

	public void updateGatheringType(String type) {
		userCommand.setGatheringType(type);
	}

	public void createDirForAllStats() {
		userCommand.createDirForAllStats();
	}

	public void createDirForPowerOnly() {
		userCommand.createDirForPowerOnly();
	}

	public void createDirForKingdomExcel() {
		userCommand.createDirForKingdomExcel();
	}

	public Player convertToPlayerObj(int rank) {
		return userCommand.convertToPlayerObj(rank);
	}

	public Map<String, String> convertToMapOfPowers(int endRank) {
		return userCommand.convertToMapOfPowers(endRank);
	}

	public String pasteName() {
		return userCommand.pasteName();
	}
}
