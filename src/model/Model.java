package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import command.CreateDir_Command;
import command.ExportExcel_Command;
import command.GatheringDataScene_Command;
import command.NotifyingThread_Command;
import command.PasteName_Command;
import command.SortPlayersList_Command;
import command.TesseractUse_Command;
import command.UserCommand;
import observer.NotifyingThread;
import observer.Observable;
import observer.Observer;

public class Model implements Observer {
	private UserCommand userCommand;

	private Map<String, String> power;
	private int lastRank;

	public Model() {
		User user = User.getInstance();

		CreateDir_Command createDirCommand = new CreateDir_Command(user);
		TesseractUse_Command tesseractUse_Command = new TesseractUse_Command(user);
		PasteName_Command pasteName_Command = new PasteName_Command();
		GatheringDataScene_Command gatheringDataScene_Command = new GatheringDataScene_Command(user);
		ExportExcel_Command exportExcel_Command = new ExportExcel_Command(user);
		SortPlayersList_Command sortPlayersList_Command = new SortPlayersList_Command(user);
		NotifyingThread_Command notifyingThread_Command = new NotifyingThread_Command(user);

		userCommand = new UserCommand(createDirCommand, tesseractUse_Command, pasteName_Command,
				gatheringDataScene_Command, exportExcel_Command, sortPlayersList_Command, notifyingThread_Command);
		power = new LinkedHashMap<String, String>();
		lastRank = 300;
	}

	private void startThread(NotifyingThread t, String type) {
		t.setListener(this); // add ourselves as a observer
		userCommand.addListener(t, type); // add to the list of threads
		System.out.println("------------------------------------------");
		System.out.println("New " + type + " Thread, ID = " + t.getId());
		System.out.println("------------------------------------------");
		System.out.println("Threads list:");
		for (Observable ob : userCommand.getListeners()) {
			System.out.println(ob);
		}

		System.out.println("Threads type map:");
		for (HashMap.Entry<Long, String> entry : userCommand.getListenersMap().entrySet()) {
			System.out.println("ID = " + entry.getKey() + ", Type = " + entry.getValue());
		}
		System.out.println("------------------------------------------");
		t.start();
	}

	public void startBot(String window, String startGame, String openRanks, String allStats, String lastRank) {
		userCommand.createDirForKingdomExcel();
		// need to replace lastRank with a listener on the rb in the controller and make
		// it an attributes in Model
		// update it in the threads as well, now use fixed 300
		if (allStats.equals(User.YES)) {
			userCommand.createDirForAllStats();
			NotifyingThread t = new NotifyingThread() {
				@Override
				public void doRun() {
					userCommand.startBot(window, startGame, openRanks, allStats, lastRank);
				}
			};
			startThread(t, User.FULL);
		} else {
			userCommand.createDirForPowerOnly();
			NotifyingThread t = new NotifyingThread() {
				@Override
				public void doRun() {
					userCommand.startBot(window, startGame, openRanks, allStats, lastRank);
				}
			};
			startThread(t, User.POWER);
		}
	}

	public void setPower(Map<String, String> power) {
		userCommand.setPower(power);
	}

	public void addPlayer(Player p) {
		userCommand.addPlayer(p);
	}

	public ArrayList<Player> getPlayersList() {
		return userCommand.getPlayersList();
	}

	public boolean setKingdom(String kingdomNumber) {
		return userCommand.setKingdom(kingdomNumber);
	}

	public String getKingdomNumber() {
		return userCommand.getKingdomNumber();
	}

	public void sortPlayersListByT4Kills() {
		userCommand.sortPlayersListByT4Kills();
	}

	public void sortPlayersListByT5Kills() {
		userCommand.sortPlayersListByT5Kills();
	}

	public void sortPlayersListBydeads() {
		userCommand.sortPlayersListBydeads();
	}

	public void sortPlayersListByKillPoints() {
		userCommand.sortPlayersListByKillPoints();
	}

	public void sortPlayersListByPower() {
		userCommand.sortPlayersListByPower();
	}

	public void exportEcxelFileForAllStats() {
		userCommand.exportEcxelFileForAllStats();
	}

	public void exportEcxelFileForPowerOnly() {
		userCommand.exportEcxelFileForPowerOnly();
	}

	public void createDirForAllStats() {
		NotifyingThread t = new NotifyingThread() {
			@Override
			public void doRun() {
				userCommand.createDirForAllStats();
			}
		};
		startThread(t, User.DIR);
	}

	public void createDirForPowerOnly() {
		NotifyingThread t = new NotifyingThread() {
			@Override
			public void doRun() {
				userCommand.createDirForPowerOnly();
			}
		};
		startThread(t, User.DIR);
	}

	public void createDirForKingdomExcel() {
		NotifyingThread t = new NotifyingThread() {
			@Override
			public void doRun() {
				userCommand.createDirForKingdomExcel();
			}
		};
		startThread(t, User.DIR);
	}

	public Player convertToPlayerObj(int rank) {
		return userCommand.convertToPlayerObj(rank);
	}

	public Map<String, String> convertToMapOfPowers(int endRank) {
		return userCommand.convertToMapOfPowers(endRank);
	}

	public String pasteName() {
		return userCommand.pasteName();
	}

	@Override
	public void notifyOfThreadComplete(NotifyingThread thread) {
		long key = thread.getId();
		String type = userCommand.getThreadType(thread);

		thread.removeListener();
		userCommand.removeListener(thread);
		System.out.println("------------------------------------------");
		System.out.println(type + " thread finished, Thread ID = " + key);

		switch (type) {
		case User.DIR:
			threadDir();
			break;
		case User.FULL:
			threadFull();
			break;
		case User.POWER:
			threadPower();
			break;
		case User.EXCEL:
			threadExcel();
			break;
		case User.TO_PLAYERS:
			threadToPlayers();
			break;
		case User.TO_MAP_POWER:
			threadToMapPower();
			break;
		default:
			System.out.println("error: thread type = null");
		}
	}

	private void threadDir() {

	}

	private void threadFull() {
		NotifyingThread t = new NotifyingThread() {
			@Override
			public void doRun() {
				for (int rank = 1; rank <= lastRank; rank++) {
					Player p = userCommand.convertToPlayerObj(rank);
					userCommand.addPlayer(p);
				}
			}
		};
		startThread(t, User.TO_PLAYERS);
	}

	private void threadPower() {
		NotifyingThread t = new NotifyingThread() {
			@Override
			public void doRun() {
				power = userCommand.convertToMapOfPowers(lastRank);
			}
		};
		startThread(t, User.TO_MAP_POWER);
	}

	private void threadExcel() {

	}

	private void threadToPlayers() {
		userCommand.exportEcxelFileForAllStats();
	}

	private void threadToMapPower() {
		userCommand.setPower(power);
		userCommand.exportEcxelFileForPowerOnly();
	}
}
