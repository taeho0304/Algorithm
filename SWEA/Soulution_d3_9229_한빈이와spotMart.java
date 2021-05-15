package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Soulution_d3_9229_한빈이와spotMart {
	static int T, N, M, max;
	static int snack[];
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isSelected = new boolean[N];
			snack = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st.nextToken());

			Subset(0, 0, 0);
			if(max==0)max=-1;
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void Subset(int cnt, int cur, int size) {
		if(cur>M) return;
        if(size==2) {
            if(max<cur) max=cur;
            return;
        }
        if(cnt==N) return;
        Subset(cnt+1,cur+snack[cnt],size+1);
        Subset(cnt+1,cur,size);
	}
}
