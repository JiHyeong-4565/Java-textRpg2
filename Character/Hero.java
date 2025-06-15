package Character;

import Store.Weapon;

public class Hero extends Character {
	private String job;
	private Weapon equippedWeapon = null;

	public Hero(String name, String job) {
		super(name, 0, 0, 1, 0, 0);
		this.job = job;
		setStatsByJob();
	}

	private void setStatsByJob() {
		switch (job) {
		case "Warrior" -> {
			hp = 250;
			mp = 30;
			power = 20;
			defense = 15;
		}
		case "Mage" -> {
			hp = 80;
			mp = 100;
			power = 25;
			defense = 5;
		}
		case "Archer" -> {
			hp = 100;
			mp = 60;
			power = 20;
			defense = 8;
		}
		case "Rogue" -> {
			hp = 110;
			mp = 40;
			power = 22;
			defense = 8;
		}
		default -> System.out.println("알 수 없는 직업입니다.");
		}
	}

	public String getJob() {
		return job;
	}

	public void showStatus() {
		System.out.println("==== Hero 상태 ====");
		System.out.println("이름: " + name + ", 직업: " + job);
		System.out.println("레벨: " + level + ", HP: " + hp + ", MP: " + mp);
		System.out.println("공격력: " + power + ", 방어력: " + defense);
		System.out.println("EXP: " + experience + "/" + (level * 100));
	}

	public void equipWeapon(Weapon weapon) {
		if (equippedWeapon != null) {
			System.out.println("[" + equippedWeapon.getName() + "]을(를) 해제하고 새로운 무기를 장착합니다.");
			this.power -= equippedWeapon.getAdditionalPower();
		}
		this.power += weapon.getAdditionalPower();
		this.equippedWeapon = weapon;
		System.out.println("[" + weapon.getName() + "] 장착 완료! 공격력 +" + weapon.getAdditionalPower());
	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void addExp(int amount) {
		this.experience += amount;
		while (this.experience >= this.level * 100) {
			this.experience -= this.level * 100;
			this.level++;
			System.out.println("🌟 레벨 업! 현재 레벨: " + this.level);
		}
	}

	private Inventory inventory = new Inventory();

	public Inventory getInventory() {
		return inventory;
	}

}