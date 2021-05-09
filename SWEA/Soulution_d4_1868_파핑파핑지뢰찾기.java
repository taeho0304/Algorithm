package com.ssafy.algo;

import java.io.*;

public class Soulution_d4_1868_파핑파핑지뢰찾기 {
	public static int N, ans;
	public static char[][] map;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			ans = 0;

			map = new char[N][N];

			for (int i = 0; i < N; ++i)
				map[i] = br.readLine().toCharArray();

			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (map[i][j] == '.' && isOpen(i, j)) {
						ans++;
						map[i][j] = 'x';
						go(i, j);
					}

			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (map[i][j] == '.')
						ans++;

			sb.append("#" + tc + " " + ans + "\n");
		}

		System.out.println(sb);
	}

	public static void go(int y, int x) {
		if (isOpen(y, x))
			for (int i = 0; i < 8; ++i) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;

				if (map[ny][nx] == '.') {
					map[ny][nx] = 'x';
					go(ny, nx);
				}
			}
	}

	public static boolean isOpen(int y, int x) {
		for (int i = 0; i < 8; ++i) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (map[ny][nx] == '*')
				return false;
		}
		return true;
	}
}