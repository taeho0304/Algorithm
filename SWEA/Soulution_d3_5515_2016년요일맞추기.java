package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d3_5515_2016년요일맞추기 {
	static int ans, T, m, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		int month[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			for (int i = 1; i < m; i++)
				ans += month[i];
			ans += d + 3;

			sb.append("#" + tc + " " + ans % 7 + "\n");
		}
		System.out.println(sb);
	}
}
