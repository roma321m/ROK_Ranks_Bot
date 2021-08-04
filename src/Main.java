import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import model.Kingdom;
import model.Player;
import model.WriteDataToExcel;

public class Main {
	public static final String PATH_OF_PIC = "E:\\rok bot data";
	public static final String PATH_OF_PYTHON_FILES = "C:\\Users\\Roman Michailov\\OneDrive\\ROK Ranks Bot\\ROK_Ranks_Bot\\src\\python";
	public static final String WINDOW_NAME = "BlueStacks 2";
	public static final String SCREENSHOT_1 = "1", SCREENSHOT_2 = "2";
	public static final String BARBS_PIC = "barbs_snap", DEAD_PIC = "dead_snap", HELP_PIC = "helps_snap",
			ID_PIC = "id_snap", NAME_PIC = "name_snap", POWER_PIC = "power_snap", RSS_A_PIC = "rss_a_snap",
			RSS_G_PIC = "rss_g_snap", T1_PIC = "t1_snap", T2_PIC = "t2_snap", T3_PIC = "t3_snap", T4_PIC = "t4_snap",
			T5_PIC = "t5_snap";

	public static void main(String[] args) {
		final int KINGDOM_NUMBER = 1254;

		Kingdom kingdom = new Kingdom(KINGDOM_NUMBER);

		String kingdomNumber = kingdomNumber(kingdom);
		/**
		createDirForKingdomExcel(kingdom);
		
		createDirForPowerOnly(kingdom);

		kingdom.setPower(convertToPower(kingdomNumber, 300));

		try {
			WriteDataToExcel.writePowerDataToExcel(
					PATH_OF_PIC + "\\Excel files\\" + kingdom.getNumber() + "\\Power - " + kingdom.getNumber() + " " + kingdom.getDate() + ".xlsx", kingdom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		createDirForAllStats(kingdom);

		for (int rank = 1; rank < 301; rank++) {
			kingdom.addPlayer(convertToObj(kingdomNumber, rank));
		}

		try {
			WriteDataToExcel.writeDataToExcel(
					PATH_OF_PIC + "\\Excel files\\" + kingdom.getNumber() + "\\" +  kingdom.getNumber() + " " + kingdom.getDate() + ".xlsx", kingdom);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(kingdom);
		**/
	}

	public static String kingdomNumber(Kingdom kingdom) {
		return "k" + kingdom.getNumber() + "  " + kingdom.getDate();
	}

	public static void createDirForAllStats(Kingdom kingdom) {
		String path = PATH_OF_PIC + "\\" + kingdomNumber(kingdom);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
			for (int i = 1; i <= 650; i++) {
				File f = new File(path + "\\" + i);
				f.mkdir();
			}
		}
	}

	public static void createDirForPowerOnly(Kingdom kingdom) {
		String path = PATH_OF_PIC + "\\Power - " + kingdomNumber(kingdom);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	public static void createDirForKingdomExcel(Kingdom kingdom) {
		String path = PATH_OF_PIC + "\\Excel files\\" + kingdom.getNumber();
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static void takeSS(String kingdom, int rank, String imgName) {
		String pathPython = PATH_OF_PYTHON_FILES + "\\take_ss.py";
		String[] cmd = new String[7];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = WINDOW_NAME;
		cmd[3] = PATH_OF_PIC;
		cmd[4] = kingdom;
		cmd[5] = String.valueOf(rank);
		cmd[6] = imgName;
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			System.out.println("take_ss.py - running");
		} catch (IOException e) {
			System.out.println("take_ss.py - error");
			e.printStackTrace();
		}
	}

	public static void cropSS1(String kingdom, int rank, String imgName) {
		String pathPython = PATH_OF_PYTHON_FILES + "\\crop_ss_1.py";
		String[] cmd = new String[6];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = PATH_OF_PIC;
		cmd[3] = kingdom;
		cmd[4] = String.valueOf(rank);
		cmd[5] = imgName;
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			System.out.println("crop_ss_1.py - running");
		} catch (IOException e) {
			System.out.println("crop_ss_1.py - error");
			e.printStackTrace();
		}
	}

	public static void cropSS2(String kingdom, int rank, String imgName) {
		String pathPython = PATH_OF_PYTHON_FILES + "\\crop_ss_2.py";
		String[] cmd = new String[6];
		cmd[0] = "python";
		cmd[1] = pathPython;
		cmd[2] = PATH_OF_PIC;
		cmd[3] = kingdom;
		cmd[4] = String.valueOf(rank);
		cmd[5] = imgName;
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd);
			System.out.println("crop_ss_2.py - running");
		} catch (IOException e) {
			System.out.println("crop_ss_2.py - error");
			e.printStackTrace();
		}
	}

	public static Player convertToObj(String kingdom, int rank) {
		Player p = new Player();
		String name = "";
		try (FileInputStream fis = new FileInputStream(
				new File(PATH_OF_PIC + "\\" + kingdom + "\\" + rank + "\\playerName.txt"));
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

		String str = textFromPic(kingdom, rank);
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

	public static Map<String, String> convertToPower(String kingdom, int endRank) {
		Map<String, String> power = new LinkedHashMap<String, String>();
		String str = powerFromPic(kingdom, endRank);
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

	public static String textFromPic(String kingdom, int rank) {
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

	public static String powerFromPic(String kingdom, int endRank) {
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

	public static String pasteName() {
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

}
