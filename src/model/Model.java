package model;

import java.util.Map;

import command.CreateDir_Command;
import command.PasteName_Command;
import command.SystemCommand;
import command.TesseractUse_Command;
import command.UserCommand;

public class Model {
	private UserCommand userCommand;
	private SystemCommand systemCommand;

	public Model() {
		// kingdom obj temporary solution
		final int KINGDOM_NUMBER = 1254;
		Kingdom kingdom = new Kingdom(KINGDOM_NUMBER);

		CreateDir_Command createDirCommand = new CreateDir_Command(kingdom);
		TesseractUse_Command tesseractUse_Command = new TesseractUse_Command(kingdom);
		PasteName_Command pasteName_Command = new PasteName_Command();

		SystemCommand systemCommand = new SystemCommand(createDirCommand, tesseractUse_Command, pasteName_Command);
		UserCommand userCommand = new UserCommand();
	}

	public void createDirForAllStats() {
		systemCommand.createDirForAllStats();
	}

	public void createDirForPowerOnly() {
		systemCommand.createDirForPowerOnly();
	}

	public void createDirForKingdomExcel() {
		systemCommand.createDirForKingdomExcel();
	}

	public Player convertToPlayerObj(int rank) {
		return systemCommand.convertToPlayerObj(rank);
	}

	public Map<String, String> convertToMapOfPowers(int endRank) {
		return systemCommand.convertToMapOfPowers(endRank);
	}
	
	public String pasteName() {
		return systemCommand.pasteName();
	}
}
