package com.ssafy.algo;

import java.io.*;
import java.util.*;


public class Soulution_d3_3499_퍼펙트셔플 {
	static int N, cnt;
	static String [] card;
	static String [] temp;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			card= new String[N];
			temp= new String[N];
			cnt = N-(N/2)-1;
			
			for (int i = 0; i < N; i++)
                card[i]=st.nextToken();
			
			for (int i = 0; i < (N+1)/2; i++)
				temp[i*2]=card[i];
			
			for (int i = (N+1)/2; i < N; i++) {
				temp[i-cnt]=card[i];
				cnt--;
			}
			
			sb.append("#" + tc + " " );
			for(int i=0; i<N; i++)
				sb.append(temp[i] + " " );
			sb.append("\n" );
		}
		System.out.println(sb);
	}
}