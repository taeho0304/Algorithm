package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_17135_캐슬디펜스 {
	private static int N, M, D;
	static int[][] map;
	static int[][] copy;
	static ArrayList<Integer> archer = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		copy = new int[N + 1][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		setArc(0);
	}

	private static void setArc(int dep) {
		// TODO Auto-generated method stub
		if (dep == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < M; i++) {
			map[N][i] = 2;
			archer.add(i);
			setArc(dep + 1);
			map[N][i] = 0;
		}
	}

	private static void copy() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < M; j++)
				copy[i][j] = map[i][j];
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		copy();
//		Queue<Index2> q = new 
		
	}

	private static int calDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	private static void move() {
//		for(int i=0; i<N; i++)
//			for(int j=0; j<M; j++)
//				copy
				
	}

	private static boolean check() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copy[i][j] == 1)
					return true;
		return false;
	}
}

class Index2 {
	int x, y;

	public Index2(int y, int x) {
		this.x = x;
		this.y = y;
	}
}