package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1987_알파벳 {
	static int R, C;
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, -1, 0, 1 };
	static boolean[] visited;
	static char[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) 
				map[i][j] = s.charAt(j);
		}

		visited[(int)map[0][0]-'A']=true;
		dfs(0, 0, 0);
		System.out.println(max+1);
	}

	private static void dfs(int y, int x, int cnt) {
		max=Math.max(cnt, max);
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			if( !visited[(int)map[ny][nx]-'A']) {
				visited[(int)map[ny][nx]-'A']=true;
				dfs(ny,nx,cnt+1);
				visited[(int)map[ny][nx]-'A']=false;
			}
		}
	}
}
