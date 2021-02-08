package com.ssafy.io;

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
			max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isSelected =new boolean[N];
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st.nextToken());

			max = Subset(0);
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static int Subset(int cnt) {
		if(cnt==N) {
			int sum=0, snum=0;
			for(int i=0; i<N; i++) 
				if(isSelected[i]==true) {
					sum+=snack[i];
					snum++;
				}
			
			if(sum<=M && snum>1) {
				max=Math.max(max, sum);
			}
			if(max==0) max=-1;
			return max;
		}
		isSelected[cnt]=true;
		Subset(cnt+1);
		
		 isSelected[cnt]=false;
		 Subset(cnt+1);
		 
		return max;
	}
	
	
}
