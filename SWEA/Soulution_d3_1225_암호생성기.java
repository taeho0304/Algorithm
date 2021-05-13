package com.ssafy.algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Soulution_d3_1225_암호생성기 {
	public static int N, cnt, cur;
	public static String s;
	static Queue<Integer> code;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < 10; tc++) {
			cnt = 1;
			code = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 8; i++)
				code.offer(Integer.parseInt(st.nextToken()));

			while (true) {
				cur = code.poll() - cnt;
				if (cur< 0) {
					code.offer(0);
					break;
				}
				code.offer(cur);
				cnt++;
				if(cnt==6) cnt=1;
			}

			sb.append("#" + N + " ");
			for (int i = 0; i < 8; i++)
				sb.append(code.poll() + " ");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}