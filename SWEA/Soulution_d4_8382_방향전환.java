package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Soulution_d4_8382_방향전환 {
	public static int N, T, ans, x1, x2, y1, y2, flag;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			ans=0;
			flag=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			solve();
			sb.append("#"+(tc+1)+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void solve() {
		while (x1 != x2 || y1 != y2) {
			if(Math.abs(y2-y1)>=Math.abs(x2-x1)) {
				if(flag!=1) {
					flag=1;
					if(y2>y1) y1++;
					else y1--;
				}
				else if(flag!=2) {
					flag=2;
					if(x2>x1) x1++;
					else x1--;
				}
			}else {
				if(flag!=2) {
					flag=2;
					if(x2>x1) x1++;
					else x1--;
				} else if(flag!=1) {
					flag=1;
					if(y2>y1) y1++;
					else y1--;
				}
			}
			ans++;
		}
	}

}