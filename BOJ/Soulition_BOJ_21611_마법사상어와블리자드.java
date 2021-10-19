package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Soulition_BOJ_21611_마법사상어와블리자드 {
	static int[][] map;
	static int[] rx = { 0, 0, 0, -1, 1 };
	static int[] ry = { 0, -1, 1, 0, 0 };
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean visited[][];
	private static StringTokenizer st;
	private static BufferedReader br;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			remove();
			move();
		}

	}

	private static void move() {
		// TODO Auto-generated method stub
		int y = N / 2;
		int x = N / 2;
		int ny = N / 2;
		int nx = N / 2;
		int dir = 0;
		int size = 1;
		while (isValid(ny, nx)) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < size; j++) {
					ny = ny + dy[dir];
					nx = nx + dx[dir];
					
					if(map[ny][nx]==0) {
						
						
						x=nx;
						y=ny;
					}
				}
				dir= (dir+1)%4;
			}
			size++;
		}

	}

	private static void remove() throws IOException {
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int y = N / 2;
		int x = N / 2;

		for (int i = 0; i < s; i++) {
			int ny = y + ry[d];
			int nx = x + rx[d];
			if (isValid(ny, nx))
				map[ny][nx] = -1;
		}
	}

	private static boolean isValid(int y, int x) {
		return (y >= 0 && x >= 0 && y < N && x < N);
	}

}