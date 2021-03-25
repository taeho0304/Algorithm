package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_SW샘플_1767_프로세서연결하기 {
	static int N, minL, maxC, cnt;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static StringTokenizer st;
	static ArrayList<Process> pc;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			pc = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			maxC = Integer.MIN_VALUE;
			minL = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1)
						pc.add(new Process(i, j));
				}
			}

			dfs(0, 0, 0);
			
			sb.append("#" + tc + " " + minL + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int dep, int c, int l) {
		if (dep == pc.size()) {
			if (c > maxC) {
				maxC = c;
				minL = l;
			} else if (c == maxC) {
				minL=Math.min(minL, l);
			}
			return;
		}
		
		Process p = pc.get(dep);

		for (int i = 0; i < 4; i++) {
			if(isCheck(p,i)) {
				check(p, i, 2); 
				dfs(dep + 1, c + 1, l + cnt); 
				check(p, i, 0);
			}
		}
		dfs(dep + 1, c, l);
	}

	private static void check(Process p, int dir, int val) {
		cnt=0;
		int cy=p.y+dy[dir];
		int cx=p.x+dx[dir];
		
		while(true) {
			if(cx < 0 || cy < 0 || cx >= N || cy >= N) break;
			map[cy][cx]=val;
			cy = cy+ dy[dir];
			cx = cx+ dx[dir];
			cnt++;
		}
	}

	private static boolean isCheck(Process p, int dir) {
		int y = p.y + dy[dir];
		int x = p.x + dx[dir];
		while (true) {
			if(x < 0 || y < 0 || x >= N || y >= N) break;
			if (map[y][x] != 0)
				return false;
			y = y + dy[dir];
			x = x + dx[dir];
		}
		return true;
	}
}

class Process {
	int x;
	int y;

	Process(int y, int x) {
		this.x = x;
		this.y = y;
	}
}