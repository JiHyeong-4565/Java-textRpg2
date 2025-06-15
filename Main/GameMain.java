package Main;

import java.util.Scanner;

import Battle.MonsterSelector;
import Character.Hero;
import Store.PotionStore;
import Store.WeaponStore;

public class GameMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 상점 객체 생성
		PotionStore potionStore = new PotionStore();
		WeaponStore weaponStore = new WeaponStore();

		System.out.println("=== 🎮 RPG 게임에 오신 것을 환영합니다 ===");
		System.out.print("당신의 이름을 입력하세요: ");
		String name = sc.nextLine();

		System.out.println("\n직업을 선택하세요:");
		System.out.println("1. Warrior(특성:중간확률 가드)");
		System.out.println("2. Mage(특성:데미지 1.3배)");
		System.out.println("3. Archer(특성:낮은 확률 연속 공격)");
		System.out.println("4. Rogue(특성:낮은 확률 회피)");
		System.out.print("번호 입력: ");
		int jobChoice = sc.nextInt();

		String job = switch (jobChoice) {
		case 1 -> "Warrior";
		case 2 -> "Mage";
		case 3 -> "Archer";
		case 4 -> "Rogue";
		default -> "Warrior";
		};

		Hero hero = new Hero(name, job);
		hero.showStatus();

		while (true) {
			System.out.println("\n===== [메인 메뉴] =====");
			System.out.println("1. 사냥터 입장");
			System.out.println("2. 무기 상점");
			System.out.println("3. 포션 상점");
			System.out.println("4. 상태 보기");
			System.out.println("5. 인벤토리 사용");
			System.out.println("0. 게임 종료");
			System.out.print("원하는 행동을 선택하세요: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1 -> MonsterSelector.selectAndBattle(hero);
			case 2 -> weaponStore.enter(hero);
			case 3 -> potionStore.enter(hero);
			case 4 -> hero.showStatus();
			case 5 -> {
				hero.getInventory().showItems();
				if (!hero.getInventory().isEmpty()) {
					System.out.print("사용할 아이템 번호를 입력하세요: ");
					int itemChoice = sc.nextInt();
					hero.getInventory().useItem(itemChoice, hero);
				}
			}
			case 0 -> {
				System.out.println("게임을 종료합니다. 감사합니다!");
				return;
			}
			default -> System.out.println("잘못된 입력입니다.");
			}

			if (hero.getHp() <= 0) {
				System.out.println("😵 당신은 사망했습니다. 게임을 종료합니다.");
				break;
			}
		}
	}
}
