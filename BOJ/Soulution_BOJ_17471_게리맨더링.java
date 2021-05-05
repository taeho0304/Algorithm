package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_17471_게리맨더링 {
	static int n, answer, total;
	static int[][] map;
	static int[] num, area;
	static StringTokenizer st;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		num = new int[n + 1];
		area = new int[n + 1];
		answer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			total += num[i];
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][temp] = map[temp][i] = 1;
			}
		}

		recursive(1, 0, 0);

		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void recursive(int depth, int area1, int area2) {
		if (depth == n + 1) {
			if (area1 == 0 || area2 == 0)
				return;
			visited = new boolean[n + 1];
			int rs = 0;
			for (int i = 1; i <= n; i++) 
				if (!visited[i]) {
					check(i, area[i]);
					rs++;
				}
//			System.out.println(answer);
			
			if (rs == 2)
				answer = Math.min(answer, Math.abs(area2 - area1));
			return;
		}

		area[depth] = 1;
		recursive(depth + 1, area1 + num[depth], area2);

		area[depth] = 2;
		recursive(depth + 1, area1, area2 + num[depth]);
	}

	 private static void check(int index, int numi) {
	        // TODO Auto-generated method stub
	        visited[index] = true;
	        for(int i=1; i<=n; i++) {
	            if(map[index][i] == 1 && !visited[i] && area[i]==numi)
	                check(i, numi);
	        }
	    }

}
