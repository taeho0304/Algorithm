package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Soulution_JO_2577_회전초밥고 {
	static int n, d, k, c, ans;
	static int[] arr;
	static boolean[] kind;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[n];
		kind = new boolean[d];
		for (int i = 0; i < n; i++)
			arr[i] = (Integer.parseInt(br.readLine()));

		for (int i = 0; i < n; i++) {
			int cnt = 1;
			Arrays.fill(kind, false);
			for (int j = i; j < i + k; j++) {
				if (!kind[arr[j % n]-1]) { 
					kind[arr[j % n]-1] = true; 
					cnt++; 

					if (arr[j % n] == c) cnt--;
				}
			}
			if(cnt == k+1) {
				ans=cnt;
				break;
			}
			ans=Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
