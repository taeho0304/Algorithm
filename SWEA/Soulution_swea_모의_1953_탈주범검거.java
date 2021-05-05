package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_1953_탈주범검거 {
	static int N, T, M, R, C, L, ans;
	static StringTokenizer st;
	static int map[][];
	static boolean visited[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Pos_1953> q;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			q= new LinkedList<Pos_1953>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			q.offer(new Pos_1953(R, C));
			visited[R][C]= true;

			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			move();
			count();
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < M; j++)
				if(visited[i][j]==true)System.out.print("9 "); else System.out.print(map[i][j]+ " ");
		}
	}

	private static void count() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (visited[i][j])
					ans++;
	}

	private static void move() {
		for (int t = 0; t < L - 1; t++) {
			int qsize = q.size();
			while (qsize-- > 0) {

				Pos_1953 cq = q.poll();
				int y = cq.y;
				int x = cq.x;

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if (inside(ny, nx) && map[ny][nx] != 0 && !visited[ny][nx] && moveP(ny, nx, y, x, i)) {
						visited[ny][nx] = true;
						q.offer(new Pos_1953(ny, nx));
					}
				}
//					print();
//					System.out.println();
			}
		}
	}

	private static boolean moveP(int ny, int nx, int y, int x, int dir) {
//		static int[] dx = { 0, 1, 0, -1 };
//		static int[] dy = { 1, 0, -1, 0 };
		if (dir == 2 && (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7 || map[y][x] == 3 || map[y][x] == 5 || map[y][x] == 6))
			return false;
		else if (dir == 1 && (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5 || map[y][x] == 2 || map[y][x] == 6 || map[y][x] == 7))
			return false;
		else if (dir == 0 && (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6 || map[y][x] == 3 || map[y][x] == 4 || map[y][x] == 7))
			return false;
		else if (dir == 3 && (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7 || map[y][x] == 2 || map[y][x] == 4 || map[y][x] == 5))
			return false;
		else return true;
	}

	private static boolean inside(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < M) return true;
		return false;
	}

}

class Pos_1953 {
	int y, x;

	public Pos_1953(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
