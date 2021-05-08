package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_2115_벌꿀채취 {
	static int N, M, T, C, ans;
	static StringTokenizer st;
	static int mapr [][], mapc [][];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			C= Integer.parseInt(st.nextToken());
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	
}

