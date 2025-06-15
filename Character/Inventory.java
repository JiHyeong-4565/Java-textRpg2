package Character;

import java.util.ArrayList;

import Store.Item;

public class Inventory {
	private ArrayList<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
		System.out.println("📦 [" + item.getName() + "]을(를) 인벤토리에 추가했습니다.");
	}

	public void showItems() {
		if (items.isEmpty()) {
			System.out.println("📭 인벤토리가 비어있습니다.");
			return;
		}

		System.out.println("🎒 인벤토리:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i).getName());
		}
	}

	public void useItem(int index, Hero hero) {
		if (index < 1 || index > items.size()) {
			System.out.println("❌ 잘못된 선택입니다.");
			return;
		}
		Item selected = items.remove(index - 1);
		selected.applyEffect(hero);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}
}
