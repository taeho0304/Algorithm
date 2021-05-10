package com.ssafy.algo;

import java.util.Scanner;

public class Solution_BOJ_34040_백설공주와일곱난쟁이 {

	static int num[];
	private static boolean[] isSelected;
	private static boolean answer=false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = new int[9];
		isSelected = new boolean[9];
		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
		}

		dfs(0);
	}

	private static void dfs(int cnt) {
		if( answer==true) return;
		if (cnt == 7) {
			int count = 0;
			for (int i = 0; i < 9; i++)
				if (isSelected[i]==true) 
					count += num[i];

			if (count == 100) {
				for (int i = 0; i < 9; i++)
					if (isSelected[i])
						System.out.println(num[i]);
				answer=true;
			}
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			dfs(cnt+1);
			isSelected[i] =false;
		}
	}

}