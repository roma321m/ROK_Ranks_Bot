package model;

public class Player {

	private String name;
	private long id, power, killPoints, t1, t2, t3, t4, t5, deaths, rss_a, rss_g, helps, barbs;

	public Player() {
		setId("0");
		setName("");
		setPower("0");
		setT1("0");
		setT2("0");
		setT3("0");
		setT4("0");
		setT5("0");
		setKillPoints();
		setDeaths("0");
		setRss_a("0");
		setRss_g("0");
		setHelps("0");
		setBarbs("0");
	}

	private long strToInt(String str) {
		char[] strArray = str.toCharArray();
		char[] strDigits = new char[10];
		for (int i = 0; i < 10; i++) {
			strDigits[i] = (char) (i + '0');
		}
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			for (char c : strDigits) {
				if (strArray[i] == c) {
					res.append(c);
					break;
				}
			}
		}
		if (res.length() != 0)
			return Long.parseLong(res.toString());
		return 0;
	}

	public void setBarbs(String barbs) {
		if (barbs.length() != 0) {
			this.barbs = strToInt(barbs);
		} else
			this.barbs = 0;
	}

	public long getBarbs() {
		return barbs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(String id) {
		if (id.length() != 0) {
			this.id = strToInt(id);
		} else
			this.id = 0;
	}

	public long getPower() {
		return power;
	}

	public void setPower(String power) {
		if (power.length() != 0) {
			this.power = strToInt(power);
		} else
			this.power = 0;
	}

	public long getKillPoints() {
		return killPoints;
	}

	public void setKillPoints() {
		this.killPoints = (long) (t1 * 0.2) + t2 * 2 + t3 * 4 + t4 * 10 + t5 * 20;
	}

	public long getT1() {
		return t1;
	}

	public void setT1(String t1) {
		if (t1.length() != 0) {
			this.t1 = strToInt(t1);
		} else
			this.t1 = 0;
		setKillPoints();
	}

	public long getT2() {
		return t2;
	}

	public void setT2(String t2) {
		if (t2.length() != 0) {
			this.t2 = strToInt(t2);
		} else
			this.t2 = 0;
		setKillPoints();
	}

	public long getT3() {
		return t3;
	}

	public void setT3(String t3) {
		if (t3.length() != 0) {
			this.t3 = strToInt(t3);
		} else
			this.t3 = 0;
		setKillPoints();
	}

	public long getT4() {
		return t4;
	}

	public void setT4(String t4) {
		if (t4.length() != 0) {
			this.t4 = strToInt(t4);
		} else
			this.t4 = 0;
		setKillPoints();
	}

	public long getT5() {
		return t5;
	}

	public void setT5(String t5) {
		if (t5.length() != 0) {
			this.t5 = strToInt(t5);
		} else
			this.t5 = 0;
		setKillPoints();
	}

	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(String deaths) {
		if (deaths.length() != 0) {
			this.deaths = strToInt(deaths);
		} else
			this.deaths = 0;
	}

	public long getRss_a() {
		return rss_a;
	}

	public void setRss_a(String rss_a) {
		if (rss_a != null && rss_a.length() != 0) {
			this.rss_a = strToInt(rss_a);
		} else
			this.rss_a = 0;
	}

	public long getRss_g() {
		return rss_g;
	}

	public void setRss_g(String rss_g) {
		if (rss_g != null && rss_g.length() != 0) {
			this.rss_g = strToInt(rss_g);
		} else
			this.rss_g = 0;
	}

	public long getHelps() {
		return helps;
	}

	public void setHelps(String helps) {
		if (helps.length() != 0) {
			this.helps = strToInt(helps);
		} else
			this.helps = 0;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n------------------------------\n");
		sb.append("Gov ID: ");
		sb.append(id);
		sb.append("\nName: ");
		sb.append(name);
		sb.append("\nPower: ");
		sb.append(power);
		sb.append("\nTotal Deaths: ");
		sb.append(deaths);
		sb.append("\nKill Points: ");
		sb.append(killPoints);
		sb.append("\nT1= ");
		sb.append(t1);
		sb.append("\nT2= ");
		sb.append(t2);
		sb.append("\nT3= ");
		sb.append(t3);
		sb.append("\nT4= ");
		sb.append(t4);
		sb.append("\nT5= ");
		sb.append(t5);
		sb.append("\nBarbs: ");
		sb.append(barbs);
		sb.append("\nResource gathered: ");
		sb.append(rss_g);
		sb.append("\nResource assistance: ");
		sb.append(rss_a);
		sb.append("\nHelps: ");
		sb.append(helps);
		sb.append("\n------------------------------\n");

		return sb.toString();
	}
}
