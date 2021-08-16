package command;

import java.util.Map;
import model.Player;

public interface Command {
	static final String PATH_OF_PIC = "E:\\rok bot data";
	static final String PATH_OF_PYTHON_FILES = "C:\\Users\\Roman Michailov\\OneDrive\\ROK Ranks Bot\\ROK_Ranks_Bot\\src\\python";
	static final String WINDOW_NAME = "BlueStacks 2";
	static final String SCREENSHOT_1 = "1", SCREENSHOT_2 = "2";
	static final String BARBS_PIC = "barbs_snap", DEAD_PIC = "dead_snap", HELP_PIC = "helps_snap", ID_PIC = "id_snap",
			NAME_PIC = "name_snap", POWER_PIC = "power_snap", RSS_A_PIC = "rss_a_snap", RSS_G_PIC = "rss_g_snap",
			T1_PIC = "t1_snap", T2_PIC = "t2_snap", T3_PIC = "t3_snap", T4_PIC = "t4_snap", T5_PIC = "t5_snap";

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
	void setGatheringType(String type);
	void setGameWindowName(String name);
	void setKingdom(String kingdomNumber);
	
	// exportExcel
	void exportEcxelFileForAllStats();
	void exportEcxelFileForPowerOnly();
	
	// sortPlayersList
	void sortPlayersListByT4Kills();
	void sortPlayersListByT5Kills();
	void sortPlayersListBydeads();
	void sortPlayersListByKillPoints();
	void sortPlayersListByPower();
}
