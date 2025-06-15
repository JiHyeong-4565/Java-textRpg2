package Battle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import Character.Dragon;
import Character.Hero;
import Character.Monster;

public class AttackManager {

	public static void attack(Hero hero, Monster monster) {
		Scanner sc = new Scanner(System.in);

		while (hero.getHp() > 0 && monster.getHp() > 0) {
			int level = hero.getLevel();
			int basePower = hero.getPower();
			int damage = 0;

			System.out.println("\n=== 공격 선택 ===");

			Map<Integer, String> skillNames = new LinkedHashMap<>();
			Map<Integer, Integer> skillDamage = new LinkedHashMap<>();
			Map<Integer, Integer> skillMpCost = new LinkedHashMap<>();
			int menuIndex = 1;

			switch (hero.getJob()) {
			case "Warrior":
				if (level >= 1) {
					skillNames.put(menuIndex, "강한 일격");
					skillDamage.put(menuIndex, basePower - monster.getDefense());
					skillMpCost.put(menuIndex++, 0);
				}
				if (level >= 3) {
					skillNames.put(menuIndex, "삼단 베기");
					skillDamage.put(menuIndex, (int) (basePower * 1.5) - monster.getDefense());
					skillMpCost.put(menuIndex++, 10);
				}
				if (level >= 5) {
					skillNames.put(menuIndex, "분노의 찌르기");
					skillDamage.put(menuIndex, (int) (basePower * 2.0) - monster.getDefense());
					skillMpCost.put(menuIndex++, 30);
				}
				break;

			case "Mage":
				if (level >= 1) {
					skillNames.put(menuIndex, "매직 미사일");
					skillDamage.put(menuIndex, basePower + 5 - monster.getDefense());
					skillMpCost.put(menuIndex++, 0);
				}
				if (level >= 3) {
					skillNames.put(menuIndex, "파이어볼");
					skillDamage.put(menuIndex, basePower + 15 - monster.getDefense());
					skillMpCost.put(menuIndex++, 10);
				}
				if (level >= 5) {
					skillNames.put(menuIndex, "메테오 스트라이크");
					skillDamage.put(menuIndex, basePower + 30 - monster.getDefense());
					skillMpCost.put(menuIndex++, 30);
				}
				break;

			case "Archer":
				if (level >= 1) {
					skillNames.put(menuIndex, "급소 사격");
					skillDamage.put(menuIndex, basePower - monster.getDefense());
					skillMpCost.put(menuIndex++, 0);
				}
				if (level >= 3) {
					skillNames.put(menuIndex, "연속 사격");
					skillDamage.put(menuIndex, (int) (basePower * 1.4) - monster.getDefense());
					skillMpCost.put(menuIndex++, 10);
				}
				if (level >= 5) {
					skillNames.put(menuIndex, "관통 화살");
					skillDamage.put(menuIndex, (int) (basePower * 1.8) - monster.getDefense());
					skillMpCost.put(menuIndex++, 30);
				}
				break;

			case "Rogue":
				if (level >= 1) {
					skillNames.put(menuIndex, "날렵한 베기");
					skillDamage.put(menuIndex, basePower - monster.getDefense());
					skillMpCost.put(menuIndex++, 0);
				}
				if (level >= 3) {
					skillNames.put(menuIndex, "그림자 일격");
					skillDamage.put(menuIndex, (int) (basePower * 1.6) - monster.getDefense());
					skillMpCost.put(menuIndex++, 10);
				}
				if (level >= 5) {
					skillNames.put(menuIndex, "연속 찌르기");
					skillDamage.put(menuIndex, (int) (basePower * 2.1) - monster.getDefense());
					skillMpCost.put(menuIndex++, 30);
				}
				break;
			}

			for (Map.Entry<Integer, String> entry : skillNames.entrySet()) {
				System.out.println(entry.getKey() + ". " + entry.getValue());
			}

			System.out.print("공격 번호를 선택하세요: ");
			int choice = sc.nextInt();

			if (!skillDamage.containsKey(choice)) {
				System.out.println("잘못된 선택입니다. 기본 공격으로 진행합니다.");
				damage = basePower - monster.getDefense();
			} else {
				int cost = skillMpCost.get(choice);
				if (hero.getMp() < cost) {
					System.out.println("❌ MP가 부족하여 스킬을 사용할 수 없습니다. 기본 공격으로 전환합니다.");
					damage = basePower - monster.getDefense();
				} else {
					hero.setMp(hero.getMp() - cost);
					damage = skillDamage.get(choice);
					System.out.println("🔋 MP " + cost + " 소모. 현재 MP: " + hero.getMp());

					String skillName = skillNames.get(choice);
					String monsterName = monster.getName();

					if (monster instanceof Dragon && hero.getJob().equals("Mage")) {
						System.out.println("드래곤은 마법에 약하다! 피해 1.5배!");
						damage *= 1.5;
					}

					if (hero.getJob().equals("Mage")) {
						damage *= 1.3;
					}

					if (monsterName.equals("라쿤") && skillName.equals("급소 사격")) {
						System.out.println("🎯 라쿤은 급소 사격에 약하다! 피해 1.5배!");
						damage *= 1.5;
					}

					if (monsterName.equals("솰쾡이") && skillName.equals("날렵한 베기")) {
						System.out.println("🐈 솰쾡이는 날렵한 베기에 약하다! 피해 1.5배!");
						damage *= 1.5;
					}

					if (monsterName.equals("오크") && skillName.equals("삼단 베기")) {
						System.out.println("🪓 오크는 삼단 베기에 약하다! 피해 1.5배!");
						damage *= 1.5;
					}
				}
			}

			damage = Math.max(0, damage);

			if (hero.getJob().equals("Archer")) {
				double doubleChance = Math.random();
				if (doubleChance < 0.3) {
					System.out.println("🎯 Archer는 두 번 연속 공격합니다!");
					monster.setHp(monster.getHp() - damage);
					System.out.println("첫 번째 공격 피해: " + damage);
					monster.setHp(monster.getHp() - damage);
					System.out.println("두 번째 공격 피해: " + damage);
				} else {
					monster.setHp(monster.getHp() - damage);
					System.out.println("[" + monster.getName() + "]에게 " + damage + "의 피해를 입혔습니다.");
				}
			} else {
				monster.setHp(monster.getHp() - damage);
				System.out.println("[" + monster.getName() + "]에게 " + damage + "의 피해를 입혔습니다.");
			}

			if (monster.getHp() <= 0) {
				System.out.println("\n=============================");
				System.out.println("🎉 " + monster.getName() + "을(를) 처치했습니다!");
				System.out.println("📈 경험치 +" + monster.getExperience() + " 획득!");
				hero.addMoney(monster.getMoney());
				hero.addExp(monster.getExperience());
				hero.recordMonsterKill(monster.getName());
				System.out.println("=============================\n");
				break;
			}

			if (hero.getJob().equals("Rogue")) {
				double evadeChance = Math.random();
				if (evadeChance < 0.3) {
					System.out.println("🌀 Rogue가 반격을 회피했습니다!");
					continue;
				}
			}

			boolean WarriorGuardSuccess = false;
			if (hero.getJob().equals("Warrior")) {
				double guardChance = Math.random();
				if (guardChance < 0.6) {
					System.out.println("🛡 Warrior는 가드에 성공했습니다! (받는 피해 절반)");
					WarriorGuardSuccess = true;
				}
			}

			int counterDamage = monster.getPower() - hero.getDefense();
			counterDamage = Math.max(0, counterDamage);
			if (WarriorGuardSuccess) {
				counterDamage /= 2;
			}

			hero.setHp(hero.getHp() - counterDamage);
			System.out.println("💥 " + monster.getName() + "의 반격! " + counterDamage + " 피해를 입었습니다.");
			System.out.println("⚔️ [Hero HP: " + hero.getHp() + " / Monster HP: " + monster.getHp() + "]");

			if (hero.getHp() <= 0) {
				System.out.println("\n=============================");
				System.out.println("💀 당신은 쓰러졌습니다...");
				System.out.println("=============================\n");
				break;
			}
		}
	}
}
