package HomeWork10_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DoubleCola {

	public static void main(String[] args) {
		String[] friends = { "Sheldon", "Leonard", "Volovitc", "Kutrapalli", "Penny" };
		Queue<String> queue = new LinkedList<>(Arrays.asList(friends));
		System.out.println(queue);

		// Bottles of DoubleCola
		int bottles = 5;

		for (int i = 0; i < bottles; i++) {
			String tmp = queue.poll();
			queue.add(tmp);
			queue.add(tmp);
			System.out.format("After %d bottles of DoubleCola, queue looks like: %n%s%n", i + 1, queue);
		}

	}

}
