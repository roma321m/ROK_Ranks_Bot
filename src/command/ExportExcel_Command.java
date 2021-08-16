package command;

import java.util.Map;

import model.Kingdom;
import model.Player;
import model.User;
import model.WriteDataToExcel;

public class ExportExcel_Command implements Command{
	private User user;
	private Kingdom myKingdom;

	public ExportExcel_Command(User user) {
		this.user = user;
		myKingdom = this.user.getKingdom();
	}
	
	public void exportEcxelFileForPowerOnly() {
		try {
			WriteDataToExcel.writePowerDataToExcel(PATH_OF_PIC + "\\Excel files\\" + myKingdom.getNumber()
					+ "\\Power - " + myKingdom.getNumber() + " " + myKingdom.getDate() + ".xlsx", myKingdom);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exportEcxelFileForAllStats() {
		try {
			WriteDataToExcel.writeAllStatsDataToExcel(PATH_OF_PIC + "\\Excel files\\" + myKingdom.getNumber() + "\\"
					+ myKingdom.getNumber() + " " + myKingdom.getDate() + ".xlsx", myKingdom);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////
	//implemented in different commands classes//
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
