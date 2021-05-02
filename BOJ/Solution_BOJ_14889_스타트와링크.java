package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_14889_스타트와링크 {
	static int N, ans;
	static int[][] map;
	static int[] l, s;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		l = new int[N / 2];
		s = new int[N / 2];
		visited = new boolean[N];
		ans=Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		com(0, 0);

		System.out.println(ans);
	}

	private static void com(int dep, int cur) {
		if (dep == N / 2) {
			int start = 0;
			int link = 0;

			int si = 0;
			for (int i = 0; i < N; i++) 
				if (!visited[i]) {
					s[si] = i;
					si++;
				}

			for (int i = 0; i < N / 2; i++) 
				for (int j = 0; j < N; j++) {
					if (l[i] != j && visited[j]) 
						start += map[l[i]][j];
					if (s[i] != j && !visited[j]) 
						link += map[s[i]][j];
				}

			ans = Math.min(ans, Math.abs(link - start));
			return;
		}

		for (int i = cur; i < N; i++)
			if (!visited[i]) {
				visited[i] = true;
				l[dep] = i;
				com(dep + 1, i+1);
				visited[i] = false;
			}
	}
}
