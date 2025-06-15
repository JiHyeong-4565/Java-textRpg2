package Character;

public abstract class Monster extends Character {
	protected int experience;

	public Monster(String name, int hp, int mp, int level, int power, int defense, int experience, int money) {
		super(name, hp, mp, level, power, defense);
		this.experience = experience;
		this.money = money; // 보상 금액도 동일 필드 사용
	}

	public int getExperience() {
		return experience;
	}
}
