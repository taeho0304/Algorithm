package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d4_sw_보급로 {
	static int N, min;
	static int[][] map, ans;
	static boolean[][] visited;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = s.charAt(j) - '0';
			}

			bfs();
			
			sb.append("#" + tc + " " + ans[N - 1][N - 1] + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Pos_1249> q = new LinkedList<>();
		visited[0][0] = true;
		q.offer(new Pos_1249(0, 0));

		while (!q.isEmpty()) {
			Pos_1249 p = q.poll();
			int x = p.x;
			int y = p.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInside(nx, ny))
					if (!visited[nx][ny] || ans[nx][ny] > ans[x][y] + map[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Pos_1249(nx, ny));
						ans[nx][ny] = ans[x][y] + map[nx][ny];
					}
			}
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}

class Pos_1249 {
	int x, y;

	public Pos_1249(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}