package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class Kingdom {

	private int number;
	private Date date;
	private SimpleDateFormat formatter;
	private ArrayList<Player> players;
	private Map<String, String> power;

	public Kingdom(int number) {
		setNumber(number);
		setFormatter();
		setDate();
		setPlayers();
		setPower(null);
	}
	
	public void sortPlayersByPower() {
		Collections.sort(players, Player.PlayerPowerComparator);
	}
	
	public void sortPlayersListByT4Kills() {
		Collections.sort(players, Player.PlayerT4KillsComparator);
	}
	
	public void sortPlayersListByT5Kills() {
		Collections.sort(players, Player.PlayerT5KillsComparator);
	}
	
	public void sortPlayersListBydeads() {
		Collections.sort(players, Player.PlayerDeadsComparator);
	}
	
	public void sortPlayersListByKillPoints() {
		Collections.sort(players, Player.PlayerKillPointsComparator);
	}

	public void setPower(Map<String, String> power) {
		this.power = power;
	}

	public void addPlayer(Player p) {
		if (p != null) {
			players.add(p);
		}
	}
	
	public Map<String, String> getPower(){
		return power;
	}

	public int getNumber() {
		return number;
	}
	
	public String getKingdomPath() {
		return "k" + number + "  " + getDate();
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
