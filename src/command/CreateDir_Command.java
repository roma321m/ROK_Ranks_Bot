package command;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.User;
import observer.Observable;

public class CreateDir_Command implements Command {

	private User user;

	public CreateDir_Command(User user) {
		this.user = user;
	}

	@Override
	public void createDirForAllStats() {
		String path = PATH_OF_PIC + "\\" + user.getKingdom().getKingdomPath();
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
		String path = PATH_OF_PIC + "\\Power - " + user.getKingdom().getKingdomPath();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	@Override
	public void createDirForKingdomExcel() {
		String path = PATH_OF_PIC + "\\Excel files\\" + user.getKingdom().getNumber();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	/////////////////////////////////////////////
	// implemented in different commands classes//
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
	public boolean setKingdom(String kingdomNumber) {
		// Do nothing
		return false;
	}

	@Override
	public String getKingdomNumber() {
		// Do nothing
		return null;
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

	@Override
	public ArrayList<Player> getPlayersList() {
		// Do nothing
		return null;
	}

	@Override
	public void StartBot(String window, String startGame, String openRanks, String allStats, String lastRank) {
		// Do nothing
	}

	@Override
	public void setPower(Map<String, String> power) {
		// Do nothing
	}

	@Override
	public void addPlayer(Player p) {
		// Do nothing
	}

	@Override
	public void addListener(Observable ob, String type) {
		// Do nothing
	}

	@Override
	public void removeListener(Observable ob) {
		// Do nothing
	}

	@Override
	public ArrayList<Observable> getListeners() {
		// Do nothing
		return null;
	}

	@Override
	public HashMap<Long, String> getListenersMap() {
		// Do nothing
		return null;
	}

	@Override
	public String getThreadType(Observable ob) {
		// Do nothing
		return null;
	}

}
