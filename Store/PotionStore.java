package Store;

import java.util.Scanner;

import Character.Hero;

public class PotionStore {
	private Scanner sc = new Scanner(System.in);

	public void enter(Hero hero) {
		while (true) {
			System.out.println("\n=== 🧪 포션 상점에 오신 것을 환영합니다 ===");
			System.out.println("보유 골드: " + hero.getMoney() + "G");
			System.out.println("1. 작은 회복 포션 (+50 HP) - 20G");
			System.out.println("2. 마나 포션 (+30 MP) - 20G");
			System.out.println("3. 힘의 정수 (+10 POWER) - 40G");
			System.out.println("4. 방어의 정수 (+10 DEFENSE) - 40G");
			System.out.println("0. 나가기");
			System.out.print("원하는 번호를 선택하세요: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 -> purchase(hero, new Item("작은 회복 포션", "HP", 50), 20);
			case 2 -> purchase(hero, new Item("마나 포션", "MP", 30), 20);
			case 3 -> purchase(hero, new Item("힘의 정수", "POWER", 10), 40);
			case 4 -> purchase(hero, new Item("방어의 정수", "DEFENSE", 10), 40);
			case 0 -> {
				System.out.println("🏪 포션 상점에서 나갑니다.");
				return;
			}
			default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	private void purchase(Hero hero, Item item, int price) {
		if (hero.getMoney() >= price) {
			hero.deductMoney(price);
			hero.getInventory().addItem(item);
			System.out.println("✅ [" + item.getName() + "]를 " + price + "G에 구매하여 인벤토리에 추가했습니다.");
		} else {
			System.out.println("❌ 골드가 부족하여 구매할 수 없습니다.");
		}
	}
}
