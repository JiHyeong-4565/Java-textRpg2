package Store;

import java.util.Scanner;

import Character.Hero;

public class WeaponStore {

	public static void enter(Hero hero) {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== ⚔ 무기 상점에 오신 것을 환영합니다 ===");
		System.out.println("보유 골드: " + hero.getMoney() + " G");
		System.out.println("사용 가능한 무기를 선택하세요:");
		System.out.println("1. 철검 (+10, Lv.1) | Warrior 전용 | 💰 100G");
		System.out.println("2. 마법봉 (+12, Lv.2) | Mage 전용 | 💰 150G");
		System.out.println("3. 활 (+8, Lv.2) | Archer 전용 | 💰 120G");
		System.out.println("4. 단검 (+9, Lv.3) | Rogue 전용 | 💰 130G");
		System.out.print("번호 입력: ");

		int choice = sc.nextInt();
		Weapon weapon = null;

		switch (choice) {
		case 1 -> weapon = new Weapon("철검", 10, "Warrior", 1, 100);
		case 2 -> weapon = new Weapon("마법봉", 12, "Mage", 2, 150);
		case 3 -> weapon = new Weapon("활", 8, "Archer", 2, 120);
		case 4 -> weapon = new Weapon("단검", 9, "Rogue", 3, 130);
		default -> {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		}

		if (!hero.getJob().equals(weapon.getRequiredJob())) {
			System.out.println("❌ 해당 무기는 " + weapon.getRequiredJob() + " 전용입니다.");
			return;
		}

		if (hero.getLevel() < weapon.getRequiredLevel()) {
			System.out.println("❌ 레벨이 부족합니다! (요구 레벨: " + weapon.getRequiredLevel() + ")");
			return;
		}

		if (hero.getMoney() < weapon.getPrice()) {
			System.out.println("💸 보유 금액이 부족합니다! (필요: " + weapon.getPrice() + "G)");
			return;
		}

		hero.deductMoney(weapon.getPrice());
		System.out.println("✅ " + weapon.getName() + "을(를) 구매하고 장착했습니다!");
		hero.equipWeapon(weapon);
	}
}
