package command;

import java.util.Map;

import model.Player;

public class SystemCommand {

	Command createDir;
	Command tesseractUse;
	Command pasteName;

	public SystemCommand(Command createDir, Command tesseractUse, Command pasteName) {
		this.createDir = createDir;
		this.tesseractUse = tesseractUse;
		this.pasteName = pasteName;
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
