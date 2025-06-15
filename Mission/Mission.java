package Mission;

import Character.Hero;
import Store.Weapon;

public class Mission {
	private String title;
	private String description;
	private boolean isCompleted;
	private String reward;

	// ✅ 추가: 특정 몬스터 관련 필드
	private String targetMonster;
	private int requiredCount;

	public Mission(String title, String description, String reward) {
		this.title = title;
		this.description = description;
		this.reward = reward;
		this.isCompleted = false;
		this.targetMonster = null;
		this.requiredCount = 0;
	}

	// ✅ 몬스터 처치 미션용 생성자
	public Mission(String title, String description, String reward, String targetMonster, int requiredCount) {
		this.title = title;
		this.description = description;
		this.reward = reward;
		this.isCompleted = false;
		this.targetMonster = targetMonster;
		this.requiredCount = requiredCount;
	}

	public void complete() {
		this.isCompleted = true;
		System.out.println("미션 완료! 보상: " + reward);
	}

	public void complete(Hero hero) {
		this.isCompleted = true;
		System.out.println("✅ 미션 완료! 보상: " + reward);

		if (reward.contains("경험치")) {
			System.out.println("📈 경험치를 획득했습니다.");
			hero.addExp(100);
		}
		if (reward.contains("골드")) {
			System.out.println("💰 골드를 획득했습니다!");
			hero.addMoney(100);
		}
		if (reward.contains("전설 무기")) {
			System.out.println("🔥 전설 무기를 지급받았습니다!");
			String job = hero.getJob();
			Weapon legendaryWeapon = null;

			switch (job) {
			case "Warrior" -> legendaryWeapon = new Weapon("전설의 검", 30, "Warrior", hero.getLevel(), 0);
			case "Mage" -> legendaryWeapon = new Weapon("전설의 지팡이", 35, "Mage", hero.getLevel(), 0);
			case "Archer" -> legendaryWeapon = new Weapon("전설의 활", 28, "Archer", hero.getLevel(), 0);
			case "Rogue" -> legendaryWeapon = new Weapon("전설의 단검", 32, "Rogue", hero.getLevel(), 0);
			}

			if (legendaryWeapon != null) {
				System.out.println("🛡️ [" + legendaryWeapon.getName() + "]이(가) 자동으로 장착되었습니다!");
				hero.equipWeapon(legendaryWeapon);
			}
		}
	}

	public void showMission() {
		System.out.println("=== [미션] ===");
		System.out.println("제목: " + title);
		System.out.println("설명: " + description);
		System.out.println("보상: " + reward);
		if (targetMonster != null) {
			System.out.println("목표 몬스터: " + targetMonster + " " + requiredCount + "마리 처치");
		}
		System.out.println("상태: " + (isCompleted ? "완료됨" : "진행 중"));
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getReward() {
		return reward;
	}

	// ✅ 추가된 getter
	public String getTargetMonster() {
		return targetMonster;
	}

	public int getRequiredCount() {
		return requiredCount;
	}
}
