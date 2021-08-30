package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Player;
import observer.Observable;

public class UserCommand {

	Command createDir;
	Command tesseractUse;
	Command pasteName;
	Command gatheringDataScene;
	Command exportExcel;
	Command sortPlayersList;
	Command notifyingThread_Command;

	public UserCommand(Command createDir, Command tesseractUse, Command pasteName, Command gatheringDataScene,
			Command exportExcel, Command sortPlayersList, Command notifyingThread_Command) {
		this.createDir = createDir;
		this.tesseractUse = tesseractUse;
		this.pasteName = pasteName;
		this.gatheringDataScene = gatheringDataScene;
		this.exportExcel = exportExcel;
		this.sortPlayersList = sortPlayersList;
		this.notifyingThread_Command = notifyingThread_Command;
	}
	
	public void addListener(Observable ob, String type) {
		notifyingThread_Command.addListener(ob, type);
	}

	public void removeListener(Observable ob) {
		notifyingThread_Command.removeListener(ob);
	}

	public ArrayList<Observable> getListeners() {
		return notifyingThread_Command.getListeners();
	}
	
	public HashMap<Long,String> getListenersMap(){
		return notifyingThread_Command.getListenersMap();
	}
	
	public String getThreadType(Observable ob) {
		return notifyingThread_Command.getThreadType(ob);
	}
	
	public void addPlayer(Player p) {
		gatheringDataScene.addPlayer(p);
	}
	
	public void setPower(Map<String, String> power) {
		gatheringDataScene.setPower(power);
	}
	
	public void startBot(String window, String startGame, String openRanks, String allStats, String lastRank) {
		gatheringDataScene.StartBot(window, startGame, openRanks, allStats, lastRank);
	}

	public ArrayList<Player> getPlayersList() {
		return sortPlayersList.getPlayersList();
	}

	public String getKingdomNumber() {
		return gatheringDataScene.getKingdomNumber();
	}

	public void sortPlayersListByT4Kills() {
		sortPlayersList.sortPlayersListByT4Kills();
	}

	public void sortPlayersListByT5Kills() {
		sortPlayersList.sortPlayersListByT5Kills();
	}

	public void sortPlayersListBydeads() {
		sortPlayersList.sortPlayersListBydeads();
	}

	public void sortPlayersListByKillPoints() {
		sortPlayersList.sortPlayersListByKillPoints();
	}

	public void sortPlayersListByPower() {
		sortPlayersList.sortPlayersListByPower();
	}

	public void exportEcxelFileForAllStats() {
		exportExcel.exportEcxelFileForAllStats();
	}

	public void exportEcxelFileForPowerOnly() {
		exportExcel.exportEcxelFileForPowerOnly();
	}

	public boolean setKingdom(String kingdomNumber) {
		return gatheringDataScene.setKingdom(kingdomNumber);
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
