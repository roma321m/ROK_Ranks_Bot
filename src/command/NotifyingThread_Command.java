package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Player;
import model.User;
import observer.Observable;

public class NotifyingThread_Command implements Command {

	private User user;

	public NotifyingThread_Command(User user) {
		this.user = user;
	}
	
	public void addListener(Observable ob, String type) {
		user.addListener(ob, type);
	}

	public void removeListener(Observable ob) {
		user.removeListener(ob);
	}

	public ArrayList<Observable> getListeners() {
		return user.getListeners();
	}
	
	public HashMap<Long,String> getListenersMap(){
		return user.getListenersMap();
	}
	public String getThreadType(Observable ob) {
		return user.getThreadType(ob);
	}

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
