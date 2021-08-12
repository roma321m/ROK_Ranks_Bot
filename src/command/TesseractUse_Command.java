package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Kingdom;
import model.Player;
import model.User;

public class TesseractUse_Command implements Command {

	User user;
	Kingdom myKingdom;

	public TesseractUse_Command(User user) {
		this.user = user;
		myKingdom = user.getKingdom();
	}

	@Override
	public Player convertToPlayerObj(int rank) {
		Player p = new Player();
		String name = "";
		try (FileInputStream fis = new FileInputStream(
				new File(PATH_OF_PIC + "\\" + myKingdom.getKingdomPath() + "\\" + rank + "\\playerName.txt"));
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr)) {

			String str;
			while ((str = reader.readLine()) != null) {
				name += str;
				System.out.println(str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		p.setName(name);

		String str = textFromPic(myKingdom.getKingdomPath(), rank);
		String lines[] = str.split("\\r?\\n");
		for (int i = 1; i < lines.length; i++) {
			lines[i] = lines[i].substring(1);
		}
		if (lines.length > 0)
			p.setBarbs(lines[0]);
		if (lines.length > 1)
			p.setDeaths(lines[1]);
		if (lines.length > 2)
			p.setHelps(lines[2]);
		if (lines.length > 3)
			p.setId(lines[3]);
		if (lines.length > 4)
			p.setPower(lines[4]);
		if (lines.length > 5)
			p.setRss_a(lines[5]);
		if (lines.length > 6)
			p.setRss_g(lines[6]);
		if (lines.length > 7)
			p.setT1(lines[7]);
		if (lines.length > 8)
			p.setT2(lines[8]);
		if (lines.length > 9)
			p.setT3(lines[9]);
		if (lines.length > 10)
			p.setT4(lines[10]);
		if (lines.length > 11)
			p.setT5(lines[11]);
		return p;
	}

	@Override
	public Map<String, String> convertToMapOfPowers(int endRank) {
		Map<String, String> power = new LinkedHashMap<String, String>();
		String str = powerFromPic(myKingdom.getKingdomPath(), endRank);
		String lines[] = str.split("\\r?\\n");
		for (int i = 1; i < lines.length; i++) {
			lines[i] = lines[i].substring(1);
		}
		if (lines.length > 1)
			power.put("Top 50", lines[1]);
		if (lines.length > 2)
			power.put("Top 100", lines[2]);
		if (lines.length > 3)
			power.put("Top 150", lines[3]);
		if (lines.length > 4)
			power.put("Top 200", lines[4]);
		if (lines.length > 5)
			power.put("Top 300 - (150 million cap)", lines[5]);
		if (lines.length > 6)
			power.put("Top 300", lines[6]);
		if (lines.length > 7)
			power.put("Top 650", lines[7]);
		return power;
	}

	private static String textFromPic(String kingdom, int rank) {
		String pathPython = PATH_OF_PYTHON_FILES + "\\text_from_pic.py";
		String[] cmd = new String[5];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = PATH_OF_PIC;
		cmd[3] = kingdom;
		cmd[4] = String.valueOf(rank);
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			System.out.println("text_from_pic.py - error");
			e.printStackTrace();
		}
		return "";
	}

	private static String powerFromPic(String kingdom, int endRank) {
		String pathPython = PATH_OF_PYTHON_FILES + "\\kingdom_power_from_pic.py";
		String[] cmd = new String[5];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = PATH_OF_PIC;
		cmd[3] = kingdom;
		cmd[4] = String.valueOf(endRank);
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			System.out.println("kingdom_power_from_pic.py - error");
			e.printStackTrace();
		}
		return "";
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
	public String pasteName() {
		// Do nothing
		return null;
	}

	@Override
	public void setGatheringType(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGameWindowName(String name) {
		// Do nothing
	}
	
	@Override
	public void setKingdom(String kingdomNumber) {
		// Do nothing
	}

}
