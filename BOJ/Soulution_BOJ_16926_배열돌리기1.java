package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_16926_배열돌리기1 {
	private static int n, m, k, x, y, min = Integer.MAX_VALUE, cnt;
	private static int[][] map, copy, rcs;

	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		copy = new int[n + 1][m + 1];
		rcs = new int[k][3];
		visited = new boolean[k];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= m; j++)
				copy[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(reader.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}
		copy();
		dfs(0);

		System.out.println(min);
	}

	private static void dfs(int cnt) {
		if (cnt == k) {
			System.out.println("zz");
			min = Math.min(min, sum());
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
System.out.print(i);
				rotate(rcs[i][0], rcs[i][1], rcs[i][2]);

				visited[i] = true;
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
		copy();
	}

	private static int sum() {
		int cmin = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			cnt = 0;
			for (int j = 1; j <= m; j++)
				cnt += map[i][j];
			cmin = Math.min(cnt, cmin);
		}
		return cmin;
	}

	private static void rotate(int r, int c, int s) {
		for (int i = 1; i <= s; i++) {
			x = c - s - 1 + i;
			y = r - s - 1 + i;

			int temp = map[y][x];
			int index = 0;

			while (index < 4) {

				int nx = x + dx[index];
				int ny = y + dy[index];

				if (nx < c - s + i - 1 || ny < r - s + i - 1 || nx > c + s - i + 1 || ny > r + s - i + 1) {
					index++;
				} else {
					map[y][x] = map[ny][nx];
					x = nx;
					y = ny;
				}
			}
			map[r - s + i - 1][c - s + i] = temp;
		}

	}

	private static void copy() {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				map[i][j] = copy[i][j];
	}
}
/*
5 6 3
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
4 2 1
*/