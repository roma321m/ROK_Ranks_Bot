package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Kingdom {

	private int number;
	private Date date;
	private SimpleDateFormat formatter;
	private ArrayList<Player> players;

	public Kingdom(int number) {
		setNumber(number);
		setFormatter();
		setDate();
		setPlayers();
	}

	public void addPlayer(Player p) {
		if (p != null) {
			players.add(p);
		}
	}

	public int getNumber() {
		return number;
	}

	private void setNumber(int number) {
		this.number = number;
	}

	public String getDate() {
		return formatter.format(date);
	}

	private void setDate() {
		this.date = new Date();
	}

	private void setFormatter() {
		this.formatter = new SimpleDateFormat("dd-MM-yyyy");
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	private void setPlayers() {
		this.players = new ArrayList<Player>();
	}

	@Override
	public String toString() {
		return "Kingdom: " + number + ", Date of gathering: " + formatter.format(date) + "\n\n" + players;
	}
}
