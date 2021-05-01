package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_BOJ_17298_오큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input= new int [N];
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			input[i]= Integer.parseInt(s.nextToken());
		
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && input[stack.peek()] < input[i]) 
				input[stack.pop()] = input[i];
			
			stack.push(i);
		}
		
		while(!stack.empty()) 
			input[stack.pop()]=-1;
		
		for(int i=0; i<N; i++)
			sb.append(input[i]+" ");
		System.out.println(sb);
	}
}