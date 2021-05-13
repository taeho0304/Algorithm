package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Soulution_d3_1220_Magnetic {
	static int N, L, cnt;
	static boolean flag;
	static int map[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			flag=false;
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < N; j++)
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 2) map[i][j] = 0;
					if (map[i][j] == 1) break;
				}

			for (int j = 0; j < N; j++)
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] == 1) map[i][j] = 0;
					if (map[i][j] == 2) break;
				}

			for (int j = 0; j < N; j++) {						
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 1&& flag==false) {
						flag=true;
						cnt++;
					}
					if (map[i][j] == 2&& flag==true) 
						flag=false;
				}
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
