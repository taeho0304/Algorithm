package com.ssafy.io;

import java.io.*;
import java.util.Stack;

public class Soulution_d4_1218_괄호짝짓기 {
	public static int N;
	public static String s;
	public static char c;
	public static Stack<Character> st;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 10; tc++) {
			st = new Stack<>();
			N = Integer.parseInt(br.readLine());
			s = br.readLine();
			
			for (int i = 0; i < N; i++) {
				c = s.charAt(i);
				if(c ==')' && st.peek()=='(') st.pop();
				else if(c==']' && st.peek()=='[') st.pop();
				else if(c=='}' && st.peek()=='{') st.pop();
				else if(c=='>' && st.peek()=='<') st.pop();
				else st.push(c);
			}
			sb.append("#" + (tc + 1) + " " + (st.isEmpty()?1:0) + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}