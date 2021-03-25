package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d4_1238_Contact {
	static int L, S, answer;
	static int person[][];
	static boolean visited[];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			person= new int [L][L];
			visited= new boolean [L];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) 
				person[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
			

			bfs();
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		visited[S]=true;
		
		while(!q.isEmpty()) {
			int qsize=q.size();
			flag=true;
			
			while(qsize-->0){
				int start = q.poll();
				
				for(int i=0; i<L; i++) {
					if(person[start][i]==1 && !visited[i]) {
						if(flag) {
							answer = 0;
							flag=false;
						}
						q.offer(i);
						answer= Math.max(answer, i);
						visited[i]=true;
					}
				}
			}
		}
	}
}
