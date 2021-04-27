package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_17143_낚시왕 {
	static int R, C, M, ans;
	static Shark[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<Shark> sharks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			Shark shark = new Shark(y, x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			map[y][x] = shark;
			sharks.add(shark);
		}

		solve();

		System.out.println(ans);
	}

	private static void solve() {
		for (int i = 0; i < C; i++) {
			catchShark(i);
			move();
			eat();
		}
	}

	static void catchShark(int row) {
		for (int i = 0; i < R; i++) {
			if (map[i][row] != null) {
				ans += map[i][row].z;
				sharks.remove(map[i][row]);
				map[map[i][row].r][map[i][row].c] = null;
				break;
			}
		}
	}

	static void move() {
		for (Shark shark : sharks) {
			int sp = shark.s;
			if (shark.d == 0 || shark.d == 1) {
				sp %= 2 * (R - 1);
				for (int i = 0; i < sp; i++) {
					if (shark.r + dy[shark.d] < 0 || shark.r + dy[shark.d] >= R)
						shark.d = shark.d==0?1:0;
					shark.r += dy[shark.d];
				}
			}
			else {
				sp %= 2 * (C - 1);				
				for (int i = 0; i < sp; i++) {
					if (shark.c + dx[shark.d] < 0 || shark.c + dx[shark.d] >= C)
						shark.d = shark.d==2?3:2;
					shark.c += dx[shark.d];
				}
			}
		}
	}

	static void eat() {
		map = new Shark[R][C];
		int size = sharks.size();
		for (int i = 0; i < size; i++) {
			Shark shark = sharks.get(i);
			if (map[shark.r][shark.c] == null)
				map[shark.r][shark.c] = shark;
			else {
				if (map[shark.r][shark.c].z > shark.z) {
					i--;
					size--;
					sharks.remove(shark);
				}
				
				else {
					sharks.remove(map[shark.r][shark.c]);
					map[shark.r][shark.c] = shark;
					i--;
					size--;
				}
			}
		}
	}
	static void print() {
		for(int i = 0; i<R; i++) {
			System.out.println();
			for(int j = 0; j<C; j++) {
				System.out.print(map[i][j]==null?0+" ":1+" ");
			}
		}
		System.out.println();
	}
}

class Shark {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}