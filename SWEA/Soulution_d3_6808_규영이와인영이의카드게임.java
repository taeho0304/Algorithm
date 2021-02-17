package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d3_6808_규영이와인영이의카드게임 {
	static int [] card;
	static int w,l;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_6808.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			card= new int [9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++)
				card[i] = Integer.parseInt(st.nextToken());

//			for (int i = 0; i < s.length(); i++)
//				a[i] = s.charAt(i) - '0';
//
//			int cnt = a[0];
//			for (int i = 1; i < a.length; i++)
//				if (a[i] != a[i - 1])
//					cnt++;

//			System.out.println("#" + t + 1 + " " + cnt);
		}
	}
}