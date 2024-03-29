package PG;

import java.util.Arrays;
import java.util.Map;

public class Soulition_programmers_level1_실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

		int[] answer = new int[N];
		int[] stageCount = new int[N];
		Map<Integer, Double> failPercent = new HashMap<>();
		int total = stages.length;

		for (int i = 0; i < stages.length; i++) {
			if (stages[i] == N + 1)
				continue;
			stageCount[stages[i] - 1]++;
		}

		for (int i = 0; i < stageCount.length; i++) {
			if (total == 0) {
				failPercent.put(i, 0d);
				continue;
			}
			failPercent.put(i, (double) stageCount[i] / (double) total);
			total -= stageCount[i];
		}

		for (int i = 0; i < N; i++) {
			double max = -1;
			int maxKey = 0;

			for (int key : failPercent.keySet()) 
				if (max < failPercent.get(key)) {
					max = failPercent.get(key);
					maxKey = key;
				}

			answer[i] = maxKey + 1;
			failPercent.remove(maxKey);
		}
	}

}