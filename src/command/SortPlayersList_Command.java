package command;

import java.util.ArrayList;
import java.util.Map;

import model.Kingdom;
import model.Player;
import model.User;

public class SortPlayersList_Command implements Command {

	private User user;
	private Kingdom myKingdom;

	public SortPlayersList_Command(User user) {
		this.user = user;
		myKingdom = this.user.getKingdom();
	}
	
	public ArrayList<Player> getPlayersList(){
		return myKingdom.getPlayers();
	}

	@Override
	public void sortPlayersListByT4Kills() {
		myKingdom.sortPlayersListByT4Kills();
	}

	@Override
	public void sortPlayersListByT5Kills() {
		myKingdom.sortPlayersListByT5Kills();
	}

	@Override
	public void sortPlayersListBydeads() {
		myKingdom.sortPlayersListBydeads();
	}

	@Override
	public void sortPlayersListByKillPoints() {
		myKingdom.sortPlayersListByKillPoints();
	}

	@Override
	public void sortPlayersListByPower() {
		myKingdom.sortPlayersByPower();
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

}
