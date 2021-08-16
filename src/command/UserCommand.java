package command;

import java.util.Map;
import model.Player;

public class UserCommand {

	Command createDir;
	Command tesseractUse;
	Command pasteName;
	Command gatheringDataScene;
	Command exportExcel;
	Command sortPlayersList;

	public UserCommand(Command createDir, Command tesseractUse, Command pasteName, Command gatheringDataScene,
			Command exportExcel, Command sortPlayersList) {
		this.createDir = createDir;
		this.tesseractUse = tesseractUse;
		this.pasteName = pasteName;
		this.gatheringDataScene = gatheringDataScene;
		this.exportExcel = exportExcel;
		this.sortPlayersList = sortPlayersList;
	}

	public void sortPlayersListByT4Kills() {
		sortPlayersList.sortPlayersListByT4Kills();
	}

	public void sortPlayersListByT5Kills() {
		sortPlayersList.sortPlayersListByT5Kills();
	}

	public void sortPlayersListBydeads() {
		sortPlayersList.sortPlayersListBydeads();
	}

	public void sortPlayersListByKillPoints() {
		sortPlayersList.sortPlayersListByKillPoints();
	}

	public void sortPlayersListByPower() {
		sortPlayersList.sortPlayersListByPower();
	}

	public void exportEcxelFileForAllStats() {
		exportExcel.exportEcxelFileForAllStats();
	}

	public void exportEcxelFileForPowerOnly() {
		exportExcel.exportEcxelFileForPowerOnly();
	}

	public void setKingdom(String kingdomNumber) {
		gatheringDataScene.setKingdom(kingdomNumber);
	}

	public void setGameWindowName(String name) {
		gatheringDataScene.setGameWindowName(name);
	}

	public void setGatheringType(String type) {
		gatheringDataScene.setGatheringType(type);
	}

	public void createDirForAllStats() {
		createDir.createDirForAllStats();
	}

	public void createDirForPowerOnly() {
		createDir.createDirForPowerOnly();
	}

	public void createDirForKingdomExcel() {
		createDir.createDirForKingdomExcel();
	}

	public Player convertToPlayerObj(int rank) {
		return tesseractUse.convertToPlayerObj(rank);
	}

	public Map<String, String> convertToMapOfPowers(int endRank) {
		return tesseractUse.convertToMapOfPowers(endRank);
	}

	public String pasteName() {
		return pasteName.pasteName();
	}
}
