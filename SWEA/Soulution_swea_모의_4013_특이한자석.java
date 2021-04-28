package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_4013_특이한자석 {
	static int T, K, ans;
	static StringTokenizer st;
	static int magnet[][];

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[4][8];

			ans = 0;

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					magnet[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				rotate(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), 7);
//				print();
			}

			ans += magnet[0][0] == 0 ? 0 : 1;
			ans += magnet[1][0] == 0 ? 0 : 2;
			ans += magnet[2][0] == 0 ? 0 : 4;
			ans += magnet[3][0] == 0 ? 0 : 8;

			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void rotate(int idx, int dir, int parent) {
		if (dir == 1) {
			int temp = magnet[idx][7];
			for (int i = 7; i > 0; i--)
				magnet[idx][i] = magnet[idx][i - 1];
			magnet[idx][0] = temp;
			if (idx - 1 < 4 && idx - 1 >= 0 && magnet[idx][7] != magnet[idx - 1][2] && idx - 1 != parent)
				rotate(idx - 1, -dir, idx);
			if (idx + 1 < 4 && idx + 1 >= 0 && magnet[idx][3] != magnet[idx + 1][6] && idx + 1 != parent)
				rotate(idx + 1, -dir, idx);
		} else {
			int temp = magnet[idx][0];
			for (int i = 0; i < 7; i++)
				magnet[idx][i] = magnet[idx][i + 1];
			magnet[idx][7] = temp;
			if (idx - 1 < 4 && idx - 1 >= 0 && magnet[idx][5] != magnet[idx - 1][2] && idx - 1 != parent)
				rotate(idx - 1, -dir, idx);
			if (idx + 1 < 4 && idx + 1 >= 0 && magnet[idx][1] != magnet[idx + 1][6] && idx + 1 != parent)
				rotate(idx + 1, -dir, idx);
		}
	}
}
//1
//10
//1 0 0 0 0 0 0 1
//1 0 1 0 1 1 0 1
//1 0 0 1 0 0 0 1
//1 1 0 1 0 1 1 1
//2 1
//1 1
//2 -1
//3 1
//3 -1
//2 -1
//2 -1
//1 1
//4 1
//4 1
/*
 * 11110101 10000100 10101010
 */
