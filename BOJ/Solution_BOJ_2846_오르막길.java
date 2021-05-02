package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_BOJ_2846_오르막길 {
	static int N, max, start, cnt;
	static int [] pi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pi = new int [N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			pi[i]=Integer.parseInt(st.nextToken());
		
		start=pi[0];
	
		for(int i=0; i<N-1; i++) 
			if(pi[i+1]<=pi[i]) {
				start=pi[i+1];
				cnt=0;
			}
			else {
				cnt+=pi[i+1]-pi[i];
				max=Math.max(max, cnt);
			}
		
		System.out.println(max);
	}
}
