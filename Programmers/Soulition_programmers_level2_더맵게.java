package PG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Soulition_programmers_level2_더맵게 {

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;

		//////////
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue();

		for (int aScoville : scoville) {
			heap.offer(aScoville);
		}

		while (heap.peek() <= K) {
			if (heap.size() == 1) {
				answer=-1;
				break;
			}
			int a = heap.poll();
			int b = heap.poll();

			int result = a + (b * 2);

			heap.offer(result);
			answer++;
		}
		System.out.println(answer);
	}

}
