package model;

import java.util.Map;

import command.CreateDir_Command;
import command.ExportExcel_Command;
import command.GatheringDataScene_Command;
import command.PasteName_Command;
import command.SortPlayersList_Command;
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
		ExportExcel_Command exportExcel_Command = new ExportExcel_Command(user);
		SortPlayersList_Command sortPlayersList_Command = new SortPlayersList_Command(user);

		userCommand = new UserCommand(createDirCommand, tesseractUse_Command, pasteName_Command,
				gatheringDataScene_Command, exportExcel_Command, sortPlayersList_Command);
	}
	
	public boolean setKingdom(String kingdomNumber) {
		return userCommand.setKingdom(kingdomNumber);
	}
	
	public String getKingdomNumber() {
		return userCommand.getKingdomNumber();
	}

	public void sortPlayersListByT4Kills() {
		userCommand.sortPlayersListByT4Kills();
	}

	public void sortPlayersListByT5Kills() {
		userCommand.sortPlayersListByT5Kills();
	}

	public void sortPlayersListBydeads() {
		userCommand.sortPlayersListBydeads();
	}

	public void sortPlayersListByKillPoints() {
		userCommand.sortPlayersListByKillPoints();
	}

	public void sortPlayersListByPower() {
		userCommand.sortPlayersListByPower();
	}

	public void exportEcxelFileForAllStats() {
		userCommand.exportEcxelFileForAllStats();
	}

	public void exportEcxelFileForPowerOnly() {
		userCommand.exportEcxelFileForPowerOnly();
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
