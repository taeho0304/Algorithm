package PG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_LV2_소수만들기_배태호_solved {

	public static void main(String[] args) {
		int answer = 0;
		int[] nums = { 1, 2, 3, 4 };

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i + 2 >= nums.length)
				break;
			for (int j = i + 1; j < nums.length; j++) {
				for (int h = j + 1; h < nums.length; h++) {
					list.add(nums[i] + nums[j] + nums[h]);
				}
			}
		}

		for (Integer i : list) {
			int count = 2;
			answer++;
			while (count < i) {
				if (i % count == 0) {
					answer--;
					break;
				}
				count++;
			}
		}
		System.out.println(answer);
	}

}