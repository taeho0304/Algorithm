package Algorithm;

import java.util.*;

public class Soulition_programmers_level2_다리를지나는트럭 {
	
	/*문제 설명
	트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
	모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
	트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
	※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

	예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 
	무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.*/
	
	
	public static void main(String[] args) {
		
		int bridge_length = 2; // 다리길이
		int weight = 10; // 다리가 견딜 수 있는 무게
		int[] truck_weights = { 7, 4, 5, 6 };//트럭별 무게
		
		/////////////////////////////////////////////////////
		
		int answer=0, cur=0;
		Queue<Integer> onBridge = new LinkedList<Integer>();
		int endTime[]= new int[truck_weights.length];
		
		while(true) {
			if(!onBridge.isEmpty() && endTime[onBridge.peek()]==answer) {// 다리를 지난 트럭 제거
				weight+=truck_weights[onBridge.poll()];
			}
			
			if( cur<truck_weights.length &&truck_weights[cur]<=weight ) {// 다리에 트럭 추가
				onBridge.add(cur);
				endTime[cur]=answer+ bridge_length;
				weight-=truck_weights[cur];
				cur++;
			}
			answer++;
			if(onBridge.isEmpty()) break;
		}
		System.out.println(answer);
	}
}
