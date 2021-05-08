package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_swea_모의_4012_요리사 {
	static int N, T, min, temp;
	static StringTokenizer st;
	static int food[][];
	static int[] selected;
	static boolean[] visited;
	static ArrayList<Integer> diff = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			selected = new int[2];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					food[i][j] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

//			for (int i = 0; i < diff.size() - 1; i++) {
//				for (int j = i + 1; j < diff.size(); j++) {
//					temp = Math.abs(diff.get(i) - diff.get(j));
//				}
//				min = Math.min(min, temp);
//			}

			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == 2) {
			diff.add(food[selected[0]][selected[1]] + food[selected[1]][selected[0]]);
//			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			selected[cnt] = i;
//			System.out.print(i);
			combination(cnt + 1, i + 1);
		}
	}

	private static void dfs(int cnt, int foodNum) {
		// TODO Auto-generated method stub
		if (cnt == N)
			return;

		if (foodNum == N / 2) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (visited[i]) A.add(i);
				else B.add(i);
			}

			int a = 0, b = 0;
			for (int i = 0; i < A.size() - 1; i++) {
				for (int j = i + 1; j < A.size(); j++) {
					a = a + food[A.get(i)][A.get(j)] + food[A.get(j)][A.get(i)];
					b = b + food[B.get(i)][B.get(j)] + food[B.get(j)][B.get(i)];
				}
			}
			min = Math.min(min, Math.abs(a - b));
			return;
		}

		visited[cnt] = true;
		dfs(cnt + 1, foodNum + 1);

		visited[cnt] = false;
		dfs(cnt + 1, foodNum);
	}
}

