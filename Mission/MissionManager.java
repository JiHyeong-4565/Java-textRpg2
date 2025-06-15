package Mission;

import Character.Hero;

public class MissionManager {

	public static Mission checkLevelAndGiveMission(Hero hero) {
		int level = hero.getLevel();
		String job = hero.getJob();

		if (level == 3) {
			return new Mission("Lv3 승급 미션", "진정한 실력을 입증하기 솰쾡이 1마리를 처치하시오.", "경험치 +100", "솰쾡이", 1 // requiredCount
			);
		} else if (level == 5) {
			return new Mission("Lv5 특별 미션", "전설의 무기를 찾아라! " + job + " 전용 무기를 장착하면 완료.", "전설 무기 지급");
		}

		return null; // 미션 없음
	}
}
