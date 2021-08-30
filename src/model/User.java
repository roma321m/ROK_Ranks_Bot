package model;

import java.util.ArrayList;
import java.util.HashMap;

import observer.NotifyingThread;
import observer.Observable;

public class User {
	private static User single_instance = null;

	public static final String PATH_OF_PIC = "D:\\rok bot data",
			PATH_OF_PYTHON_FILES = "C:\\Users\\Roman Michailov\\OneDrive\\ROK Ranks Bot\\ROK_Ranks_Bot\\src\\python";
	public static final String YES = "true", NO = "false";
	public static final String BLUESTACKS_1 = "BlueStacks 1", BLUESTACKS_2 = "BlueStacks 2",
			BLUESTACKS_3 = "BlueStacks 3", BLUESTACKS_4 = "BlueStacks 4";
	public static final String DIR = "dir", FULL = "full", POWER = "power", EXCEL = "excel", TO_PLAYERS = "players",
			TO_MAP_POWER = "map power";
	public static final int DEFAULT_KINGDOM = 1254;
	public static final int MAX_KINGDOM_NUMBER = 3000, MIN_KINGDOM_NUMBER = 1000;

	private Kingdom myKingdom;
	private ArrayList<Observable> threads;
	private HashMap<Long, String> threadsTypeMap;

	private User() {
		myKingdom = new Kingdom(DEFAULT_KINGDOM);
		threads = new ArrayList<Observable>();
		threadsTypeMap = new HashMap<Long, String>();
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

	public void addListener(Observable ob, String type) {
		if (ob instanceof NotifyingThread) {
			long key = ((NotifyingThread) ob).getId();
			threadsTypeMap.put(key, type);
			threads.add(ob);
		}
	}

	public void removeListener(Observable ob) {
		if (ob instanceof NotifyingThread) {
			long key = ((NotifyingThread) ob).getId();
			threadsTypeMap.remove(key);
			threads.remove(ob);
		}
	}

	public ArrayList<Observable> getListeners() {
		return threads;
	}

	public HashMap<Long, String> getListenersMap() {
		return threadsTypeMap;
	}

	public String getThreadType(Observable ob) {
		if (ob instanceof NotifyingThread) {
			long key = ((NotifyingThread) ob).getId();
			return threadsTypeMap.get(key);
		}
		return null;
	}
}
