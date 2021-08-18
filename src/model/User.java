package model;

public class User {
	private static User single_instance = null;

	public static final String PATH_OF_PIC = "E:\\rok bot data",
			PATH_OF_PYTHON_FILES = "C:\\Users\\Roman Michailov\\OneDrive\\ROK Ranks Bot\\ROK_Ranks_Bot\\src\\python";
	public static final String FULL_STATS = "full", POWER_ONLY = "power";
	public static final String BLUESTACKS_1 = "BlueStack 1", BLUESTACKS_2 = "BlueStack 2", BLUESTACKS_3 = "BlueStack 3",
			BLUESTACKS_4 = "BlueStack 4";
	public static final int DEFAULT_KINGDOM = 1254;
	public static final int MAX_KINGDOM_NUMBER = 3000, MIN_KINGDOM_NUMBER = 1001;

	private String gatherType;
	private String gameWindowName;
	private Kingdom myKingdom;

	private User() {
		gatherType = FULL_STATS;
		gameWindowName = BLUESTACKS_2;
		myKingdom = new Kingdom(DEFAULT_KINGDOM);
	}

	public static User getInstance() {
		if (single_instance == null) {
			single_instance = new User();
		}
		return single_instance;
	}

	public boolean setKingdom(String kingdomNumber) {
		int number = 0;
		try {
			number = Integer.parseInt(kingdomNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (number <= MAX_KINGDOM_NUMBER && number >= MIN_KINGDOM_NUMBER) {
			myKingdom = new Kingdom(number);
			return true;
		}
		return false;
	}

	public Kingdom getKingdom() {
		return myKingdom;
	}

	public void setGatherType(String type) {
		if (type.equals(FULL_STATS) || type.equals(POWER_ONLY))
			gatherType = type;
	}

	public String getGatheringType() {
		return gatherType;
	}

	public void setGameWindowName(String gameWindowName) {
		if (gameWindowName.equals(BLUESTACKS_1) || gameWindowName.equals(BLUESTACKS_2)
				|| gameWindowName.equals(BLUESTACKS_3))
			this.gameWindowName = gameWindowName;
	}

	public String getGameWindowName() {
		return gameWindowName;
	}
}
