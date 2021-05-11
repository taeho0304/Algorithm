package com.ssafy.algo;

import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;

	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Soulution_d4_1861_정사각형방 {
	static int N, len;
	static int[][] sq, dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static Queue<Pair> queue;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			sq = new int[N][N];
			int maxLen = Integer.MIN_VALUE;
			int idx = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) 
                	sq[i][j] = Integer.parseInt(st.nextToken());
            }
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					len = 0;
					BFS(i, j);
					
					if(maxLen < len) {
						maxLen = len;
						idx = sq[i][j];
					}
					if(maxLen == len && idx > sq[i][j]) 
						idx = sq[i][j];
				}
			}
			sb.append("#" + tc + " " + idx + " " + maxLen + "\n");
		}
		System.out.println(sb);
	}
	
	public static void BFS(int x, int y) {
		queue = new LinkedList();
		queue.offer(new Pair(x, y));
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			len++;
			
			for(int i=0; i<size; i++) {
				Pair p = queue.poll();
				for(int j=0; j<4; j++) {
					int nx = p.x + dir[j][0];
					int ny = p.y + dir[j][1];
					
					if(isInside(nx, ny) && sq[nx][ny] == sq[p.x][p.y]+1) 
						queue.offer(new Pair(nx, ny));
				}
			}
		}		
	}
	
	public static boolean isInside(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}