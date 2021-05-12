package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_15683_감시 {
	static int N, M, ans;
	static int[] dx1 = { 0, 0, 1, -1 };
	static int[] dy1 = { -1, 1, 0, 0 };
	static int[][] map;
	static ArrayList<Seek> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map= new int [N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					list.add(new Seek(i, j, map[i][j]));
			}
		}

		solve(0, map);

		System.out.println(ans);
	}

	private static void solve(int dep, int[][] prev) {
		int visited[][] = new int[N][M];
		if (dep == list.size()) {
			int temp = 0;
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < M; j++) {
					if (prev[i][j] == 0)
						temp++;
				}
			if (temp < ans)
				ans = temp;
			return;
		}

		Seek seek = list.get(dep);
		int y = seek.y;
		int x = seek.x;
		int dir = seek.num;

		switch (dir) {
		case 1:
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < N; i++) 
					visited[i] = Arrays.copyOf(prev[i], M);
				detect(visited, y, x, k);
				solve(dep + 1, visited);
			}
			break;
		case 2:
			for (int k = 0; k < 2; k++) {
				for (int i = 0; i < N; i++) 
					visited[i] = Arrays.copyOf(prev[i], M);
				detect(visited, y, x, k);
				detect(visited, y, x, k + 2);
				solve(dep + 1, visited);
			}
			break;
		case 3:
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < N; i++) 
					visited[i] = Arrays.copyOf(prev[i], M);
				detect(visited, y, x, k);
				detect(visited, y, x, (k + 1) % 4);
				solve(dep + 1, visited);
			}
			break;
		case 4:
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < N; i++) 
					visited[i] = Arrays.copyOf(prev[i], M);
				detect(visited, y, x, k);
				detect(visited, y, x, (k + 1) % 4);
				detect(visited, y, x, (k + 2) % 4);
				solve(dep + 1, visited);
			}
			break;
		case 5:
			for (int i = 0; i < N; i++) 
				visited[i] = Arrays.copyOf(prev[i], M);
			detect(visited, y, x, 0);
			detect(visited, y, x, 1);
			detect(visited, y, x, 2);
			detect(visited, y, x, 3);
			solve(dep + 1, visited);
			break;
		}
	}

	private static void detect(int[][] visited, int y, int x, int dir) {
		switch (dir) {
		case 0:
			for (int k = x; k >= 0; k--) {
				if (map[y][k] == 6) 
					break;
				visited[y][k] = 7;
			}
			break;
		case 1:
			for (int k = y; k >= 0; k--) {
				if (map[k][x] == 6) 
					break;
				visited[k][x] = 7;
			}
			break;
		case 2:
			for (int k = x; k < M; k++) {
				if (map[y][k] == 6) 
					break;
				visited[y][k] = 7;
			}
			break;
		case 3:
			for (int k = y; k < N; k++) {
				if (map[k][x] == 6) 
					break;
				visited[k][x] = 7;
			}
			break;
		}
	}
}

class Seek {
	int y, x, num;

	public Seek(int y, int x, int num) {
		super();
		this.y = y;
		this.x = x;
		this.num = num;
	}
}