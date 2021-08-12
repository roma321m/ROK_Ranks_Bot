package command;

import java.util.Map;

import model.Player;
import model.User;

public class GatheringDataScene_Command implements Command {
	User user;

	public GatheringDataScene_Command(User user) {
		this.user = user;
	}

	@Override
	public void setKingdom(String kingdomNumber) {
		user.setKingdom(kingdomNumber);
	}

	@Override
	public void setGameWindowName(String name) {
		user.setGameWindowName(name);
	}

	@Override
	public void setGatheringType(String type) {
		user.setGatherType(type);
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
}
