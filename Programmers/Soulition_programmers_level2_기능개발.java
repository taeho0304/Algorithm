package programmers;

import java.util.*;

public class Soulition_programmers_level2_기능개발 {

	public static void main(String[] args) {

		int bridge_length = 2; // 다리길이
		int weight = 10; // 다리가 견딜 수 있는 무게
		int[] truck_weights = { 7, 4, 5, 6 };// 트럭별 무게

		/////////////////////////////////////////////////////

		int answer = 0, cur = 0;
		Queue<Integer> onBridge = new LinkedList<Integer>();
		int endTime[] = new int[truck_weights.length];

		while (true) {
			if (!onBridge.isEmpty() && endTime[onBridge.peek()] == answer) {// 다리를 지난 트럭 제거
				weight += truck_weights[onBridge.poll()];
			}

			if (cur < truck_weights.length && truck_weights[cur] <= weight) {// 다리에 트럭 추가
				onBridge.add(cur);
				endTime[cur] = answer + bridge_length;
				weight -= truck_weights[cur];
				cur++;
			}
			answer++;
			if (onBridge.isEmpty())
				break;
		}
		System.out.println(answer);
	}
}
