package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_7576_토마토 {
	static int K, W, H, ans;
	static int map[][];
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };
	static Queue<Pos_7576> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) 
					q.offer(new Pos_7576(i, j));
			}
		}

		bfs();
		br.close();
	}

	public static void bfs() {
		
		while (!q.isEmpty()) {
			if (check()) {
				System.out.println(ans);
				return;
			}
			
			int qsize= q.size();
			while(qsize-->0) {
				Pos_7576 cq = q.poll();
				int x = cq.x;
				int y = cq.y;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (ny >= 0 && nx >= 0 && ny < H && nx < W)
						if ( map[ny][nx] == 0) {
							map[ny][nx] = 1;
							q.offer(new Pos_7576(ny, nx));
						}
				}
			}
			ans++;
		}
		System.out.println(-1);
	}

	private static boolean check() {
		for(int i=0; i<H; i++)
			for(int j=0; j<W; j++)
				if(map[i][j]==0) return false;
		return true;
	}
}

class Pos_7576 {
	int y, x;

	public Pos_7576(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}