package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_17144_미세먼지안녕 {
	static int r, c, t, count, answer;
	static int[][] map, copy;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Pos_17144> dust = new LinkedList<Pos_17144>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[c][r];
		copy = new int[c][r];

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < r; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < t; i++) {
			checkDust();
			spread();
			copy(map,copy);
			clean();
			copy(copy,map);
//			System.out.println();
//			print();
		}
//		print();
		count();
		System.out.println(answer+2);
	}

	private static void checkDust() {
		for(int i=0; i<c; i++)
			for(int j=0; j<r; j++)
				if (map[i][j] > 0)
					dust.add(new Pos_17144(i, j));
	}

	private static void count() {
		for (int i = 0; i < c; i++)
			for (int j = 0; j < r; j++)
				answer += map[i][j];
	}

	private static void clean() {
		
		int top = 0;
		for (int i = 0; i < c; i++)
			if (map[i][0] == -1) {
				top = i;
				break;
			}
		
        int down = top + 1;
        
        for (int i = top - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];
        for (int i = 0; i < r - 1; i++) 
            map[0][i] = map[0][i+1];
        for (int i = 0; i < top; i++) 
            map[i][r - 1] = map[i + 1][r - 1];
        for (int i = r - 1; i > 1; i--) 
            map[top][i] = map[top][i-1];
        map[top][1] = 0;
        
        for (int i = down + 1; i < c - 1; i++) 
            map[i][0] = map[i + 1][0];
        for (int i = 0; i < r - 1; i++) 
            map[c - 1][i] = map[c - 1][i + 1]; 
        for (int i = c - 1; i > down; i--) 
            map[i][r - 1] = map[i - 1][r - 1];
        for (int i = r - 1; i > 1; i--) 
            map[down][i] = map[down][i - 1];
        map[down][1] = 0;
        
       
	}

	private static void spread() {
//		print();
		int qsize = dust.size();
		while (qsize-- > 0) {
			Pos_17144 cq = dust.poll();
			int y = cq.y;
			int x = cq.x;

			int spreadNum = map[y][x] / 5;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny >= 0 && nx >= 0 && ny < c && nx < r && map[ny][nx] != -1) {
					copy[y][x] -= spreadNum;
					copy[ny][nx] += spreadNum;
				}
			}
		}
		
	}

	private static void copy(int arr1[][], int arr2[][]) {
		for (int i = 0; i < c; i++)
			for (int j = 0; j < r; j++)
				arr1[i][j] = arr2[i][j];
	}

	private static void print() {
		for (int i = 0; i < c; i++) {
			System.out.println();
			for (int j = 0; j < r; j++)
				System.out.print(map[i][j] + " ");
		}
	}
}

class Pos_17144 {
	int y, x;

	public Pos_17144(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}