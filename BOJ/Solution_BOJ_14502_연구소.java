package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_BOJ_14502_연구소 {
	static int N, M, ans;
	private static int[][] map;
	private static int[][] copy;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };
	static List<Birus> birus = new ArrayList<Birus>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					birus.add(new Birus(i, j));

			}
		}

		makeWall(0);
		System.out.println(ans);
		br.close();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Birus> q = new LinkedList<Birus>(); // virus를 담는 큐
		for (int i = 0; i < birus.size(); i++) {
			q.offer(new Birus(birus.get(i).y, birus.get(i).x));
		}

		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.poll().x;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (isValid(ny, nx) && copy[ny][nx] == 0) {
					copy[ny][nx] = 2;
					q.offer(new Birus(ny, nx));
				}
			}
		}
	}

	private static void makeWall(int depth) {
		if (depth == 3) {
			copyMap();
			bfs();
			ans = checkMax();
			return;
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(depth + 1);
					map[i][j] = 0;
				}
	}

	static void copyMap() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copy[i][j] = map[i][j];
	}

	private static int checkMax() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (copy[i][j] == 0)
					cnt++;
		return Math.max(ans, cnt);
	}

	private static boolean isValid(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < M)
			return true;
		return false;
	}
}

class Birus {
	int y, x;

	public Birus(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}