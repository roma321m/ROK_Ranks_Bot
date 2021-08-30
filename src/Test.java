import java.util.LinkedHashMap;
import java.util.Map;

import model.Model;
import model.Player;

public class Test {
	public static void main(String[] args) {

		// MongoConnection.makeConnection();

		Model testModel = new Model();

		// kingdom 1000 used for testing
		testModel.setKingdom("1000");
		System.out.println(testModel.getKingdomNumber());

		testModel.createDirForPowerOnly();
		testModel.createDirForAllStats();
		testModel.createDirForKingdomExcel();

		Map<String, String> power = new LinkedHashMap<String, String>();
		power = testModel.convertToMapOfPowers(300);
		System.out.println("number of elemnets in power map: " + power.size());
		testModel.setPower(power);

		testModel.exportEcxelFileForPowerOnly();

		for (int rank = 1; rank < 301; rank++) {
			Player p = testModel.convertToPlayerObj(rank);
			testModel.addPlayer(p);
			System.out.println(p);
		}
		testModel.exportEcxelFileForAllStats();
	}
}
