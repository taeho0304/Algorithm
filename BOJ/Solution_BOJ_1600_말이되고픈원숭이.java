package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int map[][];
	static boolean visited[][][];
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };
	static int hy[] = { -2, -2, -2, -1, 1, 2, 2, 1 };
	static int hx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		bfs();
		br.close();
	}

	public static void bfs() {
		// TODO Auto-generated method stub
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Pos cq = q.poll();
			int x =cq.x;
			int y =cq.y;
			int cnt =cq.cnt;
			int k =cq.k;
			
			if (x == H - 1 && y == W - 1) {
				System.out.println(cnt);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (ny >= 0 && nx >= 0 && ny < W && nx < H) {
					if (!visited[ny][nx][k] && map[ny][nx] != 1) {
						q.add(new Pos(ny, nx, cnt + 1, k));
						visited[ny][nx][k] = true;
					}
				}
			}
			if (k == K)
				continue;
			for (int i = 0; i < 8; i++) {
				int ny = y + hy[i];
				int nx = x + hx[i];
				if (ny >= 0 && nx >= 0 && ny < W && nx < H) {
					if (!visited[ny][nx][k + 1] && map[ny][nx] != 1) {
						q.add(new Pos(ny, nx, cnt + 1, k + 1));
						visited[ny][nx][k + 1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
//	private static boolean isPosible(int ny, int nx) {
//		// TODO Auto-generated method stub
//		if (ny >= 0 && nx >= 0 && ny < W && nx < H) return true;
//		return false;
//	}
}

class Pos {
	int y, x, cnt, k;

	Pos(int y, int x, int cnt, int k) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.k = k;
	}
}