package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Player;
import observer.Observable;

public interface Command {
	static final String PATH_OF_PIC = "D:\\rok bot data";
	static final String PATH_OF_PYTHON_FILES = "C:\\Users\\Roman Michailov\\OneDrive\\ROK Ranks Bot\\ROK_Ranks_Bot\\src\\python";

	// CreateDir
	void createDirForAllStats();
	void createDirForPowerOnly();
	void createDirForKingdomExcel();

	// tesseractUse
	Player convertToPlayerObj(int rank);
	Map<String, String> convertToMapOfPowers(int endRank);

	// PasteName
	String pasteName();
	
	// GathringDataScene
	boolean setKingdom(String kingdomNumber);
	String getKingdomNumber();
	void StartBot(String window, String startGame, String openRanks, String allStats, String lastRank);
	void setPower(Map<String, String> power);
	void addPlayer(Player p);
	
	// exportExcel
	void exportEcxelFileForAllStats();
	void exportEcxelFileForPowerOnly();
	
	// sortPlayersList
	void sortPlayersListByT4Kills();
	void sortPlayersListByT5Kills();
	void sortPlayersListBydeads();
	void sortPlayersListByKillPoints();
	void sortPlayersListByPower();
	ArrayList<Player> getPlayersList();
	
	// notifyingThread
	void addListener(Observable ob, String type);
	void removeListener(Observable ob);
	ArrayList<Observable> getListeners();
	HashMap<Long,String> getListenersMap();
	String getThreadType(Observable ob);
}
