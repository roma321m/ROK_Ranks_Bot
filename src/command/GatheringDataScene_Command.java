package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Kingdom;
import model.Player;
import model.User;
import observer.Observable;

public class GatheringDataScene_Command implements Command {
	private User user;

	public GatheringDataScene_Command(User user) {
		this.user = user;
	}

	@Override
	public void setPower(Map<String, String> power) {
		this.user.getKingdom().setPower(power);
	}

	@Override
	public void addPlayer(Player p) {
		this.user.getKingdom().addPlayer(p);
	}

	@Override
	public void StartBot(String window, String startGame, String openRanks, String allStats, String lastRank) {
		Kingdom myKingdom = user.getKingdom();
		String pathPython = PATH_OF_PYTHON_FILES + "\\bot.py";
		String[] cmd = new String[9];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = window;
		cmd[3] = PATH_OF_PIC;
		cmd[4] = myKingdom.getKingdomPath();
		cmd[5] = startGame;
		cmd[6] = openRanks;
		cmd[7] = allStats;
		cmd[8] = lastRank;
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			System.out.println("bot.py - error");
			e.printStackTrace();
		}
	}

	@Override
	public boolean setKingdom(String kingdomNumber) {
		return user.setKingdom(kingdomNumber);
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
