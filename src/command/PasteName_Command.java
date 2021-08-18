package command;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import model.Player;

public class PasteName_Command implements Command {

	public PasteName_Command() {

	}

	@Override
	public String pasteName() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor flavor = DataFlavor.stringFlavor;
		if (clipboard.isDataFlavorAvailable(flavor)) {
			try {
				String text = (String) clipboard.getData(flavor);
				return text;
			} catch (UnsupportedFlavorException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		return "";
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
