package Battle;

import java.util.Scanner;

import Character.Dragon;
import Character.Hero;
import Character.Monster;
import Character.Orc;
import Character.Racoon;
import Character.WildCat;

public class MonsterSelector {

	public static void selectAndBattle(Hero hero) {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n=== 몬스터를 선택하세요 ===");
		System.out.println("1. 라쿤 (Lv.1)");
		System.out.println("2. 들고양이 (Lv.5)");
		System.out.println("3. 오크 (Lv.10)");
		System.out.println("4. 드래곤 (Lv.20)");
		System.out.print("번호 입력: ");
		int choice = sc.nextInt();

		Monster monster;

		switch (choice) {
		case 1:
			monster = new Racoon();
			break;
		case 2:
			monster = new WildCat();
			break;
		case 3:
			monster = new Orc();
			break;
		case 4:
			monster = new Dragon();
			break;
		default:
			System.out.println("잘못된 선택입니다. 기본 몬스터(라쿤)로 설정됩니다.");
			monster = new Racoon();
		}

		System.out.println("[" + monster.getName() + "]과(와)의 전투를 시작합니다!");
		System.out.println("[Lv." + monster.getLevel() + "] " + monster.getName() + " - HP: " + monster.getHp()
				+ ", MP: " + monster.getMp() + ", 공격력: " + monster.getPower() + ", 방어력: " + monster.getDefense());

		AttackManager.attack(hero, monster);

		System.out.println("\n전투 종료! 아무 키나 입력하면 메인 메뉴로 돌아갑니다.");
		sc.nextLine(); // 버퍼 정리
		sc.nextLine(); // 대기
	}
}
