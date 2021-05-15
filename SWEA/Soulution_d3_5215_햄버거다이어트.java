package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Soulution_d3_5215_햄버거다이어트 {
	static int T, N, L, max;
	static int input[][];
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			isSelected= new boolean[N];
			input = new int[N][2];
			
			for(int i=0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0]= Integer.parseInt(st.nextToken());
				input[i][1]= Integer.parseInt(st.nextToken());
			}
			
			max = Subset(0);
			sb.append("#" +tc+" "+ max + "\n");
		}
		System.out.println(sb);
	}
	
	public static int Subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int answer=0;
			for (int i = 0; i < N; i++)
				if (isSelected[i]) {
					sum += input[i][1];
					answer +=input[i][0];
				}
			
			if(sum<= L) max= Math.max(max, answer);
			
			return max;
		}

		isSelected[cnt] = true;
		max= Subset(cnt+1);
		

		isSelected[cnt] = false;
		max= Subset(cnt+1);
		return max;
	}

//	static int N;
//	static int L;
//	static int[] a;
//	static int[] b;
//	static int max;
//	
//	public static void dfs(int x, int s, int k) {
//		if(k > L) 
//			return;
//		
//		if(x == N)	max = Math.max(s, max);
//		else {
//			dfs(x + 1, s + a[x], k + b[x]);
//			dfs(x + 1, s, k);
//		}
//	}
//	
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int tc = Integer.parseInt(br.readLine());
//		
//		for(int t = 1; t <= tc; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			a = new int[N];
//			b = new int[N];
//			max = 0;
//			
//			for(int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				a[i]= Integer.parseInt(st.nextToken());
//				b[i]= Integer.parseInt(st.nextToken());
//			}
//			
//			dfs(0, 0, 0);
//			sb.append("#" + t + " " + max+"\n");
//		}
//		System.out.println(sb);
//	}
}
