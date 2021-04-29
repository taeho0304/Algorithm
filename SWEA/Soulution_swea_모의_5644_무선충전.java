package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의역량테스트_무선충전 {
	static int T,M,A, ans;
	static int [] dx = {0,0,1,0,-1};
	static int [] dy = {0,1,0,-1,0};
	static int dirA [];
	static int dirB [];
	static StringTokenizer st;
	static List<BC> bc = new ArrayList<BC>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_20210412.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			
			dirA= new int[M];
			dirB= new int[M];
			
			String s;
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				dirA[i]=Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				dirB[i]=Integer.parseInt(st.nextToken());
			
			solve();
			
			for(int i=0; i<A; i++) {
				st= new StringTokenizer(br.readLine());
				BC battery_charger= new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				bc.add(battery_charger);
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	private static void solve() {
//		Queue<Integer> qa= new LinkedList<Integer>;
//		Queue<Integer> qb= new LinkedList<Integer>;
//		q.offer()
//		
//		while(!qa.isEmpty())
	}
	
	
}
class BC{
	int y, x, c, p;

	public BC(int x, int y, int c, int p) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
	
}