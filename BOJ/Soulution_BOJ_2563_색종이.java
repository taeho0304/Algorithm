package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class Soulution_BOJ_2563_색종이 {
	static int n, cnt;
	static int map [][]=new int [100][100];
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		for(int t=0; t<n; t++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= 90 - Integer.parseInt(st.nextToken());
			
			for(int i=0; i<10; i++)
				for(int j=0; j<10; j++)
					map[y+i][x+j]=1;
		}
		
		for(int i=0; i<100; i++)
			for(int j=0; j<100; j++)
				if(map[i][j]==1) cnt++;
		System.out.println(cnt);
	}
}