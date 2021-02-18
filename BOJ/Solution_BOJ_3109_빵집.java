package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_3109_빵집 {
	static int R, C, index, cnt;
	static char map[][];
	static boolean flag;
	static int dy[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input_3109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cnt = 0;
		map=new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) 
				map[i][j] = s.charAt(j);
		}
		
		for(int i=0; i<R; i++) {
			flag=false;
			dfs(i, 0);
		}
			
		System.out.println(cnt);
	}

	private static void dfs(int y, int x) {
		if(flag)return;
		if(x==C-1) {
			flag=true;
			cnt++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + 1;

			if (ny < 0 || ny >= R ) continue;
			if(map[ny][nx]=='.') {
				map[y][x] = 'x';
				dfs(ny,nx);
			}
		}
	}
}
