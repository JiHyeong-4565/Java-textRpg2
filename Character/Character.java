package Character;

public abstract class Character {
	protected String name;
	protected int hp;
	protected int mp;
	protected int level;
	protected int power;
	protected int defense;
	protected int money;
	protected int experience;

	public Character(String name, int hp, int mp, int level, int power, int defense) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.level = level;
		this.power = power;
		this.defense = defense;
		this.money = 0;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getLevel() {
		return level;
	}

	public int getPower() {
		return power;
	}

	public int getDefense() {
		return defense;
	}

	public int getMoney() {
		return money;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int amount) {
		this.money += amount;
	}

	public void deductMoney(int amount) {
		this.money -= amount;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
