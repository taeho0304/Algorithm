package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_1992_쿼드트리 {
	private static int n;
	private static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) 
				map[i][j] = (int)s.charAt(j) - '0';
		}
		divide(0, 0, n);
	}

	private static void divide(int r, int c, int n) {
		// TODO Auto-generated method stub
		if (check(r, c, n)){}
		else {
			System.out.print("(");
			int size = n / 2;
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < 2; j++)
					divide(r + size * i, c + size * j, size);

			System.out.print(")");
		}
	}
	
	private static boolean check(int r, int c, int size) {
		// TODO Auto-generated method stub
		for (int i = r; i < r + size; i++)
			for (int j = c; j < c + size; j++)
				if (map[r][c] != map[i][j])
					return false;
		
		System.out.print(map[r][c]);
		return true;
	}
}