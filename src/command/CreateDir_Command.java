package command;

import java.io.File;
import java.util.Map;

import model.Kingdom;
import model.Player;
import model.User;

public class CreateDir_Command implements Command {
	
	private User user;
	private Kingdom myKingdom;

	public CreateDir_Command(User user) {
		this.user = user;
		myKingdom = this.user.getKingdom();
	}

	@Override
	public void createDirForAllStats() {
		String path = PATH_OF_PIC + "\\" + myKingdom.getKingdomPath();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
			for (int i = 1; i <= 650; i++) {
				File f = new File(path + "\\" + i);
				f.mkdir();
			}
		}
	}

	@Override
	public void createDirForPowerOnly() {
		String path = PATH_OF_PIC + "\\Power - " + myKingdom.getKingdomPath();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	@Override
	public void createDirForKingdomExcel() {
		String path = PATH_OF_PIC + "\\Excel files\\" + myKingdom.getKingdomPath();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	/////////////////////////////////////////////
	//implemented in different commands classes//
	/////////////////////////////////////////////

	@Override
	public Player convertToPlayerObj(int rank) {
		// Do nothing
		return null;
	}

	@Override
	public Map<String, String> convertToMapOfPowers(int endRank) {
		// Do nothing
		return null;
	}

	@Override
	public String pasteName() {
		// Do nothing
		return null;
	}

	@Override
	public void setGatheringType(String type) {
		// Do nothing
	}

	@Override
	public void setGameWindowName(String name) {
		// Do nothing
	}

	@Override
	public void setKingdom(String kingdomNumber) {
		// Do nothing
	}

	@Override
	public void exportEcxelFileForAllStats() {
		// Do nothing
	}

	@Override
	public void exportEcxelFileForPowerOnly() {
		// Do nothing
	}

	@Override
	public void sortPlayersListByT4Kills() {
		// Do nothing
	}

	@Override
	public void sortPlayersListByT5Kills() {
		// Do nothing
	}

	@Override
	public void sortPlayersListBydeads() {
		// Do nothing
	}

	@Override
	public void sortPlayersListByKillPoints() {
		// Do nothing
	}

	@Override
	public void sortPlayersListByPower() {
		// Do nothing
	}
}
