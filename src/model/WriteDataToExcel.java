package model;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {

	// any exceptions need to be caught
	public static void writeDataToExcel(String filePath, Kingdom kingdom) throws Exception {
		// workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet = workbook.createSheet(kingdom.getDate());

		// creating a row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<String, Object[]> playersData = new TreeMap<String, Object[]>();

		playersData.put("1", new Object[] { "ID", "Name", "Power", "Deads", "Kill Points", "T5 kills", "T4 kills",
				"T3 kills", "T2 kills", "T1 kills", "Helps", "Rss a", "Rss g", "Barbs" });

		int count = 1;
		for (Player p : kingdom.getPlayers()) {
			count++;
			playersData.put("" + count,
					new Object[] { "" + p.getId(), p.getName(), "" + p.getPower(), "" + p.getDeaths(),
							"" + p.getKillPoints(), "" + p.getT5(), "" + p.getT4(), "" + p.getT3(), "" + p.getT2(),
							"" + p.getT1(), "" + p.getHelps(), "" + p.getRss_a(), "" + p.getRss_g(),
							"" + p.getBarbs() });
		}

		Set<String> keyid = playersData.keySet();

		int rowid = 0;

		// writing the data into the sheets...

		for (String key : keyid) {

			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = playersData.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}

		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		FileOutputStream out = new FileOutputStream(new File(filePath));

		workbook.write(out);
		out.close();
	}

	// any exceptions need to be caught
	public static void writePowerDataToExcel(String filePath, Kingdom kingdom) throws Exception {
		// workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();

		// spreadsheet object
		XSSFSheet spreadsheet = workbook.createSheet("Power - " + kingdom.getDate());

		// creating a row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<String, String> powerData = new LinkedHashMap<String, String>();
		powerData.put("Type", "Power");
		powerData.putAll(kingdom.getPower());

		Set<String> keyid = powerData.keySet();

		int rowid = 0;

		// writing the data into the sheets...

		for (String key : keyid) {

			row = spreadsheet.createRow(rowid++);
			String str = powerData.get(key);
			int cellid = 0;

			Cell cell1 = row.createCell(cellid++);
			cell1.setCellValue(key);
			Cell cell2 = row.createCell(cellid++);
			cell2.setCellValue(str);
		}

		// .xlsx is the format for Excel Sheets...
		// writing the workbook into the file...
		FileOutputStream out = new FileOutputStream(new File(filePath));

		workbook.write(out);
		out.close();
	}
}
