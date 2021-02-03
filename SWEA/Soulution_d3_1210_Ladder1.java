package com.ssafy.io;

import java.io.*;
import java.util.*;

public class Soulution_d3_1210_Ladder1_구미_4_배태호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1210.txt"));
		Scanner sc = new Scanner(System.in);
		int[][] ladder = new int[100][100];
		int[] dx = { 1, -1, 0 };
		int[] dy = { 0, 0, -1 };
		
		for (int tc = 0; tc < 10; tc++) {
			int y = 99;
			int x = 0;
			ladder = new int[100][100];
			int num = sc.nextInt();
			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j]==2)
						x=j;
				}
					

			while (true) {
				for (int i = 0; i < 3; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (nx<0 || nx>=100 || ny<0 ||ny>=100 || ladder[ny][nx] == 0) continue;
					ladder[ny][nx]=0;
					x=nx;
					y=ny;
				}
				if (y == 0) {
					System.out.println("#" + (tc+1) + " " + x);
					break;
				}
			}
		}
		sc.close();
	}
}