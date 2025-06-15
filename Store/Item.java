package Store;

import Character.Hero;

public class Item {
	private String name;
	private String effectType; // "HP", "MP", "POWER", "DEFENSE"
	private int effectValue;

	public Item(String name, String effectType, int effectValue) {
		this.name = name;
		this.effectType = effectType.toUpperCase(); // 일관성을 위해 대문자로 변환
		this.effectValue = effectValue;
	}

	public String getName() {
		return name;
	}

	public void applyEffect(Hero hero) {
		switch (effectType) {
		case "HP" -> {
			hero.setHp(hero.getHp() + effectValue);
			System.out.println("❤️ HP가 " + effectValue + "만큼 회복되었습니다!");
		}
		case "MP" -> {
			hero.setMp(hero.getMp() + effectValue);
			System.out.println("💧 MP가 " + effectValue + "만큼 회복되었습니다!");
		}
		case "POWER" -> {
			hero.setPower(hero.getPower() + effectValue);
			System.out.println("⚔️ 공격력이 " + effectValue + "만큼 증가했습니다!");
		}
		case "DEFENSE" -> {
			hero.setDefense(hero.getDefense() + effectValue);
			System.out.println("🛡️ 방어력이 " + effectValue + "만큼 증가했습니다!");
		}
		default -> {
			System.out.println("❌ 알 수 없는 아이템 효과입니다: " + effectType);
		}
		}
	}
}
