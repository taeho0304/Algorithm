package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Soulution_d5_1247_최적경로 {
	static int T, N, min;
	static Index_1247 customer[];
	static Index_1247 home, company;
	static boolean visited[];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            customer = new Index_1247[N];
            visited = new boolean[N];

            st= new StringTokenizer(br.readLine());
            company = new Index_1247(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Index_1247(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i=0; i<N; i++)
            	customer[i] = new Index_1247(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            min = Integer.MAX_VALUE;
            dfs(0,company.x, company.y,0);
            System.out.println("#" + (tc+1) + " " + min);
        }
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int cnt, int x, int y, int dis) {
		if(cnt == N){
			dis += Math.abs(home.x-x)+Math.abs(home.y-y);
            min=Math.min(min, dis);
            return;
        }
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(cnt+1,customer[i].x, customer[i].y, dis+Math.abs(customer[i].x-x)+Math.abs(customer[i].y-y));
				visited[i]=false;
			}
		}
		
	}
}

class Index_1247{
	int x,y;

	public Index_1247(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}