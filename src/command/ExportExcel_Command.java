package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Kingdom;
import model.Player;
import model.User;
import model.WriteDataToExcel;
import observer.Observable;

public class ExportExcel_Command implements Command {
	private User user;

	public ExportExcel_Command(User user) {
		this.user = user;
	}

	public void exportEcxelFileForPowerOnly() {
		new Thread() {
			public void run() {
				Kingdom myKingdom = user.getKingdom();
				try {
					WriteDataToExcel.writePowerDataToExcel(PATH_OF_PIC + "\\Excel files\\" + myKingdom.getNumber()
							+ "\\Power - " + myKingdom.getNumber() + " " + myKingdom.getDate() + ".xlsx", myKingdom);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void exportEcxelFileForAllStats() {
		new Thread() {
			public void run() {
				Kingdom myKingdom = user.getKingdom();
				try {
					WriteDataToExcel.writeAllStatsDataToExcel(PATH_OF_PIC + "\\Excel files\\" + myKingdom.getNumber()
							+ "\\" + myKingdom.getNumber() + " " + myKingdom.getDate() + ".xlsx", myKingdom);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/////////////////////////////////////////////
	// implemented in different commands classes//
	/////////////////////////////////////////////

	@Override
	public void createDirForAllStats() {
		// Do nothing
	}

	@Override
	public void createDirForPowerOnly() {
		// Do nothing
	}

	@Override
	public void createDirForKingdomExcel() {
		// Do nothing
	}

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
