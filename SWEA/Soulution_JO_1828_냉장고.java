package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Soulution_JO_1828_냉장고 {
	static int T, answer, cnt;
	static int[][] rf;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		rf = new int[T][2];
		answer = 1;
		cnt = 0;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			rf[tc][0] = Integer.parseInt(st.nextToken());
			rf[tc][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rf, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int diff = Integer.compare(o1[0], o2[0]);
				return diff != 0 ? diff : o1[1] - o2[1];
			}
		});

		for(int i=1; i<T; i++) {
			if(rf[i][0]<=rf[cnt][1]) {
				if(rf[i][1]<rf[cnt][1]) {
					cnt=i;
				}
			}else {
				cnt=i;
				answer++;
			}
		}

	System.out.println(answer);
}}		
