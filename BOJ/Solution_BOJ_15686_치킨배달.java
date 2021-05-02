package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_BOJ_15686_치킨배달 {
	static int N, M, index, min;
	static ArrayList<Index> chicken = new ArrayList<>();
	static ArrayList<Index> home = new ArrayList<>();
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				index = Integer.parseInt(st.nextToken());
				if (index == 1)	home.add(new Index(i, j));
				else if (index == 2) chicken.add(new Index(i, j));
			}
		}
		
		visited=new boolean[chicken.size()];
		combination(0,0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		if(cnt==M) {
			min=Math.min(min, getMin());
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			visited[i]=true;
			combination(cnt+1, i+1);
			visited[i]=false;
		}
	}

	private static int getMin() {
		// TODO Auto-generated method stub
		int dis; int disTotal=0;
		for(int i=0; i<home.size(); i++) {
			dis=Integer.MAX_VALUE;
			for(int j=0; j<chicken.size(); j++)
				if(visited[j]) 
					dis=Math.min(dis, Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y));
			disTotal+=dis;
		}
		return disTotal;
	}
}

class Index {
	int x, y;

	public Index(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
}