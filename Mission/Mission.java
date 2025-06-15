package Mission;

public class Mission {
	private String title;
	private String description;
	private boolean isCompleted;
	private String reward;

	public Mission(String title, String description, String reward) {
		this.title = title;
		this.description = description;
		this.reward = reward;
		this.isCompleted = false;
	}

	public void complete() {
		this.isCompleted = true;
		System.out.println("미션 완료! 보상: " + reward);
	}

	public void showMission() {
		System.out.println("=== [미션] ===");
		System.out.println("제목: " + title);
		System.out.println("설명: " + description);
		System.out.println("보상: " + reward);
		System.out.println("상태: " + (isCompleted ? "완료됨" : "진행 중"));
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getReward() {
		return reward;
	}
}
