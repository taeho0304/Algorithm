package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_4014_활주로건설 {
	static int N, T, X, ans;
	static StringTokenizer st;
	static int mapr [][], mapc [][];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			mapr= new int [N][N];
			mapc= new int [N][N];
			ans=0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					mapr[i][j]=Integer.parseInt(st.nextToken());
					mapc[j][i]=mapr[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				if (solve(mapr, i)) ans++;
				if (solve(mapc, i)) ans++;
			}
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	private static boolean solve(int map[][], int idx) {
		int count = 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i])	count++;
			else if (map[idx][i] - height == 1) {
				if (count < X)	return false;
				else {
					count = 1;
					height = map[idx][i];
				}
			} else if (height - map[idx][i] == 1) {
				if (N < X + i)	return false;
				for (int j = 1; j < X; j++) 
					if (height - map[idx][++i] != 1) return false;
				height = map[idx][i];
				count = 0;
			} else 
				return false;
		}
		return true;
	}

	
}

