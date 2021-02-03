package com.ssafy.io;

import java.io.*;
import java.util.*;

public class Soulution_d3_1289_원재의메모리복구하기_구미_4_배태호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {
			String s = sc.next();
			int[] a = new int[s.length()];

			for (int i = 0; i < s.length(); i++)
				a[i] = s.charAt(i) - '0';

			int cnt = a[0];
			for (int i = 1; i < a.length; i++)
				if (a[i] != a[i - 1])
					cnt++;

			System.out.println("#" + t + 1 + " " + cnt);
		}
	}
}