//package com.ssafy.algo;
//
//import java.io.*;
//import java.util.*;
//
//public class Soulution_BOJ_17140_이차원배열의연산 {
//	static int r,c,k;
//	static int [][] arr;
//	static int[] dx = { 0, 0, 1, -1 };
//	static int[] dy = { -1, 1, 0, 0 };
//	static ArrayList<Shark> sharks = new ArrayList<>();
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		r = Integer.parseInt(st.nextToken());
//		c = Integer.parseInt(st.nextToken());
//		k = Integer.parseInt(st.nextToken());
//		arr = new int[100][100];
//
//		for (int i = 0; i < 3; i++) {
//			st = new StringTokenizer(br.readLine());
//			Shark shark = new Shark(y, x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1,
//					Integer.parseInt(st.nextToken()));
//			map[y][x] = shark;
//			sharks.add(shark);
//		}
//
//		solve();
//
//		System.out.println(ans);
//	}
//
//	
//}
