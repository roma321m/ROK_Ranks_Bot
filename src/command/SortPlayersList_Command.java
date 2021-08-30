package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Player;
import model.User;
import observer.Observable;

public class SortPlayersList_Command implements Command {

	private User user;

	public SortPlayersList_Command(User user) {
		this.user = user;
	}
	
	public ArrayList<Player> getPlayersList(){
		return this.user.getKingdom().getPlayers();
	}

	@Override
	public void sortPlayersListByT4Kills() {
		this.user.getKingdom().sortPlayersListByT4Kills();
	}

	@Override
	public void sortPlayersListByT5Kills() {
		this.user.getKingdom().sortPlayersListByT5Kills();
	}

	@Override
	public void sortPlayersListBydeads() {
		this.user.getKingdom().sortPlayersListBydeads();
	}

	@Override
	public void sortPlayersListByKillPoints() {
		this.user.getKingdom().sortPlayersListByKillPoints();
	}

	@Override
	public void sortPlayersListByPower() {
		this.user.getKingdom().sortPlayersByPower();
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
