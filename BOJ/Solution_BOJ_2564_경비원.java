package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2564_경비원 {
	static int N, M, ans, num;
	static int[][] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(br.readLine());
		pos=new int [num+1][2];
		
		for(int i=0; i<num+1; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0]= Integer.parseInt(st.nextToken());
			pos[i][1]= Integer.parseInt(st.nextToken());
		}
		
		solve();
		
		System.out.println(ans);
	}

	private static void solve() {
		for(int i=0; i<num; i++) {
			if(pos[i][0]==pos[num][0]) ans+= Math.abs(pos[i][1]-pos[num][1]);
			else if(pos[i][0]<3 && pos[num][0]<3) ans+= (Math.min(pos[i][1] + pos[num][1],2*N-pos[i][1] - pos[num][1])+M);
			else if (pos[i][0]>=3 && pos[num][0]>=3) ans+= (Math.min(pos[i][1] + pos[num][1],2*M-pos[i][1] - pos[num][1])+N);
			else {
				if(pos[i][0]==3) ans+=pos[num][1];
				else if(pos[i][0]==4) ans+=(N-pos[num][1]);
				else if(pos[i][0]==2) ans+=(M-pos[num][1]);
				else if(pos[i][0]==1) ans+=pos[num][1];
				
				if(pos[num][0]==3) ans+=pos[i][1];
				else if(pos[num][0]==4) ans+=(N-pos[i][1]);
				else if(pos[num][0]==2) ans+=(M-pos[i][1]);
				else if(pos[num][0]==1) ans+=pos[i][1];
			}
		}
	}


}
