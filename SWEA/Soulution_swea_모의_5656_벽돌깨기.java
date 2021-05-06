package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_5656_벽돌깨기 {
	static Queue<Brick> q;
	static int [] dx= {0,1,0,-1};
	static int [] dy= {1,0,-1,0};
	static int[] spots;
	static int[][] map;
	static boolean[][] visited;
	static int T, N, W, H, ans;

	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			q = new LinkedList<>();
			spots = new int[N];
			map = new int[H][W];
			ans = Integer.MAX_VALUE;

			for (int h = 0; h < H; ++h) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; ++w) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			makeSet(0);

			System.out.println("#" + t + " " + ans);

		}
	}

	private static void makeSet(int spot) {
		if (spot == N) {
			int[][] copy = copyMap();
			int brick = 0;

			for (int i = 0; i < N; ++i) {
				visited = new boolean[H][W];
				selectAndCresh(copy, spots[i]);
				compact(copy);
			}
			
			brick = count(copy);
			ans = ans > brick ? brick : ans;

			return;
		}

		for (int w = 0; w < W; ++w) {
			spots[spot] = w;
			makeSet(spot + 1);
		}
	}

	private static int count(int[][] copy) {
		int brick = 0;
		
		for (int h = 0; h < H; ++h) 
			for (int w = 0; w < W; ++w) 
				if(copy[h][w] > 0) brick++;
		return brick;
	}
    
	private static void compact(int[][] copy) {
		Queue<Integer> temp;
		
		for(int w = 0 ; w < W ; ++w) {
			temp = new LinkedList<>();
			
			for(int h = H - 1 ; h >= 0 ; --h) 
				if(copy[h][w] > 0) temp.offer(copy[h][w]);
			
			for(int h = H - 1 ; h >= 0 ; --h) {
				if(!temp.isEmpty()) 
					copy[h][w] = temp.poll();
				else 
					copy[h][w] = 0;
			}
		}
	}

	private static void selectAndCresh(int[][] copy, int spot) {
		for(int h = 0 ; h < H ; ++h) 
			if(copy[h][spot] > 0) {
				q.offer(new Brick(h, spot, copy[h][spot]));
				break;
			}
		
		while(!q.isEmpty()) {
			Brick now = q.poll();
			int nh, nw;
			
			for(int i = 0 ; i < 4 ; i++) 
				for(int r = 0 ; r < now.range ; ++r) {
					nh = now.h + dy[i] * r;
					nw = now.w + dx[i] * r;

					if(nh >= 0 && nh < H && nw >= 0 && nw < W && !visited[nh][nw]) {
						visited[nh][nw] = true;
						q.offer(new Brick(nh, nw, copy[nh][nw]));
						copy[nh][nw] = 0;
					}
				}
		}
	}

	private static int[][] copyMap() {
		int[][] arr = new int[H][W];
		for (int h = 0; h < H; ++h) 
			for (int w = 0; w < W; ++w) 
				arr[h][w] = map[h][w];

		return arr;
	}
}

class Brick {
	int h, w, range;
	
	public Brick(int h, int w, int range) {
		this.h = h;
		this.w = w;
		this.range = range;
	}
}