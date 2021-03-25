package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_9205_맥주마시면서걸어가기 {
	static int t, n;
	static Position[] pos;
	static boolean [] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			pos = new Position[n + 2];
			visited = new boolean[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i]=new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			bfs();
			
		}
		br.close();
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Position> q = new LinkedList<Position>();
		Position start = pos[0]; 
		Position end = pos[n+1]; 
		q.offer(start);
		visited[0]=true;
		
		while(!q.isEmpty()) {
			Position cq=q.poll();
			if(cq.equals(end)) {
				System.out.println("happy");
				return;
			}
			
			for (int i = 1; i < n + 2; i++) {
                if (!visited[i] &&Math.abs(cq.x - pos[i].x) + Math.abs(cq.y - pos[i].y) <= 1000) {
                    q.offer(pos[i]);
                    visited[i] = true; 
                }
            }
		}
		System.out.println("sad");
		
	}
}
class Position{
	int y, x;

	public Position(int x, int y) {
		super();
		this.y = y;
		this.x = x;
	}
	
	
}