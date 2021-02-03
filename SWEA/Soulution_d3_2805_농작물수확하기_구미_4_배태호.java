package com.ssafy.io;

import java.io.*;

public class Soulution_d3_2805_농작물수확하기_구미_4_배태호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int [][] map;
		int answer;
		String s;
		
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = 0;
			
			for(int i=0; i<N; i++) {
				s = br.readLine();
				for(int j=0; j<N; j++)
					map[i][j] = s.charAt(j)-'0';
			}
		
			for(int i=0; i<N; i++) 
				for(int j=Math.abs(N/2-i); j<N-Math.abs(N/2-i); j++)
					answer += map[i][j];
			
			sb.append("#"+ (tc+1) + " "+answer+"\n");
		}
		System.out.println(sb);
	}
}