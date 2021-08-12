package command;

import java.util.Map;

import model.Player;

public class UserCommand {

	Command createDir;
	Command tesseractUse;
	Command pasteName;
	Command gatheringDataScene;

	public UserCommand(Command createDir, Command tesseractUse, Command pasteName, Command gatheringDataScene) {
		this.createDir = createDir;
		this.tesseractUse = tesseractUse;
		this.pasteName = pasteName;
		this.gatheringDataScene = gatheringDataScene;
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
