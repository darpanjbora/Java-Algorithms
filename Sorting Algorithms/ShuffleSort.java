import java.util.Arrays;
import java.util.Random;

public class ShuffleSort {

	private Random random = new Random();

	public void sort(int[] list) {
		while (!isSorted(list))
			shuffle(list);
	}

	private void shuffle(int[] list) {
		for (int i = list.length - 1; i > 0; i--) {
			int randomIndex = random.nextInt(i);

			int temp = list[i];
			list[i] = list[randomIndex];
			list[randomIndex] = temp;
		}
	}

	private boolean isSorted(int[] list) {
		Integer prev = null;
		for (Integer elem : list) {
			if (prev != null && prev.compareTo(elem) > 0) return false;
			prev = elem;
		}

		return true;
	}

	public static void main(String[] args) {

		int[] list = { 33, 0, 29, 4, 44, 3 };

		ShuffleSort shuffleSort = new ShuffleSort();
		shuffleSort.sort(list);

		System.out.println("Sorted list:");
		System.out.println(Arrays.toString(list));
	}
}