package command;

import java.util.ArrayList;
import java.util.Map;

import model.Player;
import model.User;

public class GatheringDataScene_Command implements Command {
	private User user;

	public GatheringDataScene_Command(User user) {
		this.user = user;
	}

	@Override
	public boolean setKingdom(String kingdomNumber) {
		return user.setKingdom(kingdomNumber);
	}

	@Override
	public void setGameWindowName(String name) {
		user.setGameWindowName(name);
	}

	@Override
	public void setGatheringType(String type) {
		user.setGatherType(type);
	}

	public String getKingdomNumber() {
		try {
			return user.getKingdom().getNumber() + "";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "0";
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
}
