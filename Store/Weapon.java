// Weapon.java
package Store;

public class Weapon {
	private String name;
	private int additionalPower;
	private String requiredJob;
	private int requiredLevel;
	private int price; // 💰 추가된 필드

	public Weapon(String name, int additionalPower, String requiredJob, int requiredLevel, int price) {
		this.name = name;
		this.additionalPower = additionalPower;
		this.requiredJob = requiredJob;
		this.requiredLevel = requiredLevel;
		this.price = price; // 💰 가격 초기화
	}

	public String getName() {
		return name;
	}

	public int getAdditionalPower() {
		return additionalPower;
	}

	public String getRequiredJob() {
		return requiredJob;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public int getPrice() {
		return price;
	}
}
