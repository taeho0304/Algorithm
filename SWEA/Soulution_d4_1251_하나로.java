package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_d4_1251_하나로 {
	static int N;
	static double ans;
	static int parent[];
	static Island[] il;
	static double E;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			ans=0;
			N = Integer.parseInt(br.readLine());
			il = new Island[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				il[i] = new Island(Integer.parseInt(st.nextToken()), 0, 0);

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				il[i].y = Integer.parseInt(st.nextToken());

			E = Double.parseDouble(br.readLine());
			
			ArrayList<Island> weights = new ArrayList<>();

            for(int i=0; i<N-1; i++)
                for(int j=i+1; j<N; j++)
                    weights.add(new Island(i, j, calWeight(il[i].x, il[i].y, il[j].x, il[j].y)));

            Collections.sort(weights, new Comparator<Island>() {
                @Override
                public int compare(Island p1, Island p2){
                	return Double.compare(p1.weight, p2.weight);
                }
            });

			make();
            
			for(int i=0; i< weights.size(); i++)
                if(!isSameParent(weights.get(i).x, weights.get(i).y)){
                    union(weights.get(i).x, weights.get(i).y); 
                    ans = ans + weights.get(i).weight; 
                }
			
			System.out.format("#%d %.00f\n", tc, ans);
		}
	}



	public static double calWeight(long x, long y, long dx, long dy){        
        return E * Math.pow(Math.sqrt(Math.pow(dx-x, 2) + Math.pow(dy-y, 2)),2);
    }
	
	public static void make() {
		parent = new int[N];
        for(int i=0; i<N; i++)
            parent[i] = i;
	}


	public static int find(int x) {
		if (parent[x] == x) return x;
		else
			return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) 
			parent[y] = x; // 연결
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)	return false;
		
		return true;
	}
}

class Island {
	int y;
	int x;
	double weight;

	public Island(int x, int y, double weight) {
		super();
		this.y = y;
		this.x = x;
		this.weight = weight;
	}
}