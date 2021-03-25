package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d4_3234_준환이의양팔저울 {
	static int answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight[] = new int[N];
			boolean[] visited = new boolean[N];
			answer = 0;

			for (int i = 0; i < N; i++)
				weight[i] = Integer.parseInt(st.nextToken());

			permutation(0, 0, 0, N, weight, visited);
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	private static void permutation(int cnt, int l, int r, int N, int weight[], boolean visited[]) {
		if (cnt == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			
			permutation(cnt + 1, l + weight[i], r, N, weight, visited);
			if (r + weight[i] <= l)
				permutation(cnt + 1, l, r + weight[i], N, weight, visited);
			
			visited[i] = false;
		}
	}
}
