package com.ssafy.algo;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Soulution_d4_1233_사칙연산유효성검사 {
	public static String[] tree;
	public static int child [][];
	public static int N, answer=1, flag;
	public static String s;
	public static boolean visited[];
	public static boolean isNumber = true;
	public static Stack<Integer> st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N];
			child = new int[N][N];
			visited = new boolean[N];
			st = new Stack<>();
			flag =1;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int curr = Integer.parseInt(tk.nextToken());
				tree[i] = tk.nextToken();
				for(int j = 0; j < 2; j++) 
					if(tk.hasMoreTokens()) {
						int ch = Integer.parseInt(tk.nextToken());
						child[curr-1][ch-1] = 1;
					}
			}
			dfs(0);
			if(st.size() == 0) flag = 0;

			sb.append("#" + (tc+1) + " " + flag +"\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int cnt) {
		if(checkEnd()) return;
		if(flag==0) return;
		
		visited[cnt]=true;
		for(int i=0; i<N; i++)
			if(child[cnt][i]!=0 && !visited[i])
				dfs(i);
		
		check(tree[cnt]);
	}

	private static void check(String s) {
		if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			if(st.size() < 2) {
				flag = 0;
				return;
			}
			int a = st.pop();
			int b = st.pop();
			
			if(s.equals("+")) st.push(a+b);
			if(s.equals("-")) st.push(b-a);
			if(s.equals("*")) st.push(a*b);
			if(s.equals("/")) {
				if(a == 0) a = 1;
				st.push(b/a);
			}
		}
		else st.push(Integer.parseInt(s));
	}

	private static boolean checkEnd() {
		for(int i=0; i<N; i++)
			if(!visited[i])
				return false;
		return true;
	}
}