package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Soulution_BOJ_2239_스도쿠 {

	static ArrayList<int[]> list = new ArrayList();
	static int[][] map = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j)-'0';
				if (map[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}

		sudoku(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean sudoku(int cnt) {
		if (cnt == list.size()) return true;

		int[] position = list.get(cnt); 
		int n = position[0];
		int m = position[1];
		
		for (int i = 1; i < 10; i++)
			if (isPromising(map, n, m, i)) {
				map[n][m] = i;
				if (sudoku(cnt + 1)) return true;
				else map[n][m] = 0;
			}

		return false;
	}

	static boolean isPromising(int[][] map, int n, int m, int num) {
		int len = map.length;
		int n_block = n / 3;
		int m_block = m / 3;

		for (int i = 0; i < len; i++) { 
			if (map[n][i] == num) return false;
			if (map[i][m] == num) return false;
		}

		for (int i = 0; i < 3; i++) 
			for (int j = 0; j < 3; j++) 
				if (map[(n_block * 3) + i][(m_block * 3) + j] == num)
					return false;		

		return true;
	}
}